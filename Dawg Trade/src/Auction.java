import java.sql.Date;

/**
 * This class represents an Auction in the Dawg Trades system.
 * @author emilywall
 *
 */
public class Auction {
	
	/**------------ Instance Variables ------------**/
	private double minPrice; 
	private Date expiration; // TODO: Does this need to be java.util.Date?
	private Item item; 
	
	/**
	 * Constructor for Auction object. Initializes instance variables. 
	 * @param minPrice
	 * @param expiration
	 */
	public Auction(Item item, double minPrice, Date expiration) {
		this.setItem(item); 
		this.setMinPrice(minPrice); 
		this.setExpiration(expiration); 
	}
	
	/**------------ Mutators ------------**/
	
	/**
	 * Set the item of this Auction.
	 * @param item
	 */
	public void setItem(Item item) {
		this.item = item; 
	}
	
	/**
	 * Set the min price of this Auction.
	 * @param minPrice
	 */
	public void setMinPrice(double minPrice) {
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
	 * Get the item of this Auction.
	 * @return
	 */
	public Item getItem() {
		return item; 
	}
	
	/**
	 * Get the min price of this Auction.
	 * @return
	 */
	public double getMinPrice() {
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
