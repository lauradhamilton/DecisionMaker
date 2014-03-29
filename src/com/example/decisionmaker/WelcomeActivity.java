package com.example.decisionmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		Button getStartedButton = (Button) findViewById(R.id.get_started);
		getStartedButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(WelcomeActivity.this, DecisionActivity.class);
				startActivity(myIntent);
			}
		});
		
	}
}