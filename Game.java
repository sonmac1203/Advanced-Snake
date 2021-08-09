
public class Game {
	
	Board newBoard;
	Player player1, player2;

	Game(Board board, Player player1, Player player2){
		this.newBoard = board;
		this.player1 = player1;
		this.player2 = player2;
	}
	
	private void welcome() {
		System.out.println("\nLet's play Tic Tac Toe!");
		System.out.println("\n 0 | 1 | 2 \n 3 | 4 | 5 \n 6 | 7 | 8 \n");
	}
	
	public void play() {
		this.welcome();
		while (true) {
			int position;
			position = player1.getPosition();
			System.out.println("Player 1 chose position: " + position);
			player1.makeMove(player1.getLetter(), position);
			newBoard.printBoard();
			if (newBoard.checkWin()) {
				System.out.println("Player 1 has won !!!");
				break;
			}
			if (newBoard.checkFull()) {
				System.out.println("This is a tie !!!");
				break;
			}
			position = player2.getPosition();
			System.out.println("Player 2 chose position: " + position);
			player2.makeMove(player2.getLetter(), position);
			newBoard.printBoard();
			if (newBoard.checkWin()) {
				System.out.println("Player 2 has won !!!");
				break;
			}
			if (newBoard.checkFull()) {
				System.out.println("This is a tie !!!");
				break;
			}
		}
	}
}
