package Lab4;

// TODO: Auto-generated Javadoc
/**
 * The Class Referee.
 */
public class Referee {
	
	/** The o player. */
	private Player xPlayer, oPlayer;
	
	/** The board. */
	private Board board;


	/**
	 * Run the game.
	 */
	public void runTheGame() {
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();
	}

	/**
	 * Sets the board.
	 *
	 * @param board the new board
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Sets the o player.
	 *
	 * @param oPlayer the new o player
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}

	/**
	 * Sets the x player.
	 *
	 * @param xPlayer the new x player
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}

}
