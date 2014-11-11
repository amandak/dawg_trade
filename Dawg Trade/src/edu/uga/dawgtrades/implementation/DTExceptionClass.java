package edu.uga.dawgtrades.implementation;
import edu.uga.dawgtrades.model.DTException;


public class DTExceptionClass implements DTException {

	private static final long serialVersionUID = 1L;
	
	 public DTException( String message )
	 {
	      super( message );
	 }
	 
	 public DTException( Throwable cause )
	 {
	      super( cause );
	 }
}
