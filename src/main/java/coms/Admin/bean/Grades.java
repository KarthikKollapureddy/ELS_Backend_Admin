package coms.Admin.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade_info")
public class Grades {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int gradId;
	public String gradName;
	public int getGradId() {
		return gradId;
	}
	public void setGradId(int gradId) {
		this.gradId = gradId;
	}
	public String getGradName() {
		return gradName;
	}
	public void setGradName(String gradName) {
		this.gradName = gradName;
	}
	public Grades(int gradId, String gradName) {
		super();
		this.gradId = gradId;
		this.gradName = gradName;
	}
	public Grades(String gradName) {
		super();
		this.gradName = gradName;
	}
	public Grades() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
