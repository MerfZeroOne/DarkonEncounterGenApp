package com.merfZeroOne.darkonencountergenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
	String rangerChoice;
	static String hexTypeChoice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	   //set content view AFTER ABOVE sequence (to avoid crash)
	    this.setContentView(R.layout.activity_main); 
	    
		//declare button and spinner(s)
		
		Button genButton = (Button) findViewById(R.id.buttonGenerate);
		Button chartButton = (Button) findViewById(R.id.buttonViewCharts);
		
		final Spinner rangerSpinner = (Spinner)findViewById(R.id.spinnerRangerLevel);
		final Spinner hexTypeSpinner = (Spinner)findViewById(R.id.spinnerHexType);
		
		chartButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, Charts.class));
				
			}
		});
		
		genButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//this will pull the string selected and compare it, then send the activity to the page needed
				rangerChoice = rangerSpinner.getSelectedItem().toString();
				if((rangerChoice.equals("Level 3 (Land Search)")) ){
					startActivity(new Intent(MainActivity.this, LandSearch.class));
					}
				if((rangerChoice.equals("Level 15 (Scouting)")) ){
					startActivity(new Intent(MainActivity.this, Scout.class));
					}
				if((rangerChoice.equals("Level 25 (Exploration)")) ){
					startActivity(new Intent(MainActivity.this, Exploration.class));
					}
				
				hexTypeChoice =hexTypeSpinner.getSelectedItem().toString();
			}
		});
	}
	
		
	//getters and setters
	public String getRangerChoice() {
		return rangerChoice;
	}

	public void setRangerChoice(String rangerChoice) {
		this.rangerChoice = rangerChoice;
	}

	public static String getHexTypeChoice() {
		return hexTypeChoice;
	}

	public void setHexTypeChoice(String hexTypeChoice) {
		MainActivity.hexTypeChoice = hexTypeChoice;
	}
	
}
