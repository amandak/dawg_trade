package edu.uga.dawgtrades.persist.impl;
import edu.uga.dawgtrades.persist.Persistable;


public class PersistableImpl implements Persistable {

	private long persistentId;
	
	@Override
	public long getId() {
		
		return persistentId;
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
