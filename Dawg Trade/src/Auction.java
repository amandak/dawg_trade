import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This class represents an Auction in the Dawg Trades system.
 * @author emilywall
 *
 */
public class Auction {
	
	/**------------ Instance Variables ------------**/
	private float minPrice; 
	private Date expiration; 
	private long itemID; 
	private List<Bid> bids;
	
	/**
	 * Constructor for Auction object. Initializes instance variables. 
	 * @param minPrice
	 * @param expiration
	 */
	public Auction(long itemID, float minPrice, Date expiration) {
		this.setItemID(itemID); 
		this.setMinPrice(minPrice); 
		this.setExpiration(expiration); 
		bids = new ArrayList<Bid>(); 
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
	public Bid getWinningBid() {
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
	public void setItemID(long itemID) {
		this.itemID = itemID; 
	}
	
	/**
	 * Set the min price of this Auction.
	 * @param minPrice
	 */
	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice; 
	}
	
	/**
	 * Set the expiration of this Auction.
	 * @param expiration
	 */
	public void setExpiration(Date expiration) {
		this.expiration = expiration; 
	}
	
	/**------------ Accessors ------------**/

	/**
	 * Get the itemID of this Auction.
	 * @return
	 */
	public long getItemID() {
		return itemID; 
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
