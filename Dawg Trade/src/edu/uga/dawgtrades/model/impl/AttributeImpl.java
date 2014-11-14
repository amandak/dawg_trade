package edu.uga.dawgtrades.model.impl;
import edu.uga.dawgtrades.model.Attribute;
import edu.uga.dawgtrades.persist.impl.PersistableImpl;

/**
 * This class represents an attribute in the Dawg Trades system.
 * @author alexwhite
 */

public class AttributeImpl extends PersistableImpl implements Attribute {
    
    // Instance Variables
    private long itemId;
    private long attributeId;
    private String value;
    
    public AttributeImpl() {};
    
    public AttributeImpl(String value, long itemId, long attributeId) {
        
        setValue(value);
        setItemId(itemId);
        setAttributeType(attributeId);
    }
    
    @Override
    public boolean isPersistent() {
        
        return false;
    }
    
    @Override
    public String getValue() {
        
        return value;
    }
    
    @Override
    public void setValue(String value) {
        
        this.value = value;
    }
    
    @Override
    public long getItemId() {
        
        return this.itemId;
    }
    
    @Override
    public void setItemId(long itemId) {
        
        this.itemId = itemId;
    }
    
    @Override
    public long getAttributeType() {
        
        return this.attributeId;
    }
    
    @Override
    public void setAttributeType(long attributeId) {
        
        this.attributeId = attributeId;
    }
    
}