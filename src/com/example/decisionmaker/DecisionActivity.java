package com.example.decisionmaker;

import java.util.List;

import com.example.decisionmaker.data.Choice;
import com.example.decisionmaker.data.ChoiceDataSource;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.content.DialogInterface;

public class DecisionActivity extends ListActivity {
	
	private ChoiceDataSource dataSource;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decision);
		registerForContextMenu(getListView());
		dataSource = new ChoiceDataSource(this);
		displayAllChoices();
		bindNewChoiceButton();
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
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		if (item.getItemId() == 9999) {
			Choice choice = choices.get(currentChoiceId);
			dataSource.remove(choice);
			displayAllChoices();
		}
		return super.onContextItemSelected(item);
	}
	
	private void bindNewChoiceButton() {
		Button newChoiceButton = (Button) findViewById(R.id.new_choice);
		newChoiceButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				createChoice();
			}
		});
	}
	
	private void createChoice() {
		final Choice choice = new Choice();
	}
	
	private void updateChoiceFromInput(final Choice choice) {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		
		final EditText input = new EditText(this);
		input.setText(choice.getName());
		alert.setView(input);
		
		alert.setPositiveButton("Save",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				String updatedName = input.getText().toString();
				choice.setName(updatedName);
				dataSource.save(choice);
				displayAllChoices();
			}
		});
		
		alert.show();
	}
}