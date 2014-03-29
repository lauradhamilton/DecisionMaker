package com.example.decisionmaker;

import java.util.List;

import com.example.decisionmaker.data.Choice;
import com.example.decisionmaker.data.ChoiceDataSource;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class DecisionActivity extends ListActivity {
	
	private ChoiceDataSource dataSource;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decision);
		dataSource = new ChoiceDataSource(this);
		displayAllChoices();
	}
	
	private List<Choice> choices;
	
		private void displayAllChoices() {
			choices = dataSource.findAll();
			ArrayAdapter<Choice> adapter = new ArrayAdapter<Choice>(this, android.R.layout.simple_list_item_1, choices);
			setListAdapter(adapter);
		}
}