package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.utils.DBUtil;
import de.unidue.inf.is.utils.DateTimeUtil;



@WebServlet(urlPatterns= {"/input_feedback"}, name="inputFeedback")
public class InputHandlerServlet extends HttpServlet{
	List<String> errors;
	Connection conn;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		errors = new ArrayList<String>();

		//int uid = Integer.parseInt(req.getParameter("uid"));
		int uid = 2;
		String from = req.getParameter("from");
		String destination = req.getParameter("destination");
		int capacity = Integer.parseInt(req.getParameter("capacity"));
		String date = req.getParameter("date").replace("-", ".");
		String time = req.getParameter("time");
		String description = req.getParameter("description");
		String transporter = req.getParameter("tr_radio");
		int transporter_id ;
		
		
		if(transporter == "Car") {
			transporter_id = 1;
		}else if(transporter == "Bus") {
			transporter_id = 2;
		}else {
			transporter_id = 3;
		}
		
		if(capacity < 1 || capacity > 10) {
			errors.add("Capacity have to be between 1 and 10 "); 
		}
		int cost = Integer.parseInt(req.getParameter("cost"));
		if(cost <= 0) {
			errors.add("Cost has to be an Integer that is larger than 0");
		}
		
		
		LocalDate current_date = LocalDate.now();
		LocalDate in_date = LocalDate.parse(req.getParameter("date"));
		System.out.println(current_date);
		System.out.println(in_date);
		if(current_date.compareTo(in_date) > 0) { // check if given date in the future 
			errors.add("Date has to be in the future !");
		}
		
		req.setAttribute("from", from);
		req.setAttribute("destination", destination);
		req.setAttribute("capacity", capacity);
		req.setAttribute("cost", cost);
		req.setAttribute("transportmittel", transporter_id);
		req.setAttribute("date", date);
		req.setAttribute("time", time);
		req.setAttribute("description", description);
		req.setAttribute("errors", errors);
		if(errors.isEmpty()) {
			req.setAttribute("valid_input", "Input is Valid");
			// Create new Trip in the Database
			
			try {
				conn = DBUtil.getExternalConnection();
				conn.setAutoCommit(false);
				
				
				String add_stmt = 
					"INSERT INTO dbp198.fahrt (startort, zielort, fahrtdatumzeit, maxPlaetze, fahrtkosten, anbieter, transportmittel, beschreibung)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
					
				PreparedStatement add_trip = conn.prepareStatement(add_stmt);
				add_trip.setString(1, from);
				add_trip.setString(2, destination);
				add_trip.setString(3, DateTimeUtil.convertDateAndTimeToDB2DateTime(date, time));
				add_trip.setInt(4, capacity);
				add_trip.setDouble(5, cost);
				add_trip.setInt(6, uid);
				add_trip.setInt(7, transporter_id);
				add_trip.setString(8, description);
				int rs = add_trip.executeUpdate();
				if(rs != -1) {
					req.setAttribute("inserted", "Trip was added to Database !");
					conn.commit();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				req.setAttribute("db_fail", "Trip was added to Database !");
			}finally {
				if(conn != null) {
					try {
						conn.close();
						System.out.println("closed");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		req.getRequestDispatcher("/feedback.ftl").forward(req, res);
	}
	
	
	
}
