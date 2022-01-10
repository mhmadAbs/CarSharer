package de.unidue.inf.is.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import de.unidue.inf.is.domain.User;

// import de.unidue.inf.is.utils.DBUtil;

public class Help {
	
	
	
	// Diese Methode benutzen, um sich von außerhalb der Uni mit der DB zu verbinden
    public static Connection getExternalConnection() throws SQLException {
        Properties properties = new Properties();

        InputStream input = null;
        try {
            input = new FileInputStream("settings.properties");

            // Zugangsdaten aus der Properties-Datei lesen
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String user = properties.getProperty("gruppenname");
        String pass = properties.getProperty("passwort");
        String rechnername = properties.getProperty("rechnername");
        String database = properties.getProperty("database");

        String gruppennummer = user.split("(?<=\\D)(?=\\d)")[1];

        final String url = "jdbc:db2://" + rechnername + ".is.inf.uni-due.de:50" + gruppennummer + "/" + database + ":currentSchema=" + user + ";";
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }


    public static boolean checkDatabaseExistsExternal() {
        // Nur für Demozwecke!
        boolean exists = false;

        try (Connection connection = getExternalConnection()) {
            exists = true;
        } catch (SQLException e) {
            exists = false;
            e.printStackTrace();
        }

        return exists;
    }

	public static String getTripIcon(int tid) throws SQLException {
		Connection conn = DBUtil.getExternalConnection();
		String trip_icon = "";
		try {
			conn = getExternalConnection();
			String icon_query = "Select * from dbp198.transportmittel t join dbp198.fahrt f on t.tid = f.transportmittel where f.fid = ?"; 
					
			PreparedStatement ps = conn.prepareStatement(icon_query);
			ps.setInt(1, tid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				trip_icon = rs.getString("icon");
			}
			  
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				conn.close();
			}
		}
		
		
		return trip_icon;
	}
	
}
