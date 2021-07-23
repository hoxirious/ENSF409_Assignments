package Exercise_3;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class HumanPlayer.
 */
public class HumanPlayer extends Player {

	/**
	 * Instantiates a new human player.
	 *
	 * @param name the name
	 * @param playerCharacter the player character
	 */
	public HumanPlayer(String name, char playerCharacter) {
		super(name, playerCharacter);
	}

	/**
	 * Make move.
	 */
	@Override
	protected void makeMove() {
		Scanner scan = new Scanner(System.in);
		int row, col;
		System.out.println(getMark() + "'s turn");
		System.out.println("Enter row: ");
		row = scan.nextInt();
		System.out.println("Enter column: ");
		col = scan.nextInt();
		while (!checkEmpty(row, col)) {
			System.out.println("Your move has been played!");
			System.out.println("Enter row: ");
			row = scan.nextInt();
			System.out.println("Enter column: ");
			col = scan.nextInt();
		}
		board.addMark(row, col, mark);
	}

}
