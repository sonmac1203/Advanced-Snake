
public abstract class Player {
	
	protected Board newBoard;
	protected char letter;
	
	Player(char letter, Board newBoard){
		this.letter = letter;
		this.newBoard = newBoard;
	}
	
	public char getLetter() {
		return this.letter;
	}
	
	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public int getPosition() {
		return 0;
	}
	
	public void makeMove(char letter, int position) {
		int value = newBoard.getBoard()[newBoard.returnY(position)][newBoard.returnX(position)];
		if (value == 0) { // Checks if the board is empty
			if (letter == 'X') {
				newBoard.getBoard()[newBoard.returnY(position)][newBoard.returnX(position)] = 1;
			}
			else if(letter == 'O') {
				newBoard.getBoard()[newBoard.returnY(position)][newBoard.returnX(position)] = -1;
			}
		}
	}
}
