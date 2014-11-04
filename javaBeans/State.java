package javaBeans;

import java.util.HashMap;

public class State implements java.io.Serializable{

	private static final long serialVersionUID = 5238138249612272816L;

	private String state = "";
	private HashMap<String,LastName> lastnames = new HashMap<String,LastName>();
	
	public State(){}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public HashMap<String, LastName> getLastnames() {
		return lastnames;
	}

	public void setLastnames(HashMap<String, LastName> lastnames) {
		this.lastnames = lastnames;
	}

	public String toString()
	{
		
		return lastnames.toString();
	}

}
