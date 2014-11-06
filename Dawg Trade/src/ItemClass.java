import java.util.List;

/**
 * This class represents an Item in the Dawg Trades system.
 * @author emilywall
 *
 */
public class ItemClass implements Item {

	/**------------ Instance Variables ------------**/
	private String id, name, description; 
	private long ownerID; 
	private CategoryClass category; 
	private List<AttributeClass> attributes; 
	
	/**
	 * Constructor for Item. Initializes instance variables.
	 * @param id
	 * @param name
	 * @param description
	 */
	public ItemClass(String id, String name, String description, long ownerID, CategoryClass category, List<AttributeClass> attributes) {
		this.setID(id); 
		this.setName(name); 
		this.setDescription(description); 
		this.setOwnerID(ownerID);
		this.setCategory(category); 
		this.setAttributes(attributes); 
	}
	
/**------------ Mutators ------------**/
	
	/**
	 * Set the id of this Item.
	 * @param id
	 */
	public void setID(String id) {
		this.id = id; 
	}
	
	/**
	 * Set the name of this Item.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name; 
	}
	
	/**
	 * Set the description of this Item.
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description; 
	}
	
	/**
	 * Set the ownerID of this Item.
	 * @param owner
	 */
	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID; 
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
	public String getID() {
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
	public long getOwnerID() {
		return ownerID; 
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
	
}
