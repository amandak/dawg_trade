package edu.uga.dawgtrades.persist.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import com.mysql.jdbc.PreparedStatement;

import edu.uga.dawgtrades.model.Auction;
import edu.uga.dawgtrades.model.DTException;
import edu.uga.dawgtrades.model.Item;
import edu.uga.dawgtrades.model.ObjectModel;

public class AuctionManager {

	private ObjectModel objectModel = null;
    private Connection   conn = null;

    public AuctionManager(Connection conn, ObjectModel objectModel) {
        this.conn = conn;
        this.objectModel = objectModel;
    }

    public void save(Auction auction)
            throws DTException {
        String insertAuctionSql = "insert into auction ( expiration, isClosed, item_id, minPrice, sellingPrice ) values ( ?, ?, ?, ?, ?, ? )";
        String updateAuctionSql = "update club set expiration = ?, isClosed = ?, item_id = ?, minPrice = ?, sellingPrice = ? where id = ?";
        PreparedStatement stmt = null;
        int inscnt;
        long auctionId;

        if (auction.getItemId() == -1)
            throw new DTException("AuctionManager.save: Attempting to save an Auction without an item");

        try {

            if(!auction.isPersistent())
                stmt = (PreparedStatement) conn.prepareStatement(insertAuctionSql);
            else
                stmt = (PreparedStatement) conn.prepareStatement(updateAuctionSql);

            if(auction.getExpiration() != null) {
            	java.util.Date jDate = auction.getExpiration(); 
            	java.sql.Date sDate = new java.sql.Date(jDate.getTime());
            	stmt.setDate(1, sDate);
            } else
            	stmt.setNull(1, java.sql.Types.DATE);
            
            stmt.setBoolean(2, auction.getIsClosed());
            stmt.setLong(3, auction.getItemId());
            stmt.setFloat(4, auction.getMinPrice());
            stmt.setFloat(5, auction.getSellingPrice());
            
            if (auction.isPersistent())
            	stmt.setLong(6, auction.getId());
            inscnt = stmt.executeUpdate(); 
            
            if (!auction.isPersistent()) {
            	if (inscnt >= 1) {
            		String sql = "select last_insert_id()";
            		if (stmt.execute(sql)) {
            			ResultSet r = stmt.getResultSet(); 
            			
            			while (r.next()) {
            				auctionId = r.getLong(1);
            				if (auctionId > 0)
            					auction.setId(auctionId);
            			}
            		}
            	}
            	else
            		throw new DTException("AuctionManager.save: failed to save an Auction");
            } else {
            	if (inscnt < 1)
            		throw new DTException("AuctionManager.save: failed to save an Auction:");
            }
        } catch (SQLException e) {
        	e.printStackTrace(); 
        	throw new DTException("AuctionManager.save: failed to save an Auction: " + e);
        }
    }
    
    public Iterator<Auction> restore(Auction auction) 
    		throws DTException {
    	String selectAuctionSql = "select expiration, isClosed, item_id, minPrice, sellingPrice from auction";
        Statement stmt = null;
        StringBuffer query = new StringBuffer(100);
        StringBuffer condition = new StringBuffer(100);

        condition.setLength(0);

        query.append(selectAuctionSql);

        if(auction != null) {
            if(auction.getId() >= 0)
                query.append(" where id = " + auction.getId());
            else {
            	if(auction.getItemId() >= 0)
                    condition.append( " item_id = '" + auction.getItemId() + "'" );

                if(auction.getExpiration() != null) {
                    if(condition.length() > 0)
                        condition.append(" and");
                    condition.append( " expiration = '" + auction.getExpiration() + "'" );
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
                return new AuctionIterator(r, objectModel);
            }
        } catch(Exception e) {
        	e.printStackTrace(); 
        	throw new DTException("AuctionManager.restore: Could not restore persistent Auction object; Root cause: " + e);
        }
        
        throw new DTException("AuctionManager.restore: Could not restore persistent Auction object");
    }
    
    public Item restoreAuctionItem(Auction auction) 
    		throws DTException {
    	String selectItemSql = "select i.id, i.category_id, i.description, i.identifier, i.name, i.owner_id from item i, auction a where i.id = a.item_id";
        Statement stmt = null;
        StringBuffer query = new StringBuffer(100);
        StringBuffer condition = new StringBuffer(100);

        condition.setLength(0);

        query.append(selectItemSql);
        
        if(auction != null) {
            if(auction.getId() >= 0)
                query.append(" and a.id = " + auction.getId() );
            else {
            	if(auction.getItemId() >= 0)
                    condition.append( " item_id = '" + auction.getItemId() + "'" );

                if(auction.getExpiration() != null) {
                    if(condition.length() > 0)
                        condition.append(" and");
                    condition.append( " expiration = '" + auction.getExpiration() + "'" );
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
        		Iterator<Item> itemIter = new ItemIterator(r, objectModel); 
        		if (itemIter != null && itemIter.hasNext()) {
        			return itemIter.next();
        		} else
        			return null;
        	}
        } catch(Exception e) {
        	throw new DTException("AuctionManager.restoreAuctionItem: Could not restore persistent Item object; Root cause: " + e); 
        }
        throw new DTException("AuctionManager.restoreAuctionItem: Could not restore persistent Item object"); 
        
    }
    
    public void delete(Auction auction) 
    		throws DTException {
    	 String deleteAuctionSql = "delete from auction where id = ?";
         PreparedStatement stmt = null;
         int inscnt;

         if(!auction.isPersistent())
             return;

         try {
             stmt = (PreparedStatement) conn.prepareStatement(deleteAuctionSql);
             stmt.setLong(1, auction.getId());
             inscnt = stmt.executeUpdate();
             if(inscnt == 1) {
                 return;
             }
             else
            	 throw new DTException("AuctionManager.delete: failed to delete an Auction");

         } catch(SQLException e) {
        	 e.printStackTrace(); 
        	 throw new DTException("AuctionManager.delete: failed to delete an Auction: " + e);
         }
    }
}
