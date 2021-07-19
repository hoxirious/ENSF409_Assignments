import java.util.Scanner;

/**
 * The Class Player.
 */
public class Player implements Constants {
	
	/** The name. */
	private String name;
	
	/** The board. */
	private Board board;
	
	/** The opponent. */
	private Player opponent;
	
	/** The mark. */
	private char mark;

	/**
	 * Instantiates a new player.
	 *
	 * @param name the name
	 * @param playerCharacter the player character
	 */
	public Player(String name, char playerCharacter) {
		setName(name);
		setMark(playerCharacter);
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the mark.
	 *
	 * @param mark the new mark
	 */
	public void setMark(char mark) {
		this.mark = mark;
	}

	/**
	 * Gets the mark.
	 *
	 * @return the mark
	 */
	public char getMark() {
		return mark;
	}

	/**
	 * Play.
	 */
	public void play() {
		if (board.checkWinner(mark) == 0) {
			makeMove();
			board.display();
			if (board.checkWinner(mark) == 0) {
				opponent.play();
			} else {
				gameOver();
			}
		} else {
			gameOver();
		}

	}

	/**
	 * Game over.
	 */
	public void gameOver() {
		if (board.isFull()) {
			System.out.println("It's a tie!");
		} else if (board.xWins()) {
			System.out.println("Player X aka " + getName() + " wins!");
		} else {
			System.out.println("Player O aka " + getName() + " wins!");
		}
	}

/**
 * Make move.
 */
//javac Game.java Constants.java Player.java Referee.java Board.java
	public void makeMove() {
		Scanner scan = new Scanner(System.in);
		int row, col;
		System.out.println(getMark()+ "'s turn");
		System.out.println("Enter row");
		row = scan.nextInt();
		System.out.println("Enter column");
		col = scan.nextInt();
		board.addMark(row, col, mark);
	}

	/**
	 * Sets the opponent.
	 *
	 * @param otherPlayer the new opponent
	 */
	public void setOpponent(Player otherPlayer) {
		this.opponent = otherPlayer;
	}

	/**
	 * Sets the board.
	 *
	 * @param theBoard the new board
	 */
	public void setBoard(Board theBoard) {
		board = theBoard;
	}
}
