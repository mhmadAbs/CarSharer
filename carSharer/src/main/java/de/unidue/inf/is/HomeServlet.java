package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Reservation;
import de.unidue.inf.is.domain.Trip;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;


/*
 * A User will be hard codded 
 * All his reservations will be added to his list of reservations
 * Data will be sent to home_page to display reserved trips.
 * */


@WebServlet(urlPatterns = "/MainView", name = "homeServlet")
public final class HomeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	Connection conn;
	List<Trip> available_trips;
	User user;
	public List<Trip> getAvailableTrips(){
		return available_trips;
	}
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		available_trips = new ArrayList<Trip>();
	try {
			user = new User(2, "Alan Turing", "alan@turing.com");
		
    		conn = DBUtil.getExternalConnection();
    		// Get all Reservations for this user and put them in the list.
    		String reservations_query = "Select * from dbp198.reservieren where kunde = ? ";
    		PreparedStatement reserv_ps = conn.prepareStatement(reservations_query); 
    		reserv_ps.setInt(1, user.getId());
    		ResultSet reservs_res = reserv_ps.executeQuery();
    		while(reservs_res.next()) {
    			int k = reservs_res.getInt("kunde");
    			int f = reservs_res.getInt("fahrt");
    			int p = reservs_res.getInt("anzPlaetze");
    			user.reservations.add(new Reservation(k, f, p));
    		}
    		
    		
    		
    		
    		// Get trips which still have free seats
		StringBuffer trips_query = new StringBuffer();
		trips_query.append("select f.fid, startort, zielort, fahrtdatumzeit, maxPlaetze, fahrtkosten, status, anbieter, transportmittel, f.beschreibung from dbp198.fahrt f where f.fid not in (select fahrt from dbp198.reservieren)");
		trips_query.append("union all");
		trips_query.append("(select f2.fid, startort, zielort, fahrtdatumzeit, f2.maxPlaetze, fahrtkosten, status, anbieter, transportmittel, f2.beschreibung from ");
		trips_query.append("(dbp198.fahrt f2 join");
		trips_query.append("(select f.fid, f.maxPlaetze, sum(anzPlaetze) as reserved from dbp198.fahrt f join dbp198.reservieren r on f.fid = r.fahrt ");
		trips_query.append("group by f.fid, f.maxPlaetze) as tmp on f2.fid = tmp.fid) ");
		trips_query.append("where tmp.reserved < tmp.maxPlaetze)");
		
		
		
    		
    		
    		
    		PreparedStatement trips_ps = conn.prepareStatement(trips_query.toString());
    		ResultSet trips_result = trips_ps.executeQuery(); 
    		while(trips_result.next()) {
    				available_trips.add(new Trip(trips_result.getInt("fid"), 
						trips_result.getInt("maxPlaetze"), 
						trips_result.getString("Beschreibung"),
						trips_result.getString("Status"),
						trips_result.getString("startort"),
						trips_result.getString("zielort"),
						String.valueOf(trips_result.getTimestamp("fahrtdatumzeit")),
						trips_result.getFloat("fahrtkosten"),
						trips_result.getInt("anbieter"),
						trips_result.getInt("transportmittel")));
    		}
    			
    			
    		// send the list with the request so freemarker has access to it.
    		req.setAttribute("reservations", user.getReservations());
			req.setAttribute("open_trips", getAvailableTrips());
			// send the mail of the user since it is the view_drive page
			req.setAttribute("email", user.getEmail());
			req.setAttribute("uid", user.getId());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// forward to freemarker to create a webpage.
			req.getRequestDispatcher("home_page.ftl").forward(req, res);
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
}
	

}
