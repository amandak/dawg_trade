package edu.uga.dawgtrades.implementation;
import java.util.Date;

import edu.uga.dawgtrades.model.DTException;
import edu.uga.dawgtrades.model.ExperienceReport;
import edu.uga.dawgtrades.model.RegisteredUser;


public class ExperienceReportClass implements ExperienceReport {

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
	public int getRating() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRating(int rating) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReport(String report) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegisteredUser getReviewer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReviewer(RegisteredUser reviewer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegisteredUser getReviewed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReviewed(RegisteredUser reviewed) {
		// TODO Auto-generated method stub
		
	}

}
