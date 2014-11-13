package edu.uga.dawgtrades.model.impl;
import java.util.Date;

import edu.uga.dawgtrades.model.Membership;
import edu.uga.dawgtrades.persist.impl.PersistableImpl;


public class MembershipImpl extends PersistableImpl implements Membership {

	private float price;
	private Date date;
	
	public MembershipImpl(float price, Date date) {
		super();
		this.price = price;
		this.date = date;
	}
	
	public MembershipImpl(){}
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPersistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public Date getDate() {
		return date;
	}

}
