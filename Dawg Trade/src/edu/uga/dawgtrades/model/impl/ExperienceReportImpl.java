package edu.uga.dawgtrades.model.impl;
import java.util.Date;

import edu.uga.dawgtrades.model.DTException;
import edu.uga.dawgtrades.model.ExperienceReport;
import edu.uga.dawgtrades.model.RegisteredUser;
import edu.uga.dawgtrades.persist.impl.PersistableImpl;


public class ExperienceReportImpl extends PersistableImpl implements ExperienceReport {

	private int rating;
	private String report;
	private Date date;
	private RegisteredUser reviewer;
	private RegisteredUser reviewed;
	
	public ExperienceReportImpl(){};
	
	public ExperienceReportImpl(int rating, String report, Date date,
			RegisteredUser reviewer, RegisteredUser reviewed) {
		super();
		this.rating = rating;
		this.report = report;
		this.date = date;
		this.reviewer = reviewer;
		this.reviewed = reviewed;
	}
	
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
		return rating;
	}

	@Override
	public void setRating(int rating) throws DTException {
		if (rating<1 || rating>5){
			throw new DTException("rating is an invalid number");
		}
		this.rating = rating;
		
	}

	@Override
	public String getReport() {
		return report;
	}

	@Override
	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public RegisteredUser getReviewer() {
		return reviewer;
	}

	@Override
	public void setReviewer(RegisteredUser reviewer) {
		this.reviewer = reviewer;
	}

	@Override
	public RegisteredUser getReviewed() {
		return reviewed;
	}

	@Override
	public void setReviewed(RegisteredUser reviewed) {
		this.reviewed = reviewed;
	}

}
