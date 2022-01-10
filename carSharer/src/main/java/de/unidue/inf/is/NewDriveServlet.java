package de.unidue.inf.is;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/new_drive"}, name="NewDrive")
public final class NewDriveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setAttribute("uid", req.getParameter("uid"));
		req.getRequestDispatcher("new_drive.ftl").forward(req, res);
		
	}
	

	
	

}
