package edu.uga.dawgtrades.model.impl;
import edu.uga.dawgtrades.model.Attribute;
import edu.uga.dawgtrades.model.Category;
import edu.uga.dawgtrades.model.Item;
import edu.uga.dawgtrades.persist.impl.PersistableImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an Item in the Dawg Trades system.
 * @author emilywall
 *
 */
public class ItemImpl extends PersistableImpl implements Item {

	/**------------ Instance Variables ------------**/
	private String name, description; 
	private long ownerId; 
	private Category category; 
	private List<Attribute> attributes; 
	
	/**
	 * Constructor for Item. Initializes instance variables.
	 * @param id
	 * @param name
	 * @param description
	 */
	public ItemImpl(String name, String description, long ownerId, Category category, List<Attribute> arrayList) {
		this.setName(name); 
		this.setDescription(description); 
		this.setOwnerId(ownerId);
		this.setCategory(category); 
		this.setAttributes(arrayList); 
	}
	
	/**
	 * Default constructor for Item.
	 */
	public ItemImpl() {
		new ItemImpl("", "", -1, null, new ArrayList<Attribute>());
	}
	
/**------------ Mutators ------------**/

	/**
	 * Set the name of this Item.
	 * @param name
	 */
	public void setName(String name) {
		if (name != null)
			this.name = name; 
		else
			this.name = ""; 
	}
	
	/**
	 * Set the ownerID of this Item.
	 * @param owner
	 */
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId; 
		
	}
	
	/**
	 * Set the description of this Item.
	 * @param description
	 */
	public void setDescription(String description) {
		if (description != null)
			this.description = description; 
		else 
			this.description = ""; 
	}
	
	/**
	 * Set the category of this Item.
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category; 
	}
	
	/**
	 * Set the attributes of this Item.
	 * @param attributes
	 */
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	
	/**------------ Accessors ------------**/
	
	/**
	 * Get the name of this Item.
	 * @return
	 */
	public String getName() {
		return name; 
	}
	
	/**
	 * Get the description of this Item.
	 * @return
	 */
	public String getDescription() {
		return description; 
	}
	
	/**
	 * Get the ownerID of this Item. 
	 * @return
	 */
	public long getOwnerId() {
		return ownerId; 
	}
	
	/**
	 * Get the category of this Item.
	 * @return
	 */
	public Category getCategory() {
		return category; 
	}
	
	/**
	 * Get the attributes of this Item. 
	 * @return
	 */
	public List<Attribute> getAttributes() {
		return attributes; 
	}
}
