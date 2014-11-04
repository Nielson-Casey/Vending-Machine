package javaBeans;

public class FirstName implements java.io.Serializable{
	
	private static final long serialVersionUID = 5238138249612272816L;
	
	private String firstName1 = "";
	
	public FirstName(){}
	
	public void setfirstName1(String firstName1)
	{
		this.firstName1 = firstName1;
	}

	public String getFirstName1() {
		return firstName1;
	}

	public String toString()
	{
		
		return firstName1;
	}
}
