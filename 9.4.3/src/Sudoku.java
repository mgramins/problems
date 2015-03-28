import java.util.Scanner;


public class Sudoku {
	
	private static int[][] board = new int[4][4];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				board[i][j] = in.nextInt();
			}
		}
		in.close();
		
		printBoard();
		solve();
		System.out.println();
		printBoard();
		
		
	}
	
	private static void solve() {
		//Fills 0s with possibilities 1-4
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(board[i][j] == 0) {
					board[i][j] = 1234;
				}
			}
		}
		
		while(!isSolved()) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(Integer.toString(board[i][j]).length() != 1) {
						board[i][j] = removeIllegals(i, j);
					}
				}
			}
		}
	}
	
	private static boolean isSolved() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(Integer.toString(board[i][j]).length() != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int removeIllegals(int row, int col) {
		for(int r = 0; r < 4; r++) {
			if(r != row) {
				switch(board[r][col]) {
					case 1:
						board[row][col] = removeDig(board[row][col], 1);
						break;
					case 2:
						board[row][col] = removeDig(board[row][col], 2);
						break;
					case 3:
						board[row][col] = removeDig(board[row][col], 3);
						break;
					case 4:
						board[row][col] = removeDig(board[row][col], 4);
						break;
				}
			}
		}
		
		for(int c = 0; c < 4; c++) {
			if(c != col) {
				switch(board[row][c]) {
				case 1:
					board[row][col] = removeDig(board[row][col], 1);
					break;
				case 2:
					board[row][col] = removeDig(board[row][col], 2);
					break;
				case 3:
					board[row][col] = removeDig(board[row][col], 3);
					break;
				case 4:
					board[row][col] = removeDig(board[row][col], 4);
					break;
				}
			}
		}
		int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
		if(row == 0 || row == 1) {
			if(col <= 1) {
				startRow = 0;
				startCol = 0;
				endRow = 1;
				endCol = 1;
			} else {
				startRow = 0;
				startCol = 2;
				endRow = 1;
				endCol = 3;
			}
		} else {
			if(col <= 1) {
				startRow = 2;
				startCol = 0;
				endRow = 3;
				endCol = 1;
			} else {
				startRow = 2;
				startCol = 2;
				endRow = 3;
				endCol = 3;
			}
		}
		
		for(int r = startRow; r <= endRow; r++) {
			for(int c = startCol; c <= endCol; c++) {
				if(!(r == row && c == col)) {
					switch(board[r][c]) {
					case 1:
						board[row][col] = removeDig(board[row][col], 1);
						break;
					case 2:
						board[row][col] = removeDig(board[row][col], 2);
						break;
					case 3:
						board[row][col] = removeDig(board[row][col], 3);
						break;
					case 4:
						board[row][col] = removeDig(board[row][col], 4);
						break;
					}
				}
			}
		}
		
		return board[row][col];
	}
	
	private static int removeDig(int n, int d) {
		String ns = Integer.toString(n);
		String ds = Integer.toString(d);
		String s = "";
		for(int i = 0; i < ns.length(); i++) {
			if(!(ns.charAt(i) == ds.charAt(0))) {
				s += ns.charAt(i);
			}
		}
		return Integer.parseInt(s);
	}
	
	private static void printBoard() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
