package edu.uga.dawgtrades.model.impl;
import edu.uga.dawgtrades.model.Category;
import edu.uga.dawgtrades.persist.impl.PersistableImpl;

/**
 * This class represents a category in the Dawg Trades system.
 * @author alexwhite
 */

public class CategoryImpl extends PersistableImpl implements Category {
    
   // Instance Variables
    private String name;
    private long parentId;
    
    public CategoryImpl(){};
    
    public CategoryImpl(String name, long parentId) {
        setName(name);
        setParentId(parentId);
    }
    
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
    public long getParentId() {
        
        return parentId;
    }
    
    @Override
    public void setParentId(long parentId) {
        
        this.parentId = parentId;
    }
    
}