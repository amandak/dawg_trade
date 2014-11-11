package edu.uga.dawgtrades.implementation;
import edu.uga.dawgtrades.model.Item;

import java.util.List;

/**
 * This class represents an Item in the Dawg Trades system.
 * @author emilywall
 *
 */
public class ItemClass implements Item {

	/**------------ Instance Variables ------------**/
	private String name, description; 
	private long id, ownerId; 
	private CategoryClass category; 
	private List<AttributeClass> attributes; 
	
	/**
	 * Constructor for Item. Initializes instance variables.
	 * @param id
	 * @param name
	 * @param description
	 */
	public ItemClass(long id, String name, String description, long ownerId, CategoryClass category, List<AttributeClass> attributes) {
		this.setId(id); 
		this.setName(name); 
		this.setDescription(description); 
		this.setOwnerId(ownerId);
		this.setCategory(category); 
		this.setAttributes(attributes); 
	}
	
/**------------ Mutators ------------**/
	
	/**
	 * Set the id of this Item.
	 * @param id
	 */
	public void setId(long id) {
		this.id = id; 
	}
	
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
	public void setCategory(CategoryClass category) {
		this.category = category; 
	}
	
	/**
	 * Set the attributes of this Item.
	 * @param attributes
	 */
	public void setAttributes(List<AttributeClass> attributes) {
		this.attributes = attributes;
	}
	
	
	/**------------ Accessors ------------**/
	
	/**
	 * Get the id of this Item.
	 * @return
	 */
	public long getId() {
		return id; 
	}
	
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
	public CategoryClass getCategory() {
		return category; 
	}
	
	/**
	 * Get the attributes of this Item. 
	 * @return
	 */
	public List<AttributeClass> getAttributes() {
		return attributes; 
	}

	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
