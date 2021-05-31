package rockPaperScissorsPig;
import java.util.*;

public class rockPaperScissorsPig {
	public static void main(String[] args) {
	String timer = "yes";
	while (timer.equals("yes")){
		timer = repeat();
	}
	}
	public static String repeat() {
		exercise1();
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to play again?");
		String repeater_choice = input.nextLine();
		repeater_choice = repeater_choice.toLowerCase();
		
		return repeater_choice;
	}
	public static String computer_choice() {
		Random rand = new Random();
		String computer_choice = "";
		int choice = rand.nextInt(3);
		//System.out.println(choice);
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
		//System.out.println(computer_choice);
		return computer_choice;
	}
	public static void exercise1() {
		Scanner input = new Scanner(System.in);
		System.out.println("Rock, Paper, or Scissors?");
		String user_choice = input.nextLine();
		String computer_choice = computer_choice();
		user_choice = user_choice.toLowerCase();
		//System.out.println(computer_choice);
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
}
