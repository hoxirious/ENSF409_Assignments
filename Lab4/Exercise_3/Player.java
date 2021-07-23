package Exercise_3;

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
	 * @param name            player's name
	 * @param playerCharacter the player's mark
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

	protected boolean checkEmpty(int row, int col) {
		return board.getMark(row, col) == SPACE_CHAR;
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
		if (board.checkWinner(mark) == 0 && board.checkWinner(opponent.getMark()) == 0 && !board.isFull()) {
			makeMove();
			board.display();
			if (board.checkWinner(mark) == 0 && board.checkWinner(opponent.getMark()) == 0 && !board.isFull()) {
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
		if (board.xWins()) {
			System.out.println("Player X aka " + getName() + " wins!");
		} else if (board.oWins()) {
			System.out.println("Player O aka " + getName() + " wins!");
		} else if (board.isFull()) {
			System.out.println("It's a tie!");
		}
	}

	/**
	 * Make move.
	 */
	protected void makeMove() {
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
