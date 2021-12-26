package de.unidue.inf.is;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.User;

// NEw Branch


/**
 * Einfaches Beispiel, das die Vewendung der Template-Engine zeigt.
 * Will be called when /hello is called
 */


@WebServlet(urlPatterns = {"/hello"}, name = "helloServlet") 
public final class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    private static List<User> userList = new ArrayList<>();

    // Just prepare static data to display on screen
    static {
        userList.add(new User("Bill", "Gates"));
        userList.add(new User("Steve", "Jobs"));
        userList.add(new User("Larry", "Page"));
        userList.add(new User("Sergey", "Brin"));
        userList.add(new User("Larry", "Ellison"));
    }

    // will be called when the Servlet has been called
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Put the user list in request and let freemarker paint it.
        request.setAttribute("users", userList);

        request.getRequestDispatcher("/index.ftl").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
                    IOException {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");

        if (null != firstname && null != lastname && !firstname.isEmpty() && !lastname.isEmpty()) {

            synchronized (userList) {
                userList.add(new User(firstname, lastname));
            }

        }

        // Display the list again after an Entry was added.
        doGet(request, response);
    }
}
