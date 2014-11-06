import java.util.Date;

/**
 * This interface represents a bid in the Dawg Trades system.
 * @author emilywall
 *
 */
public interface Bid {
	
	/**
	 * Return true if this bid is the winning bid in its Auction.
	 * @return
	 */
	public boolean isWinning();
	
	/**
	 * Set the amount of this Bid. 
	 * @param amount
	 */
	public void setAmount(float amount);
	
	/**
	 * Set the date of this Bid. 
	 * @param date
	 */
	public void setDate(Date date);
	
	/**
	 * Get the auction of this Bid. 
	 * @return
	 */
	public AuctionClass getAuction();
	
	/**
	 * Get the bidder of this Bid; 
	 * @return
	 */
	public RegisteredUserClass getRegisteredUser();
	
	/**
	 * Get the amount of this Bid. 
	 * @return
	 */
	public float getAmount();
	
	/**
	 * Get the date of this Bid. 
	 * @return
	 */
	public Date getDate();
}
