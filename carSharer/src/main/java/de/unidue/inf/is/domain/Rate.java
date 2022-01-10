package de.unidue.inf.is.domain;

import java.util.Date;


// Bewertung : {[beid : integer, textNachricht : String, erstellungsdatum : Date, rating : integer]}

public final class Rate {
	private int id;
	private String comment;
	private Date rating_date;
	private int rating;
	
	public Rate(int id, String comment,Date rating_date, int rating) {
		this.id = id;
		this.comment = comment;
		this.rating_date = rating_date;
		this.rating = rating;
	}

	public int getBeid() {
		return this.id;
	}

	public String getComment() {
		return comment;
	}


	public Date getRating_date() {
		return rating_date;
	}


	public int getRating() {
		return rating;
	}

	
	
	
}
