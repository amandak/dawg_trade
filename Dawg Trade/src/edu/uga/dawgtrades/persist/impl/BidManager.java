package edu.uga.dawgtrades.persist.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import com.mysql.jdbc.PreparedStatement;

import edu.uga.dawgtrades.model.Auction;
import edu.uga.dawgtrades.model.Bid;
import edu.uga.dawgtrades.model.DTException;
import edu.uga.dawgtrades.model.Item;
import edu.uga.dawgtrades.model.ObjectModel;
import edu.uga.dawgtrades.model.RegisteredUser;

public class BidManager {

	private ObjectModel objectModel = null;
    private Connection   conn = null;

    public BidManager(Connection conn, ObjectModel objectModel) {
        this.conn = conn;
        this.objectModel = objectModel;
    }

    public void save(Bid bid)
            throws DTException {
        String insertBidSql = "insert into bid ( amount, auction_id, date, registeredUser_id, isWinning ) values ( ?, ?, ?, ?, ? )";
        String updateBidSql = "update club set amount = ?, auction_id = ?, date = ?, registeredUser_id = ?, isWinning = ? where id = ?";
        PreparedStatement stmt = null;
        int inscnt;
        long bidId;

        if (bid.getAuction() == null)
            throw new DTException("BidManager.save: Attempting to save a Bid without an auction");
        if (bid.getRegisteredUser() == null)
        	 throw new DTException("BidManager.save: Attempting to save a Bid without a registered user");
        
        try {

            if(!bid.isPersistent())
                stmt = (PreparedStatement) conn.prepareStatement(insertBidSql);
            else
                stmt = (PreparedStatement) conn.prepareStatement(updateBidSql);

            stmt.setFloat(1, bid.getAmount());
            stmt.setLong(2, bid.getAuction().getId());
            
            if(bid.getDate() != null) {
            	java.util.Date jDate = bid.getDate(); 
            	java.sql.Date sDate = new java.sql.Date(jDate.getTime());
            	stmt.setDate(3, sDate);
            } else
            	stmt.setNull(3, java.sql.Types.DATE);
            
            stmt.setLong(4,  bid.getRegisteredUser().getId());
            stmt.setBoolean(5, bid.isWinning());
           
            if (bid.isPersistent())
            	stmt.setLong(6, bid.getId());
            inscnt = stmt.executeUpdate(); 
            
            if (!bid.isPersistent()) {
            	if (inscnt >= 1) {
            		String sql = "select last_insert_id()";
            		if (stmt.execute(sql)) {
            			ResultSet r = stmt.getResultSet(); 
            			
            			while (r.next()) {
            				bidId = r.getLong(1);
            				if (bidId > 0)
            					bid.setId(bidId);
            			}
            		}
            	}
            	else
            		throw new DTException("BidManager.save: failed to save a Bid");
            } else {
            	if (inscnt < 1)
            		throw new DTException("BidManager.save: failed to save a Bid:");
            }
        } catch (SQLException e) {
        	e.printStackTrace(); 
        	throw new DTException("BidManager.save: failed to save a Bid: " + e);
        }
    }
    
    public Iterator<Bid> restore(Bid bid) 
    		throws DTException {
    	String selectBidSql = "select amount, auction_id, date, registeredUser_id, isWinning from bid";
        Statement stmt = null;
        StringBuffer query = new StringBuffer(100);
        StringBuffer condition = new StringBuffer(100);

        condition.setLength(0);

        query.append(selectBidSql);

        if(bid != null) {
            if(bid.getId() >= 0)
                query.append(" where id = " + bid.getId());
            else {
            	if(bid.getAuction().getId() >= 0)
                    condition.append( " auction_id = '" + bid.getAuction().getId() + "'" );

                if(bid.getDate() != null) {
                    if(condition.length() > 0)
                        condition.append(" and");
                    condition.append( " date = '" + bid.getDate() + "'" );
                }
                
                if(bid.getRegisteredUser().getId() >0) {
                    if(condition.length() > 0)
                        condition.append(" and");
                    condition.append( " registeredUser_id = '" + bid.getRegisteredUser().getId() + "'" );
                }

                if(condition.length() > 0) {
                    query.append(" where ");
                    query.append(condition);
                }
            }
        }
        
        try {
        	stmt = conn.createStatement(); 
        	if(stmt.execute(query.toString())) { 
                ResultSet r = stmt.getResultSet();
                return new BidIterator(r, objectModel);
            }
        } catch(Exception e) {
        	e.printStackTrace(); 
        	throw new DTException("BidManager.restore: Could not restore persistent Bid object; Root cause: " + e);
        }
        
        throw new DTException("BidManager.restore: Could not restore persistent Bid object");
    }
    
