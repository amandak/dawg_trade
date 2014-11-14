package edu.uga.dawgtrades.persist.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.uga.dawgtrades.model.Auction;
import edu.uga.dawgtrades.model.DTException;
import edu.uga.dawgtrades.model.Item;
import edu.uga.dawgtrades.model.ObjectModel;

public class AuctionIterator implements Iterator<Auction> {

	private ResultSet rs = null;
    private ObjectModel objectModel = null;
    private boolean more = false;

    /**
     * Constructor
     * @param rs
     * @param objectModel
     * @throws DTException
     */
    public AuctionIterator(ResultSet rs, ObjectModel objectModel)
            throws DTException {
        this.rs = rs;
        this.objectModel = objectModel;
        try {
            more = rs.next();
        } catch( Exception e ) { 
            throw new DTException( "AuctionIterator: Cannot create Auction iterator; root cause: " + e );
        }
    }
    
	@Override
	public boolean hasNext() {
		return more;
	}

	@Override
	public Auction next() {
		long id;
		boolean isPersistent;
		Date expiration;
		boolean isClosed; 
		long itemID;
		float minPrice;
		float sellingPrice;
		
        Auction auction = null;

        if (more) {

            try {
            	id = rs.getLong(1); 
            	isPersistent = rs.getBoolean(2); 
            	expiration = rs.getDate(3);
            	isClosed = rs.getBoolean(4);
            	itemID = rs.getLong(5); 
            	minPrice = rs.getFloat(6);
            	sellingPrice = rs.getFloat(7); 
      
                more = rs.next();
            } catch(Exception e) {
                throw new NoSuchElementException( "AuctionIterator: No next Auction object; root cause: " + e );
            }
            Item item = objectModel.createItem();
            item.setId(id);
            try {
                auction = objectModel.createAuction(item, minPrice, expiration);
                auction.setId(id);
            } catch( DTException ce ) {
                // ignore
            }

            return auction;
        }
        else {
            throw new NoSuchElementException( "AuctionIterator: No next Auction object" );
        }
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
