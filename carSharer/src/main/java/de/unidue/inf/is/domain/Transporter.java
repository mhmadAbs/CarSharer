package de.unidue.inf.is.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import de.unidue.inf.is.utils.DBUtil;

// Transportmittel : {tid : integer, name : String, icon : String]}


public final class Transporter {
	private int tid ;
	private String name;
	private String icon; // Not sure about datatype
	
	public Transporter(int tid, String name, String icon) {
		this.tid = tid;
		this.name = name;
		this.icon = icon;
		//Bus :"https://freedesignfile.com/upload/2017/08/bus-icon-vector.jpg";
		//Car : this.icon = "https://cdn-icons-png.flaticon.com/512/741/741411.png";
	
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}


	public String getIcon(int id) {
		
		return icon;
	}

	
	
	
}