    public Bid restoreBidAuction(Bid bid) 
    		throws DTException {
    	String selectAuctionSql = "select a.id, a.expiration, a.isClosed, a.item_id, a.minPrice, a.sellingPrice from auction a, bid b where a.id = b.auction_id";
        Statement stmt = null;
        StringBuffer query = new StringBuffer(100);
        StringBuffer condition = new StringBuffer(100);

        condition.setLength(0);

        query.append(selectAuctionSql);
        
        if(bid != null) {
            if(bid.getId() >= 0)
                query.append(" and b.id = " + bid.getId() );
            else {
            	if(bid.getAuction().getId() >= 0)
                    condition.append( " auction_id = '" + bid.getAuction().getId() + "'" );

                if(bid.getDate() != null) {
                    if(condition.length() > 0)
                        condition.append(" and");
                    condition.append( " date = '" + bid.getDate() + "'" );
                }
                
                if(bid.getRegisteredUser().getId() >0) {
                    if(condition.length() > 0)
                        condition.append(" and");
                    condition.append( " registeredUser_id = '" + bid.getRegisteredUser().getId() + "'" );
                }

                if(condition.length() > 0) {
                    query.append(condition);
                }
            }
        }
        try {
        	stmt = conn.createStatement(); 
        	
        	if (stmt.execute(query.toString())) {
        		ResultSet r = stmt.getResultSet(); 
        		Iterator<Bid> bidIter = new BidIterator(r, objectModel); 
        		if (bidIter != null && bidIter.hasNext()) {
        			return bidIter.next();
        		} else
        			return null;
        	}
        } catch(Exception e) {
        	throw new DTException("BidManager.restoreBidAuction: Could not restore persistent Auction object; Root cause: " + e); 
        }
        throw new DTException("BidManager.restoreBidAuction: Could not restore persistent Auction object"); 
        
    }
    
    public RegisteredUser restoreBidRegisteredUser(Bid bid) 
    		throws DTException {
    	String selectRegisteredUserSql = "select r.id, r.canText, r.email, r.firstName, r.isAdmin, r.lastName, r.name, r.password, r.phone from registeredUser r, bid b where r.id = b.registeredUser_id";
        Statement stmt = null;
        StringBuffer query = new StringBuffer(100);
        StringBuffer condition = new StringBuffer(100);

        condition.setLength(0);

        query.append(selectRegisteredUserSql);
        
        if(bid != null) {
            if(bid.getId() >= 0)
                query.append(" and b.id = " + bid.getId() );
            else {
            	if(bid.getAuction().getId() >= 0)
                    condition.append( " auction_id = '" + bid.getAuction().getId() + "'" );

                if(bid.getDate() != null) {
                    if(condition.length() > 0)
                        condition.append(" and");
                    condition.append( " date = '" + bid.getDate() + "'" );
                }
                
                if(bid.getRegisteredUser().getId() >0) {
                    if(condition.length() > 0)
                        condition.append(" and");
                    condition.append( " registeredUser_id = '" + bid.getRegisteredUser().getId() + "'" );
                }

                if(condition.length() > 0) {
                    query.append(condition);
                }
            }
        }
        try {
        	stmt = conn.createStatement(); 
        	
        	if (stmt.execute(query.toString())) {
        		ResultSet r = stmt.getResultSet(); 
        		Iterator<RegisteredUser> registeredUserIter = new RegisteredUserIterator(r, objectModel); 
        		if (registeredUserIter != null && registeredUserIter.hasNext()) {
        			return registeredUserIter.next();
        		} else
        			return null;
        	}
        } catch(Exception e) {
        	throw new DTException("BidManager.restoreBidRegisteredUser: Could not restore persistent RegisteredUser object; Root cause: " + e); 
        }
        throw new DTException("BidManager.restoreBidRegisteredUser: Could not restore persistent RegisteredUser object"); 
        
    }
    
    public void delete(Bid bid) 
    		throws DTException {
    	 String deleteBidSql = "delete from bid where id = ?";
         PreparedStatement stmt = null;
         int inscnt;

         if(!bid.isPersistent())
             return;

         try {
             stmt = (PreparedStatement) conn.prepareStatement(deleteBidSql);
             stmt.setLong(1, bid.getId());
             inscnt = stmt.executeUpdate();
             if(inscnt == 1) {
                 return;
             }
             else
            	 throw new DTException("BidManager.delete: failed to delete a Bid");

         } catch(SQLException e) {
        	 e.printStackTrace(); 
        	 throw new DTException("BidManager.delete: failed to delete a Bid: " + e);
         }
    }
}
