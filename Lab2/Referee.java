
public class Referee {
	private Player xPlayer, oPlayer;
	private Board board;


	public void runTheGame() {
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}

	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}

}
