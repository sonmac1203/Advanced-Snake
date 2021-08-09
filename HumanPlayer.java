import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
	HumanPlayer(char letter, Board newBoard) {
		super(letter, newBoard);
	}
	
	@Override
	public int getPosition() {
		int position;
		while (true) {
			try {
				Scanner inputScanner = new Scanner(System.in);
				System.out.print("Please enter position (0-8): ");
				position = inputScanner.nextInt();
				if (newBoard.availableMove().contains(position)) break;
			}
			catch (InputMismatchException e) {
				System.out.println("Please retry!");
			}
		}
		return position;
	}
}
