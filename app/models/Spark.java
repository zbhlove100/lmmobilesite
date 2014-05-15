package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="spark")
public class Spark extends BaseModel{
	public String name;
	public String description;
}
