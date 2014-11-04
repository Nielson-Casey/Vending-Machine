

import java.util.Scanner;

public class hibView {
	// This is used to be able to get input from the user
	private static Scanner in;
	
	//Starts the view
	public static void runthis(){
		//creates the object for getting user input
		in = new Scanner(System.in);
		
		//This is what is viewed by the user; asks for input; saves data into the variables
		System.out.println("Insert your name: ");
		String name = in.nextLine();
		
		System.out.println("Insert your home state: ");
		String state = in.nextLine();
	
		System.out.println("Insert your town: ");
		String town = in.nextLine();
		
		//Starts the control and inputs the data into it
		hibControl con = new hibControl(name, state, town);
		con.runThis();
		
	}
}
