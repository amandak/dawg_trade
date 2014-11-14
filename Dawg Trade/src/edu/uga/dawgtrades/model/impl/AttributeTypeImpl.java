package edu.uga.dawgtrades.model.impl;
import edu.uga.dawgtrades.model.AttributeType;
import edu.uga.dawgtrades.persist.impl.PersistableImpl;

/**
 * This class represents an attribute type in the Dawg Trades system.
 * @author alexwhite
 */
 
public class AttributeTypeImpl extends PersistableImpl implements AttributeType {
    
    // Instance Variables
    private long categoryId;
    private String name;
    
    public AttributeTypeImpl(long categoryId, String name) {
        
        setCategoryId(categoryId);
        setName(name);
    }
    
    public AttributeTypeImpl(){};
    
    @Override
    public boolean isPersistent() {
        
        return false;
    }
    
    @Override
    public String getName() {
    	return name;
    }
    
    @Override
    public void setName(String name) {
        if (name != null)
        	this.name = name;
        else
        	this.name = "";
    }
    
    @Override
    public long getCategoryId() {
        
        return categoryId;
    }
    
    @Override
    public void setCategoryId(long categoryId) {
        
        this.categoryId = categoryId;
    }
    
}