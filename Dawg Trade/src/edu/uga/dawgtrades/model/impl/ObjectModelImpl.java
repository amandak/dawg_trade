package edu.uga.dawgtrades.model.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;

import edu.uga.dawgtrades.model.Attribute;
import edu.uga.dawgtrades.model.AttributeType;
import edu.uga.dawgtrades.model.Auction;
import edu.uga.dawgtrades.model.Bid;
import edu.uga.dawgtrades.model.Category;
import edu.uga.dawgtrades.model.DTException;
import edu.uga.dawgtrades.model.ExperienceReport;
import edu.uga.dawgtrades.model.Item;
import edu.uga.dawgtrades.model.Membership;
import edu.uga.dawgtrades.model.ObjectModel;
import edu.uga.dawgtrades.model.RegisteredUser;


public class ObjectModelImpl implements ObjectModel {

	@Override
	public Category createCategory(Category parent, String name)
			throws DTException {
		
		if(!parent.isPersistent())
			throw new DTException("The parent category is not a persistent object.");
		
		Category newCategory = new CategoryImpl();
		newCategory.setName(name);
		newCategory.setParentId(parent.getId());
		newcategory.setId(-1);
		
		return newCategory;
	}

	@Override
	public Category createCategory() {
		
		return new CategoryImpl();
	}

	@Override
	public Iterator<Category> findCategory(Category modelCategory)
			throws DTException {
		
		if(modelCategory == null) {
			//Retrieve all categories
		}
		
		long searchId = modelCategory.getId();
		String searchName = modelCategory.getName();
		long searchParent = modelCategory.getParentId();
		
		//Search for the categories based on which aren't null
		
		return null;
	}

	@Override
	public void storeCategory(Category category) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(Category category) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AttributeType createAttributeType(Category category, String name)
			throws DTException {
		
		AttributeType newAttrType = new AttributeTypeImpl();
		
		newAttrType.setName(name);
		newAttrType.setCategoryId(category.getId());
		newAttrType.setId(-1);
		
		return newAttrType;
	}

	@Override
	public AttributeType createAttributeType() {
		
		return new AttributeTypeImpl();
	}

	@Override
	public void storeAttributeType(AttributeType attributeType)
			throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAttributeType(AttributeType attributeType)
			throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Item createItem(Category category, RegisteredUser user,
			String identifier, String name, String description)
			throws DTException {
		
		Item newItem = new ItemImpl();
		
		newItem.setOwnerId(category.getId()); 
		newItem.setOwnerId(user.getId());
		//newItem.setIdentifier(identifier); //May not be implemented
		newItem.setName(name);
		newItem.setDescription(description);
		
		return newItem;
	}

	@Override
	public Item createItem() {
		
		return new ItemImpl();
	}

	@Override
	public Iterator<Item> findItem(Item modelItem) throws DTException {

		if(modelItem == null) {
			//Retrieve all Items
		}
		
		//Get the items and stuff
		
		return null;
	}

	@Override
	public void storeItem(Item item) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(Item item) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Attribute createAttribute(AttributeType attributeType, Item item,
			String value) throws DTException {
		
		Attribute newAttr = new AttributeImpl();
		
		newAttr.setAttributeType(attributeType.getId());
		newAttr.setItemId(item.getId());
		newAttr.setValue(value);
		
		return newAttr;
	}

	@Override
	public Attribute createAttribute() {
		
		return new AttributeImpl();
	}

	@Override
	public void storeAttribute(Attribute attribute) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAttribute(Attribute attribute) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Auction createAuction(Item item, float minPrice, Date expiration)
			throws DTException {
		
		Auction newAuction = new AuctionImpl();
		
		newAuction.setItemId(item.getId());
		newAuction.setMinPrice(minPrice);
		newAuction.setExpiration(expiration);
		
		return newAuction;
	}

	@Override
	public Auction createAuction() {
		
		return new AuctionImpl();
	}

