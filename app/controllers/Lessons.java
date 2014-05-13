package controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.net.URLCodec;
import org.hibernate.cfg.Settings;

import jxl.*;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import play.Play;
import play.libs.MimeTypes;
import play.mvc.Http;
import utils.MyDateUtils;
import models.BaseModel;
import models.Classroom;
import models.Code;
import models.Grade;
import models.Lesson;
import models.LessonTable;
import models.Order;
import models.School;
import models.Setting;
import models.Student;
import models.Teacher;

import com.google.gson.Gson;

public class Lessons extends CRUD {
    private static final String ATTACHMENT_DISPOSITION_TYPE = "attachment";
    
    private static final String INLINE_DISPOSITION_TYPE = "inline";
    private static final String LESSON_AVALIABLE_YEARS = "lesson_avaliable_years";
    private static URLCodec encoder = new URLCodec();
    
    public static void list(){
        
        
        
    	List<Setting> nowseason = Setting.find("name = ?", "NOW_SEASON").fetch();
    	Setting nowyear = Setting.find("name = ?", "NOW_YEAR").first();
    	StringBuffer bf = new StringBuffer("state != '"+ BaseModel.DELETE+"'");
    	bf.append("\n and lesson_year = '"+nowyear.value+"'");
    	if(nowseason.size()!=0){
    		bf.append("\n and ( ");
    		bf.append("\n lessonTimeType like '"+nowseason.get(0).value+"'");
            for(int i=1;i<nowseason.size();i++){
            	String value = nowseason.get(i).value;
            	bf.append("\n and lessonTimeType like '"+value+"'");
            }
            bf.append("\n )"); 
    	}
    	bf.append("\n and collection = '少儿系列'");
    	bf.append("\n order by id desc");   
    	
    	StringBuffer bf2 = new StringBuffer("state != '"+ BaseModel.DELETE+"'");
    	bf2.append("\n and lesson_year = '"+nowyear.value+"'");
    	if(nowseason.size()!=0){
    		bf2.append("\n and ( ");
    		bf2.append("\n lessonTimeType like '"+nowseason.get(0).value+"'");
            for(int i=1;i<nowseason.size();i++){
            	String value = nowseason.get(i).value;
            	bf2.append("\n and lessonTimeType like '"+value+"'");
            }
            bf2.append("\n )"); 
    	}
    	bf2.append("\n and collection = '进阶'");
    	bf2.append("\n order by id desc"); 
        int pageNum = Integer.parseInt((params.get("pageNum")==null||"".equals(params.get("pageNum")))?"1":params.get("pageNum"));
        int numPerPage = 15;
        
        List<Lesson> lessons = Lesson.find(bf.toString()).fetch(pageNum,numPerPage);
        List<Lesson> lessons2 = Lesson.find(bf2.toString()).fetch(pageNum,numPerPage);
        System.out.println(bf2);
        System.out.println(bf);
        render(lessons,lessons2);
    }
    
    
    
    
    public static void detail(long id){
        try {
            Lesson lesson = Lesson.findById(id);
            List<List> lessonTables = new ArrayList<List>();
            List<Student> students = new ArrayList<Student>();
            List<Order> orders = Order.find("lesson = ? and (state = ? or state = ?)", lesson,BaseModel.ACTIVE,BaseModel.PENDING).fetch();
            for(Order order:orders){
                students.add(order.student);
            }
            renderArgs.put("lessonTables",lessonTables);
            renderArgs.put("lesson",lesson);
            renderArgs.put("orders",orders);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        render();
    }
    
    
}
