package com.merfZeroOne.darkonencountergenerator;

public class RollsGen {
	private final static int max = 100;
	private static int initial =1;
	private static int primaryRollValue;
	private static int secondaryRollValue;
	private static int fertilityRollValue;
	private static int minesRollValue;
	private static int minesModValue;
	private static int minesTotalValue;
	private static int salvageRollValue;
	private static int salvagePercent;
	private static String swamp = "This Hex is a Swamp, 2000sp to drain";
	private static String jungle = "This Hex is a Jungle, 1000sp to thin";
	private static String rocky = "This Hex is Rocky, 1000sp to clear";
	private static String barren = "This Hex is Barren, 1500sp to fertilize";
	private static String fertile = "This Hex is Fertile";
	private static String primaryString;
	private static String secondaryString;
	private static String inputHex;
	private static String fertilityString;
	private static String minesString;
	private static String fortString;
	private static String salvageString;
	private static String primaryHeaderString;
	private static String secondaryHeaderString;
	private static String fertilityHeaderString;
	private static String minesHeaderString;
	
	
	
public RollsGen(){
	initial = 1;
	primaryRollValue = 1;
	secondaryRollValue = 1;
	fertilityRollValue = 1;
	minesRollValue = 1;
	minesModValue = 0;
	minesTotalValue = 1;
	fortString =" ";
	minesString = " ";
	salvageString = " ";
	
}

public void PrimaryRoll(){
	primaryRollValue = (int)(Math.random()*max)+1;
	primaryHeaderString = "Primary Roll of: " + "[" + primaryRollValue + "]";
	//NE
	if (primaryRollValue <= 10){
		primaryString = "++No Encounter++";
		secondaryHeaderString = "++No Encounter++";
		secondaryString ="";
		MinesRoll(0);
	
		
	}
	//Humans
	if (primaryRollValue >=11 && primaryRollValue <=40){
		primaryString = "++Humans++";
		HumanRoll();
		
		
	}
	//Humanoids
	if (primaryRollValue >=41 && primaryRollValue <=60){
		primaryString = "++Humanoids++";
		HumanoidRoll();
		
		
	}
	//Undead
	if (primaryRollValue >=61 && primaryRollValue <=80){
		primaryString = "++Undead * A silver weapon does double damage to any undead++";
		UndeadRoll();
		
	}
	//Giants
	if (primaryRollValue >=81 && primaryRollValue <=94){
		primaryString = "++Giants++";
		GiantRoll();
		
		
	}
	//Dragons
	if (primaryRollValue >=95 && primaryRollValue <=97){
		primaryString = "++Dragons++";
		DragonRoll();
		
		
	}
	//Fortifications
	if (primaryRollValue == 98){
		primaryString = "++Fortifications++";
		FortificationRoll();
		
		
	}
	//Land Marshal Choice
	if (primaryRollValue == 99 ){
		primaryString = "++Landmarshal Choice++";
		secondaryHeaderString = "";
				secondaryString ="";
		fortString = "**Be sure to modify the Mines roll by the amount granted by the Encounter**";
		salvageString =					  "01-85	Nothing"+
										"\n86-88	Iron Mine"+
										"\n89-91	Copper Mine"+
										"\n92-94	Silver Mine"+
										"\n95		    Gold Mine"+
										"\n96-97	Ruined Tower"+
										"\n98-99	Ruined Keep"+
										"\n00		    Ruined Castle"+

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
"\n5 Events to complete";
		MinesRoll(0);
		
		
	}
	//Double encounter
	if (primaryRollValue == 100){
		primaryString = "++Roll again, doubling number of monsters. Ignore further rolls of 100++";
		secondaryHeaderString = "++Roll Again++";
		secondaryString ="";
	//will need another function to roll again and add the encounters together
		
		
		
	}

}

public static void HumanRoll(){
	secondaryRollValue = (int)(Math.random()*max)+1;
	secondaryHeaderString = "Humans Table Roll of: " + "[" + secondaryRollValue + "]";
	//peasants 0
	if (secondaryRollValue <= 20){
		secondaryString = "++10 Peasants in AC0 and pole arms or hand weapons (no  shields)++";
		
		MinesRoll(0);
		}
	//brigands 0
	if (secondaryRollValue >= 21 && secondaryRollValue <= 36){
		secondaryString = "++2 Brigands in AC2, 2 Archers** in AC0++";
		
		MinesRoll(0);
		}
	//brigands 1
	if (secondaryRollValue >= 37 && secondaryRollValue <= 46){
		secondaryString = "++3 Brigands in AC2, 2 Archers** in AC01++";
		
		MinesRoll(0);
		}
	//knights 0
	if (secondaryRollValue >= 47 && secondaryRollValue <= 54){
		secondaryString = "++3 Knights in AC3, 1 Mage(10th Rank)++";
		
		MinesRoll(0);
		}
	//knights 1
	if (secondaryRollValue >= 55 && secondaryRollValue <= 61){
		secondaryString = "++3 Knights in AC3, 1 Cleric(10th Rank)++";
		
		MinesRoll(0);
		}
	//barbarians 0
	if (secondaryRollValue >= 62 && secondaryRollValue <= 68){
		secondaryString = "++4 Barbarians in AC2, all take an extra hit++";
		
		MinesRoll(0);
		}
	//peasants 1
	if (secondaryRollValue >= 69 && secondaryRollValue <= 74){
		secondaryString = "++20 Peasants (1 hit, no shields), 1 Peasant Hero(AC2 with shield)++";
		
		MinesRoll(0);
		}
	//brigands 2
	if (secondaryRollValue >= 75 && secondaryRollValue <= 80){
		secondaryString = "++5 Brigands in AC2++";
		
		MinesRoll(0);
		}
	//barbarians 1
	if (secondaryRollValue >= 81 && secondaryRollValue <= 85){
		secondaryString = "++6 Barbarians in AC2 (2 Handed weapons only), all take an extra hit++";
		
		MinesRoll(0);
		}
	//brigands 3
	if (secondaryRollValue >= 86 && secondaryRollValue <= 89){
		secondaryString = "++5 Brigands in AC2, 4 Brigands in AC3, 1 Mage(20th Rank)++";
		
		MinesRoll(0);
		}
	//knights 2
	if (secondaryRollValue >= 90 && secondaryRollValue <= 93){
		secondaryString = "++4 Knights in AC3, 1 Champion in AC4++";
		
		MinesRoll(0);
		}
	//brigands 4
	if (secondaryRollValue >= 94 && secondaryRollValue <= 96){
		secondaryString = "++2 Brigands in AC2, 2 Brigands in AC3, 1 Brigand in AC4 with shield [+5 mines and ruins]++";
		
		MinesRoll(5);
		}
	//knights 3
	if (secondaryRollValue >= 97 && secondaryRollValue <= 98){
		secondaryString = "++4 Knights in AC3, 1 Cavalier(20th Rank) in AC4 [+5 mines and ruins]++";
		
		MinesRoll(5);
		}
	//brigands 5
	if (secondaryRollValue == 99){
		secondaryString = "++4 Brigands in AC1, 2 Brigands in AC2, 2 Brigands in AC3, and Druib(20th Rank) [+10 mines and ruins]++";
		
		MinesRoll(10);
		}
	//adventuring party
	if (secondaryRollValue == 100){
		secondaryString = "++5 people, any class, 20th Rank [+15 mines and ruins]++";
		
		MinesRoll(15);
		}
	
}

public static void HumanoidRoll(){
	secondaryRollValue = (int)(Math.random()*max)+1;
	secondaryHeaderString = "Humanoid Table Roll of: " + "[" + secondaryRollValue + "]";
	
	
	//goblins 0
		if (secondaryRollValue <= 10){
			secondaryString = "++10 Goblins (1 Hit)++";
			
			MinesRoll(0);
			}
	//goblins 1
		if (secondaryRollValue >= 11 && secondaryRollValue <= 15){
			secondaryString = "++20 Goblins (1 Hit) and 1 Goblin King(2 Hits)++";
			
			MinesRoll(0);
			}
	//orcs 0
		if (secondaryRollValue >= 16 && secondaryRollValue <= 20){
			secondaryString = "++3 Orcs in AC0 and 1 Ogre(6 Hits and Giant)++";
			
			MinesRoll(0);
			}
	//orcs 1
		if (secondaryRollValue >= 21 && secondaryRollValue <= 24){
			secondaryString = "++6 Orcs in AC0 and 1 Orc Boss in AC3++";
			
			MinesRoll(0);
			}
	//hobgoblin 0
		if (secondaryRollValue >= 25 && secondaryRollValue <= 35){
			secondaryString = "++2 Hobgoblins in AC2++";
			
			MinesRoll(0);
			}
	//hobgoblin 1
		if (secondaryRollValue >= 36 && secondaryRollValue <= 44){
			secondaryString = "++5 Hobgoblins in AC1++";
			
			MinesRoll(0);
			}
	//hobgoblin 2
		if (secondaryRollValue >= 45 && secondaryRollValue <= 52){
			secondaryString = "++8 Hobgoblins in AC1++";
			
			MinesRoll(0);
			}
	//gnolls 0
		if (secondaryRollValue >= 53 && secondaryRollValue <= 60){
			secondaryString = "++6 Gnolls in AC2, 3 have shields++";
			
			MinesRoll(0);
			}
	//gnolls 1
		if (secondaryRollValue >= 61 && secondaryRollValue <= 62){
			secondaryString = "++10 Gnolls in AC2++";
			
			MinesRoll(0);
			}
	//bugbears 0
		if (secondaryRollValue >= 63 && secondaryRollValue <= 69){
			secondaryString = "++3 Bugbears in AC3++";
			
			MinesRoll(0);
			}
	//bugbears 1
		if (secondaryRollValue >= 70 && secondaryRollValue <= 78){
			secondaryString = "++3 Bugbears in AC3, 1 Bugbear Shaman in AC3(1 Entangle, 1 Lightning Boltt, 1 Cure Light Wounds)++";
			
			MinesRoll(0);
			}
	//goblins 2
		if (secondaryRollValue >= 79 && secondaryRollValue <= 87){
			secondaryString = "++10 Goblins (1 Hit), 5 Orcs in AC1, 5 Hobgoblins in AC2[+10 Mines and Ruins]++";
			
			MinesRoll(10);
			}
	//hobgoblin 3
		if (secondaryRollValue >= 88 && secondaryRollValue <= 94){
			secondaryString = "++2 Hobgoblins in AC1, 2 Gnolls in AC2, 2 Bugbears in AC3 [+15 Mines and Ruins]++";
			
			MinesRoll(15);
			}
	//goblins 3
		if (secondaryRollValue >= 95 && secondaryRollValue <= 98){
			secondaryString = "++10 Goblins(1 Hit), 2 Orcs in AC0," +
					" 2 Hobgoblins in AC1, 2 Gnolls in AC2, 2 Bugbears in AC3 [+20 Mines and Ruins]++";
			
			MinesRoll(20);
			}
	// waaauuuugh
		if (secondaryRollValue >= 99 && secondaryRollValue <= 100){
			secondaryString = "++20 Goblins(1 Hit),10 Orcs in AC0, 5 Hobgoblins in AC1," +
					" plus 1 Ogre Magi(6 Hits, 2 Lightning Bolts, Damaged only by Magic Weapons) [+25 Mines and Ruins]++";
			
			MinesRoll(25);
			}
	
}
public static void UndeadRoll(){
	secondaryRollValue = (int)(Math.random()*max)+1;
	secondaryHeaderString = "Undead Table Roll of: " + "[" + secondaryRollValue + "]";
	//skeletons 0
	if (secondaryRollValue >= 1 && secondaryRollValue <= 25){
		secondaryString = "++5 Skeletons(AC1, red damage has no effect, destroyed by one hit from a non-red Holy or Blessed weapon++";
		
		MinesRoll(0);
		}
	//zombies 0
	if (secondaryRollValue >= 26 && secondaryRollValue <= 50){
		secondaryString = "++5 Zombies(AC2, destroyed by one hit from a non-red Holy or Blessed weapon++";
		
		MinesRoll(0);
		}
	//mummies 0
	if (secondaryRollValue >= 51 && secondaryRollValue <= 75){
		secondaryString = "++5 Mummies(AC3, destroyed by one hit from a non-red Holy or Blessed weapon," +
				" 1 minute Agony Poison with each damage causing hit++";
		
		MinesRoll(0);
		}
	//skeletal knights 0
	if (secondaryRollValue >= 76 && secondaryRollValue <= 85){
		secondaryString = "++5 Skeletal Knights (AC3, Red Damage has no effect," +
				" destroyed by two hits from a non-red Holy or Blessed weapon)[+5 Mines and Ruins]++";
		
		MinesRoll(5);
		}
	//ghouls 0
	if (secondaryRollValue >= 86 && secondaryRollValue <= 90){
		secondaryString = "++3 Ghouls(AC4, destroyed by two hits from a Holy or Blessed weapon," +
				" 1 minute Paralyzation Poison with each damage causing hit)[+10 Mines and Ruins]++";
		
		MinesRoll(10);
		}
	//banshee 0
	if (secondaryRollValue >= 91 && secondaryRollValue <= 95){
		secondaryString = "++1 Banshee (7 Hits, damaged only by Magic, Holy or Blessed Weapon. "
				+ "May \"Scream\" once per encounter causing a Curse effect in a 3ft radius from spell ball impact. "
				+ "Banshee calls out \"Curse, 3ft Radius!\" when throwing spellball[+15 Mines and Ruins]++";
		
		MinesRoll(15);
		}
	//lich 0
	if (secondaryRollValue >= 96 && secondaryRollValue <= 98){
		secondaryString = "++1 Lich(8 Hits, damaged only by Magic, Holy or Blessed weapons." +
				" Takes 2x damage from Holy weapons(since they are silvered), "
				+ "immune to Turn Undead unless Cleric is lvl 30+, 3 Fireballs)[+20 Mines and Ruins]++";
		
		MinesRoll(20);
		}
	//fleshGolem 0
	if (secondaryRollValue == 99){
		secondaryString = "++1 Flesh Golem(9 Hits, does not have to fight on knees vs Gian Sized opponents,"
				+ " damaged only by Magic, Holy or Blessed weapons, does black damage with weapons)[+25 Mines and Ruins]++";
		
		MinesRoll(25);
		}
	//vampire
	if (secondaryRollValue == 100){
		secondaryString = "++1 Vampire(10 Hits, damaged only by Magic, Holy or Blessed weapons," +
				" does black damage with weapons, immune to Turn Undead)"
				+ " and 3 Thralls(0 level humans, no shields, no armor)[+30 Mines and Ruins]++";
		
		MinesRoll(30);
		}
	
}
	
public static void GiantRoll(){
	secondaryRollValue = (int)(Math.random()*max)+1;
	secondaryHeaderString = "Giants Table Roll of: " + "[" + secondaryRollValue + "]";
	
	//owlbears 0
	if (secondaryRollValue <= 25){
		secondaryString = "++2 Owlbears, (AC4, giant)++";
		
		MinesRoll(0);
		}
	//owlbears 1
	if (secondaryRollValue >= 26 && secondaryRollValue <= 50){
		secondaryString = "++4 Owlbears, (AC4, giant)++";
		
		MinesRoll(0);
		}
	//trolls 0
	if (secondaryRollValue >= 51 && secondaryRollValue <= 60){
		secondaryString = "++1 Troll, (6 Hits, giant, heals self at a rate of one hit per minute, Fireball kills instantly)++";
		
		MinesRoll(0);
		}
	//ogres 0
	if (secondaryRollValue >= 61 && secondaryRollValue <= 70){
		secondaryString = "++5 Ogres, (6 Hits, giant)[+10 Mines and Ruins]++";
		
		MinesRoll(10);
		}
	//trolls 1
	if (secondaryRollValue >= 70 && secondaryRollValue <= 80){
		secondaryString = "++3 Trolls, (6 Hits, giant, heals self at a rate of one hit per minute," +
				" Fireball kills instantly)[+15 Mines and Ruins]++";
		
		MinesRoll(15);
		}
	//ogres 1
	if (secondaryRollValue >= 81 && secondaryRollValue <= 90){
		secondaryString = "++5 Ogres, (6 Hits, giant) and 1 Ogre Magi (6 Hits, giant, 2 Lightning Bolts," +
				" Damaged only with Magic Weapons)[+15 Mines and Ruins]++";
		
		MinesRoll(15);
		}
	//hill giants 0
	if (secondaryRollValue >= 91 && secondaryRollValue <= 93){
		secondaryString = "++2 Hill Giants, (8 Hits, giant)[+10 Mines and Ruins]++";
		
		MinesRoll(10);
		}
	//Frost giants
	if (secondaryRollValue >= 94 && secondaryRollValue <= 96){
		secondaryString = "++2 Frost Giants, (9 Hits, giant, does black damage, immune to ice spells)[+15 Mines and Ruins]++";
		
		MinesRoll(15);
		}
	//fire giants
	if (secondaryRollValue >= 97 && secondaryRollValue <= 99){
		secondaryString = "++2 Fire Giants, (10 Hits, giant, does black damage, immune to fire spells)[+20 Mines and Ruins]++";
		
		MinesRoll(20);
		}
	//storm giant
	if (secondaryRollValue >= 100){
		secondaryString = "++1 Storm Giant(10 Hits, giant, does black damage and shield break, 3 Lightning Bolts," +
				" immune to lightning spells, damaged only by Magic Weapons)[+25 Mines and Ruins]++";
		
		MinesRoll(25);
		}
	
	}

public static void DragonRoll(){
	secondaryRollValue = (int)(Math.random()*max)+1;
	secondaryHeaderString = "Dragons Table Roll of: " + "[" + secondaryRollValue + "]";
	
	//juvenile blue dragons
	if (secondaryRollValue <= 15 ){
		secondaryString = "++2 Juvenile Blue Dragons(5 Hits, use white or red weapon, 1 Lightning Bolt each)[+5 Mines and Ruins]++";
		
		MinesRoll(5);
		}
	//juvenile white dragons
	if (secondaryRollValue >= 16 && secondaryRollValue <= 30 ){
		secondaryString = "++2 Juvenile White Dragons(5 Hits, use white or red weapon, 1 Ice Storm each)[+5 Mines and Ruins]++";
		
		MinesRoll(5);
		}
	//juvenile red dragons
	if (secondaryRollValue >= 30 && secondaryRollValue <= 45 ){
		secondaryString = "++2 Juvenile Red Dragons(5 Hits, use white or red weapon, 1 Fireball each)[+10 Mines and Ruins]++";
		
		MinesRoll(10);
		}
	//adult blue dragon
	if (secondaryRollValue >= 46 && secondaryRollValue <= 55 ){
		secondaryString = "++1 Adult Blue Dragon(10 Hits, giant, does black damage, 3 Lightning Bolts, Immune to Lightning Bolt," +
				" damaged only by Magic Weapons)[+15 Mines and Ruins]++";
		
		MinesRoll(15);
		}
	//adult white dragon
	if (secondaryRollValue >= 56 && secondaryRollValue <= 65 ){
		secondaryString = "++1 Adult White Dragon(10 Hits, giant, does black damage, 3 Ice Storms, Immune to Ice Storm," +
				" damaged only by Magic Weapons)[+15 Mines and Ruins]++";
		
		MinesRoll(15);
		}
	//adult red dragon
	if (secondaryRollValue >= 66 && secondaryRollValue <= 75 ){
		secondaryString = "++1 Adult Red Dragon(10 Hits, giant, does black damage, 3 Fireballs, Immune to Fireball/BurningHands," +
				" damaged only by Magic Weapons)[+20 Mines and Ruins]++";
		
		MinesRoll(20);
		}
	//hydra
	if (secondaryRollValue >= 76 && secondaryRollValue <= 99 ){
		secondaryString = "++1 Hydra(15 Hits, giant, 2 Fireballs, damaged only by Magic Weapons," +
				" regenerates 1 hit every 30 seconds to represent head regrowth." +
				"does not regenerate after body is killed. Played by 3 people; 1 body and 2 \"heads\". Heads are Immune to all damage/spells.)[+30 Mines and Ruins]++";
		
		MinesRoll(30);
		}
	//chromatic dragon
	if (secondaryRollValue >= 100 ){
		secondaryString = "++1 Chromatic Dragon(15 Hits, giant, does black damage, 3 Fireballs, 3 Ice Storms," +
				" 3 Lightning Bolts, played by 3 people, damaged only by Magic Weapons)[+30 Mines and Ruins]++";
		
		MinesRoll(30);
		}
	}

//percentages for structure yield? rolled before or after encounter, do they know?
//mines??
public static void FortificationRoll(){
	secondaryRollValue = (int)(Math.random()*max)+1;
	secondaryHeaderString = "Fortifications Table Roll of: " + "[" + secondaryRollValue + "]";
	//!!!!! toast? information field??
	 fortString = "++These encounters are fought with a structure/fortification on the field of play. The structure has 1 accessible gate " +
			"to it which will be indicated by the Land Marshal. Once destroyed, these gates are not able to be mended by any means. Successful defeat of the encounter " +
			"will grant the possiblity to salvage " +
			"the structure, at 50% of the normal cost++ ";
	//wizard tower
	if (secondaryRollValue <= 20 ){
		secondaryString = "++Wizard's Tower- 1 Mage(Rank 20), 1 Apprentice(Rank 8), 3 Novices(Rank 4) [Salvage 10%]++";
		
	
		SalvageRoll(10);
		}
	//lords tower
	if (secondaryRollValue >= 21 && secondaryRollValue <= 40 ){
		secondaryString = "++Lord's Tower- 1 Knight(AC4), 4 Man at Arms(AC3), 2 Archers(AC1) [Salvage 10%]++";
		
		
		SalvageRoll(10);
		}
	//haunted tower
	if (secondaryRollValue >= 41 && secondaryRollValue <= 55 ){
		secondaryString = "++Haunted Tower- 5 Skeletal Knights(AC3, Immune to red damage, destroyed by two hits from a Holy or Blessed weapon), 1 Ghost(4 Hits, destroyed by" +
				" 1 hit from a Holy or Blessed weapon, may Passwall at will) [Salvage 25%]++";
		
		
		SalvageRoll(25);
		}
	//goblin keep
	if (secondaryRollValue >= 56 && secondaryRollValue <= 70 ){
		secondaryString = "++Goblin Keep (30x30)- 20 Goblins(no weapons over 4' in length, 1 hit)," +
				" 5 Hobgoblins(AC2), 1 Goblin King(2 hits)[Salvage 10%]++";
		
		
		SalvageRoll(10);
		}
	//fortified keep
	if (secondaryRollValue >= 71 && secondaryRollValue <= 85 ){
		secondaryString = "++Fortified Keep (30’x30’)- 10 Soldiers(AC2), 5 Knights(AC3)," +
				" 2 Archers(AC1), 1 Mage(Rank 10), 1 Cleric(AC3,Rank 10), 1 Lord(AC4)[Salvage 10%]++";
		
		
		SalvageRoll(10);
		}
	//giants lair
	if (secondaryRollValue >= 86 && secondaryRollValue <= 95 ){
		secondaryString = "++Giant’s Lair (40’x40’)- 6 Hill Giants(8 hits, giant) and 1 Hill Giant Chieften(10 hits, giant, does black damage) "+
				"Successful defeat of the encounter has a 10% chance of salvaging broken Caravel parts. [Salvage 10%]++";
		
	
		SalvageRoll(10);
		}
	//dragons lair
	if (secondaryRollValue >= 100 ){
		secondaryString = "++Dragon’s Lair (40’x40’)- Ancient Red Dragon (20 hits, Immune to Fire Based Spells, giant. Played by 4 participants (Head, 2 Claws, Tail)" + 
				"Head has 2 single blades, Claws have black sword, tail has spear. Claws do Black Damage & have shield break, Tail does double red damage and has shield break, " + 
				"head does black damage and the participant may throw 5 fireballs (Must wait 5 seconds between each throw), Damaged only by Magic Weapon.[Salvage 25%]++";
		
		
		SalvageRoll(25);
		}
	
	
	}
// Fertility rolls ( the LM will need to know what kind of hex is being searched)
//
public static void HexTypeSorter(String hex){
	inputHex = hex;
if (inputHex.equals("Mountains")){
	MountainFertilityRoll();
}
if (inputHex.equals("Forest")){
	ForestFertilityRoll();
	
}
if (inputHex.equals("Coastal")){
	CoastalFertilityRoll();
	
}
if (inputHex.equals("Plains")){
	PlainsFertilityRoll();
	
}
if (inputHex.equals("Desert")){
	DesertFertilityRoll();
	
}
}


public static void MountainFertilityRoll(){
	fertilityRollValue = (int)(Math.random()*max) +1;
	fertilityHeaderString = "Mountain Hex Fertility Roll of: " + "[" + fertilityRollValue + "]";
	
	if (fertilityRollValue <= 1 ){
		fertilityString = "++" + jungle + "++";
		}
	if (fertilityRollValue >= 2 && fertilityRollValue <= 46 ){
		fertilityString = "++" + rocky + "++";
		}
	if (fertilityRollValue >= 47 && fertilityRollValue <= 71 ){
		fertilityString = "++" + barren + "++";
		}
	if (fertilityRollValue >= 72  ){
		fertilityString = "++" + fertile + "++";
		}
	}

public static void ForestFertilityRoll(){
	fertilityRollValue = (int)(Math.random()*max) +1;
	fertilityHeaderString = "Forest Hex Fertility Roll of: " + "[" + fertilityRollValue + "]";
	if (fertilityRollValue <= 5 ){
		fertilityString = "++" + swamp + "++";
		}
	if (fertilityRollValue >= 6 && fertilityRollValue <= 25 ){
		fertilityString = "++" + jungle + "++";
		}
	if (fertilityRollValue >= 26 && fertilityRollValue <= 35 ){
		fertilityString = "++" + rocky + "++";
		}
	if (fertilityRollValue >= 36 && fertilityRollValue <= 45 ){
		fertilityString = "++" + barren + "++";
		}
	if (fertilityRollValue >= 46 ){
		fertilityString = "++" + fertile + "++";
		}
	}

public static void CoastalFertilityRoll(){
	fertilityRollValue = (int)(Math.random()*max) +1;
	fertilityHeaderString = "Coastal Hex Fertility Roll of: " + "[" + fertilityRollValue + "]";
	
	if (fertilityRollValue <= 5 ){
		fertilityString = "++" + swamp + "++";
		}
	if (fertilityRollValue >= 6 && fertilityRollValue <= 25 ){
		fertilityString = "++" + jungle + "++";
		}
	if (fertilityRollValue >= 26 && fertilityRollValue <= 35 ){
		fertilityString = "++" + rocky + "++";
		}
	if (fertilityRollValue >= 36 && fertilityRollValue <= 45 ){
		fertilityString = "++" + barren + "++";
		}
	if (fertilityRollValue >= 46 ){
		fertilityString = "++" + fertile + "++";
		}
	}

public static void PlainsFertilityRoll(){
	fertilityRollValue = (int)(Math.random()*max) +1;
	fertilityHeaderString = "Plains Hex Fertility Roll of: " + "[" + fertilityRollValue + "]";
	
	if (fertilityRollValue <= 5 ){
		fertilityString = "++" + swamp + "++";
		}
	if (fertilityRollValue >= 6 && fertilityRollValue <= 7 ){
		fertilityString = "++" + jungle + "++";
		}
	if (fertilityRollValue >= 8 && fertilityRollValue <= 23 ){
		fertilityString = "++" + rocky + "++";
		                                                                                               
		}
	if (fertilityRollValue >= 24 && fertilityRollValue <= 34 ){
		fertilityString = "++" + barren + "++";
		                                                                                               
		}
	if (fertilityRollValue >= 35 ){
		fertilityString = "++" + fertile + "++";
		}
	
	
	}

public static void DesertFertilityRoll(){
	fertilityRollValue = (int)(Math.random()*max) +1;
	fertilityHeaderString = "Desert Hex Fertility Roll of: " + "[" + fertilityRollValue + "]";
	if (fertilityRollValue <= 25 ){
		fertilityString = "++" + rocky + "++";
		}
	if (fertilityRollValue >= 26 && fertilityRollValue <= 75 ){
		fertilityString = "++" + barren + "++";
		}
	if (fertilityRollValue >= 76 ){
		fertilityString = "++" + fertile + "++";
		}
	
	}

// roll to salvage a structure, using the same header/ text as mines and ruins, as you cannot win mines and ruins on this search.
public static void SalvageRoll(int chance){
	salvagePercent = chance;
	salvageRollValue = (int)(Math.random()*max) +1;
	minesHeaderString = "Salvage roll of: " + "[" + salvageRollValue+"]" + ", "+ salvagePercent +"% chance of success";
	
	if(salvageRollValue <= salvagePercent){
		minesString = "Salvaged structure! ";
	}else{
		minesString = "Structure unsalvageable!";
	}
	
	
	}
public static void MinesRoll(int bonus){
	minesModValue = bonus; 
	minesRollValue = (int)(Math.random()*max) +1;
	minesTotalValue = minesModValue + minesRollValue;
	minesHeaderString = "Mines roll of " + minesRollValue + ", total of [" + minesTotalValue + "]";
	
	
	if (minesTotalValue <= 85){
		minesString = "++No Mines or Ruins are discovered++";
	}
	if (minesTotalValue >= 86 && minesTotalValue <= 88){
		minesString = "++An Iron Mine is discovered, yielding 100 Silver Pieces per season++";
	}
	if (minesTotalValue >= 89 && minesTotalValue <= 91){
		minesString = "++A Copper Mine is discovered, yielding 250 Silver Pieces per season++";
	}
	if (minesTotalValue >= 92 && minesTotalValue <= 94){
		minesString = "++A Silver Mine is discovered, yielding 500 Silver Pieces per season++";
	}
	if (minesTotalValue == 95){
		minesString = "++A Gold Mine is discovered, yielding 750 Silver Pieces per season++";
	}
	if (minesTotalValue >= 96 && minesTotalValue <= 97){
		minesString = "++A Ruined Tower is discovered++";
	}
	if (minesTotalValue >= 98 && minesTotalValue <= 99){
		minesString = "++A Ruined Keep is discovered++";
	}
	if (minesTotalValue >= 100){
		minesString = "++A Ruined Castle is discovered++";
	}
}

public static int getInitial() {
	return initial;
}

public static void setInitial(int initial) {
	RollsGen.initial = initial;
}

public static int getPrimaryRollValue() {
	return primaryRollValue;
}

public static void setPrimaryRollValue(int primaryRollValue) {
	RollsGen.primaryRollValue = primaryRollValue;
}

public static int getSecondaryRollValue() {
	return secondaryRollValue;
}

public static void setSecondaryRollValue(int secondaryRollValue) {
	RollsGen.secondaryRollValue = secondaryRollValue;
}

public static int getFertilityRollValue() {
	return fertilityRollValue;
}

public static void setFertilityRollValue(int fertilityRollValue) {
	RollsGen.fertilityRollValue = fertilityRollValue;
}

public static int getMinesRollValue() {
	return minesRollValue;
}

public static void setMinesRollValue(int minesRollValue) {
	RollsGen.minesRollValue = minesRollValue;
}

public static int getMinesModValue() {
	return minesModValue;
}

public static void setMinesModValue(int minesModValue) {
	RollsGen.minesModValue = minesModValue;
}

public static int getMinesTotalValue() {
	return minesTotalValue;
}

public static void setMinesTotalValue(int minesTotalValue) {
	RollsGen.minesTotalValue = minesTotalValue;
}

public static int getSalvageRollValue() {
	return salvageRollValue;
}

public static void setSalvageRollValue(int salvageRollValue) {
	RollsGen.salvageRollValue = salvageRollValue;
}

public static int getSalvagePercent() {
	return salvagePercent;
}

public static void setSalvagePercent(int salvagePercent) {
	RollsGen.salvagePercent = salvagePercent;
}

public static String getSwamp() {
	return swamp;
}

public static void setSwamp(String swamp) {
	RollsGen.swamp = swamp;
}

public static String getJungle() {
	return jungle;
}

public static void setJungle(String jungle) {
	RollsGen.jungle = jungle;
}

public static String getRocky() {
	return rocky;
}

public static void setRocky(String rocky) {
	RollsGen.rocky = rocky;
}

public static String getBarren() {
	return barren;
}

public static void setBarren(String barren) {
	RollsGen.barren = barren;
}

public static String getFertile() {
	return fertile;
}

public static void setFertile(String fertile) {
	RollsGen.fertile = fertile;
}

public String getPrimaryString() {
	return primaryString;
}

public static void setPrimaryString(String primaryString) {
	RollsGen.primaryString = primaryString;
}

public String getSecondaryString() {
	return secondaryString;
}

public static void setSecondaryString(String secondaryString) {
	RollsGen.secondaryString = secondaryString;
}

public String getFertilityString() {
	return fertilityString;
}

public static void setFertilityString(String secondaryString) {
	RollsGen.fertilityString = secondaryString;
}

public static String getInputHex() {
	return inputHex;
}

public static void setInputHex(String inputHex) {
	RollsGen.inputHex = inputHex;
}

public String getMinesString() {
	return minesString;
}

public static void setMinesString(String minesString) {
	RollsGen.minesString = minesString;
}

public String getFortString() {
	return fortString;
}

public static void setFortString(String fortString) {
	RollsGen.fortString = fortString;
}

public String getSalvageString() {
	return salvageString;
}

public static void setSalvageString(String salvageString) {
	RollsGen.salvageString = salvageString;
}

public static String getPrimaryHeaderString() {
	return primaryHeaderString;
}

public static void setPrimaryHeaderString(String primaryHeaderString) {
	RollsGen.primaryHeaderString = primaryHeaderString;
}

public String getSecondaryHeaderString() {
	return secondaryHeaderString;
}

public static void setSecondaryHeaderString(String secondaryHeaderString) {
	RollsGen.secondaryHeaderString = secondaryHeaderString;
}

public String getFertilityHeaderString() {
	return fertilityHeaderString;
}

public static void setFertilityHeaderString(String fertilityHeaderString) {
	RollsGen.fertilityHeaderString = fertilityHeaderString;
}

public String getMinesHeaderString() {
	return minesHeaderString;
}

public static void setMinesHeaderString(String minesHeaderString) {
	RollsGen.minesHeaderString = minesHeaderString;
}

public static int getMax() {
	return max;
}

}
