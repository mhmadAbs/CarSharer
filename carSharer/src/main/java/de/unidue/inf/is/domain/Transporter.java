package de.unidue.inf.is.domain;


// Transportmittel : {tid : integer, name : String, icon : String]}


public final class Transporter {
	private int tid ;
	private String name;
	private String icon; // Not sure about datatype
	
	public Transporter() {
		
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

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	
}
