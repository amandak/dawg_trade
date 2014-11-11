package edu.uga.dawgtrades.implementation;
import edu.uga.dawgtrades.model.Auction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This class represents an Auction in the Dawg Trades system.
 * @author emilywall
 *
 */
public class AuctionClass extends PersistableClass implements Auction {
	
	/**------------ Instance Variables ------------**/
	private float minPrice; 
	private Date expiration; 
	private long itemId; 
	private List<BidClass> bids;
	
	/**
	 * Constructor for Auction object. Initializes instance variables. 
	 * @param minPrice
	 * @param expiration
	 */
	public AuctionClass(long id, long itemId, float minPrice, Date expiration) {
		this.setId(id); 
		this.setItemId(itemId); 
		this.setMinPrice(minPrice); 
		this.setExpiration(expiration); 
		bids = new ArrayList<BidClass>(); 
	}
	
	/**
	 * Default constructor for Auction.
	 */
	public AuctionClass() {
		new AuctionClass(-1, -1, (float) 0.01, new Date());
	}

	/**
	 * Return true if those auction is closed, false otherwise. 
	 * @return
	 */
	public boolean getIsClosed() {
		Date current = new Date(); 
		if (current.after(expiration))
			return true; 
		else 
			return false; 
	}
	
	/**
	 * Get the selling price of this auction. 
	 * If the auction isn't over or there were no bids, return -1. 
	 * @return
	 */
	public float getSellingPrice() {
		if (!getIsClosed() || bids.isEmpty())
			return -1;
		else
			return bids.get(bids.size() - 1).getAmount();
	}
	
	/**
	 * Get the winning bid of this Auction.
	 * @return
	 */
	public BidClass getWinningBid() {
		if (bids.isEmpty())
			return null; 
		else
			return bids.get(bids.size() - 1);
	}
	
	/**------------ Mutators ------------**/
	
	/**
	 * Set the item id of this Auction.
	 * @param itemID
	 */
	public void setItemId(long itemId) {
		this.itemId = itemId; 
	}
	
	/**
	 * Set the min price of this Auction.
	 * @param minPrice
	 */
	public void setMinPrice(float minPrice) {
		if (minPrice > 0)
			this.minPrice = minPrice; 
		else
			this.minPrice = (float) 0.01;
	}
	
	/**
	 * Set the expiration of this Auction.
	 * @param expiration
	 */
	public void setExpiration(Date expiration) {
		Date current = new Date(); 
		if (expiration.after(current))
			this.expiration = expiration; 
		else
			expiration = current; // auction immediately over if invalid expiration passed
	}
	
	/**------------ Accessors ------------**/

	/**
	 * Get the itemID of this Auction.
	 * @return
	 */
	public long getItemId() {
		return itemId; 
	}
	
	/**
	 * Get the min price of this Auction.
	 * @return
	 */
	public float getMinPrice() {
		return minPrice; 
	}
	
	/**
	 * Get the expiration of this Auction.
	 * @return
	 */
	public Date getExpiration() {
		return expiration; 
	}
}
