package de.unidue.inf.is.domain;


// Benutzer : {[bid : integer, Name : String, email : String]}

public final class User {

	private int uid;
	private String name;
    private String email;
    
    


    public User(int uid, String name, String email) {
    	this.uid = uid;
    	this.name = name;
    	this.email = email;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public int getUid() {
    	return this.uid;
    }


    

}