
public class SmartComputerPlayer extends Player {

	SmartComputerPlayer(char letter, Board newBoard) {
		super(letter, newBoard);
	}
	
	@Override
	public int getPosition() {
		int position;
		if (newBoard.countEmptyBoxes() == 9) {
			return 4;
		}
		else {
			position = smartComputerPlay(this.letter).position;
		}
		return position;
		
	}
	
	miniMax smartComputerPlay(char letter) {
		char other_letter, max_letter;
		max_letter = this.letter;
		other_letter = (letter == 'X') ? 'O' : 'X';
		miniMax best = new miniMax();
		miniMax simulator = new miniMax();
		
		if (newBoard.checkWin()) {
			best.position = -100;
			int utility;
			if (other_letter == max_letter) {
				utility = newBoard.countEmptyBoxes() + 1;
			}
			else {
				utility = -(newBoard.countEmptyBoxes() + 1);
			}
			best.score = utility;
			return best;
		}
		else if (newBoard.checkFull()) {
			best.position = -100;
			best.score = 0;
			return best;
		}
		
		if(max_letter == letter) {
			best.position = -100;
			best.score = -500;
		}
		else {
			best.position = -100;
			best.score = 500;
		}
		
		for (int position : newBoard.availableMove()) {
			makeMove(letter, position);
			simulator = smartComputerPlay(other_letter);
			
			newBoard.getBoard()[newBoard.returnY(position)][newBoard.returnX(position)] = 0;
			simulator.position = position;
			
			if (letter == max_letter) {
				if (simulator.score > best.score) {
					best = simulator;
				}
			}
			else {
				if (simulator.score < best.score) {
					best = simulator;
				}
			}
		}
		return best;
	}
	
	public class miniMax{
		int position;
		int score;
	}

}
