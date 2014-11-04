package javaBeans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;


public class Main implements Serializable {

	public static void main(String[] args) {
		
		State idaho = new State();
		State utah = new State();
		
        LastName white = new LastName();
        LastName black = new LastName();
        
        FirstName bob = new FirstName();
        FirstName sue = new FirstName();
        FirstName joe = new FirstName();
		
		bob.setfirstName1("bob");
        sue.setfirstName1("sue");
        joe.setfirstName1("joe");
               
        ArrayList<FirstName> firstNames = new ArrayList<>(); 
        firstNames.add(bob);
        firstNames.add(sue);
        firstNames.add(joe);
                
        white.setFirstNames(firstNames);
        white.setLastName1("White");
        
        black.setFirstNames(firstNames);
        black.setLastName1("Black");
        
        
        HashMap<String,LastName> group1 = new HashMap<String,LastName>();      
        HashMap<String,LastName> group2 = new HashMap<String,LastName>();
        
        HashMap<String,State> states = new HashMap<String,State>();
        
        group1.put("white", white);
        group2.put("black", black);
        
        utah.setState("utah");
        utah.setLastnames(group2);
        
        idaho.setState("Idaho");       
        idaho.setLastnames(group1);
        
        states.put("Idaho", idaho);
        states.put("Utah", utah);
        
       // System.out.println(states);
        //System.out.println(group2);
        
        
        File aFile = new File("test.json");
        try {
        FileOutputStream aFileStream = new FileOutputStream(aFile);
        JSONOutputStream jsonOut =
        new JSONOutputStream(aFileStream);
        jsonOut.writeObject(group1);
        jsonOut.close();
        }
        catch (Exception e) {
        e.printStackTrace();
        }
   
        
        try {
        	FileInputStream aFileStream = new FileInputStream(aFile);
        	JSONInputStream objectIn = new JSONInputStream(aFileStream);
        	
        	//Person aPerson = (Person)objectIn.readObject();
        	HashMap<String,Object> cow = (HashMap<String,Object> )objectIn.readObject();
        	
        	objectIn.close();
        	System.out.println(cow);
        	
        	}
        	catch (Exception e) {
        	e.printStackTrace();
        	}      
        
	}

}
