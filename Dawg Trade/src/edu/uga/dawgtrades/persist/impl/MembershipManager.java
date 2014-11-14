package edu.uga.dawgtrades.persist.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import com.mysql.jdbc.PreparedStatement;

import edu.uga.dawgtrades.model.Membership;
import edu.uga.dawgtrades.model.ObjectModel;


public class MembershipManager {

	private ObjectModel objectModel = null;
	private Connection conn = null;
	
	public MembershipManager(Connection conn, ObjectModel objectModel){
		this.conn = conn;
		this.objectModel = objectModel;
	}
	
	
	
}