/**
 * This class represents a bid in the Dawg Trades system.
 * @author emilywall
 *
 */
public class Bid {
	
	/**------------ Instance Variables ------------**/
	private double amount;
	Auction auction; 
	RegisteredUser bidder; 
	
	/**
	 * Constructor for Bid object. Initializes instance variables.
	 * @param amount
	 */
	public Bid(Auction auction, RegisteredUser bidder, double amount) {
		this.setAuction(auction); 
		this.setBidder(bidder); 
		this.setAmount(amount); 
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
	public void setBidder(RegisteredUser bidder) {
		this.bidder = bidder;
	}
	
	/**
	 * Set the amount of this Bid. 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount; 
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
	public RegisteredUser getBidder() {
		return bidder; 
	}
	
	/**
	 * Get the amount of this Bid. 
	 * @return
	 */
	public double getAmount() {
		return amount; 
	}
}
