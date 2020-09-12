package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RoadSystem {
	


	// C1 Codesignal
	boolean newRoadSystem(boolean[][] roadRegister) {
		
		// columns is where they receive roads
		// rows are where they give roads
		
		for (int i = 0; i < roadRegister.length; i++) {
			//City cityA = new City(i, roadRegister );
			
			if ( !scan(roadRegister, i)) return false;
		}
		
		return true;
	}
	
	
	boolean isNearTarget(City3 city, int searchId) {
		
		return city.nearby.contains(searchId);

	// end of the isNearTarget method
	}
	int plustorial(int n) {
	    if (n <= 1) {
	        return n;
	    }
	    return n + plustorial(n - 1);
	}


	// C2
	int[][] roadsBuilding(int cities, int[][] roads) {
		
		boolean debug = false; 
		// create a new 2D array based on the length of the cities
		int[][] arr = new int[cities][cities];
		
		if ( debug) System.out.println("Not Filled Yet... Array....");
		displayRoadsBuilding(arr);
		
		fillRoadSystem(arr, roads);
		if ( debug)System.out.println("...Filled with initial information....");
		displayRoadsBuilding(arr);
		
		int outputRL = determineOutputRSLength(cities, roads.length);
		
		if ( debug) System.out.println("\nWe will need to build " + outputRL + " roads.");
		
		int[][] result = new int[outputRL][2];
		
		fillResult(arr, result);
		
		return result;
		
	// end of the roadsBuilding function 
	}
	
	// C3 
	boolean efficientRoadNetwork(int n, int[][] roads) {
		boolean debug = true; 
		
		if (debug) System.out.println("****** Challenge 3 -> efficientRoadNetwork **** ");
		// create a new 2D array based on the length of the cities
		int[][] arr = new int[n][n];
		
		
		fillRoadSystem(arr, roads);
		
		if (debug )displayRoadsBuilding(arr);
		
		ArrayList<City3> cities = new ArrayList<City3>();
		
		for (int i = 0; i < n; i++) {
			City3 testCity = new City3(arr, i);
			cities.add(testCity);	
		}
		
		
		if (debug) System.out.println("Here are our cities for Challenge 3 so far....\n");
		
		// looping through each city 
		for (int i = 0; i < n; i++) {
		
			City3 city = cities.get(i);
			
			// looping through each city again that it should be connected to within 2 units 
			for (int j = 0; j < cities.size(); j++) {
				if (debug) System.out.printf("\nChecking if CITY ID#: %s is within two units of CITY ID#: %s. \n", i, j );
				if ( i == j ) {
					if (debug) System.out.println("I don't need to check the river...continuing on...");
					continue;	
				}
				
				boolean withinOne = isNearTarget(city, j);
				
				if ( withinOne) {
					if (debug) System.out.printf("\nCITY ID#: %s is one unit away from  %s. ", i,  j );
					continue;
				}
				
				
				if (debug) System.out.printf("\nCITY ID#: %s is NOT one unit away from CITD ID #: %s. ", i, j );
				if (debug) System.out.println("\nI'm CITY ID#: " + i + " and these are my connections: " + city.nearby);
				
				boolean hasSecondaryConnection = false;
				
				for (int index = 0; index < city.nearby.size(); index++) {
					
					City3 secondaryCity = cities.get(city.nearby.get(index));
					
					if (debug) System.out.println("This is one of my connections...CITY ID#: " + secondaryCity.cityId);
					
					boolean withinTwo = isNearTarget(secondaryCity, j);
					
					if ( withinTwo) {
						
						if (debug) System.out.printf("\n*** SUCCESS *** - CITY ID#: %s IS exactly TWO units away from CITY ID #: %s. \n", i, j );
						
						hasSecondaryConnection = true; 
						
					}
					
				}
				
				if (!hasSecondaryConnection) return false;
				
			}
			
		}
		// by default return true if I can make it through the sieve
		return true;

	// end of the efficientRoadNetwork
	}
	
	// C4 
	boolean[][][] financialCrisis(boolean[][] roadRegister) {
		
		boolean debug = true; 
		
		if ( debug ) {
			System.out.println("*** Challenge 4 ! Financial Crisis! ***");
			
			System.out.println("\n\n*** Original Road Register ***");
			displayNewRoadSystem(roadRegister);
		}
		
		int RL = roadRegister.length; 
		int L  = RL - 1; 
		
		// TODO 
		boolean [][][] result = new boolean[RL][L][L];
		
		for (int i = 0; i < RL; i++) {
			
			boolean [][] crafted = craftDestroyedRegister(roadRegister, i);
			result[i] = crafted;
			
			if (debug) displayNewRoadSystem(crafted);
			
		}
		
		return result; 
	}
	
	// C6 
	boolean[][] greatRenaming(boolean[][] roadRegister) {
		
		boolean[][] C6T1SOLUTION = {{false,false,false,true}, 
		                            {false,false,true,true}, 
		                            {false,true,false,true}, 
		                            {true,true,true,false}};

		boolean debug = true;
		
		int H = roadRegister.length; 
		int W = roadRegister[0].length;
		
		if ( debug) {
			System.out.println("\n ORIGINAL ROADREGISTER");
			displayNewRoadSystem(roadRegister);
		} 
		
		boolean [][] result = new boolean[H][W];
		
		boolean [] lastRow = new boolean[W];
		
		// Reserve the last row 
		for (int i = 0; i < W; i++) lastRow[i] = roadRegister[H-1][i];
		
		if (debug) {
			System.out.println("\n Displaying Final row.... ");
			for (int i = 0; i < lastRow.length; i++) {
				
				int val = lastRow[i] ? 1: 0;
				if ( i == 0) {
					System.out.print("\n [ " + val + ", ");
				} 
				else if ( i < W - 1) {
					System.out.print(  val + ", ");
				} else {
					System.out.print(  val + " ] \n ");
				}
			}
		}
		
		
		if ( debug ) System.out.println("\nBegin Parsing Sequence...");
		
		for (int r = 0; r < H - 1; r++) {
			
			boolean preserve = roadRegister[r][W - 1];
			for (int c = 0; c < W - 1; c++) {
				
				boolean origVal = roadRegister[r][c];
				
				if ( r == c) {
					continue; 
				}
				result[r + 1][c + 1] = origVal; 
			}
			result[r + 1][0] = preserve;
		}
		
		boolean preserve = roadRegister[H - 1][W - 1];
		for (int c = 0; c < W - 1; c++) {
			
			boolean origVal = roadRegister[H - 1][c];
			
			if ( W - 1 == c) {
				continue; 
			}
			result[0][c + 1] = origVal; 
		}
		result[0][0] = preserve; 
		
		
		
		if ( debug ) {
			System.out.println("\n Result so far .... ");
			displayNewRoadSystem(result);
			System.out.println("\n EXPECTED OUTPUT .... ");
			displayNewRoadSystem(C6T1SOLUTION);
		}
		
		return result; 
		
	}
	
	// C7 - Challenge 7 Cities Conquering
	int[] citiesConquering(int n, int[][] roads) {
		
		boolean debug = true; 
		
		if ( debug ) {
			System.out.println("\n************************************************************");
			System.out.println("******      Codesignal Challenges - Graph Theory       *****");
			System.out.println("******      Challenge #7   -   Cities Conquering       *****");
			System.out.println("************************************************************");
			System.out.println("******              $$$  Core Concepts $$$             *****");
			System.out.println("************************************************************");
			System.out.println("******      Single Cities and cities....               *****");
			System.out.println("******      with only one connection pop in one day    *****");
			System.out.println("************************************************************");
			System.out.println("******      Potential support data structures...       *****");
			System.out.println("******      2D array to track system changes...        *****");
			System.out.println("******      HashSet for finding destroyed cities       *****");
			System.out.println("******      That could save time for searching.        *****");
			System.out.println("************************************************************\n");
		}
		
		int L = n; 
		int[] result = new int[L];
		int[][] grid = new int[L][L];
		
		/*
		for (int r = 0; r < roads.length; r++) {
			
			int cityA = roads[r][0];
			int cityB = roads[r][1];
			
			//if ( debug ) System.out.printf("\nCity %s: has a road going to City %s  ", cityA, cityB);
			grid[cityA][cityB] = 1;
			grid[cityB][cityA] = 1;
			
		}
		*/
		
		
		for (int i = 0; i < roads.length; i++) {
			grid[roads[i][0]][roads[i][1]] = 1;
			grid[roads[i][1]][roads[i][0]] = 1;
	    }

		
		HashSet<Integer>destroyed = new HashSet<Integer>();
		cityC7Supp(1, result, grid, destroyed );
		
		return result; 
		
	}
	
	void cityC7Supp(int day, int[] result, int[][] roads, HashSet<Integer> destroyed) {
		
		boolean debug = true; 
		int L = roads.length; 
		
		if ( debug ) {
			System.out.println("***** BEGIN DAY " + day + " ******* ");
			System.out.println("**** DESTRYOED CITIES :( -> " + destroyed);
			displayRoadsIntsVC(roads);
		}


		int destroyedToday = 0; 
		
		for (int r = 0; r < L; r++) {
			if ( destroyed.contains(r)) continue; 
			
			int connections = 0; 
			
			// begin inner loop 
			for (int c = 0; c < L; c++) {
				
				if ( destroyed.contains(c)) continue; 
				// val represents a 1 or a 0 in the matrix 
				int val = roads[r][c]; 
				connections += val; 	
			}
			
			if (connections <= 1) {
				if ( debug) System.out.println("City " + r + " was destroyed... OOF!");
				
				result[r] = day;
				destroyedToday++; 
			}
		
		// end of the outer loop 
		}
		
		
		if ( destroyedToday == 0) {
			for (int i = 0; i < result.length; i++) {
				if ( !destroyed.contains(i)) {
					result[i] = -1; 
				}
			}
		} else {
			
			for (int d = 0; d < L; d++) {
				int foundDays = result[d];
				
				if ( foundDays == day) {
					
					destroyed.add(d);
					
					for (int i = 0; i < L; i++) {
						roads[d][i] = 0; 
						roads[i][d] = 0; 
					}
				}
			}

			cityC7Supp(day + 1, result, roads, destroyed);
		}
	
	// end of the cityC7Support method... 
	}
	
	
	// C8 -> Challenge 8  Merging Cities... 
	boolean[][] mergingCities(boolean[][] roadRegister) {
		
		int L = roadRegister.length; 
		
		System.out.println("The original system has a length of: " + L);
		System.out.println("Original System..... ");
		displayNewRoadSystem(roadRegister);

		
		
	
		List<Integer> tags = new ArrayList<Integer>();
	    for (int i = 0; i < roadRegister.length - 1; i += 2) {
	        if (roadRegister[i][i+1] == true ) {
	            tags.add(i);
	            tags.add(i+1);
	        }
	    }

		
		
		int S = tags.size() / 2; 
		
		
		boolean [][] result = new boolean[S][S];
		
		System.out.println("The tags are: " + tags);
		
		return result; 
		
		
	// end of mergingCities 
	}
	
	void squishRow(boolean[][] arr, int a, int b) {
		//for (int r = 0; r < arr.length; r++)
		
	}

	int determineOutputRSLength(int cities, int roadLength) {

		int TS = cities * cities;
		int C = cities; 
		int IAL = roadLength; 
		return ((TS - C) / 2) - IAL;
		
	// end of the determineOutputRSLength method 
	}
	
	void fillResult(int[][]arr, int[][]result) {
		
		// go through all the elements past the river of the arr
		// and if there is a 0 ... populate the result at the appropriate row column combination
		// with a 1 
		
		int W = arr[0].length; 
		int H = W; 
		
		int counter = 0;
		for (int c = 0; c < W; c++) {
			
			for (int r = c + 1; r < H; r++) {
				
				int val = arr[r][c];
				
				if ( val == 0) {
					result[counter][0] = c;
					result[counter][1] = r;
					counter++;
				}
			}
		}
	//	
	}
	
	// Challenge 2 
	void fillRoadSystem(int[][] arr, int[][] roads) {
		// fill the 2D array with road connections based on the testCase
		for (int i = 0; i < roads.length; i++) {
			
			// store temp variables for the row and column information
			// for already created roads 
			// EG -> roads[i] -> [1, 2]  -> row: 1, col: 2
			int r = roads[i][0];
			int c = roads[i][1];
			
			// use the row and column to place a road! of a [11]
			arr[r][c] = 1;
			// and the inverse :D
			arr[c][r] = 1;
				
		// end of the loop 	
		}
		
	// end of the fillRoadSystem method 
	}
	
	
	// Challenge # 5 Codesignal -> 
	boolean namingRoads(int[][] roads) {
		
		
		
		boolean debug = true; 
		
		// single city to all its edges
		HashMap<Integer, HashSet<Integer>> cityToEdge = new HashMap<Integer, HashSet<Integer>>();
		
		for (int i = 0; i < roads.length; i++) {
			
			int cityA = roads[i][0];
			int cityB = roads[i][1];
			int edge  = roads[i][2];
			
			if ( cityToEdge.containsKey(cityA)) {
				cityToEdge.get(cityA).add(edge);
			} else {
				HashSet<Integer> set = new HashSet<Integer>(); 
				set.add(edge);
				cityToEdge.put(cityA, set);
			}
			

			if ( cityToEdge.containsKey(cityB)) {
				cityToEdge.get(cityB).add(edge);
			} else {
				HashSet<Integer> set = new HashSet<Integer>(); 
				set.add(edge);
				cityToEdge.put(cityB, set);
			}
		}
		
		
		
		for (Integer key : cityToEdge.keySet()) {
			System.out.println("The key of " + key + " has edges " + cityToEdge.get(key));
			
			/*  list         arrayList          keySet
			 * 
			 * String        String             char [] 
			 */
			
			List<Integer> list = new ArrayList<Integer>(cityToEdge.get(key)); 
	        Collections.sort(list); 
	        
	        System.out.println("THE LIST IS: " + list);
	        
	        for (int i = 0; i < list.size() - 1; i++) {
	        	int left = list.get(i);
	        	int right = list.get(i + 1);
	        	
	        	if ( right - left == 1) return false; 
	        }
	       
		}
		
		
		return true;
	}
	
	// unused challenge5 code 
	int[][] fillSystem (int[][] roads ) {
		
		boolean debug = true; 
		
		int L = roads.length; 
		
		int max = 0;
		
		for (int i = 0; i < L; i++) {
			
			int edgeFound = roads[i][2];
			int cityA = roads[i][0];
			int cityB = roads[i][1];
			
			if ( cityA > max) max = cityA; 
			if ( cityB > max) max = cityB; 
			
			//if ( debug ) System.out.printf("\nCity %s: has a road going to City %s Edge named: %s ", cityA, cityB, edgeFound);
			
		}
		
		max++;
		int[][] system = new int[max][max];
		
		// for setting it full of -1's for each spot for the negative space and the river
		for (int r = 0; r < max; r++) {
			
			for (int c = 0; c < max; c++) {
				
				system[r][c] = -1;
			}
		}
		
		
		for (int i = 0; i < L; i++) {
			
			int edgeFound = roads[i][2];
			int cityA = roads[i][0];
			int cityB = roads[i][1];
			if ( debug ) System.out.printf("\nCity %s: has a road going to City %s Edge named: %s ", cityA, cityB, edgeFound);
			
			system[cityA][cityB] = edgeFound; 
			system[cityB][cityA] = edgeFound; 
		
		}
		
		
		return system;
		
		
	}
	

	
	
	// Challenge # 1 Codesignal -> without Support Class 
	boolean scan(boolean arr[][], int index) {
		
		int out = 0;
		int in  = 0;
		
		// use the horizontal rows for checking outgoing. 
		for (int i = 0; i < arr.length; i++) {
			boolean valOut = arr[index][i];
			boolean valIn  = arr[i][index];
			
			if ( valOut) out++;
			if ( valIn ) in++;
	
		// end of the for loop 	
		}
		
		
		if ( out != in) {
			
			System.out.println("\nThis road has a problem!");
			return false;
		} else {
			System.out.println("\n What great road!");
			return true;
		}
		
	// end of the scanOutgoing method	
	}
	
	
	
	// C4 - Supplemental
	boolean [][] craftDestroyedRegister(boolean[][] R, int city) {
		
		int RL = R.length; 
		int L  = RL - 1; 
		
		boolean debug = false;
		
		if ( debug) {
			System.out.println("\nThe length / width of road register is: " + RL);
			System.out.println("The length / width of the crafted register is: " + L);
			System.out.println("I'm trying to remove city: " + city);
		}

		
		// where I look at the original arra
		int rowPlacer = 0; 
		int colCounter = 0;
		
		// just remove a row! not the column
		
		boolean [][] craft = new boolean[L][L];
		for (int i = 0; i < RL; i++) {
			
			colCounter = 0;
			
			if ( i == city) {
				//rowPlacer++;
				continue;
			}
		
			for (int j = 0; j < RL; j++) {
				
				if ( j == city) continue;
			
				// the value at the row column in the original	
				boolean RR_val = R[i][j];
				
				if ( debug) {
					System.out.printf("\nORIG-> [R: %s C: %s] -> val: %s ", i, j, RR_val);
					System.out.printf("\nCRFT-> [R: %s C: %s] -> val: %s ", rowPlacer, colCounter, RR_val);
				}
				craft[rowPlacer][colCounter] = RR_val;

				colCounter++;
			}
			
			// increase the row counter 
			rowPlacer++;		
		}
		
		return craft;
	}
	
	// Display Method for 2D arrays of Ints -> Graph Theory problems 
	void displayRoadsIntsVC(int[][] arr) {
		System.out.println("***** Displaying the Roads! *******\n\n");
		int W = arr[0].length; 
		int H = arr.length;
		
		String header = "[**]-";
		for (int i = 0; i < W; i++) {
			if ( i < 10) {
				header += "[0" + i +"]";
			} else {
				header += "[" + i +"]";
			}
		}
		
		System.out.println(header);
		for (int r = 0; r < H; r++) {
			
			String line = "";
			// MARGIN for the column
			if ( r < 10) {
				line += "[0" + r +"]-";
			} else {
				line += "[" + r +"]-";
			}
			// data for the column
			for (int c = 0; c < W; c++) {
				
				int val = arr[r][c];
				
				// convert 1's and zeroes to [11] or [00] accordingly 
				if ( val == 0) {
					line += "[  "  + "]";
				} else {
					line += "[ " + val + "]";
				} 
				
			}
			System.out.println(line);
		}
		
	// end of the displayRoadsBuilding method 
	}
	
	
	
	// Display Method for 2D arrays of Ints -> Graph Theory problems 
	void displayRoadsInts(int[][] arr) {
		System.out.println("***** Displaying the Roads! *******\n\n");
		int W = arr[0].length; 
		int H = arr.length;
		
		String header = "[**]-";
		for (int i = 0; i < W; i++) {
			if ( i < 10) {
				header += "[0" + i +"]";
			} else {
				header += "[" + i +"]";
			}
		}
		
		System.out.println(header);
		for (int r = 0; r < H; r++) {
			
			String line = "";
			// MARGIN for the column
			if ( r < 10) {
				line += "[0" + r +"]-";
			} else {
				line += "[" + r +"]-";
			}
			// data for the column
			for (int c = 0; c < W; c++) {
				
				int val = arr[r][c];
				
				// convert 1's and zeroes to [11] or [00] accordingly 
				if ( val < 0 || val >= 10) {
					line += "[" + val + "]";
				} else {
					line += "[ " + val + "]";
				} 
				
			}
			System.out.println(line);
		}
		
	// end of the displayRoadsBuilding method 
	}
	
	
	
	void displayRoadsBuilding(int[][] arr) {
		System.out.println("***** Displaying the Roads! *******\n\n");
		int W = arr[0].length; 
		int H = arr.length;
		
		String header = "[**]-";
		for (int i = 0; i < W; i++) {
			if ( i < 10) {
				header += "[0" + i +"]";
			} else {
				header += "[" + i +"]";
			}
		}
		
		System.out.println(header);
		for (int r = 0; r < H; r++) {
			
			String line = "";
			// MARGIN for the column
			if ( r < 10) {
				line += "[0" + r +"]-";
			} else {
				line += "[" + r +"]-";
			}
			// data for the column
			for (int c = 0; c < W; c++) {
				
				int val = arr[r][c];
				
				// convert 1's and zeroes to [11] or [00] accordingly 
				line += (val == 1)?  "[11]" : "[00]";
			}
			System.out.println(line);
		}
		
	// end of the displayRoadsBuilding method 
	}
	
	// Challenge 1 Codesignal Display Method
	static void displayNewRoadSystem(boolean [][] arr) {
		
		System.out.println("***** Displaying the Kingdom! *******\n\n");
		
		int W = arr[0].length; 
		int H = arr.length; 
		
		String header  = "[**]-";
		String header2 = " ||  ";
		for (int i = 0; i < W; i++) {
			header2 += " || ";
			if ( i < 10) {
				header  += "[0" + i +"]";
				
			} else {
				header += "[" + i +"]";
			}
		}
		
		System.out.println(header);
		System.out.println(header2);
		for (int r = 0; r < H; r++) {
			
			String line = "";
			// MARGIN for the column
			if ( r < 10) {
				line += "[0" + r +"]-";
			} else {
				line += "[" + r +"]-";
			}
			// data for the column
			for (int c = 0; c < W; c++) {
				
				boolean val = arr[r][c];
				line += val ? "[11]" : "[  ]";
			}
			System.out.println(line);
		}
	
	// end of the display method 
	}

// end of the Road System class 
}


