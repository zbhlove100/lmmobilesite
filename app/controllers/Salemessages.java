package controllers;

import java.util.List;

import models.BaseModel;
import models.Code;
import models.Salemessage;

public class Salemessages extends CRUD{
	public static void list(){
		String year = "2014";
		List<Code> timeTypes = Code.find("parentCode = ? and state !=? and code_name = ?", Code.ROOT,BaseModel.DELETE,"lesson_time_type").fetch();
		List<Salemessage> sms = Salemessage.find("state = ? and recent = ?", BaseModel.ACTIVE,"hot").fetch();
		render(sms);
	}
	public static void detail(){
		render();
	}
}
