import TerminalIO.KeyboardReader;
import java.util.*;
import java.io.*;
import BreezySwing.*;

public class AddressBookMain extends GBFrame implements Serializable{
	
	public static BigBadAddressBook ab;

    public static void main(String args[]) {
    	int choice = 0;
    	boolean change = false;
    	
    	KeyboardReader reader = new KeyboardReader();
    	
    	while (choice != 6){
    		
    		System.out.println("\n1.)Create New Address Book\n" +
    			"2.)Edit Address Book\n" +
    				"3.)Open Existing Address Book\n" +
    					"4.)Save Address Book\n" +
    						"5.)View Address Book\n" +
    							"6.)Exit\n");
    		choice = reader.readInt("Enter option: ");
    		System.out.println("");
    					
    		if (choice == 1){
    			ab = new BigBadAddressBook();
    			System.out.println("Address book created.");
    			reader.pause();
    		}
    		
    		if (choice == 2){
    			int option = 0;
    			while (option != 6){
    				System.out.println("\n1.)Create entry\n" +
    					"2.)View entry\n" +
    						"3.)Edit entry\n" +
    							"4.)Delete entry\n" +
    								"5.)Sort entries\n" +
    									"6.)Return\n");
    				option = reader.readInt("Enter option: ");
    				System.out.println("");
    				
    				if (option == 1){
    					String fn = reader.readLine("First Name: ");
    					String ln = reader.readLine("Last Name: ");
    					String sa = reader.readLine("Street Address: ");
    					String c = reader.readLine("City: ");
    					String s = reader.readLine("State(XX): ");
    					String z = reader.readLine("Zip code: ");
    					String p = reader.readLine("Phone number(exclude dashes): ");
    					String e = reader.readLine("E-mail: ");
    					Entries entry = new Entries(fn,ln,sa,c,s,z,p,e);
    					ab.addEntry(entry);
    					change = true;
    				}
    				
    				if (option == 2){
    					String search = reader.readLine("Full Name of entry: ");
    					Entries vEntry = ab.searchEntry(search);
    					if(vEntry == null){
    						System.out.println("Entry not found.");
    					}
    					else{
    						System.out.println(vEntry.toString());
    					}
    					change = true;
    					reader.pause();
    				}
    				
    				if (option == 3){
    					String search = reader.readLine("Full Name of entry: ");
    					Entries eEntry = ab.searchEntry(search);
    					if(eEntry == null){
    						System.out.println("Entry not found.");
    						reader.pause();
    					}
    					else{
    						System.out.println("");
    						String fn = reader.readLine("First Name: ");
    						String ln = reader.readLine("Last Name: ");
    						String sa = reader.readLine("Street Address: ");
    						String c = reader.readLine("City: ");
    						String s = reader.readLine("State(XX): ");
    						String z = reader.readLine("Zip code: ");
    						String p = reader.readLine("Phone number(exclude dashes): ");
    						String e = reader.readLine("E-mail: ");
    						eEntry.editEntry(fn,ln,sa,c,s,z,p,e);
    					}
    					change = true;
    				}
    				
    				if (option == 4){
    					String search = reader.readLine("Full Name of entry: ");
    					Entries dEntry = ab.searchEntry(search);
    					if(dEntry == null){
    						System.out.println("Entry not found.");
    						reader.pause();
    					}
    					else{
    						int d = ab.getEntryIndex(search);
    						ab.deleteEntry(d);
    					}
    					change = true;
    					reader.pause();
    				}
    				
    				if (option == 5){
    					System.out.println("1.)Sort by name\n" +
    						"2.)Sort by phone number\n");
    					int sort = reader.readInt("Select sort type: ");
    					if (sort == 1){
    						ab.sortByName();
    					}
    					else if (sort == 2){
    						ab.sortByPhone();
    					}
    					else{
    						System.out.println("Invalid sort choice...");
    						reader.pause();
    					}
    					change = true;
    					reader.pause();
    				}
    				
    				if (option > 6 || option < 1){
    					System.out.println("Please enter a valid option.");
    					reader.pause();
    				}
    			}
    		}
    		
    		if (choice == 3){
    			String ifilename = reader.readLine("Enter address book file name: ");
    			openAddressBook(ifilename);
    			reader.pause();
    		}
    		
    		if (choice == 4){
    			String ofilename = reader.readLine("Enter address book file name: ");
    			saveAddressBook(ofilename, ab);
    			change = false;
    			reader.pause();
    		}
    		
    		if (choice == 5){
    			System.out.println(ab.toString());
    			reader.pause();
    		}
    		
    		if (choice > 6 || choice < 1){
    			System.out.println("Please enter a valid option.");
    			reader.pause();
    		}
    	}
    	if (change == true){
    		System.out.println("Would you like to save this address book?\n1.)Yes\n2.)No");
    		int yn = reader.readInt();
    		if (yn == 1){
    			String ofilename = reader.readLine("Enter address book file name: ");
    			saveAddressBook(ofilename, ab);
    			change = false;
    			reader.pause();
    		}
    	}
    }
    
    public static void saveAddressBook(String ofn, BigBadAddressBook a){
    	try{
    		FileOutputStream fos = new FileOutputStream (ofn);
    		ObjectOutputStream oos = new ObjectOutputStream (fos);
    		oos.writeObject (a);
    		fos.flush();
    		fos.close();
    	}
    	catch(IOException e){
    		System.out.println("Error - Cannot save file: " + e.toString());
    	}
    }
    
    public static void openAddressBook(String ifn){
    	try{
    		FileInputStream fis = new FileInputStream(ifn);
    		ObjectInputStream ois = new ObjectInputStream(fis);
    		ab = (BigBadAddressBook) ois.readObject();
    		fis.close();
    	}
    	catch(Exception e){
    		System.out.println("Error - Cannot open file: " + e.toString());
    	}
    }
    	
}