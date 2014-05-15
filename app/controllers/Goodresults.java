package controllers;

import java.util.List;

import models.BaseModel;
import models.Score;

public class Goodresults extends CRUD{
	public static void list(){
		List<Score> scores = Score.find("state =? and bigone = ?", BaseModel.ACTIVE,"hot").fetch(5);
		render(scores);
	}
}
