package Exercise_3;

// TODO: Auto-generated Javadoc
/**
 * The Class BlockingPlayer.
 */
public class BlockingPlayer extends RandomPlayer {

	/**
	 * Instantiates a new blocking player.
	 *
	 * @param name the name
	 * @param playerCharacter the player character
	 */
	public BlockingPlayer(String name, char playerCharacter) {
		super(name, playerCharacter);
	}

	/**
	 * Make move.
	 */
	@Override
	protected void makeMove() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (checkEmpty(i, j)) {
					// test if this cell needed to be blocked
					if (testForBlocking(i, j)) {
						board.addMark(i, j, mark);
						return; 
					}
				}
			}
		}
		super.makeMove();
		return;
	}

	/**
	 * Test for blocking.
	 *
	 * @param row the row
	 * @param col the col
	 * @return true, if the given move makes the opponent win
	 */
	protected boolean testForBlocking(int row, int col) {

		// suppose opponent make this move
		char opponentMark = opponent.getMark();
		board.addMark(row, col, opponentMark);
		if (board.checkWinner(opponentMark) == 1) {
			// remove the suppose move
			board.setBlank(row, col);
			return true;
		} else {
			// remove the suppose move
			board.setBlank(row, col);
			return false;
		}
	}

}
