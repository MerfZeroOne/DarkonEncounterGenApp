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

public class Exploration extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exploration);
		
		//Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	   //set content view AFTER ABOVE sequence (to avoid crash)
	    this.setContentView(R.layout.exploration); 
		
		final TextView primaryHeader = ((TextView)findViewById(R.id.textViewExplorationPrimaryHeader));
		final TextView primaryResult = ((TextView)findViewById(R.id.textViewExplorationPrimaryResults));
		
		final TextView secondaryHeader = ((TextView)findViewById(R.id.textViewExplorationSecondaryHeader));
		final TextView secondaryResult = ((TextView)findViewById(R.id.textViewExplorationSecondaryResults));
		
		final TextView fertilityHeader = ((TextView)findViewById(R.id.textViewExplorationFertilityHeader));
		final TextView fertilityResult = ((TextView)findViewById(R.id.textViewExplorationHexResults));
		
		final TextView minesHeader = ((TextView)findViewById(R.id.textViewExplorationMinesHeader));
		final TextView minesResult = ((TextView)findViewById(R.id.textViewExplorationMinesRuins));
		final TextView infoResult1 = ((TextView)findViewById(R.id.textViewExplorationInfo1));
		final TextView infoResult2 = ((TextView)findViewById(R.id.textViewExplorationInfo2a));
		
		//second roll display
		final TextView primaryHeader2 = ((TextView)findViewById(R.id.textViewExploration2PrimaryHeader));
		final TextView primaryResult2 = ((TextView)findViewById(R.id.textViewExploration2PrimaryResults));
		
		final TextView secondaryHeader2 = ((TextView)findViewById(R.id.textViewExploration2SecondaryHeader));
		final TextView secondaryResult2 = ((TextView)findViewById(R.id.textViewExploration2SecondaryResults));
		
		final TextView fertilityHeader2 = ((TextView)findViewById(R.id.textViewExploration2FertilityHeader));
		final TextView fertilityResult2 = ((TextView)findViewById(R.id.textViewExploration2HexResults));
		
		final TextView minesHeader2 = ((TextView)findViewById(R.id.textViewExploration2MinesHeader));
		final TextView minesResult2 = ((TextView)findViewById(R.id.textViewExploration2MinesRuins));
		final TextView infoResult12 = ((TextView)findViewById(R.id.textViewExploration2Info1));
		final TextView infoResult22 = ((TextView)findViewById(R.id.textViewExploration2Info2a));
		
		//button control
		Button choiceExploreButtonA = (Button) findViewById(R.id.buttonExploreChoice1);
		choiceExploreButtonA.setVisibility(View.GONE);
		choiceExploreButtonA.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Exploration.this, Charts.class));
				
			}
		});
		
		//button control
				Button choiceExploreButtonB = (Button) findViewById(R.id.buttonExploreChoice2);
				choiceExploreButtonB.setVisibility(View.GONE);
				choiceExploreButtonB.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						startActivity(new Intent(Exploration.this, Charts.class));
						
					}
				});
		
		RollsGen ExploreRoll = new RollsGen();
		RollsGen ExploreRoll2 = new RollsGen();
		Toast.makeText(Exploration.this, "The Ranger is aware of the results of the encounter beforehand", Toast.LENGTH_LONG).show();
		
		//first roll and display
		ExploreRoll.PrimaryRoll();
		
		primaryHeader.setText(RollsGen.getPrimaryHeaderString());
		primaryResult.setText(ExploreRoll.getPrimaryString());
		if (ExploreRoll.getPrimaryString().equals("++Landmarshal Choice++")){
			choiceExploreButtonA.setVisibility(View.VISIBLE);
			
		}
		
		secondaryHeader.setText(ExploreRoll.getSecondaryHeaderString());
		secondaryResult.setText(ExploreRoll.getSecondaryString());
		
		RollsGen.HexTypeSorter(MainActivity.getHexTypeChoice());
		
		fertilityHeader.setText(ExploreRoll.getFertilityHeaderString());
		fertilityResult.setText(ExploreRoll.getFertilityString());
		
		minesHeader.setText(ExploreRoll.getMinesHeaderString());
		minesResult.setText(ExploreRoll.getMinesString());
		
		infoResult1.setText(ExploreRoll.getFortString());
		infoResult2.setText(ExploreRoll.getSalvageString());
		
		//second roll and display
		
		ExploreRoll2.PrimaryRoll();
		
		primaryHeader2.setText(RollsGen.getPrimaryHeaderString());
		primaryResult2.setText(ExploreRoll.getPrimaryString());
		if (ExploreRoll2.getPrimaryString().equals("++Landmarshal Choice++")){
			choiceExploreButtonB.setVisibility(View.VISIBLE);
		}
		
		secondaryHeader2.setText(ExploreRoll.getSecondaryHeaderString());
		secondaryResult2.setText(ExploreRoll.getSecondaryString());
		
		RollsGen.HexTypeSorter(MainActivity.getHexTypeChoice());
		
		fertilityHeader2.setText(ExploreRoll.getFertilityHeaderString());
		fertilityResult2.setText(ExploreRoll.getFertilityString());
		
		minesHeader2.setText(ExploreRoll.getMinesHeaderString());
		minesResult2.setText(ExploreRoll.getMinesString());
		
		infoResult12.setText(ExploreRoll.getFortString());
		infoResult22.setText(ExploreRoll.getSalvageString());
		
		
		
	}
	

}
