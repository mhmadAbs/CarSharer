package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Trip;
import de.unidue.inf.is.utils.DBUtil;


@WebServlet(urlPatterns = {"/view_drive"}, name="ViewDrive")
public final class ViewDriveServlet extends HttpServlet {
	private Trip trip;
	private Connection conn;
	private int trip_id;
	private String icon;
	private int driver_id;
	private String driver_mail;
	private int free_seats;
	private int max_seats;
	
	public int getTrip_id() {
		return trip_id;
	}
	public int getDriverId(){
		return driver_id;
	}
	public String getDriverMail() {
		return driver_mail;
	}

	public String getIcon() {
		return icon;
	}
	public Trip getTrip() {
		return trip;
	}
	public int getFreeSeats() {
		return free_seats;
	}

	
	
	

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		this.trip_id = Integer.parseInt(req.getParameter("tid")); 
		this.icon = req.getParameter("icon"); 
		
		try {
			conn = DBUtil.getExternalConnection();
			
			String trip_query = "Select * from dbp198.fahrt f where f.fid = ? ";
			PreparedStatement trip_ps = conn.prepareStatement(trip_query);
			trip_ps.setInt(1, getTrip_id());
			
			
			ResultSet rs = trip_ps.executeQuery();
			
			
			while(rs.next()) {
				driver_id = rs.getInt("anbieter");
				max_seats = rs.getInt("maxPlaetze");
				trip = new Trip(rs.getInt("fid"), rs.getInt("maxPlaetze"), rs.getString("Beschreibung"),
						rs.getString("Status"), rs.getString("startort"), rs.getString("zielort"),
						String.valueOf(rs.getTimestamp("fahrtdatumzeit")), rs.getFloat("fahrtkosten"), getDriverId(),
						rs.getInt("transportmittel"));
			}
			
			
			// Query already reserved seats to calculate the remaining seats
			
			String reserved_seats_query = "Select sum(anzPlaetze) as seats from dbp198.reservieren r where r.fahrt = ? group by fahrt";
			PreparedStatement reserved_seats_ps = conn.prepareStatement(reserved_seats_query);
			reserved_seats_ps.setInt(1, getTrip_id());
			
			ResultSet rs2 = reserved_seats_ps.executeQuery();
			
			
			
			while(rs2.next()) {
				free_seats = max_seats - rs2.getInt("seats");
			}
			
			
			
			String mail_query = "Select * from dbp198.benutzer b where b.bid = ?";
			PreparedStatement mail_ps = conn.prepareStatement(mail_query);
			mail_ps.setInt(1, this.getDriverId());
			
			ResultSet rs3 = mail_ps.executeQuery();
			
			while(rs3.next()) {
				driver_mail = rs3.getString("email");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		// prepare data needed in the view drive page
		req.setAttribute("trip", getTrip());
		req.setAttribute("icon", getIcon());
		req.setAttribute("mail", getDriverMail());
		req.setAttribute("free_seats", getFreeSeats());
		
		req.getRequestDispatcher("view_drive.ftl").forward(req, res);
	}
	

	
	

	
}
