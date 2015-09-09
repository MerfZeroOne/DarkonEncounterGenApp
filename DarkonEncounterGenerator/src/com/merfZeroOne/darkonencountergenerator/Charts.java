package com.merfZeroOne.darkonencountergenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class Charts extends Activity {
	String chartChoice;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.charts);
		
		//Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	   //set content view AFTER ABOVE sequence (to avoid crash)
	    this.setContentView(R.layout.charts); 
		
		final Spinner chartSpinner = (Spinner)findViewById(R.id.spinnerCharts);
		final TextView chartDisplay = ((TextView)findViewById(R.id.textViewChartDisplay));
		
		chartSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				chartChoice = chartSpinner.getSelectedItem().toString();
				
				
				if((chartChoice.equals("Primary Encounter Chart")) ){
					chartDisplay.setText("01-10	No Encounter \n11-40	Humans \n41-60	Humanoids \n61-80	Undead* \n81-94 	Giants \n95-97 	Dragons \n98 	Fortifications* \n99 Land Marshal’s Choice" +
"\n00	 Roll again, doubling number of Monsters, ignoring any further roll of 00");
					}
				//human
				if((chartChoice.equals("Human Encounter")) ){
					chartDisplay.setText(
							  "01-20 	10 Peasants in AC0 and pole arms or hand weapons (no shields)\n"+ 
							"\n21-36 	2 Brigands in AC2, 2 Archers** in AC0\n"+ 
							"\n37-46 	3 Brigands in AC2, 2 Archers** in AC1\n"+
							"\n47-54 	3 Knights in AC3, 1 Mage (10th Rank)\n"+
							"\n55-61 	3 Knights in AC3, 1 Cleric (10th Rank)\n"+
							"\n62-68 	4 Barbarians in AC2, all take an extra hit\n"	+ 
							"\n69-74 	20 Peasants (1 hit, no shields), 1 Peasant Hero in AC2 with Shield\n" +
							"\n75-80 	5 Brigands in AC2\n" +"\n81-85 	6 Barbarians in AC2 (2 Handed Weapons Only), all take an extra hit\n"+
							"\n86-89 	5 Brigands in AC2, 4 Brigands in AC3, 1 Mage (20th Rank)\n"+
							"\n90-93 	4 Knights in AC3, 1 Champion in AC4\n" + 
							"\n94-96 	2 Brigands in AC2, 2 Brigands in AC3, 1 Brigand in AC4 with shield. +5% Mines & Ruins Chart.\n" + 
							"\n97-98 	4 Knights in AC3, 1 Cavalier (20th Rank) in AC4. +5% Mines & Ruins Chart\n" + 
							"\n99 		4 Brigands in AC1, 2 Brigands in AC2, 2 Brigands in AC3, and Druid (20th Rank)+10% Mines & Ruins Chart\n" + 
							"\n00 		Adventuring Party (5 people, any class, 20th Rank).+15% Mines & Ruins Chart\n");
					}
				//humanoid
				if((chartChoice.equals("Humanoid Encounter")) ){
					chartDisplay.setText(
							   "01-10 	10 Goblins (1 hit)\n"+
							"\n 11-15 	20 Goblins (1 hit) and 1 Goblin King (2 hits)\n"+
							"\n 16-20 	3 Orcs in AC0 and 1 Ogre (6 hits and giant)\n"+
							"\n 21-24 	6 Orcs in AC0 and 1 Ork Boss in AC3\n"+
							"\n 25-35 	2 Hobgoblins in AC2\n"+
							"\n 36-44 	5 Hobgoblins in AC1\n"+
							"\n 45-52 	8 Hobgoblins in AC1\n"+
							"\n 53-60 	6 Gnolls in AC2, 3 have shields\n"+
							"\n 61-62 	10 Gnolls in AC2\n"+
							"\n 63-69 	3 Bugbears in AC3\n"+
							"\n 70-78 	3 Bugbears in AC3, 1 Bugbear Shaman in AC3 (1 Entangle, 1 Lightning Bolt, 1 Cure Light Wounds)\n"+
							"\n 79-87 	10 Goblins (1hit), 5 Orcs in AC1, 5 Hobgoblins in AC2. +10% Mines & Ruins Chart\n"+
							"\n 88-94 	2 Hobgoblins in AC1, 2 Gnolls in AC2, 2 Bugbears in AC3. +15% Mines & Ruins Chart\n"+
							"\n 95-98 	10 Goblins (1hit), 2 Orcs in AC0, 2 Hobgoblins in AC1, 2 Gnolls in AC2, 2 Bugbears in AC3. +20% Mines & Ruins Chart\n"+
							"\n 99-00 	20 Goblins (1hit), 10 Orcs in AC0, 5 Hobgoblins in AC1, plus 1 Ogre Magi (6 hits, giant, 2 Lightning Bolts, Damaged only by Magic Weapon). +25% Mines & Ruins Chart\n");
							
					}
				//undead
				if((chartChoice.equals("Undead Encounter")) ){
					chartDisplay.setText(
							"*- A Silver weapon does double damage to any Undead Creature*\n"+
							"\n 01-25 	5 Skeletons (AC1, red damage has no effect, destroyed by one hit from a non-red Holy or Blessed weapon)\n"+
							"\n 26-50 	5 Zombies (AC2, destroyed by one hit from a Holy or Blessed weapon)\n"+
							"\n 51-75	5 Mummies (AC3, destroyed by one hit from a Holy or Blessed weapon. 1 minute Agony poison with each damage causing hit)\n"+
							"\n 76-85 	5 Skeletal Knights (AC3,(Red damage has no effect, destroyed by two hits from a non-red Holy or Blessed weapon) +5 Mines & Ruins Chart\n"+
							"\n 86-90 	3 Ghouls (AC4, destroyed by two hits from a Holy or Blessed weapon, 1 minute Paralyzation poison with each damage causing hit) +10 Mines & Ruins Chart\n"+
							"\n 91-95 	1 Banshee (7 hits, Damaged only by Magic, Holy or Blessed Weapon. May “Scream” once per encounter causing a Curse effect in a 3ft radius from spell ball impact. Banshee calls out “Curse, 3ft Radius”  when throwing spellball. +15 Mines & Ruins Chart\n"+
							"\n 96-98 	1 Lich (8 hits, damaged only by Magic, Holy or Blessed weapons. Takes 2x damage from Holy Weapons (since they are silvered), Immune to Turn Undead unless  Cleric is lvl 30+, 3 Fireballs) +20 Mines & Ruins Chart\n"+
							"\n 99 		1 Flesh Golem (9 hits, does not have to fight on knees vs Giant Sized opponents, damaged only by Magic, Holy or Blessed weapons, does black damage with weapons) +25 Mines & Ruins Chart\n"+
							"\n 00 		1 Vampire (10 hits, damaged only by Holy, Blessed, Magic weapon). Immune to Turn Undead, does black damage with weapons) and 3 Thralls (0 level Humans, no shields, no armor) +30 Mines & Ruins Chart \n");
					
				}
				//giant
				if((chartChoice.equals("Giant Encounter")) ){
					chartDisplay.setText(
							  "01-25	2 Owlbears (AC4, giant)\n"+
							"\n26-50	4 Owlbears (AC4, giant)\n"+
							"\n51-60 	1 Troll (6 hits, giant, heals self at rate of 1 hit per minute, Fireball kills instantly)\n"+
							"\n61-70	5 Ogres (6 hits and giant). +10% Mines & Ruins Chart\n"+
							"\n71-80	3 Trolls (6 hits, giant, heals self at rate of 1 hit per minute, Fireball kills instantly).+15% Mines & Ruins Chart\n"+
							"\n81-90 	5 Ogres (6 hits and giant) and 1 Ogre Magi (6 hits, giant, 2 Lighting Bolts, Damaged only by Magic Weapons). +15% Mines & Ruins Chart\n"+
							"\n91-93	2 Hill Giants (8 hits and giant). +10% Mines & Ruins Chart\n"+
							"\n94-96	2 Frost Giants (9 hits, giant, does black damage, immune to ice spells). +15% Mines & Ruins Chart\n"+
							"\n97-99   	2 Fire Giants (10 hits, giant, does black damage, immune to fire spells). +20% Mines & Ruins Chart\n"+
							"\n00		1 Storm Giant (10 hits, giant, does black damage & shield break, 3 lightning bolts, immune to lightning spells, Damaged only by Magic Weapon) +25% Mines & Ruins Chart");
					
				}
				//dragon
				if((chartChoice.equals("Dragon Encounter")) ){
					chartDisplay.setText(
							 "01-15 	2 Juvenile Blue Dragons (5 hits, use white or red weapon, 1 Lighting Bolt each). +5% Mines & Ruins Chart\n"+
							"\n16-30	2 Juvenile White Dragons (5 hits, use white or red weapon, 1 Ice Storm each). +5% Mines & Ruins Chart\n"+
							"\n31-45	2 Juvenile Red Dragons (5 hits, use white or red weapon, 1 Fireball each).+10% Mines & Ruins Chart\n"+
							"\n46-55 	1 Adult Blue Dragon (10 hits, giant, does black damage, 3 Lighting Bolts, Immune to Lightning Bolt, Damaged only by Magic Weapon). +15% Mines & Ruins Chart\n"+
							"\n56-65 	1 Adult White Dragon (10 hits, giant, does black damage, 3 Ice Storms, Immune to Ice Storm, Damaged only by Magic Weapon). +15% Mines & Ruins Chart\n"+
							"\n66-75 	1 Adult Red Dragon (10 hits, giant, does black damage, 3Fireballs, Immune to Fireball/Burning Hands, Damaged only by Magic Weapon). +20% Mines & Ruins Chart\n"+
							"\n76-99 	1 Hydra (15 hits, giant, 2 Fireballs, Regenerates 1 hit every 30 seconds to represent head regrowth. Does not regenerate after body is killed. Played by 3 people; 1 body and 2 “heads”. Heads are Immune to all damage/spells, Damaged only by Magic Weapon) +30% Mines & Ruins Chart\n"+
							"\n   00 	1 Chromatic Dragon (15 hits, giant, does black damage, 3 Fireballs, 3 Ice Storms, 3 Lighting Bolts, played by 3 people, Damaged only by Magic Weapon).+30% Mines & Ruins Chart");
					
				}
				//Fortification
				if((chartChoice.equals("Fortification Encounter")) ){
					chartDisplay.setText(
							"*These encounters are fought with a structure/fortification on the field of play. The structure has 1 accessible gate to it which will be indicated by the Land Marshal. Once destroyed, these gates are not able to be mended by any means.*\n"+
							"\n01-20	Wizard’s Tower- 1 Mage (Rank 20), 1 Apprentice (Rank 8), 3 Novices (Rank 4). Successful defeat of encounter has 10% chance of salvaging a Tower on this hex. country may pay 50% of Tower price to place a Tower here.\n"+
							"\n21-40	Lord’s Tower- 1 Knight in AC4, 4 Man at Arms in AC3, 2 Archers** in AC1. Successful defeat of encounter has 10% chance of salvaging a Tower on this hex. country may pay 50% of Tower price to place a Tower here.\n"+
							"\n41-55	Haunted Tower- 5 Skeletal Knights (AC3, Red damage has no effect, destroyed by two hits from a Holy or Blessed weapon) , 1 Ghost (4 hits, destroyed by 1 hit from a Holy or Blessed weapon, may Passwall at will.) Successful defeat of encounter has 25% chance of salvaging a Tower on this hex. country may pay 50% of Tower price to place a Tower here.\n"+
							"\n55-70	Goblin Keep (30’x30’)- 20 Goblins (no weapons over 4ft in length, 1 hit), 5 Hobgoblins (AC2) 1 Goblin King (2 hits) Successful defeat of encounter has 10% chance of salvaging a Keep on this hex. country may pay 50% of normal Keep price to place a Keep here\n"+								
							"\n71-85	Fortified Keep (30’x30’)- 10 Soldiers in AC2, 5 Knights in AC3, 2 Archers** in AC1, 1 Mage (Rank 10), 1 Cleric in AC2 (Rank 10), 1 Lord in AC4 Successful defeat of encounter has 10% chance of salvaging a Keep on this hex. country may pay 50% of normal Keep price to place a Keep here\n"+
							"\n86-95	Giant’s Lair (40’x40’)- 6 Hill Giants (8 hits, giant) and 1 Hill Giant Chieften (10 hits, giant, does black damage) Successful defeat of the encounter has a 10% chance of salvaging broken Caravel parts. country may pay 50% of normal Caravel price to build a Caravel.\n"+
							"\n96-99	Desecrated Temple (40’x40’)- 20 Zombies (AC2, destroyed by one hit from a Holy or Blessed weapon), 5 Ghouls (AC4, destroyed by two hits from a Holy or Blessed weapon, 1 minute Paralyzation poison with each damage causing hit) 5 Banshees (7 hits, destroyed by two hits from a Holy or Blessed Weapon. May “Scream” once per encounter causing a Curse effect in a 3ft radius from spell ball impact. Banshee calls out “Curse, 3ft Radius”  When throwing spell ball. Successful defeat of encounter has 25% chance of salvaging a Keep on this hex. country may pay 50% of normal Keep price to place a Keep here\n"+
							"\n00		Dragon’s Lair (40’x40’)- Ancient Red Dragon (20 hits, Immune to Fire Based Spells, giant. Played by 4 participants (Head, 2 Claws, Tail) Head has 2 single blades, Claws have black sword, tail has spear. Claws do Black Damage & have shield break, Tail does double red damage and has shield break, head does black damage and the participant may throw 5 fireballs (Must wait 5 seconds between each throw), Damaged only by Magic Weapon. Successful defeat of encounter has 25% chance of salvaging a Castle on this hex. country may pay 50% of normal Castle price to place a Castle here\n"+
							"\n** In the event that the land search takes place in a bow prohibiting the use of Bows, replace “Archer” with “Spearman” ");
					
					}
				//land mountains
				if((chartChoice.equals("Land Fertility Mountains")) ){
					chartDisplay.setText(
								 "01	Jungle\n"+
							"\n02-46	Rocky\n"+
							"\n47-71	Barren\n"+
							"\n72-00	Fertile\n"+
							"\nSwampy land costs 2,000 silver pieces to drain.\n"+ 
							"\nJungle costs 1,000 silver pieces to thin. \n"+
							"\nRocks cost 1,000 silver pieces to clear. \n"+
							"\nBarren land costs 1,500 silver pieces to fertilize. \n"
);
					
				}
				//land forest
				if((chartChoice.equals("Land Fertility Forest")) ){
					chartDisplay.setText(
							  "01-05	Swamp\n"+
							"\n06-25	Jungle\n"+
							"\n26-35	Rocky\n"+
							"\n36-45	Barren\n"+
							"\n46-00	Fertile\n"+
							"\nSwampy land costs 2,000 silver pieces to drain.\n"+ 
							"\nJungle costs 1,000 silver pieces to thin. \n"+
							"\nRocks cost 1,000 silver pieces to clear. \n"+
							"\nBarren land costs 1,500 silver pieces to fertilize. \n"
							);
					
				}
				//land coastal
				if((chartChoice.equals("Land Fertility Coastal")) ){
					chartDisplay.setText(
							  "01-05	Swamp\n"+
							"\n06-25	Jungle\n"+
						    "\n26-35	Rocky\n"+
						    "\n36-45	Barren\n"+
						    "\n46-00	Fertile\n"+
						    "\nSwampy land costs 2,000 silver pieces to drain.\n"+ 
							"\nJungle costs 1,000 silver pieces to thin. \n"+
							"\nRocks cost 1,000 silver pieces to clear. \n"+
							"\nBarren land costs 1,500 silver pieces to fertilize. \n");
					
				}
				//land plains
				if((chartChoice.equals("Land Fertility Plains")) ){
					chartDisplay.setText(
							  "01-05	Swamp\n"+
							"\n06-07	Jungle\n"+
							"\n08-23	Rocky\n"+
							"\n24-34	Barren\n"+
							"\n35-00	Fertile\n"+
							"\nSwampy land costs 2,000 silver pieces to drain.\n"+ 
							"\nJungle costs 1,000 silver pieces to thin. \n"+
							"\nRocks cost 1,000 silver pieces to clear. \n"+
							"\nBarren land costs 1,500 silver pieces to fertilize. \n");
					
				}
				//land desert
				if((chartChoice.equals("Land Fertility Desert")) ){
					chartDisplay.setText(
							
							 "01-25	Rocky\n"+
							"\n26-75	Barren\n"+
							"\n76-00	Fertile\n"+
							"\nSwampy land costs 2,000 silver pieces to drain.\n"+ 
							"\nJungle costs 1,000 silver pieces to thin. \n"+
							"\nRocks cost 1,000 silver pieces to clear. \n"+
							"\nBarren land costs 1,500 silver pieces to fertilize. \n");
					
				}
				//mines and ruins
				if((chartChoice.equals("Mines and Ruins")) ){
					chartDisplay.setText(
									 " 01-85			Nothing\n"+
									"\n86-88			Iron Mine\n"+
									"\n89-91			Copper Mine\n"+
									"\n92-94			Silver Mine\n"+
									"\n95				Gold Mine\n"+
									"\n96-97			Ruined Tower\n"+
									"\n98-99			Ruined Keep\n"+
									"\n00				Ruined Castle\n"+

"\nMines are resources that will begin producing income at the end of the season in which it is discovered; they are considered to be a natural feature of the Hex upon which they are found.  Mines produce income according to the following chart:\n"+

"\nIron Mine: 100 silver pieces/season"+
"\nCopper Mine: 250 silver pieces/season"+
"\nSilver Mine: 500 silver pieces/season"+
"\nGold Mine: 750 silver pieces/season\n"+

"\nRuins are ancient Structures that have begun to deteriorate but can be restored with funds and construction. Ruins that have not been restored do not provide any protection during invasions, but they also do not cost any upkeep.  Restoration of ruins is treated identically to upgrading a Structure and you may not build or upgrade any other Structure at the time you are restoring a ruin.  Once a ruin has been fully restored, it functions as a normal structure of the type indicated with all benefits and costs as described above.\n"+ 
"\nRuins may be restored according to the chart below: \n"+

"\nRuined Towers	"+
"\n625 silver pieces to restore"+
"\n1 Event to complete\n"+

"\nRuined Keeps"+
"\n1,250 silver pieces to restore"+	
"\n3 Events to complete\n"+

"\nRuined Castles"+
"\n5,000 silver pieces to restore"+	
"\n5 Events to complete");
					
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				chartDisplay.setText("nothing selected");
			}
		});
	
				
			
	
	}
	
	
}
