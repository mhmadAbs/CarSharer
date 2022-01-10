package de.unidue.inf.is.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import de.unidue.inf.is.utils.DBUtil;
import de.unidue.inf.is.utils.Help;

/*
Fahrt : 
{[
	fid : integer, max_places : integer, description : String, status : String ,
	start_adress : String,end_adress : String, trip_date : Date, time : Time , cost : float,
	Transportmittel.tid : integer, Benutzer.bid :integer
]} 
*/


public final class Trip {
	
	private int trip_id;
	private int max_places;
	private String description;
	private String status; // make sure status is allowed (Assert ?) - DB deals with it ?
	private String start_address;
	private String end_address;
	private String trip_date_time;
	private String icon;
	private float cost;
	private int user_id;
	
	private int transporter_id;
	private Connection conn;
	
	


	public Trip(int trip_id, int max_places, String description, String status, String start_adress, String end_adress,
			String trip_date_time, float cost, int user_id, int transporter_id) throws SQLException {
		
		this.trip_id = trip_id;
		this.max_places = max_places;
		if(description == null) {
			this.description = "";
		}else {
			this.description = description;
		}
		
		this.status = status;
		this.start_address = start_adress;
		this.end_address = end_adress;
		this.trip_date_time = trip_date_time;
		this.cost = cost;
		this.user_id = user_id;
		this.transporter_id = transporter_id;
		this.icon = Help.getTripIcon(trip_id);
	}
	

	
	public int getId() {
		return trip_id;
	}



	public String getStartAddress() {
		return start_address;
	}


	public String getEndAddress() {
		return end_address;
	}


	public int getMaxPlaces() {
		return max_places;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}

	public String getDateTime() {
		return trip_date_time;
	}
	public double getCost() {
		return cost;
	}

	public int getUID() {
		return user_id;
	}

	public int getTransporter() {
		return this.transporter_id;
	}
	
	public String getIcon() throws SQLException {
		return this.icon;
	}


	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

	public void setMax_places(int max_places) {
		this.max_places = max_places;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStartAddress(String start_adress) {
		this.start_address = start_adress;
	}

	public void setEndAddress(String end_adress) {
		this.end_address = end_adress;
	}

	public void setDateTime(String trip_date) {
		this.trip_date_time = trip_date;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setTransporter(int transporter_id) {
		this.transporter_id = transporter_id;
	}
	

	

}
