/* By: Shashank Ganta
 * *Pseudocode
 * check if user wants to play again or quit
 * get the computers choice
 * get the players/users choice
 * compare both results and check who won
 * 
 * start exercise 3, compare stats
 * take in input for both players
 * compare both players stats and decide who won
 * in ranking from Wins < Games < Moves
*/

package rockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {
	public static void main(String[] args) {
		String timer = "yes";
		int counter = 0;
		
		//checks if user would like to play again, and keeps track of total games played
		while (timer.equals("yes")){
			timer = repeat();
			counter++;
		}
		
		//Exercise 3, where we input the stats and decides who did better
		System.out.println("Number of Games Played: "+counter);
		System.out.println("\n");
		System.out.println("This next set of questions were made to see either player 1 or player 2 did better!");
		exercise3();
		}
	
		//ask user if they want to play again or quit
		public static String repeat() {
			exercise1();
			Scanner input = new Scanner(System.in);
			System.out.println("Would you like to play again?");
			String repeater_choice = input.nextLine();
			//forces input to lower case, to avoid any Case Sensitive Errors
			repeater_choice = repeater_choice.toLowerCase();
			
			return repeater_choice;
		}
		
		//get computer to choose its random choice
		public static String computer_choice() {
			Random rand = new Random();
			String computer_choice = "";
			//get the random choice
			int choice = rand.nextInt(3);
			//changes computer choice from a integer to a string
			switch (choice){
				case 0:
					computer_choice = "rock";
					break;
				case 1:
					computer_choice = "scissors";
					break;
				case 2:
					computer_choice = "paper";
					break;
				default:
					computer_choice = "error";
			}
			return computer_choice;
		}
		
		//Compare Users Choice and Computers Choice
		public static void exercise1() {
			//input the Players Choice
			Scanner input = new Scanner(System.in);
			System.out.println("Rock, Paper, or Scissors?");
			String user_choice = input.nextLine();
			String computer_choice = computer_choice();
			user_choice = user_choice.toLowerCase();
			//Compare User to Computer using switch statements
			switch (computer_choice) {
				case "rock":
					System.out.println("Computer chose rock!");
					switch (user_choice) {
						case "rock":
							System.out.println("You Tied");
							break;
						case "scissors":
							System.out.println("You Lose");
							break;
						case "paper":
							System.out.println("You Win");
							break;
						default:
							System.out.println("rock");
					}
					break;
				case "scissors":
					System.out.println("Computer chose scissors!");
					switch (user_choice) {
					case "rock":
						System.out.println("You Won");
						break;
					case "scissors":
						System.out.println("You Tied");
						break;
					case "paper":
						System.out.println("You Lost");
						break;
					default:
						System.out.println("error");
				}
				break;
				case "paper":
					System.out.println("Computer chose paper!");
					switch (user_choice) {
					case "rock":
						System.out.println("You Lost");
						break;
					case "scissors":
						System.out.println("You Won");
						break;
					case "paper":
						System.out.println("You Tied");
						break;
					default:
						System.out.println("error");
				}
				break;
				default:
					System.out.println("error!");
			}
		}

		//Exercise 3, check stats
		public static void exercise3() {
			Scanner input = new Scanner(System.in);
			//input Players 1 stats
			System.out.println("Player 1: ");
			System.out.println("Number of times they played the game: ");
			int timesPlayed1 = input.nextInt();
			System.out.println("Number of times they won the game: ");
			int winsPlayer1 = input.nextInt();
			System.out.println("Number of moves each game: ");
			int movesPlayer1 = input.nextInt();
			System.out.println("\n");
			
			//input Players 2 stats
			System.out.println("Player 2: ");
			System.out.println("Number of times they played the game: ");
			int timesPlayed2 = input.nextInt();
			System.out.println("Number of times they won the game: ");
			int winsPlayer2 = input.nextInt();
			System.out.println("Number of moves each game: ");
			int movesPlayer2 = input.nextInt();
			
			//check to see who has more wins, if tie move to next checkpoint
			if (winsPlayer1 > winsPlayer2) {
				System.out.println("Player 1 had more wins");
			}else if (winsPlayer2 > winsPlayer1) {
				System.out.println("Player 2 has more wins");
			}else {
				
				//check this if wins are equal
				if (timesPlayed1 > timesPlayed2) {
					System.out.println("Player 2 won, you both had the same wins!");
					System.out.println("But Player 2 got those wins in a lower amount of games");
				}else if (timesPlayed2 > timesPlayed1) {
					System.out.println("Player 1 won, you both had the same wins!");
					System.out.println("But Player 1 got those wins in a lower amount of games");
				}else {
					
					//check if wins and games are equal
					if (movesPlayer1 > movesPlayer2) {
						System.out.println("Player 2 won, with less moves than Player 1!");
					}else if (movesPlayer2 > movesPlayer1) {
						System.out.println("Player 1 won, with less moves than Player 2!");
					}else {
						System.out.println("Player 1 and Player 2 had equal stats, therefore you both tied!");
					}
				}
			}
		}
		
	}