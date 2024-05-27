//Author full name: Yash Jain
//==================================================



/**
 * Your documentation for this class ....
 *
 *
 */

 //https://www.site.uottawa.ca/~diana/csi1102/Examples/chap11/TowersOfHanoi.java

import java.lang.Math;


public class HanoiTowerGame {

	//This will point to the array of three towers (type of towers LinkedStack)
	private Stack[] towerValues;

	// all methods should be documented: purpose of the method, input, and output

	//your code here

	//COMMENTS
	//private instance variables for the class
	//private variable disks = integer type variable (tracks all the disks in the game)
	//private variable currentLevel = integer type variable (tracks the currentLevel in the game)
	//private variable maxLevels = integer type variable (this is the maxlvels in the game)
	//private variable gameState = GameState type variable (tracks the GameState)
	private int disks;
	private int currentLevel;
	private int maxLevels;
	private GameState gameState;

	//First Type of Constructor
	//If no parameter was passed in this constructor is called
	public HanoiTowerGame() {
		this(3);
	}

	//Second Type of Constructor
	//If parameter disks were passed in this constructor is called
	public HanoiTowerGame(int disks) {

		//Set the instance variable to the disks passed in 
		//Set the current level to 0
		//Set the maxLevels using the equation given in the PDF
		//Set gameState to PLAYING
		this.disks = disks;
		this.currentLevel = 0;
		this.maxLevels = 2 * ((int) Math.pow(2, disks) - 1);
		this.gameState = GameState.PLAYING;


		//Initializing towerValues to hold 3 towers
		//Push disks (in integer form - meaning integer numbers) into the first tower 
		//Starts from the max disk size and then decrements
		towerValues = new LinkedStack[3];
		towerValues[0] = new LinkedStack();

		for (int i = this.disks; i > 0; i--) {
			towerValues[0].push(i);
		}

		//Creating the second tower and the third tower
		towerValues[1] = new LinkedStack();
		towerValues[2] = new LinkedStack();
	}
		
	/**
	 * Getter for the variable disks
	 * An integer return type method because disks is an integer value
	 * @return the value of disks (int type)
	*/ 

	public int getDisks() { return this.disks; }

	/**
	 * Getter for the variable disks at the specific tower mentioned
	 * An integer return type method because disks is an integer value
	 * @return the value of disks at the tower specified (int type)
	*/ 

	public int getDisksAtTower(int i) { return towerValues[i].size(); }

	/**
	 * Getter for the variable level
	 * An integer return type method because level is an integer value
	 * @return the current level the game is at (int type)
	*/ 

	public int getLevel() { return this.currentLevel; }

	/**
	 * Getter for the variable maxLevels
	 * An integer return type method because maxLevels is an integer value
	 * @return the maxLevels of the game allowed (int type)
	*/ 

	public int getMaxLevels() { return this.maxLevels; }

	/**
	 * getter for the variable gameState
	 * A GameState return type method because gameState is a GameState value
	 * @return the value of gameState
	*/

	public GameState getGameState() { return this.gameState; }

	//The main method for the HanoiTowerGame - Allows moves to be made (moving disks from towers to towers)
	//Takes 2 parameters both of type int
	//First parameter : int source = The source from which the disks are coming from
	//an integer type variable that represents the source tower from which you are taking disks from
	//Second parameter : int destination = The destination to which the disk should be placed
	//an integer type variable that represents at which tower should the disk be moved to
	//@return type void
	//
	//The way the method works...
	//Peek at the top of the source tower and destination tower
	//Check if destination tower is empty
	//Check if disk size is valid to be placed (it might be greater and as a result that is an invalid move)
	//Proceed with code and start popping the disk from source tower and pushing it into destination tower
	//Call the winner function
	//Else the source tower is empty


	public void play (int source, int destination) {

		int topValue1 = (int) towerValues[source].peek();
		int topValue2 = (int) towerValues[destination].peek();

		if (topValue2 == 0) {
			topValue2 = topValue1 + 1;
		}

		if (topValue1 > topValue2) {
			System.out.println("This disk size is greater! - INVALID MOVE.");
		}

		else if (topValue1 != 0) {
			towerValues[source].pop();
			towerValues[destination].push(topValue1);
			this.currentLevel++;
			checkWinner();
		}

		else {
			System.out.println("This tower is empty!");
		}

	}

	//Check winner method
	//First checks the Gamestate and if it not set to playing that means there is a winner
	//Check the size of tower 3 and if it equal to the number of disks the game was intialized with then that means all the disks are at tower 3 and the user has won and the gameState is winner
	//Check if the levels are not equal to the max levels (if this is the case) that means they lost and the gameState is loser
	public void checkWinner() {

		if (this.gameState != GameState.PLAYING) {
			return;
		}

		if (towerValues[2].size() == this.disks) {
			this.gameState = GameState.WINNER;
		}

		else if (this.currentLevel == maxLevels) {
			this.gameState = GameState.LOSER;
		}

	}

	//New line
	final String NEW_LINE = System.getProperty("line.separator");

	//toString method which returns the string representation of the game (each tower and the disks etc etc)
	//@return type String
	public String toString() {

		String hyphens = "";

		for (int i = 0; i < towerValues.length; i++) {
			hyphens += "Tower " + (i + 1) + Utils.NEW_LINE;
			hyphens += "\n".repeat(disks - towerValues[i].size());
			hyphens += towerValues[i].toString();
		}
		return hyphens;
	}
}