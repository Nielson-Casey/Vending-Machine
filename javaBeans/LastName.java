package javaBeans;

import java.util.ArrayList;
import java.util.List;

public class LastName implements java.io.Serializable {

	private static final long serialVersionUID = 61388158562106045L;
	
	private List <FirstName> firstNames = new ArrayList<>();
	private String lastName1 = "";
	
	public LastName(){}

	public List<FirstName> getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(List<FirstName> firstNames) {
		this.firstNames = firstNames;
	}

	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}
	
	public String toString()
	{
		
		return firstNames.toString();
	}
	
}