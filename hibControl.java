

import java.io.Serializable;

public class hibControl implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//variables needed
	private String homeStateInput;
	private String homeTownInput;
	private String firstNameInput;
	
	//here is the constructor; takes the values passed by hibView and assigns them locally
	public hibControl(String name, String state, String town) {
		// TODO Auto-generated constructor stub
		this.firstNameInput = name;
		this.homeStateInput = state;
		this.homeTownInput  = town;
	}
	
	//runs the control
	public void runThis(){
		
		//creates an instance of the hibernate compatible bean
		SurveyBean bean = new SurveyBean();
		
		//assigns the values to the hibernate compatible bean
		bean.setFirstName(this.firstNameInput);
		bean.setHomeState(this.homeTownInput);
		bean.setHomeTown(this.homeStateInput);
		
		//calls the model which communicates with the database via hibernate
		hibModel mod = new hibModel();
		
		//passes in the instance of the bean
		mod.addToDb(bean);
	
	}
	
	/*
		this.addToDb(bean);
	}

	public void addToDb (SurveyBean bean){
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(bean);
		transaction.commit();
	}
	*/
}
