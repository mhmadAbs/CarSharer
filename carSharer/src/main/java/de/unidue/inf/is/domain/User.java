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
    

    // Transporter tra = new Transporter(1, "Mercedes", "https://cdn-icons-png.flaticon.com/512/741/741411.png");
	// Transporter tra2 = new Transporter(1, "BMW", "https://cdn-icons-png.flaticon.com/512/741/741407.png");
	// Trip trip = new Trip(1, 10, "Offen", "aaaaaaaaaaaaaaaaaaaaaaaSa", "start", "end", "01/02/2018", "12:15", 55, this,tra);
    // Trip trip2 = new Trip(2, 5, "Geschlossen", "aa", "start2", "end2", "01/02/1999", "12:00", 55, this,tra2);
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