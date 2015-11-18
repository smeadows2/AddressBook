import TerminalIO.KeyboardReader;
import java.util.*;
import java.io.*;
 
public class BigBadAddressBook implements Serializable {
    	
    ArrayList bbab;
    	
    public BigBadAddressBook(){
    	bbab = new ArrayList();
    }
    	
    public void addEntry(Entries e){
    	bbab.add(bbab.size(), e);
    }
    
    public Entries searchEntry(String e){
    	Entries searchEntry = null;
    	for (int y = 0; y < bbab.size(); y++){
    		Entries viewEntry = (Entries)bbab.get(y);
    		String firstName = viewEntry.getFirstName();
    		String lastName = viewEntry.getLastName();
    		String fullName = firstName + " " + lastName;
    		if (e.equalsIgnoreCase(fullName)){
    			searchEntry = viewEntry;
    		}
    	}
    	return searchEntry;
    }
    
    public int getEntryIndex(String e){
    	int y = 0;
    	for (int x = 0; x < bbab.size(); x++){
    		Entries viewEntry = (Entries)bbab.get(x);
    		String firstName = viewEntry.getFirstName();
    		String lastName = viewEntry.getLastName();
    		String fullName = firstName + " " + lastName;
    		if (e.equalsIgnoreCase(fullName)){
    			y = x;
    		}
    	}
    	return y;
    }
    
    public void deleteEntry(int d){
    	bbab.remove(d);
    }
    
    public void sortByName(){
    	for (int i = 0; i < bbab.size()-1; i++){
    		for (int j = i + 1; j < bbab.size(); j++){
    			Entries entryA = (Entries)bbab.get(i);
    			Entries entryB = (Entries)bbab.get(j);
    			String nameA = entryA.getLastName();
    			String nameB = entryB.getLastName();
    			if (nameA.compareTo(nameB) > 0){
    				Entries temp = entryA;
    				bbab.set(i,entryB);
    				bbab.set(j,temp);
    			}
    		}
    	}
    }
    
    public void sortByPhone(){
    	for (int i = 0; i < bbab.size()-1; i++){
    		for (int j = i + 1; j < bbab.size(); j++){
    			Entries entryA = (Entries)bbab.get(i);
    			Entries entryB = (Entries)bbab.get(j);
    			String phoneA = entryA.getPhone();
    			String phoneB = entryB.getPhone();
    			if (phoneA.compareTo(phoneB) > 0){
    				Entries temp = entryA;
    				bbab.set(i,entryB);
    				bbab.set(j,temp);
    			}
    		}
    	}
    }
    
    public String toString(){
    	String str = "";
    	for (int x = 0; x < bbab.size(); x++){
    		Entries sEntry = (Entries)bbab.get(x);
    		str = str + sEntry.toString();
    	}
    	return str;
    }
    	    	
}
