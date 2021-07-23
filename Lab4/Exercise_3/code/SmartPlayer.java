package Exercise_3;

// TODO: Auto-generated Javadoc
/**
 * The Class SmartPlayer.
 */
public class SmartPlayer extends BlockingPlayer {

	/**
	 * Instantiates a new smart player.
	 *
	 * @param name the name
	 * @param playerCharacter the player character
	 */
	public SmartPlayer(String name, char playerCharacter) {
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
					if (testForWinning(i, j)) {
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
	 * Test for winning.
	 *
	 * @param row the row
	 * @param col the col
	 * @return true, if the given move makes the player win 
	 */
	protected boolean testForWinning(int row, int col) {
	
		// suppose you make this move
		board.addMark(row, col, mark);
		//if that makes you win
		if (board.checkWinner(mark) == 1) {
			// remove the suppose move
			board.setBlank(row, col);
			return true;
		}
		
		else {
			// remove the suppose move
			board.setBlank(row, col);
			return false;
		}
		
		
	}
	
	
}
