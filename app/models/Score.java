package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score extends BaseModel{
	
	public String score;
	
	public String examname;
	
	public String year;
	
	public String bigone;
	
	public String state;
	
	public Date examtime;
	
	@ManyToOne
	public Student student;
}