	@Override
	public Iterator<Auction> findAuction(Auction modelAuction)
			throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeAuction(Auction auction) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAuction(Auction auction) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RegisteredUser createRegisteredUser(String name, String firstName,
			String lastName, String password, boolean isAdmin, String email,
			String phone, boolean canText) throws DTException {

		RegisteredUser newUser = new RegisteredUserImpl();
		
		newUser.setName(name);
		newUser.setFirstName(firstName);
		newUser.setLastName(lastName);
		newUser.setPassword(password);
		newUser.setIsAdmin(isAdmin);
		newUser.setEmail(email);
		newUser.setPhone(phone);
		newUser.setCanText(canText);
		
		return newUser;
	}

	@Override
	public RegisteredUser createRegisteredUser() {
		
		return new RegisteredUserImpl();
	}

	@Override
	public RegisteredUser findRegisteredUser(RegisteredUser modelRegisteredUser)
			throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeRegisteredUser(RegisteredUser registeredUser)
			throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRegisteredUser(RegisteredUser registeredUser)
			throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bid createBid(Auction auction, RegisteredUser user, float price)
			throws DTException {

		Bid newBid = new BidImpl();
		
		newBid.setAmount(price);
		//Other setters?
		
		return newBid;
	}

	@Override
	public Bid createBid() {
		
		return new BidImpl();
	}

	@Override
	public Iterator<Bid> findBid(Bid modelBid) throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeBid(Bid bid) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBid(Bid bid) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExperienceReport createExperienceReport(RegisteredUser reviewer,
			RegisteredUser reviewed, int rating, String report, Date date)
			throws DTException {
		
		ExperienceReport newExprRep = new ExperienceReportImpl();
		
		newExprRep.setReviewer(reviewer);
		newExprRep.setReviewed(reviewed);
		newExprRep.setRating(rating);
		newExprRep.setReport(report);
		newExprRep.setDate(date);
		
		return newExprRep;
	}

	@Override
	public ExperienceReport createExperienceReport() {
		
		return new ExperienceReportImpl();
	}

	@Override
	public Iterator<ExperienceReport> findExperienceReport(
			ExperienceReport modelExperienceReport) throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeExperienceReport(ExperienceReport experienceReport)
			throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteExperienceReport(ExperienceReport experienceReport)
			throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Membership createMembership(float price, Date date)
			throws DTException {
		
		Membership newMembership = new MembershipImpl();
		newMembership.setPrice(price);
		//Set date
		
		return newMembership;
	}

	@Override
	public Membership createMembership() {
		
		return new MembershipImpl();
	}

	@Override
	public Membership findMembership() throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void storeMembership(Membership membership) throws DTException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getParent(Category category) throws DTException {

		Category modelCategory = new CategoryImpl();
		modelCategory.setId(category.getParentId()); 
		return modelCategory;
	}

	@Override
	public Iterator<Category> getChild(Category category) throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory(AttributeType attributeType) throws DTException {

		if(!attributeType.isPersistent()) 
			throw new DTException("Attribute type is not persistent.");
		
		else {
			Category category = new CategoryImpl();
			category.setId(attributeType.getCategoryId());
			
			if(!findCategory(category).hasNext())
				throw new DTException("No such category found.");
			else
				return findCategory(category).next();
		}
	}

	@Override
	public Iterator<AttributeType> getAttributeType(Category category)
			throws DTException {

		//Get the Category's AttributeTypes
		
		return null;
	}

	@Override
	public Category getCategory(Item item) throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Item> getItem(Category category) throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItem(Attribute attribute) throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Attribute> getAttribute(Item item) throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisteredUser getRegisteredUser(Item item) throws DTException {
		
		if(!item.isPersistent())
			throw new DTException("Item is not persistent");
		
		else {
			
			/*RegisteredUser regUser = new RegisteredUserImpl();
			regUser.setId(item.getOwnerId());
			return regUser;*/
			return null;
		}
	}

	@Override
	public Iterator<Item> getItem(RegisteredUser registeredUser)
			throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItem(Auction auction) throws DTException {

		/*Item item = new ItemImpl();
		item.setId(auction.getId());
		return item;*/
		return null;
	}

	@Override
	public Auction getAuction(Item item) throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeType getAttributeType(Attribute attribute)
			throws DTException {
		// TODO Auto-generated method stub
		return null;
	}

}
