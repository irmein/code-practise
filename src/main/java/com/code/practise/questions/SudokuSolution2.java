package com.code.practise.questions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolution2 {

	public static void main(String[] args) {
		SudokuSolution2 solution = new SudokuSolution2();
		solution.process();
	}
	
	public void process() {
		int [][] board = new int [9][9];
		board[0][8] = 8;
		board[1][0] = 1;
		board[6][0] = 6;
		board[8][0] = 5;
		Sudoku sudoku = new Sudoku(board);
		print(sudoku.getSolution(board, 0, 0));
	}
	
	void print(Integer [] results) {
		System.out.println(Arrays.toString(results));
	}
	
	class Sudoku {
		int [][] board;
		
		public Sudoku(int [][] board) {
			this.board = board;
		}
		
		public Integer[] getSolution(int [][] board, int i, int j) {
			
			List<Integer> possibleValues = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9})); 
			
			
			removeRow(board, possibleValues, i);
			removeColumn(board, possibleValues, j);
			
			return possibleValues.toArray(new Integer[] {});
		}

		private void removeRow(int [][] board, List<Integer> possibleValues, int rowIndex) {
			for (int i = 0; i < board.length; i++) {
				if(-1 != possibleValues.indexOf(board[rowIndex][i])) {
					possibleValues.remove(possibleValues.indexOf(board[rowIndex][i]));
				}
			}
		}
		
		private void removeColumn(int [][] board, List<Integer> possibleValues, int columnIndex) {
			for (int i = 0; i < board.length; i++) {
				if(-1 != possibleValues.indexOf(board[i][columnIndex])) {
					possibleValues.remove(possibleValues.indexOf(board[i][columnIndex]));
				}
			}
		}
		
	}
	

}
