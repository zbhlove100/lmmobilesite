package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import models.BaseModel;
import models.Code;
import models.ImgDetail;
import models.Spark;

public class Sparkflys extends CRUD{
	public static void list(){
		
		int pagenumber = 1;

		int pagesize = 10;
		List<ImgDetail> sparklist = ImgDetail.find("spark_id != ? order by spark_id desc","null").fetch(pagenumber,pagesize);

		render(sparklist,pagenumber);
	}
	public static void getmorepic(int newpagenumber){
        List<ImgDetail> data =new ArrayList<ImgDetail>();
        int pagenumber = 1;
        if(newpagenumber != 0){
        	pagenumber = newpagenumber;
        }
		int pagesize = 10;
        List<ImgDetail> sparklist = ImgDetail.find("spark_id != ? order by spark_id desc","null").fetch(pagenumber,pagesize);
        for(ImgDetail item:sparklist){

            data.add(item);
        }
        Gson gson = new Gson();
        String result = gson.toJson(data);
        response.setContentTypeIfNotSet("application/json; charset=UTF-8");
        try {
            response.out.write(result.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
