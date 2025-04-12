package Backtracking;

public class Sudukosolver {


	public static void main(String[] args) {
		int[][] grid = {
				{ 3, 0, 6, 5, 0, 8, 4, 0, 0 },
				{ 5, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 },
				{ 9, 0, 0, 8, 6, 3, 0, 0, 5 },
				{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 7, 4 },
				{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		sudoku(grid, 0, 0);
	}

	public static void sudoku(int[][] grid, int row, int col) {
		if (col == 9) {
			row++;
			col = 0;
		}
		if (row == 9) {
			display(grid);
			return;
		}

		if (grid[row][col] != 0) {
			sudoku(grid, row, col + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (isitsafe(grid, row, col, i)) {
					grid[row][col] = i;
					sudoku(grid, row, col + 1);
					grid[row][col] = 0;

				}

			}
		}

	}

	private static void display(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean isitsafe(int[][] grid, int row, int col, int val) {
		for (int j = 0; j < grid.length; j++) {
			if (grid[j][col] == val) {
				return false;
			}
		}

		for (int i = 0; i < grid.length; i++) {
			if (grid[row][i] == val) {
				return false;
			}
		}

		int sr = row - row % 3;
		int sc = col - col % 3;
		for (int i = sr; i < sr + 3; i++) {
			for (int j = sc; j < sc + 3; j++) {
				if (grid[i][j] == val) {
					return false;
				}
			}
		}
		return true;
	}
}
