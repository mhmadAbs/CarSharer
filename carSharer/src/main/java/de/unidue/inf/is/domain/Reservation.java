package de.unidue.inf.is.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.unidue.inf.is.utils.DBUtil;
import de.unidue.inf.is.utils.Help;

public final class Reservation {
	
	
	private int uid;
	private int trip_id;
	private int places;
	private String trip_end_address;
	private String trip_start_address;
	private String trip_icon;
	private String trip_status;
	private Connection conn;
	private Connection conn2;
	
	
	public Reservation(int uid, int trip_id, int places) throws SQLException {
		this.uid = uid;
		this.trip_id = trip_id;
		this.places = places;
		setTripInfo();
		this.trip_icon = Help.getTripIcon(trip_id);
	}
	public int getUid() {
		return uid;
	}
	public int getTripId() {
		return trip_id;
	}
	public int getPlaces() {
		return places;
	}
	public String getTripEndAddress() {
		return trip_end_address;
	}
	public String getTripStartAddress() {
		return trip_start_address;
	}
	
	public String getTripStatus() {
		return trip_status;
	}
	public String getTripIcon() throws SQLException {
		return this.trip_icon;
	}
	
	public void setTripIcon(String icon) throws SQLException{
		this.trip_icon = icon;
	}
	
	public void setTripInfo() throws SQLException{
		
		try {
			conn2 = DBUtil.getExternalConnection();
			String status_query = "Select * from dbp198.fahrt f where f.fid = ? ";
			PreparedStatement ps4 = conn2.prepareStatement(status_query);
			ps4.setInt(1, this.getTripId());
			
			ResultSet rs = ps4.executeQuery();
			while(rs.next()) {
				
				this.trip_start_address =  rs.getString("startort");
				this.trip_end_address = rs.getString("zielort");
				this.trip_status = rs.getString("status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn2 != null) {
				conn2.close();
			}
		}
	}
	
}
