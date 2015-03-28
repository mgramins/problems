import java.util.Scanner;
public class NineByNine {
		
	private static int[][] board = new int[9][9];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
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
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] == 0) {
					board[i][j] = 123456789;
				}
			}
		}
		
		while(!isSolved()) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(Integer.toString(board[i][j]).length() != 1) {
						board[i][j] = removeIllegals(i, j);
					}
				}
			}
		}
	}
	
	private static boolean isSolved() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(Integer.toString(board[i][j]).length() != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static int removeIllegals(int row, int col) {
		for(int r = 0; r < 9; r++) {
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
					case 5:
						board[row][col] = removeDig(board[row][col], 5);
						break;
					case 6:
						board[row][col] = removeDig(board[row][col], 6);
						break;
					case 7:
						board[row][col] = removeDig(board[row][col], 7);
						break;
					case 8:
						board[row][col] = removeDig(board[row][col], 8);
						break;
					case 9:
						board[row][col] = removeDig(board[row][col], 9);
						break;
				}
			}
		}
		
		for(int c = 0; c < 9; c++) {
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
					case 5:
						board[row][col] = removeDig(board[row][col], 5);
						break;
					case 6:
						board[row][col] = removeDig(board[row][col], 6);
						break;
					case 7:
						board[row][col] = removeDig(board[row][col], 7);
						break;
					case 8:
						board[row][col] = removeDig(board[row][col], 8);
						break;
					case 9:
						board[row][col] = removeDig(board[row][col], 9);
						break;
				}
			}
		}
		int startRow = 0, startCol = 0, endRow = 0, endCol = 0;
		if(row <= 2) {
			if(col <= 2) {
				startRow = 0;
				startCol = 0;
				endRow = 2;
				endCol = 2;
			} else if(col > 2 && col <= 5){
				startRow = 0;
				startCol = 3;
				endRow = 2;
				endCol = 5;
			} else {
				startRow = 0;
				startCol = 6;
				endRow = 2;
				endCol = 8;
			}
		} else if(row > 2 && row <= 5){
			if(col <= 2) {
				startRow = 3;
				startCol = 0;
				endRow = 5;
				endCol = 2;
			} else if(col > 2 && col <= 5){
				startRow = 3;
				startCol = 3;
				endRow = 5;
				endCol = 5;
			} else {
				startRow = 3;
				startCol = 6;
				endRow = 5;
				endCol = 8;
			}
		} else {
			if(col <= 2) {
				startRow = 6;
				startCol = 0;
				endRow = 8;
				endCol = 2;
			} else if(col > 2 && col <= 5){
				startRow = 6;
				startCol = 3;
				endRow = 8;
				endCol = 5;
			} else {
				startRow = 6;
				startCol = 6;
				endRow = 8;
				endCol = 8;
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
					case 5:
						board[row][col] = removeDig(board[row][col], 5);
						break;
					case 6:
						board[row][col] = removeDig(board[row][col], 6);
						break;
					case 7:
						board[row][col] = removeDig(board[row][col], 7);
						break;
					case 8:
						board[row][col] = removeDig(board[row][col], 8);
						break;
					case 9:
						board[row][col] = removeDig(board[row][col], 9);
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
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
