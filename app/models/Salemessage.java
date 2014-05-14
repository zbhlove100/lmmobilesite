package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="salemessage")
public class Salemessage extends BaseModel{
	public String state;
	
	public String title;
	
	public String year;
	
	public String summary;
	
	public String detail;
	
	public String htmlname;
	
	public Date createdAt;
	
	@OneToMany(mappedBy="salemessage")
    public List<ImgDetail> imgs;
	
}
