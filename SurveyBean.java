

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "state")

public class SurveyBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer numbers;
	
	@Column (name = "firstName")
	private String firstName;
	private String homeState;
	private String homeTown;
	
	
	
	
	public String getHomeState() {
		return homeState;
	}
	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}
	
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Integer getNumber() {
		return numbers;
	}
	public void setNumber(Integer numbers) {
		this.numbers = numbers;
	}
	
	
}
