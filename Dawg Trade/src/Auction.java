import java.util.Date;


/**
 * This interface represents an Auction in the Dawg Trades system.
 * @author emilywall
 *
 */
public interface Auction {
	
	/**
	 * Return true if those auction is closed, false otherwise. 
	 * @return
	 */
	public boolean getIsClosed();
	
	/**
	 * Get the selling price of this auction. 
	 * If the auction isn't over or there were no bids, return -1. 
	 * @return
	 */
	public float getSellingPrice();

	/**
	 * Get the itemID of this Auction.
	 * @return
	 */
	public long getItemID();
	
	/**
	 * Get the min price of this Auction.
	 * @return
	 */
	public float getMinPrice();
	
	/**
	 * Get the expiration of this Auction.
	 * @return
	 */
	public Date getExpiration();
	
	/**
	 * Set the item id of this Auction.
	 * @param itemID
	 */
	public void setItemID(long itemID);
	
	/**
	 * Set the min price of this Auction.
	 * @param minPrice
	 */
	public void setMinPrice(float minPrice);
	
	/**
	 * Set the expiration of this Auction.
	 * @param expiration
	 */
	public void setExpiration(Date expiration);
}
