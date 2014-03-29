package com.example.decisionmaker;

import java.util.List;

import com.example.decisionmaker.data.Choice;
import com.example.decisionmaker.data.ChoiceDataSource;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class DecisionActivity extends ListActivity {
	
	private ChoiceDataSource dataSource;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decision);
		registerForContextMenu(getListView());
		dataSource = new ChoiceDataSource(this);
		displayAllChoices();
	}
	
	private List<Choice> choices;
	
		private void displayAllChoices() {
			choices = dataSource.findAll();
			ArrayAdapter<Choice> adapter = new ArrayAdapter<Choice>(this, android.R.layout.simple_list_item_1, choices);
			setListAdapter(adapter);
		}
		
	private int currentChoiceId;
	
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
		currentChoiceId = (int) info.id;
		menu.add(0, 9999, 0, "Delete Choice");
	}
}