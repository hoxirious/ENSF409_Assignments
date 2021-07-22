package Exercise_2;

import java.util.Scanner;

/**
 * The Class Player.
 */
public abstract class Player implements Constants {

	/** The name. */
	protected String name;

	/** The board. */
	protected Board board;

	/** The opponent. */
	protected Player opponent;

	/** The mark. */
	protected char mark;

	/**
	 * Instantiates a new player.
	 *
	 * @param name            the name
	 * @param playerCharacter the player character
	 */
	protected Player(String name, char playerCharacter) {
		setName(name);
		setMark(playerCharacter);
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	protected String getName() {
		return this.name;
	}

	/**
	 * Sets the mark.
	 *
	 * @param mark the new mark
	 */
	protected void setMark(char mark) {
		this.mark = mark;
	}

	/**
	 * Gets the mark.
	 *
	 * @return the mark
	 */
	protected char getMark() {
		return mark;
	}

	/**
	 * Play.
	 */
	protected void play() {
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
	protected void gameOver() {
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
	protected void makeMove() {
		Scanner scan = new Scanner(System.in);
		int row, col;
		System.out.println(getMark() + "'s turn");
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
	protected void setOpponent(Player otherPlayer) {
		this.opponent = otherPlayer;
	}

	/**
	 * Sets the board.
	 *
	 * @param theBoard the new board
	 */
	protected void setBoard(Board theBoard) {
		board = theBoard;
	}
}
