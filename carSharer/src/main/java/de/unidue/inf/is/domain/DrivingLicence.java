package de.unidue.inf.is.domain;

import java.util.Date;

// Fahrerlaubnis : {[Nummer : integer, Ablaufdatum : Date, Benutzer.bid : Integer]}

public final class DrivingLicence {
	private int number;
	private Date exp_date;
	private int user_id ;
	
	public DrivingLicence(int number, Date exp_date, User user) {
		this.number = number;
		this.exp_date = exp_date;
		this.user_id = user.getId();
	}

	public int getNumber() {
		return number;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public int getUser_id() {
		return user_id;
	}
	
	
	
	
	
	
}
