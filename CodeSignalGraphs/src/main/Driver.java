package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		System.out.println("************************************************************");
		System.out.println("******           Welcome to the Road System!           *****");
		System.out.println("************************************************************");
		RoadSystem RS = new RoadSystem();
		
		/*
		boolean [][] challenge1Test1 = {{false, true,  false, false},
		                      {false, false, true,  false},
		                      {true,  false, false, true },
		                      {false, false, true,  false}};
		
	
		
		
		RS.displayNewRoadSystem(challenge1Test1);


		boolean result = RS.newRoadSystem(challenge1Test1);
		
		
		System.out.println("It is " + result + " that this road system is good!");
		*/
		
		/*
		// Roads Building (Challenge 2 - Test Case 1) 
		int[][] C2T1  = {{0,1}, {1,2}, {2,0}};
		
		int[][] C2T3 = {{5,8}, 
		                {6,0}, 
		                {0,5}, 
		                {4,1}, 
		                {0,1}, 
		                {7,0}, 
		                {6,8}, 
		                {7,3}, 
		                {2,6}, 
		                {0,2}, 
		                {0,3}, 
		                {8,7}, 
		                {5,4}, 
		                {8,4}, 
		                {8,2}, 
		                {7,1}, 
		                {4,6}, 
		                {5,6}, 
		                {4,2}, 
		                {4,7}, 
		                {2,7}, 
		                {3,6}, 
		                {8,0}, 
		                {1,6}, 
		                {3,2}, 
		                {3,4}, 
		                {4,0},
		                {6,7}, 
		                {5,7}};
		
		Support.display2DArray(RS.roadsBuildingVSachin(9, C2T3));
		
		Support.display2DArray(RS.roadsBuilding(4, C2T1));
		*/
		
		
		// Challenge 3 - efficientRoadNetwork -> n == 6 -> Expected true
		
		/*
		int[][] C3T1 = {{3,0}, 
		                {0,4}, 
		                {5,0}, 
		                {2,1}, 
		                {1,4}, 
		                {2,3}, 
		                {5,2}};
		
		
		boolean result1 = RS.efficientRoadNetwork(6, C3T1);
		
		System.out.println("The result of test1 is: " + result1);
		*/
		
		/*
	    int [][] C3T2 = {{0,4}, 
	                     {5,0}, 
	                     {2,1}, 
	                     {1,4}, 
	                     {2,3}, 
	                     {5,2}};
	    
	    boolean result2 = RS.efficientRoadNetwork(6, C3T2);
	    System.out.println("The result of test2 is: " + result2);
	    */
		
		/*
	    int [][] C3T4 = {{0,1}, 
	                     {0,2}, 
	                     {3,4}};
	    
	    boolean result4 = RS.efficientRoadNetwork(5, C3T4);  // expected false 
	    System.out.println("The result of test4 is: " + result4);
	    */
	    
	    // number of cities -> n: 16 
		
		/*
	    int[][] C3T6 = {{7,12}, 
	                    {3,15}, 
	                    {0,7}, 
	                    {14,1}, 
	                    {15,6}, 
	                    {8,7}, 
	                    {3,4}, 
	                    {1,3}, 
	                    {15,2}, 
	                    {2,11}, 
	                    {1,8}, 
	                    {12,0}, 
	                    {7,4}, 
	                    {9,5}, 
	                    {11,10}, 
	                    {7,5}, 
	                    {6,11}, 
	                    {5,15}, 
	                    {1,12}, 
	                    {4,15}, 
	                    {6,4}, 
	                    {11,7}, 
	                    {4,8}, 
	                    {10,15}, 
	                    {1,7}, 
	                    {3,13}, 
	                    {15,7}, 
	                    {13,4}, 
	                    {13,6}, 
	                    {12,10}, 
	                    {1,13}, 
	                    {6,14}, 
	                    {4,0}, 
	                    {11,1}, 
	                    {13,15}, 
	                    {10,2}, 
	                    {6,9}, 
	                    {0,13}, 
	                    {8,6}, 
	                    {14,9}, 
	                    {13,5}, 
	                    {14,7}, 
	                    {13,9}, 
	                    {6,7}, 
	                    {9,10}, 
	                    {8,2}, 
	                    {12,8}, 
	                    {9,3}, 
	                    {11,15}, 
	                    {12,13},
	                    {2,0},
	                    {9,0},
	                    {3,8},
	                    {15,14},
	                    {1,9},
	                    {1,2},
	                    {3,12}};
	   
		
	   boolean result6 = RS.efficientRoadNetwork(16, C3T6);  // expected false 
	   System.out.println("The result of result6 is: " + result6);
	   
		*/
		/*
		int[][] C3T8 = {{1,0}, 
		 {0,2}, 
		 {2,4}, 
		 {3,0}, 
		 {5,6}, 
		 {5,4}, 
		 {5,0}, 
		 {0,4}, 
		 {5,2}}; // EXPECTED false 
		
		boolean result8 = RS.efficientRoadNetwork(7, C3T8);  // expected false 
		System.out.println("The result of C3T8 is: " + result8);
		*/
		
		/*
		boolean [][] C4T1 = {{false,true,true,false}, 
		                     {true,false,true,false}, 
		                     {true,true,false,true}, 
		                     {false,false,true,false}};
		
		boolean[][][] resultC4T1 = RS.financialCrisis(C4T1);
		*/
		
		
		/*
		int [][] C5T1 		= {{0,1,0}, 
		                       {4,1,2}, 
		                       {4,3,4}, 
		                       {2,3,1}, 
		                       {2,0,3}};
		
		int [][] C5T2  = {{2, 3, 1},
		         		  {3, 0, 0},
		         		  {2, 0, 2}};
		
		
		// This is truncated... it must work with big data...
		int [][] C5T23 = {{0,2,0}, 
		                  {1,3,1}, 
		                  {0,4,2}, 
		                  {1,5,3}, 
		                  {0,6,4}, 
		                  {1,7,5}, 
		                  {0,8,6}, 
		                  {1,9,7}, 
		                  {0,10,8}, 
		                  {1,11,9}, 
		                  {0,12,10}, 
		                  {1,13,11}, 
		                  {0,14,12}, 
		                  {1,15,13}, 
		                  {0,16,14}, 
		                  {1,17,15}, 
		                  {0,18,16}, 
		                  {1,19,17}, 
		                  {0,20,18}, 
		                  {1,21,19}, 
		                  {0,22,20}, 
		                  {1,23,21}, 
		                  {0,24,22}, 
		                  {1,25,23}, 
		                  {0,26,24}, 
		                  {1,27,25}, 
		                  {0,28,26}, 
		                  {1,29,27}, 
		                  {0,30,28}, 
		                  {1,31,29}, 
		                  {0,32,30}, 
		                  {1,33,31}, 
		                  {0,34,32}}; 
		*/
		
		
		/*
		boolean resultC5T1 = RS.namingRoads(C5T1);
		System.out.println("The result of C5T1 is: " + resultC5T1);
		*/
		
		/*
		boolean resultC5T2 = RS.namingRoads(C5T2);
		System.out.println("The result of C5T2 is: " + resultC5T2);
		*/
		
		

		
		/*
		boolean resultC5T23 = RS.namingRoads(C5T23);
		System.out.println("The result of C5T2 is: " + resultC5T23);
		*/
		
		/*
		boolean [][] C6T1 = {{false,true,true,false}, 
		                     {true,false,true,false}, 
		                     {true,true,false,true}, 
		                     {false,false,true,false}};
		
		boolean [][] resultC6T1 = RS.greatRenaming(C6T1);
		*/
		
		
		int[][] C7T1 = 		{{1,0}, 
		                     {1,2}, 
		                     {8,5}, 
		                     {9,7}, 
		                     {5,6}, 
		                     {5,4}, 
		                     {4,6}, 
		                     {6,7}};
		
		int [][] C7T3 = {{0,1}, 
		                 {1,2}, 
		                 {2,3}, 
		                 {3,4}, 
		                 {4,5}, 
		                 {5,0}};
		
		int [][] C7T11 = 
						 {{14,21}, 
		                  {16,20}, 
		                  {2,7}, 
		                  {24,19}, 
		                  {28,25}, 
		                  {26,2}, 
		                  {16,27}, 
		                  {4,12}, 
		                  {26,25}, 
		                  {22,10}, 
		                  {15,13}, 
		                  {18,13}, 
		                  {28,1}, 
		                  {19,17}, 
		                  {0,6}, 
		                  {11,28}};
		
		int [][] C7T13 = 
					{{11,12}, 
					 {6,15}, 
					 {8,21}, 
					 {6,16}, 
					 {2,4}, 
					 {3,0}, 
					 {9,11}, 
					 {18,28}, 
					 {23,1}, 
					 {27,10}, 
					 {3,4}, 
					 {14,2}, 
					 {3,11}, 
					 {19,13}, 
					 {5,20}, 
					 {9,25}, 
					 {16,25}, 
					 {3,2}, 
					 {14,28}};
		/*
		int[] resultC7T1 = RS.citiesConquering(10, C7T1);
		System.out.println(Arrays.toString(resultC7T1));
		*/
		/*
		int[] resultC7T3 = RS.citiesConquering(5, C7T3);
		System.out.println(Arrays.toString(resultC7T3));
		
		int[] resultC7T11 = RS.citiesConquering(29, C7T11);
		System.out.println(Arrays.toString(resultC7T11));
		
		
		int[] resultC7T13 = RS.citiesConquering(30, C7T13);
		System.out.println(Arrays.toString(resultC7T13));
		*/
		
		boolean [][] C8T1 = 
							{{false,true,true,false,false,false,true}, 
		                     {true,false,true,false,true,false,false}, 
		                     {true,true,false,true,false,false,true}, 
		                     {false,false,true,false,false,true,true}, 
		                     {false,true,false,false,false,false,false}, 
		                     {false,false,false,true,false,false,false}, 
		                     {true,false,true,true,false,false,false}};
		
		//boolean [][] resultC8T1 = RS.mergingCities(C8T1);
		boolean [][] solutionC8T1 = 
				
				
			{{false,true,true,false,true}, 
			 {true,false,false,true,true}, 
			 {true,false,false,false,false}, 
			 {false,true,false,false,false}, 
			 {true,true,false,false,false}};
		

		boolean [][] C8T9 = 
				
				{{false,true,true,false,true,true,true,false}, 
				 {true,false,false,false,true,false,false,false}, 
				 {true,false,false,true,false,true,true,true}, 
				 {false,false,true,false,true,false,false,false}, 
				 {true,true,false,true,false,true,false,false}, 
				 {true,false,true,false,true,false,false,false}, 
				 {true,false,true,false,false,false,false,false}, 
				 {false,false,true,false,false,false,false,false}};
		
		
		

				 
				 
				 
				 
		//System.out.println("Challenge 8 -> Test Case 9");
		//boolean [][] resultC8T1   = RS.mergingCities(C8T1);
		boolean [][] solutionC8T9  = 	
				
				{{false,true,true,true,false}, 
				 {true,false,true,true,true}, 
				 {true,true,false,false,false}, 
				 {true,true,false,false,false}, 
				 {false,true,false,false,false}};
		//System.out.println("Expected result has a width / height of: " + solutionC8T9.length);
		//System.out.println("***** Expected solutionC8T9 - is below **** \n");
		//RoadSystem.displayNewRoadSystem(solutionC8T9);
		
		
		System.out.println("Challenge 8 -> Test Case 12");
		
		boolean[][] C8T12 = 
							{{false,true,true,false,false,false,false}, 
		                     {true,false,false,false,true,false,true}, 
		                     {true,false,false,false,true,true,true}, 
		                     {false,false,false,false,true,true,true}, 
		                     {false,true,true,true,false,false,false}, 
		                     {false,false,true,true,false,false,true}, 
		                     {false,true,true,true,false,true,false}};
		
		boolean [][] resultC8T12   = RS.mergingCities(C8T12);
		
		
		boolean[][] C8T12solution  = 
							{{false,true,false,true,false,true}, 
							 {true,false,false,true,true,true}, 
							 {false,false,false,true,true,true}, 
							 {true,true,true,false,false,false}, 
							 {false,true,true,false,false,true}, 
							 {true,true,true,false,true,false}};
		
		System.out.println("\n C8T12 solution...");
		RoadSystem.displayNewRoadSystem(C8T12solution);
		
	// end of the main driver method 
	}
	
	

	
// end of the 
}
