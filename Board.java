import java.util.ArrayList;

public class Board {
	
	private int[][] board = new int[3][3];
	
	Board() {
		makeBoard();
	}
	
	public int[][] getBoard(){
		return this.board;
	}
	
	// Initializes a board of zeros
	private void makeBoard() { 
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.board[i][j] = 0;
			}
		}
	}
	
	// Converts numerical values to characters
	private char convertBoard(int boardIndex) {
		if (boardIndex == 0) {
			return ' ';
		}
		else if (boardIndex == 1) {
			return 'X';
		}
		else {
			return 'O';
		}
	}
	
	// Prints the board to console
	public void printBoard() {
		System.out.print("\n");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (j==2) {
					System.out.print(" " + convertBoard(this.board[i][j]) + " ");
				}
				else {
					System.out.print(" " + convertBoard(this.board[i][j]) + " |");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	// Checks if one of the players wins
	public boolean checkWin() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] + board[i][1] + board[i][2] == 3 // Row check
					|| board[0][i] + board[1][i] + board[2][i] == 3 // Column check
					|| board[0][0] + board[1][1] + board[2][2] == 3 // Diagonal check
					|| board[0][2] + board[1][1] + board[2][0] == 3) { 
			    return true;
		    }
			else if (board[i][0] + board[i][1] + board[i][2] == -3 
					|| board[0][i] + board[1][i] + board[2][i] == -3 
					|| board[0][0] + board[1][1] + board[2][2] == -3 
					|| board[0][2] + board[1][1] + board[2][0] == -3) { //Three 'O's means a sum of 0, since O corresponds to 0
		    	return true;
		    }
		}
		return false;
	}
	

	// Returns the empty boxes
	public int countEmptyBoxes() {
		int emptyBoxes = 0;
		for (int[] i : this.board) {
			for (int j : i) {
				if (j==0) emptyBoxes ++;
			}
		}
		return emptyBoxes;
	}
	
	// Checks if the board is already full
	public boolean checkFull() {
		return (countEmptyBoxes() == 0);
	}
	
	// Returns the board's X index from a given numerical position
	public int returnX(int position) {
		return position % 3;
	}
	
	// Returns the board's Y index from a given numerical position 
	public int returnY(int position) {
		return (int)(position / 3);
	}
	
	// Returns an array of available moves
	public ArrayList<Integer> availableMove(){
		ArrayList<Integer> move = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					move.add(3*i + j);
				}
			}
		}
		return move;
	}
}
