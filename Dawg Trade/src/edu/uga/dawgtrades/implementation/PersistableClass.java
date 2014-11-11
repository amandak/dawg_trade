package edu.uga.dawgtrades.implementation;
import edu.uga.dawgtrades.model.Persistable;


public class PersistableClass implements Persistable {

	private long persistentId;
	
	@Override
	public long getId() {
		
		return peristentID;
	}

	@Override
	public void setId(long id) {

		persistentId = id;
	}

	@Override
	public boolean isPersistent() {
		
		if(this instanceof Persistable) 
			return true;
		else
			return false;
	}

}
