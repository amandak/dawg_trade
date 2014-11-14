package edu.uga.dawgtrades.persist.impl;

/**
 * This class defines the parameters that are used when accessing the Database using JDBC.
 * 
 */

public abstract class DbAccessConfig
{
    /** 
     * The fully qualified name of the JDBC driver.
     */
    static final String DB_DRIVE_NAME  = "com.mysql.jdbc.Driver";
    
    /** 
     * The database name
     */
    static final String DB_NAME        = "team1";
    
    /** 
     * The database server name for the connection pool
     */
    static final String DB_SERVER_NAME = "localhost"; //TODO change this

    /** 
     * The JDBC connection string/URL.
     */
    static final String DB_CONNECTION_URL = "jdbc:mysql://uml.cs.uga.edu:3306/team1";

    /** 
     * The database user name.
     */
    static  String DB_CONNECTION_USERNAME = "team1";

    /** 
     * The password for the database user.
     */
    static  String DB_CONNECTION_PWD = "virtual";

}
