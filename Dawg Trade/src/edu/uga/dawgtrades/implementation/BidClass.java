package edu.uga.dawgtrades.implementation;
import edu.uga.dawgtrades.model.Bid;
import edu.uga.dawgtrades.model.RegisteredUser;

import java.util.Date;

/**
 * This class represents a bid in the Dawg Trades system.
 * @author emilywall
 *
 */
public class BidClass extends PersistableClass implements Bid {
	
	/**------------ Instance Variables ------------**/
	private float amount;
	private long id; 
	private AuctionClass auction; 
	private RegisteredUserClass bidder; 
	private Date date; 
	
	/**
	 * Constructor for Bid object. Initializes instance variables.
	 * @param amount
	 */
	public BidClass(long id, AuctionClass auction, RegisteredUserClass bidder, float amount) {
		this.setId(id); 
		this.setAuction(auction); 
		this.setRegisteredUser(bidder); 
		this.setAmount(amount); 
		this.setDate(new Date()); 
	}
	
	/**
	 * Return true if this bid is the winning bid in its Auction.
	 * @return
	 */
	public boolean isWinning() {
		if (getAuction().getWinningBid().equals(this))
			return true; 
		else
			return false; 
	}
	
	/**
	 * Determine if this Bid and the other Bid are the same. 
	 * @param otherBid
	 * @return
	 */
	public boolean equals(BidClass otherBid) {
		if (this.getAmount() == otherBid.getAmount() 
				&& this.getAuction().getItemId() == otherBid.getAuction().getItemId()
				&& this.getRegisteredUser().getId() == otherBid.getRegisteredUser().getId())
			return true; 
		else return false; 
	}
	
	/**------------ Mutators ------------**/
	
	/**
	 * Get the id of this Bid.
	 */
	public void setId(long id) {
		this.id = id; 
	}
	
	/**
	 * Set the auction of this Bid. 
	 * @param auction
	 */
	public void setAuction(AuctionClass auction) {
		this.auction = auction; 
	}
	
	/**
	 * Set the bidder of this Bid. 
	 * @param bidder
	 */
	public void setRegisteredUser(RegisteredUserClass bidder) {
		this.bidder = bidder;
	}
	
	/**
	 * Set the amount of this Bid. 
	 * @param amount
	 */
	public void setAmount(float amount) {
		this.amount = amount; 
	}
	
	/**
	 * Set the date of this Bid. 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date; 
	}
	
	/**------------ Accessors ------------**/

	/**
	 * Get the id of this Bid. 
	 */
	public long getId() {
		return id; 
	}
	
	/**
	 * Get the auction of this Bid. 
	 * @return
	 */
	public AuctionClass getAuction() {
		return auction; 
	}
	
	/**
	 * Get the bidder of this Bid; 
	 * @return
	 */
	public RegisteredUserClass getRegisteredUser() {
		return bidder; 
	}
	
	/**
	 * Get the amount of this Bid. 
	 * @return
	 */
	public float getAmount() {
		return amount; 
	}
	
	/**
	 * Get the date of this Bid. 
	 * @return
	 */
	public Date getDate() {
		return date; 
	}
}