// this is for non-public classes that are within the same file as RoadSystem 
// USED IN CHALLENGE: {3}
class City3 {
	

	
	ArrayList<Integer> nearby = new ArrayList<Integer>();
	int cityId;
	
	public City3(int[][] roads, int id) {
		
		this.cityId = id; 
		this.scanRoads(roads);
		
	}
	
	void scanRoads(int[][] roads) {
		
		int[] targetRow = roads[this.cityId];
		int L = targetRow.length;
		
		for (int i = 0; i < L; i++) {
			
			int val = targetRow[i];
			
			if ( val == 1) {
				this.nearby.add(i);
			}			
		}
	}
	
	@Override
	public String toString(){
		
		String output = "\n";
		output += "** CITY ID: " + this.cityId;
		output += "\n******** CONNECTIONS 1 UNIT AWAY *****\n";
		
		for (int i = 0; i < this.nearby.size(); i++) {
			output += "ME: " + this.cityId + " -> " + this.nearby.get(i) + "\n";
		}
		
		output += "**** End of connections display for CITY ID: " + this.cityId + " ******\n";
		return output;
				 
	}
	
	
// end of the City3 	
}





// challenge #5 
class City5 {
	
	int index;
	
	HashSet<Integer> nearbyEdges = new HashSet<Integer>();
	
