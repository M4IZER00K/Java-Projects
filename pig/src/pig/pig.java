/*Pseudocode
 * Introduce the game
 * continue playing the game until someone reaches 100
 * get random number for player1
 * ask if player 1 wants to play again, unless if they rolled a 1
 * if yes then play again and repeat until a 1 appears or no is answered
 * 
 * get player's 2 random number
 * ask if they want play again
 * 
 * continue alternating until someone reaches 100
 */

package pig;
import java.util.*;
public class pig {
	public static void main(String[] args) {
		runner();
	}
	public static int roller(int player) {
		//decide whose turn it is
		System.out.println("\n\n\n");
		System.out.println("This is Player " + player + "'s Turn:");
		int runScore1 = 0;
		Scanner input = new Scanner(System.in);
		String choice = "yes";
		Random rand = new Random();
		while (choice.equals("yes")) {
			//get random number for turn
			System.out.println("\nRolling...");
			int adder = rand.nextInt(6) + 1;
			if (adder == 1) {
				runScore1 = 0;
				System.out.println("You Rolled a 1, you lost all points gained on this run, your turn is now over!");
				choice = "no";
			}else {
				//ask if player would like to go again, only if they didn't roll a 1
				System.out.println("You rolled: " + adder);
				runScore1 += adder; 
				System.out.println("Your Score On This Run Is: " + runScore1);
				System.out.println("Would you like to continue rolling?");
				choice = input.nextLine();	
				choice = choice.toLowerCase();

			}
		}
		//return the score they got this turn
		return runScore1;
	}

	public static void runner() {
		System.out.println("Welcome To Pig");
		int totalScore1 = 0;
		int totalScore2 = 0;
		int player = 1;
		int timer = 1;
		
		//continue playing until someone wins
		while (totalScore1 < 100 && totalScore2 < 100) {
			if (timer == 1) {
				player = 1;
				int runScore1 = roller(player);
				totalScore1 += runScore1; 
				System.out.println("Total Score for Player1: "+ totalScore1);
				timer = 2;
			}else {
				player = 2;
				int runScore2 = roller(player);
				totalScore2 += runScore2;
				System.out.println("Total Score for Player2: " + totalScore2);
				timer = 1;
			}
		}
		//check to see who won and print it
		if (totalScore1 >= 100) {
			System.out.println("\n\nCongrats Player 1 Won With A Score Of: "+totalScore1);
		}else {
			System.out.println("\n\nCongrats Player 2 Won With A Score Of: "+totalScore2);
		}
	}
}
