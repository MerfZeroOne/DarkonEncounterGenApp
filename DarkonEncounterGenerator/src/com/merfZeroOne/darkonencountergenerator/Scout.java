package com.merfZeroOne.darkonencountergenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Scout extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scouting);
		
		//Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	   //set content view AFTER ABOVE sequence (to avoid crash)
	    this.setContentView(R.layout.scouting); 
		
		final TextView primaryHeader = ((TextView)findViewById(R.id.textViewScoutPrimaryHeader));
		final TextView primaryResult = ((TextView)findViewById(R.id.textViewScoutPrimaryResults));
		
		final TextView secondaryHeader = ((TextView)findViewById(R.id.textViewScoutSecondaryHeader));
		final TextView secondaryResult = ((TextView)findViewById(R.id.textViewScoutSecondaryResults));
		
		final TextView fertilityHeader = ((TextView)findViewById(R.id.textViewScoutFertilityHeader));
		final TextView fertilityResult = ((TextView)findViewById(R.id.textViewScoutHexResults));
		
		final TextView minesHeader = ((TextView)findViewById(R.id.textViewScoutMinesHeader));
		final TextView minesResult = ((TextView)findViewById(R.id.textViewScoutMinesRuins));
		final TextView infoResult1 = ((TextView)findViewById(R.id.textViewScoutInfo1));
		final TextView infoResult2 = ((TextView)findViewById(R.id.textViewScoutInfo2a));
		
		//button control
				Button choiceScoutButton = (Button) findViewById(R.id.buttonScoutChoice);
				choiceScoutButton.setVisibility(View.GONE);
				choiceScoutButton.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(Scout.this, Charts.class));
						
					}
				});
		
		RollsGen ScoutRoll = new RollsGen();
		Toast.makeText(Scout.this, "The Ranger is aware of the results of the encounter beforehand", Toast.LENGTH_LONG).show();
		
		
		ScoutRoll.PrimaryRoll();
		
		primaryHeader.setText(RollsGen.getPrimaryHeaderString());
		primaryResult.setText(ScoutRoll.getPrimaryString());
		if (ScoutRoll.getPrimaryString().equals("++Landmarshal Choice++")){
			choiceScoutButton.setVisibility(View.VISIBLE);
			
		}
		
		secondaryHeader.setText(ScoutRoll.getSecondaryHeaderString());
		secondaryResult.setText(ScoutRoll.getSecondaryString());
		
		RollsGen.HexTypeSorter(MainActivity.getHexTypeChoice());
		
		fertilityHeader.setText(ScoutRoll.getFertilityHeaderString());
		fertilityResult.setText(ScoutRoll.getFertilityString());
		
		minesHeader.setText(ScoutRoll.getMinesHeaderString());
		minesResult.setText(ScoutRoll.getMinesString());
		
		infoResult1.setText(ScoutRoll.getFortString());
		infoResult2.setText(ScoutRoll.getSalvageString());
		
	}
	

}
