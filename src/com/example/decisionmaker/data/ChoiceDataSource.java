package com.example.decisionmaker.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import android.content.Context;
import android.content.SharedPreferences;

public class ChoiceDataSource {
	private static final String PREFKEY = "choices";
	private SharedPreferences choicePrefs;
	
	public ChoiceDataSource(Context context) {
		choicePrefs = context.getSharedPreferences(PREFKEY, Context.MODE_PRIVATE);
	}
	
	public List<Choice> findAll() {
		List<Choice> choiceList = new ArrayList<Choice>();
		
		for (Map.Entry<String, ?> entry : choicePrefs.getAll().entrySet()) {
			String key = entry.getKey();
			String name = (String) entry.getValue();
			Choice choice = new Choice(key, name);
			choiceList.add(choice);
		}
		
		return choiceList;
	}
}