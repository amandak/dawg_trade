package edu.uga.dawgtrades.persist.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.uga.dawgtrades.model.Auction;
import edu.uga.dawgtrades.model.Bid;
import edu.uga.dawgtrades.model.DTException;
import edu.uga.dawgtrades.model.ObjectModel;
import edu.uga.dawgtrades.model.RegisteredUser;

public class BidIterator implements Iterator<Bid> {
	
	private ResultSet rs = null;
    private ObjectModel objectModel = null;
    private boolean more = false;

    /**
     * Constructor
     * @param rs
     * @param objectModel
     * @throws DTException
     */
    public BidIterator(ResultSet rs, ObjectModel objectModel)
            throws DTException {
        this.rs = rs;
        this.objectModel = objectModel;
        try {
            more = rs.next();
        } catch( Exception e ) { 
            throw new DTException( "BidIterator: Cannot create Bid iterator; root cause: " + e );
        }
    }
    
	@Override
	public boolean hasNext() {
		return more;
	}

	@Override
	public Bid next() {
		long id;
		boolean isPersistent;
		float amt; 
		long auctionID;
		Date date;
		long userID;
		boolean isWinning;
		
        Bid bid = null;

        if (more) {

            try {
            	id = rs.getLong(1); 
            	isPersistent = rs.getBoolean(2); 
            	amt = rs.getFloat(3); 
            	auctionID = rs.getLong(4); 
            	date = rs.getDate(5);
            	userID = rs.getLong(6); 
            	isWinning = rs.getBoolean(7); 
      
                more = rs.next();
            } catch(Exception e) {
                throw new NoSuchElementException( "BidIterator: No next Bid object; root cause: " + e );
            }
            Auction auction = objectModel.createAuction();
            auction.setId(auctionID);
            RegisteredUser user = objectModel.createRegisteredUser();
            user.setId(userID);
            try {
                bid = objectModel.createBid(auction, user, amt);
                bid.setId(id);
            } catch( DTException ce ) {
                // ignore
            }

            return bid;
        }
        else {
            throw new NoSuchElementException( "BidIterator: No next Bid object" );
        }
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