	public City5 (int index) {
		this.index = index; 
	}
	
	public void addEdge(int edge) {
		this.nearbyEdges.add(edge);
	}
	
	public boolean cleanEdges() {
		
		int[] sortedEdges = new int[this.nearbyEdges.size()];
		
		Arrays.sort(sortedEdges);
		
		for (int i = 0; i < sortedEdges.length - 1; i++) {
			
			int left = sortedEdges[i];
			int right = sortedEdges[i + 1];
			if ( right - left == 1) return false; 
		}
		
		return true; 
		
	}
	
	
}

// Challenge # 1 City 
class City {
	
	int index, in, out;
	
	boolean happyRoad;
	
	public City(int index, boolean [][]arr ) {
		
		this.index = index;
		
		this.scan(arr);
	
	// end of the City constructor
	}
	


	
	void scan(boolean arr[][]) {
		
		// use the horizontal rows for checking outgoing. 
		for (int i = 0; i < arr.length; i++) {
			boolean valOut = arr[this.index][i];
			boolean valIn  = arr[i][this.index];
			
			if ( valOut) this.out++;
			if ( valIn ) this.in++;
	
		// end of the for loop 	
		}
		
		
		if ( this.out != this.in) {
			
			System.out.println("\nThis road has a problem!");
			this.happyRoad = false;
		} else {
			System.out.println("\n What great road!");
			this.happyRoad = true;
		}
		
	// end of the scanOutgoing method	
	}
	

	
	@Override
	public String toString() {
		return "CITY: INDEX" + this.index + 
				"\nOUTGOING: " + this.out +"\n" + 
				"INCOMING: " + this.in +"\n";
	}
	
// end of the City class 
}

