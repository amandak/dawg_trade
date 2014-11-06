import java.util.Date;

/**
 * This class represents a bid in the Dawg Trades system.
 * @author emilywall
 *
 */
public class Bid {
	
	/**------------ Instance Variables ------------**/
	private float amount;
	Auction auction; 
	RegisteredUser bidder; 
	Date date; 
	
	/**
	 * Constructor for Bid object. Initializes instance variables.
	 * @param amount
	 */
	public Bid(Auction auction, RegisteredUser bidder, float amount) {
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
	public boolean equals(Bid otherBid) {
		if (this.getAmount() == otherBid.getAmount() 
				&& this.getAuction().getItemID() == otherBid.getAuction().getItemID()
				&& this.getRegisteredUser().getID() == otherBid.getRegisteredUser().getID())
			return true; 
		else return false; 
	}
	
	/**------------ Mutators ------------**/
	
	/**
	 * Set the auction of this Bid. 
	 * @param auction
	 */
	public void setAuction(Auction auction) {
		this.auction = auction; 
	}
	
	/**
	 * Set the bidder of this Bid. 
	 * @param bidder
	 */
	public void setRegisteredUser(RegisteredUser bidder) {
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
	 * Get the auction of this Bid. 
	 * @return
	 */
	public Auction getAuction() {
		return auction; 
	}
	
	/**
	 * Get the bidder of this Bid; 
	 * @return
	 */
	public RegisteredUser getRegisteredUser() {
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
