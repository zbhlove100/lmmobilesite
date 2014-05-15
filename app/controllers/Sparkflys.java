package controllers;

import java.util.ArrayList;
import java.util.List;

public class Sparkflys extends CRUD{
	public static void list(){
		List<String> sparklist = new ArrayList<String>();
		for(int i=0;i<20;i++){
			sparklist.add("spark");
		}
		render(sparklist);
	}
}
