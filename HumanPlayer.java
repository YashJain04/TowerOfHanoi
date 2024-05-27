import java.util.Scanner;

//Author full name: Yash Jain
//==================================================

/**
 * The class <b>HumanPlayer</b> is the class that controls the human's plays.
 * ... some more details here
 * 
*/

//COMMENTS
//The HUMANPLAYER class which implements the interface PLAYER
//Allows the humans to make moves for the GAME and play it

public class HumanPlayer implements Player {

	// your code here

	//private integer type variable called score and is initialized to 0
	//the variable will track the score of the player
	private int score = 0;

	@Override
	public void play(HanoiTowerGame game) {

		//Creating a scanenr
		Scanner sc = new Scanner(System.in);

		//Boolean varialble for while loop condition
		boolean checker = true;

		//Integer variable to track which statements should be printed to the user over and over again
		int counter = 0;

		while (checker) {
			System.out.println(game);

			if (counter == 0) {
				System.out.println("Your goal is to move all disks from tower 1 to 3.");
				System.out.println("Only one simple rule: no large disk on the top of a smaller one!");
			}

			else if (counter > 0) {
				System.out.println("Moves Played: " + game.getLevel() + " Max: " + game.getMaxLevels());
			}

			System.out.println("Enter the source and the destination towers each on a single line:");

			//Taking inputs from the user for the source tower and the destination tower
			int sourceChoice = sc.nextInt();
			int destinationChoice = sc.nextInt();

			//Playing the game with those inputs - 1 (human starts from 1 not 0)
			game.play(sourceChoice - 1, destinationChoice - 1);

			counter++;

			//Check for winner and loser and print the score
			//If they won the score variable gets incremented by 1 and prints that their score is 1 
			//And if they lost the score is 0

			if (game.getGameState() != GameState.PLAYING) {

				System.out.println(game);
				System.out.println("Moves Played: " + game.getLevel() + " Max: " + game.getMaxLevels());
				
				if (game.getGameState() == GameState.WINNER) {
					this.score++;
					System.out.println("You did it within the allowed number of moves!");
					System.out.println("Your score is " + this.score);
					System.out.println("=================");
				}

				else if (game.getGameState() == GameState.LOSER) {
					System.out.println("You finished the allowed number of moves!");
					System.out.println("Your score is " + this.score);
					System.out.println("=================");
				}

				checker = false;
			}
		}
		
	}


	//The method getScore() is a getter for the instance variable score that tracks the score of the player (will return the integer variable score)
	@Override
	public int getScore() { return this.score; }
}