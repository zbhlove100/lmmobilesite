package controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.EntityManager;

import com.google.gson.Gson;

import play.Play;
import play.db.jpa.JPA;
import utils.MyDateUtils;
import models.BaseModel;
import models.Department;
import models.ImgDetail;
import models.Lesson;
import models.LessonTable;
import models.School;
import models.Setting;
import models.Student;
import models.Teacher;
import models.TeacherDetail;
import models.Where;

public class Teachers extends CRUD {
    public static void list(){
    	/*long sunTeacher = Teacher.count("state = ? and employeType = ?", BaseModel.ACTIVE ,Teacher.EM_TYPE.TEACHER.toString());
        long sunAssistant = Teacher.count("state = ? and employeType = ?", BaseModel.ACTIVE ,Teacher.EM_TYPE.ASSISTANT.toString());
        long sunMarketer = Teacher.count("state = ? and employeType = ?", BaseModel.ACTIVE ,Teacher.EM_TYPE.MARKETER.toString());
        List<School> schools = School.find("state !=?", BaseModel.DELETE).fetch();
        List<String> employeTypes = Setting.values("EMPLOYE_TYPE");
        renderArgs.put("schools", schools);
        renderArgs.put("employeTypes", employeTypes);
        renderArgs.put("sunTeacher", sunTeacher);
        renderArgs.put("sunAssistant", sunAssistant);
        renderArgs.put("sunMarketer", sunMarketer);*/
        Department department1 = Department.find("state = ? and name = ?",BaseModel.ACTIVE,"新思维").first();
        Department department2 = Department.find("state = ? and name = ?",BaseModel.ACTIVE,"进阶").first();
        
        List<Teacher> teachers1 = Teacher.find("state =? and department=?",BaseModel.ACTIVE,department1 ).fetch();
        List<Teacher> teachers2 = Teacher.find("state =? and department=?",BaseModel.ACTIVE,department2 ).fetch();
        System.out.println("=========================="+teachers1);
        renderArgs.put("teachers1",teachers1);
        renderArgs.put("teachers2",teachers2);
        renderArgs.put("teachers1size",teachers1.size());
        renderArgs.put("teachers2size",teachers2.size());
        render();
        /*Where where = new Where(params);
        if (params.get("name") != null)
            where.add("name", "name like");
        if (params.get("type") != null)
            where.add("type", "employeType like");
        if (params.get("schoolid") != null)
            where.add("schoolid", "school_id =");
        where.add("state !=", BaseModel.DELETE);
        _list(where);*/
    }
    
    
    public static void detail(long id){
        try {
            Teacher t = Teacher.findById(id);
            
            List<Lesson> lessons = Lesson.find("teacher = ? and state != ? order by id desc", t,BaseModel.DELETE).fetch(5);
          
            renderArgs.put("showTeacher", t);
            renderArgs.put("lessons", lessons);

            render();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
