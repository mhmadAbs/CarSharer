package de.unidue.inf.is.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;

import de.unidue.inf.is.utils.DBUtil;
import de.unidue.inf.is.utils.DateTimeUtil;

// Benutzer : {[bid : integer, Name : String, email : String]}

public final class User {

	private Integer id;
	private String name;
    private String email;
    public List<Reservation> reservations = new ArrayList<Reservation>();
    
    Connection conn ;

    	
    	

    public User(int uid, String name, String email) throws SQLException {
    	this.id = uid;
    	this.name = name;
    	this.email = email;
    	
    	
    		
    	
    	
    	}
    	
    
    
    public String getName() {
    	return this.name;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public Integer getId() {
    	return this.id;
    }
    
    public List<Reservation> getReservations(){
    	return reservations;
    }


    

}