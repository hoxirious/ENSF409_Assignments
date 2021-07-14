import java.util.Scanner;

public class Player implements Constants {
	private String name;
	private Board board;
	private Player opponent;
	private char mark;

	public Player(String name, char playerCharacter) {
		setName(name);
		setMark(playerCharacter);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setMark(char mark) {
		this.mark = mark;
	}

	public char getMark() {
		return mark;
	}

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

	public void gameOver() {
		if (board.isFull()) {
			System.out.println("It's a tie!");
		} else if (board.xWins()) {
			System.out.println("Player X aka " + getName() + " wins!");
		} else {
			System.out.println("Player O aka " + getName() + " wins!");
		}
	}

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

	public void setOpponent(Player otherPlayer) {
		this.opponent = otherPlayer;
	}

	public void setBoard(Board theBoard) {
		board = theBoard;
	}
}
