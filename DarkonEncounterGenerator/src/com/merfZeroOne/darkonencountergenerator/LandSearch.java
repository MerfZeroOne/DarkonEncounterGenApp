package com.merfZeroOne.darkonencountergenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LandSearch extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.land_search);
		
		//Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	   //set content view AFTER ABOVE sequence (to avoid crash)
	    this.setContentView(R.layout.land_search); 
		
		
		
		final TextView primaryHeader = ((TextView)findViewById(R.id.textViewLSPrimaryHeader));
		final TextView primaryResult = ((TextView)findViewById(R.id.textViewLSPrimaryResults));
		
		final TextView secondaryHeader = ((TextView)findViewById(R.id.textViewLSSecondaryHeader));
		final TextView secondaryResult = ((TextView)findViewById(R.id.textViewLSSecondaryResults));
		
		final TextView fertilityHeader = ((TextView)findViewById(R.id.textViewLSFertilityHeader));
		final TextView fertilityResult = ((TextView)findViewById(R.id.textViewLSHexResults));
		
		final TextView minesHeader = ((TextView)findViewById(R.id.textViewLSMinesHeader));
		final TextView minesResult = ((TextView)findViewById(R.id.textViewLSMinesRuins));
		final TextView infoResult1 = ((TextView)findViewById(R.id.textViewLSInfo1));
		final TextView infoResult2 = ((TextView)findViewById(R.id.textViewLSInfo2a));
		
		//button control
		Button choiceButton = (Button) findViewById(R.id.buttonLSChoice);
		choiceButton.setVisibility(View.GONE);
		choiceButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(LandSearch.this, Charts.class));
				
			}
		});
		
		
		RollsGen LandSearch = new RollsGen();
		Toast.makeText(LandSearch.this, "The Ranger is unaware of the results of the encounter beforehand", Toast.LENGTH_LONG).show();
		
		
		LandSearch.PrimaryRoll();
		
		primaryHeader.setText(RollsGen.getPrimaryHeaderString());
		primaryResult.setText(LandSearch.getPrimaryString());
		if (LandSearch.getPrimaryString().equals("++Landmarshal Choice++")){
			choiceButton.setVisibility(View.VISIBLE);
			
		}
		
		secondaryHeader.setText(LandSearch.getSecondaryHeaderString());
		secondaryResult.setText(LandSearch.getSecondaryString());
		
		RollsGen.HexTypeSorter(MainActivity.getHexTypeChoice());
		
		fertilityHeader.setText(LandSearch.getFertilityHeaderString());
		fertilityResult.setText(LandSearch.getFertilityString());
		
		minesHeader.setText(LandSearch.getMinesHeaderString());
		minesResult.setText(LandSearch.getMinesString());
		
		infoResult1.setText(LandSearch.getFortString());
		infoResult2.setText(LandSearch.getSalvageString());
		
	}
}
