package com.example.decisionmaker;

import android.app.ListActivity;
import android.os.Bundle;

public class DecisionActivity extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decision);
	}
}