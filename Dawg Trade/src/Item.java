import java.util.List;

/**
 * This class represents an Item in the Dawg Trades system.
 * @author emilywall
 *
 */
public class Item {

	/**------------ Instance Variables ------------**/
	private String id, name, description; 
	private RegisteredUser owner; 
	private Category category; 
	private List<Attribute> attributes; 
	
	/**
	 * Constructor for Item. Initializes instance variables.
	 * @param id
	 * @param name
	 * @param description
	 */
	public Item(String id, String name, String description, RegisteredUser owner, Category category, List<Attribute> attributes) {
		this.setID(id); 
		this.setName(name); 
		this.setDescription(description); 
		this.setOwner(owner);
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
	 * Set the owner of this Item.
	 * @param owner
	 */
	public void setOwner(RegisteredUser owner) {
		this.owner = owner; 
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
	 * Get the owner of this Item. 
	 * @return
	 */
	public RegisteredUser getOwner() {
		return owner; 
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
