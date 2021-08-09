import java.util.Random;

public class DumbComputerPlayer extends Player{
	DumbComputerPlayer(char letter, Board newBoard) {
		super(letter, newBoard);
	}
	
	@Override
	public int getPosition() {
		Random random = new Random();
		int position;
		while (true) {
			position = random.nextInt(9);
			if (newBoard.availableMove().contains(position)) break;
		}
		return position;	
	}
}
