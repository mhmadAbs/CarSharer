package de.unidue.inf.is.domain;

import java.sql.Time;
import java.util.Date;


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
	private String start_adress;
	private String end_adress;
	private Date trip_date;
	private Time time;
	private double cost;
	private int user_id;
	private int transporter_id;
	
	


	public Trip(int trip_id, int max_places, String description, String status, String start_adress, String end_adress,
			Date trip_date, Time time, double cost, User user, Transporter transporter) {
		
		this.trip_id = trip_id;
		this.max_places = max_places;
		this.description = description;
		this.status = status;
		this.start_adress = start_adress;
		this.end_adress = end_adress;
		this.trip_date = trip_date;
		this.time = time;
		this.cost = cost;
		this.user_id = user.getUid();
		this.transporter_id = transporter.getTid();
	}
	
	// Overloading Constructor so that we make entering a description optional
	public Trip(int trip_id, int max_places, String status, String start_adress, String end_adress,
			Date trip_date, Time time, double cost, User user, Transporter transporter) {
		
		this.trip_id = trip_id;
		this.max_places = max_places;
		this.description = ""; // So that we don't get null Exception
		this.status = status;
		this.start_adress = start_adress;
		this.end_adress = end_adress;
		this.trip_date = trip_date;
		this.time = time;
		this.cost = cost;
		this.user_id = user.getUid();
		this.transporter_id = transporter.getTid();
	}
	
	
	public int getTrip_id() {
		return trip_id;
	}


	public int getMax_places() {
		return max_places;
	}


	public String getStart_adress() {
		return start_adress;
	}


	public String getEnd_adress() {
		return end_adress;
	}


	public Date getTrip_date() {
		return trip_date;
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
	public String getStart_Adress() {
		return start_adress;
	}
	public String getEnd_Adress() {
		return end_adress;
	}
	public Date getDate() {
		return trip_date;
	}
	public Time getTime() {
		return time;
	}
	public double getCost() {
		return cost;
	}

	public int getUser_id() {
		return user_id;
	}

	public int getTransporter_id() {
		return transporter_id;
	}
	
	
	

}
