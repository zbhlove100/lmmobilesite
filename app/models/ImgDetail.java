package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="img_detail")
public class ImgDetail extends BaseModel {

    public String basicImg;
    
    public String state;
    
    @OneToOne
    public Teacher teacher;
    
    @OneToOne
    public Student student;
    
    @ManyToOne
    public Salemessage salemessage;
    
    @ManyToOne
    public Spark spark;
}
