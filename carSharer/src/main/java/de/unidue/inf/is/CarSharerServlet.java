package de.unidue.inf.is;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.utils.DBUtil;



/**
 * Das könnte die Eintrittsseite sein.
 */


@WebServlet(urlPatterns = "/carSharer", name = "carSharerServlet")
public final class CarSharerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
  
        boolean databaseExists = DBUtil.checkDatabaseExistsExternal();
        
        // setAttributes let us send data to the target file so that we can use it there.
        if (databaseExists) {
            request.setAttribute("db2exists", "vorhanden! Supi!");
        }
        else {
            request.setAttribute("db2exists", "nicht vorhanden :-(");
        }

        // request is sent to carSharer_start.ftl so a html page will be created.
        request.getRequestDispatcher("carSharer_start.ftl").forward(request, response);
    }

}