import java.util.List;

/**
 * This interface represents an Item in the Dawg Trades system.
 * @author emilywall
 *
 */
public interface Item {	
	
	
	/**
	 * Set the name of this Item.
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * Set the description of this Item.
	 * @param description
	 */
	public void setDescription(String description);
	
	/**
	 * Set the ownerID of this Item.
	 * @param owner
	 */
	public void setOwnerID(long ownerID);
	
	/**
	 * Get the name of this Item.
	 * @return
	 */
	public String getName();
	
	/**
	 * Get the description of this Item.
	 * @return
	 */
	public String getDescription();
	
	/**
	 * Get the ownerID of this Item. 
	 * @return
	 */
	public long getOwnerID();	
}
