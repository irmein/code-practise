package com.code.practise.questions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuSolution1 {

	public static void main(String[] args) {
		SudokuSolution1 solution = new SudokuSolution1();
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
			Map<Integer, List<Integer>> rows = new HashMap<Integer, List<Integer>>();
			Map<Integer, List<Integer>> columns = new HashMap<Integer, List<Integer>>();
			
			List<Integer> possibleValues = new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9})); 
			
			process(board, rows, true);
			process(board, columns, false);
			
			possibleValues.removeAll(rows.get(i));
			possibleValues.removeAll(columns.get(j));
			return possibleValues.toArray(new Integer[] {});
		}
		
	}
	
	public void process(int [][] board, Map<Integer, List<Integer>> map, boolean isRow)  {
		List<Integer> values = null;
		for (int k = 0; k < board.length; k++) {
			for (int k2 = 0; k2 < board[k].length; k2++) {
				Integer key = isRow ? k : k2 ;
				if(map.containsKey(key)) {
					values = map.get(key);
				} else {
					values = new ArrayList<Integer>();
					map.put(key, values);
				}
				values.add(board[k][k2]);
			}
		}
	}

}
