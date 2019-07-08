/*
ID: omnimed1  
LANG: JAVA
TASK: transform 
*/


package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class transform {

	public static int [][] testArr0B = { {1, 2, 3, 9},
			  {4, 5, 6, 7},
			  {0, 4, 2, 6},
			  {3, 5, 6, 7}};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader f = new BufferedReader(new FileReader("D:/ECLIP/USACO/Transform/src/main/transform.in"));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/ECLIP/USACO/Transform/src/main/transform.out")));
		
		
		int [][] testArr0 = { {1, 2, 3, 9},
							  {4, 5, 6, 7},
							  {0, 4, 2, 6},
							  {3, 5, 6, 7}};
		
		boolean debug = false; 
		
		String max_rows = f.readLine();
		
		int n = Integer.parseInt(max_rows);
		
		char [][] board_original = new char[n][n];
		
		char [][] board_goal = new char[n][n];
		
		if ( debug) System.out.println("The maximum number of rows / columns is: " + n);
		
		extractData(board_original, board_goal, f);
		
		if ( debug ) System.out.println(" \n***** The Original Board is below *****  ");
		if ( debug ) display2DArray(board_original);
		if ( debug ) System.out.println(" \n***** The Goal Board is below *****  ");
		if ( debug ) display2DArray(board_goal);
		
		
		int result = checkTranforms(board_original, board_goal);
		
		if (debug) System.out.println("The result is: " + result );
		
		
		// Get line, break into tokens

		out.println(result);		
		// output result
		out.close();        							 // close the output file

	// end of the main method 
	}
	
	public static int checkTranforms(char[][] board, char[][]goal) {
		
		
		
		for (int i = 1; i <= 3; i++) {
			
			board = rotate90DegClockwise(board);
			
			if ( verify2DArraysIdentical(board, goal)) return i;
			
		}
		
		// reset the board back to 0 rotation...
		board = rotate90DegClockwise(board);
		
		reflect2DArrayHoriz(board);
		
		if ( verify2DArraysIdentical(board, goal)) return 4;
		
		
		for (int i = 1; i <= 3; i++) {
			
			// check to see if no change is necessary 
			
			board = rotate90DegClockwise(board);
			
			if ( verify2DArraysIdentical(board, goal)) return 5;
	
		}
		
		// reset the board back to 0 rotation...
		board = rotate90DegClockwise(board);
		reflect2DArrayHoriz(board);
		
		if ( verify2DArraysIdentical(board, goal)) return 6;
		
		
		// Invalid Transformation -> no pattern can be obtained by combination of reflection or rotation etc...
		return 7;
	}
	
	public static void extractData (char[][] board, char[][] goal, BufferedReader f ) throws IOException { 
		
		// extract data for the original board 
		for (int row = 0; row < board.length; row ++ ) {
			
			String line = f.readLine();
			
			for (int col = 0; col < line.length(); col++){
				
				board[row][col] = line.charAt(col);
			}
		}
		
		// extract data for the goal  board 
		for (int row = 0; row < goal.length; row ++ ) {
			
			String line = f.readLine();
			
			for (int col = 0; col < line.length(); col++){
				
				goal[row][col] = line.charAt(col);
			}
		}
		
	// end of the extractData function	
	}
	
	public static int[][] rotate90DegClockwise ( int[][] arr ) {
		
		// This function should rotate the integers of the input array (arr) 90 degrees clockwise
		// The goal is to do the rotation with N space -> So one duplicate array worth of space and a maximum of a single nested for loop
		// The for loop can have only one nested loop inside it
		// basically we want Time performance of O * n * n   and space performance of O(n * n)  [n * n meaning the number of rows * columns]
		
		int[][] modified = new int[arr.length][arr[0].length];
		
		boolean debug = false; 
		
		for (int row = 0; row < arr.length; row ++){
			
			for (int col = 0; col < arr[0].length; col++){
				
				modified[col][arr[0].length - row -1] = arr[row][col];
				
				// only do the live-time display of changes if the debug boolean is set to true...
				if ( debug) {
					try  {
						
						Thread.sleep(160);
						
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("***** ORIGINAL MATRIX*******");
						display2DArray(testArr0B);
						System.out.println("\n***** MODIFIED MATRIX*******");
						display2DArray(modified);
						
					} catch (Exception e) {
						
						System.out.println("There was an exception of: " + e);
					}
				}
			}
		}
		
		return modified;
	
	// end of the ninetyDegRotClockwise function
	}
	
	
	public static boolean verify2DArraysIdentical( char[][] a, char[][]b ) {
		
		// This function verifies returns true if all of their values are identical. 
		
		for (int row = 0; row < a.length; row++) {
			
			for (int col = 0; col < b.length; col++) {
				
				if ( a[row][col] != b[row][col]) return false; 
			}
		}
		
		return true; 
		
	// end of verify2DArraysIdentical 
	}
	
	

	public static char[][] rotate90DegClockwise ( char[][] arr ) {
		
		// This function should rotate the integers of the input array (arr) 90 degrees clockwise
		// The goal is to do the rotation with N space -> So one duplicate array worth of space and a maximum of a single nested for loop
		// The for loop can have only one nested loop inside it
		// basically we want Time performance of O * n * n   and space performance of O(n * n)  [n * n meaning the number of rows * columns]
		
		char[][] modified = new char[arr.length][arr[0].length];
		
		boolean debug = false; 
		
		
		for (int row = 0; row < arr.length; row ++){
			
			for (int col = 0; col < arr[0].length; col++){
				
				
				modified[col][arr[0].length - row -1] = arr[row][col];
				
				// only do the live-time display of changes if the debug boolean is set to true...
				if ( debug) {
					try  {
						
						Thread.sleep(160);
						
						
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						System.out.println("***** ORIGINAL MATRIX*******");
						display2DArray(testArr0B);
						System.out.println("\n***** MODIFIED MATRIX*******");
						display2DArray(modified);
						
					} catch (Exception e) {
						
						System.out.println("There was an exception of: " + e);
					}
				}
			}
		}
		
		return modified;
	
	// end of the ninetyDegRotClockwise function
	}
	
	
	public static void reflect2DArrayHoriz( char [][] arr ){
		
		for (int row = 0; row < arr.length; row ++ ) {
			
		
		   for (int col = 0; col < arr.length / 2; col++){
	            
	            char orig = arr[row][col];
	            char swap = arr[row][arr[row].length - 1- col];
	            

	            arr[row][col] = swap;
	            arr[row][arr[row].length - 1 - col] = orig;
	  
		      } 
		}
		
		
	// end of the reflex2DArrayHoriz function 	
	}
	
	
	
	public static void display2DArray(int[][] arr) {
	  
	  for (int row = 0; row < arr.length; row ++ ){
		  
		  System.out.print("\n[ ");
			
			for (int i = 0; i < arr[0].length; i++) {
				if (i == arr[0].length - 1) {
					System.out.print(arr[row][i]);
				} else {
					System.out.print(arr[row][i] + ", ");
				}
			}
			System.out.print(" ]");
	  }	
	  System.out.println("");
	// end of the display2Darray  
	}
	
	
	public static void display2DArray(char[][] arr) {
		  
		  for (int row = 0; row < arr.length; row ++ ){
			  
			  System.out.print("\n[ ");
				
				for (int i = 0; i < arr[0].length; i++) {
					if (i == arr[0].length - 1) {
						System.out.print(arr[row][i]);
					} else {
						System.out.print(arr[row][i] + ", ");
					}
				}
				System.out.print(" ]");
		  }	
		  System.out.println("");
		// end of the display2Darray  
		}
	
	
// end of the transform class 
}
