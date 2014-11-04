

import org.hibernate.Session;
import org.hibernate.Transaction;

public class hibModel {
	
	//calls the instance of the survey bean that has the values
	SurveyBean bean = new SurveyBean();
	
	
	public void addToDb (SurveyBean bean){
		
		//starts the session
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		
		//creates the transaction
		Transaction transaction = session.beginTransaction();
		
		//saves the values that are in SurveyBean
		session.save(bean);
		
		//saves the session and exits
		transaction.commit();
	}

}
