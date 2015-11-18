import java.util.*;
import java.io.*;

public class Entries implements Serializable {
	
	private String fname;
	private String lname;
	private String staddress;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;

    public Entries(String fn, String ln, String sa, String c, String s, String z, String p, String e) {
    	fname = fn;
    	lname = ln;
    	staddress = sa;
    	city = c;
    	state = s;
    	zip = z;
    	phone = p;
    	email = e;
    }
    
    public String toString(){
    	String str = "\nName: " + fname + " " + lname +
    		"\nStreet Address: " + staddress +
    			"\nCity: " + city +
    				"\nState: " + state +
    					"\nZip code: " + zip +
    						"\nPhone number: " + phone +
    							"\nE-mail: " + email + "\n";
    	return str;
    }
    
    public void editEntry(String fn, String ln, String sa, String c, String s, String z, String p, String e){
    	fname = fn;
    	lname = ln;
    	staddress = sa;
    	city = c;
    	state = s;
    	zip = z;
    	phone = p;
    	email = e;
    }
    
    public String getFirstName(){
    	return fname;
    }
    
    public String getLastName(){
    	return lname;
    }
    
    public String getPhone(){
    	return phone;
    }
}