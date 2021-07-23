package Exercise_3;

// TODO: Auto-generated Javadoc
/**
 * The Class RandomPlayer.
 */
public class RandomPlayer extends Player {

	/**
	 * Instantiates a new random player.
	 *
	 * @param name the name
	 * @param playerCharacter the player character
	 */
	public RandomPlayer(String name, char playerCharacter) {
		super(name, playerCharacter);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Make move.
	 */
	@Override
	protected void makeMove() {
		RandomGenerator rg = new RandomGenerator();
		int row, col;
		row = rg.discrete(0, 2);
		col = rg.discrete(0, 2);
		while (!checkEmpty(row, col)) {
			row = rg.discrete(0, 2);
			col = rg.discrete(0, 2);
		}
		board.addMark(row, col, mark);
	}
}
