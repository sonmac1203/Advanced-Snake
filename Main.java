import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String answer1;
		Player player1, player2;
		Board newBoard = new Board();
		
		// Show options for Player 1
		System.out.println("Player 1: ");
		System.out.println("\n-> Human (1)\n-> Smart Computer (2)\n-> Dumb Computer (3)\n");
		while (true) {
			System.out.print("Choice: ");
			answer1 = inputScanner.nextLine();
			if (answer1.equals("1") || answer1.equals("2") || answer1.equals("3")) break;
		}
		if (answer1.equals("1")) {
			player1 = new HumanPlayer('X', newBoard);
		}
		else if (answer1.equals("2")) {
			player1 = new SmartComputerPlayer('X', newBoard);
		}
		else {
			player1 = new DumbComputerPlayer('X', newBoard);
		}
		
		// Show options for Player 2
		System.out.println("\nPlayer 2: ");
		System.out.println("\n-> Human (1)\n-> Smart Computer (2)\n-> Dumb Computer (3)\n");
		while (true) {
			System.out.print("Choice: ");
			answer1 = inputScanner.nextLine();
			if (answer1.equals("1") || answer1.equals("2") || answer1.equals("3")) break;
		}
		if (answer1.equals("1")) {
			player2 = new HumanPlayer('O', newBoard);
		}
		else if (answer1.equals("2")) {
			player2 = new SmartComputerPlayer('O', newBoard);
		}
		else {
			player2 = new DumbComputerPlayer('O', newBoard);
		}
		
		// Play the game
		Game game = new Game(newBoard, player1, player2);
		game.play();
	}
}
