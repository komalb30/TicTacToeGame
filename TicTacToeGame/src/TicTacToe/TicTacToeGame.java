package TicTacToe;

import java.util.Scanner;

public class TicTacToeGame {
	private char[][] board;
	private char currentPlayer;

	public TicTacToeGame() {
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
		currentPlayer = 'X';
	}

	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			printBoard();
			System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (0-2):");
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			if (isValidMove(row, col)) {
				makeMove(row, col);
				if (hasWon()) {
					printBoard();
					System.out.println("Player " + currentPlayer + " wins!");
					break;
				}
				switchPlayer();
			} else {
				System.out.println("Invalid move, try again.");
			}
		}
	}

	private void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private boolean isValidMove(int row, int col) {
		return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
	}

	private void makeMove(int row, int col) {
		board[row][col] = currentPlayer;
	}

	private boolean hasWon() {
		// Check rows
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
				return true;
			}
		}
		// Check columns
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
				return true;
			}
		}
		// Check diagonals
		if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
				|| (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
			return true;
		}
		return false;
	}

	private void switchPlayer() {
		currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
	}

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.playGame();
	}
}