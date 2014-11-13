package edu.uga.dawgtrades.persist;

import edu.uga.dawgtrades.model.*;
import java.util.Iterator;

public interface Persistence {

	public void saveAttribute(Attribute attribute) throws DTException;
	public Iterator<Attribute> restoreAttribute(Attribute attribute) throws DTException;
	public void deleteAttribute(Attribute attribute) throws DTException;
	
	public void saveAttributeType(AttributeType attrType) throws DTException;
	public Iterator<AttributeType> restoreAttributeType(AttributeType attrType) throws DTException;
	public void deleteAttributeType(AttributeType attrType) throws DTException;
	
	public void saveAuction(Auction auction) throws DTException;
	public Iterator<Auction> restoreAuction(Auction auction) throws DTException;
	public void deleteAuction(Auction auction) throws DTException;
	
	public void saveBid(Bid bid) throws DTException;
	public Iterator<Bid> restoreBid(Bid bid) throws DTException;
	public void deleteBid(Bid bid) throws DTException;
	
	public void saveCategory(Category category) throws DTException;
	public Iterator<Category> restoreCategory(Category category) throws DTException;
	public void deleteCategory(Category category) throws DTException;
	
	public void saveExperienceReport(ExperienceReport exprReport) throws DTException;
	public Iterator<ExperienceReport> restoreExperienceReport(ExperienceReport exprReport) throws DTException;
	public void deleteExperienceReport(ExperienceReport exprReport) throws DTException;
	
	public void saveItem(Item item) throws DTException;
	public Iterator<Item> resotreItem(Item item) throws DTException;
	public void deleteItem(Item item) throws DTException;
	
	public void saveMembership(Membership membership) throws DTException;
	public Iterator<Membership> restoreMembership(Membership membership) throws DTException;
	public void deleteMembership(Membership membership) throws DTException;
	
	public void saveRegisteredUser(RegisteredUser regUser) throws DTException;
	public Iterator<RegisteredUser> restoreRegisteredUser(RegisteredUser regUser) throws DTException;
	public void deleteRegisteredUser(RegisteredUser regUser) throws DTException;
}
