/*
ID: overidon
LANG: JAVA
TASK: barn1
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Arrays;

public class barn1 {
	
	/*
	 * 						******** DESGIN DOCUMENT *******
	 * 
	 *  STORY: ------->  The cows are in a barn....specifically in NUMBERED STALLS. 
	 *  			 	 There was a storm and and the roof was torn off. 
	 *  
	 *  IMPERATIVE --->  1. All cows MUST be covered by a new roof made of BOARD NODES. 
	 *  
	 *  				 2. There is a limited number of BOARD NODES available for purchase... specifically M number of boards available. 
	 *  
	 *  				 2.A. Just because there are -> M <- number of boards available for purchase...we don't have to buy them all. 
	 *  				 2.B. Just buy what you need. 
	 *  
	 *   				 3.A. The cost of each board node is based on its length. 
	 *   				 3.B. The length of each board node is determined by the amount of stalls that it covers....
	 *   					  ... (Whether that stall has a cow in it or not) 
	 *   
	 *   
	 *  GOAL --------->  Determine the minimum LENGTH / COST of the boards that will cover all the cows. 
	 *  
	 *  
	 *  INPUTS ------->  ****** LINE 1 of the INPUT contains the inputs of M ... S .... C   *******
	 *  				 ****** LINE 1 has 3 total data points 								*******
	 *  
	 *  				 M -> Maximum number of potential BOARD NODES for purchase 
	 *  				 RANGE ....      1 <= M <= 50 
	 *  
	 *  				 S -> Total number of STALLS 
	 *  		         RANGE ....      1 <= S <= 200
	 *  				 
	 * 					 C -> Total number of COWS (All of these must be covered...)
	 * 					 RANGE ....      1 <= C <= S     
	 * 				     (The total number of cows has an upper limit that matches the total number of stalls).
	 * 					 (This makes sense because there can't be more cows in the stalls than there were stalls before the storm.)
	 * 
	 * 					 						
	 * 					*****  LINE 2 and BEYOND contain a single data point each ****
	 * 					*****  Each data point represents the STALL NUMBER of a COW
	 * 
	 * 
	 *  IDEAS --------> ***** Ideas are ways to appreciate the question and may not necessarily help solve ******
	 *  				***** These are basically mini-experiments which should be able to done quickly    ******
	 *  				
	 *  				Since each NODE could potentially cover 1 or more Stalls
	 *  				Let's understand the system more by identifying the number of stall subgroups
	 *  				These subgroups can have a few properties including
	 *  				Let's make this a Java object called -> Group 
	 *  				
	 *  				1. .start -> Integer  (Where does the group start)?
	 *  				2. .end   -> Integer  (Where does the group end)? 
	 *  				3. .length -> Integer (How many consecutive COWS are in this group)? 
	 *  
	 *  				** SPECIAL RULE ** A GROUP CANNOT have any empty spaces or unoccupied stalls within its length! 
	 *  
	 * 
	 */

	// start main driver method 
	public static void main(String[] args) throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

		// input file name goes above
	    //BufferedReader f = new BufferedReader(new FileReader("D:/ECLIP/USACO/barn1/src/main/barn1.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/ECLIP/USACO/barn1/src/main/barn1.out")));
		
        
		
		StringTokenizer first = new StringTokenizer(f.readLine());
		
		boolean debug = false; 
		
		int maxNodes = Integer.parseInt(first.nextToken());
		int totalStalls = Integer.parseInt(first.nextToken());
		int totalCows = Integer.parseInt(first.nextToken());
		
		
		if ( debug ) {
			System.out.println("The maximum number of potential Nodes is: " + maxNodes);
			System.out.println("The total number of stalls are: " + totalStalls);
			System.out.println("The total number of cows are: " + totalCows + " \n");
		}
		
		
		// This is an ArrayList that stores the groups 
		ArrayList<Group> groups = new ArrayList<Group>();
		
		// make an integer for the target stall 
		int start = -1; 
		int end = -1; 

		int[] stalls = new int[totalCows];
		
		// begin the for loop to populate the groups list 
		for (int i = 0; i < totalCows; i++) {
			
			int stall = Integer.parseInt(f.readLine());
			
			stalls[i] = stall;
			
		}
		
		Arrays.sort(stalls);
		
		for (int i = 0; i < totalCows; i++) {
			
			int stall = stalls[i];

			// the first stall MUST be the first target. 
			if ( i == 0 ) {
				start = stall;
				end = stall; 	
			} 
			
			else if ( i == totalCows - 1) {
				
				if ( stall - end > 1) {

					// there must be a new group 
					Group group_0x = new Group(start, end);
					groups.add(group_0x);
					
					start = stall; 
					end = stall; 
					
					
					Group group_1x = new Group(start, end);
					groups.add(group_1x);
					
					start = stall; 
					end = stall; 

				} else {

					end = stall;
					
					Group group_0x = new Group(start, end);
					groups.add(group_0x);
				}
			}
			
			else {

				if ( stall - end > 1) {
					
					// there must be a new group 
		
					Group group_0x = new Group(start, end);
					groups.add(group_0x);
					
					start = stall; 
					end = stall; 

				} else {
					
					end = stall;
				}
			}
		// end of the for loop for making Group objects 	
		}
		

		if ( debug ) System.out.println(groups);
		if ( debug ) System.out.println("\n The total number of groups is: " + groups.size() + " and the maximum number of nodes is: " + maxNodes);
		

		Tree tree = new Tree( groups, maxNodes);
		
		if ( debug) System.out.println("\n \n ******** The minimum cost is: " + tree.min);
		
		out.println(tree.min);
		
		out.close();
		
	// end of the main driver method... 
	}
	
	
// end of the barn1 class 
}

// start of the tree class.... -> This will handle permutations and will help find the shortest length of nodes to purchase 
class Tree {
	
	// it does not need a clean copy of groups since the Tree so far will not be changing the groups. 
	public ArrayList<Group> groups; 
	
	public LinkedList<Group> gPerm = new LinkedList<Group>(); 
	
	public int min; 
	public int maxNodes;
	
	public int minDist = -1;

	public boolean debug = false; 
	
	public int minDistStart = -1; 
	public int minDistEnd = -1; 
	
	public Tree ( ArrayList<Group> groups, int maxNodes) {
		

		this.groups = groups; 
		this.maxNodes = maxNodes; 
		
		this.cleanCopyGroups();
		this.findMinimumDistanceBetweenGroups();

		if ( this.debug ) System.out.println("The number of nodes is: " + gPerm.size() );
		
		
		this.determineLength();

		mergeGroups();
		
		this.determineLength();
		
	// end of the Tree constructor 	
	}
	
	public void mergeGroups() {
		
		if ( this.debug) System.out.println("THE MAX number of nodes is: " + this.maxNodes);

		while (this.gPerm.size() > this.maxNodes ) {
			
			if ( debug )System.out.println("\nShowing the groups before a merge.... " + this.gPerm);
			
			Group merger = new Group( this.gPerm.get(this.minDistStart).start, this.gPerm.get(this.minDistEnd).end);
			
			if ( debug )System.out.println("\nMERGER IS: " + merger);
			
			this.gPerm.remove(this.minDistStart);
			this.gPerm.remove(this.minDistStart);
			
			
			if ( debug ) System.out.println("\nTHE DATA SO FAR!!! \n");
			
			this.gPerm.add(this.minDistStart, merger);
			
			if ( debug ) System.out.println(this.gPerm);
			
			
			this.findMinimumDistanceBetweenGroups();
		}

		
	// end of mergeGroups	
	}
	
	public void init() {
		
		this.cleanCopyGroups();
		
	// end of populateNodes method 	
	}
	
	public void findMinimumDistanceBetweenGroups() {
		
		this.minDist = 1000;
		
		
		for (int i = 0; i < this.gPerm.size() - 1; i++) {
			
			if ( i == 0) {
				
				if ( this.minDist == -1 ) {
					this.minDist = this.gPerm.get(i + 1).start -  this.gPerm.get(i).end; 
					
					this.minDistStart = 0; 
					this.minDistEnd = 1; 
				} else {
					
					int dist = this.gPerm.get(1).start -  this.gPerm.get(i).end; 
					
					if ( dist < this.minDist) {
						
						if ( this.debug) System.out.println ("The distance is smaller than the current minimum... at index 0" );
						this.minDist = dist;
						this.minDistStart = 0; 
						this.minDistEnd = 1; 
					}
				}
				
				
				
			} else {
				
				int dist = this.gPerm.get(i + 1).start -  this.gPerm.get(i).end; 
				
				if ( dist < this.minDist) {
					
					if ( this.debug) System.out.println ("The distance is smaller than the current minimum...after index 0" );
					this.minDist = dist;
					this.minDistStart = i; 
					this.minDistEnd = i + 1; 
				}
			}
		}
		
		
		if ( this.debug) System.out.println("The minDistStartis: " + this.minDistStart);
		if ( this.debug) System.out.println("The minDistEnd is: " + this.minDistEnd);
		
	// end 	
	}
	
	public void cleanCopyGroups() {
		
		gPerm.clear();
		
		for (int i = 0; i < groups.size(); i++) gPerm.add(groups.get(i));
		
		
	// end of cleanCopyGroups	
	}
	

	public void determineLength() {
		
		int runningTotal = 0; 
		
		for (int i = 0; i < this.gPerm.size(); i++) runningTotal += this.gPerm.get(i).length;
		
		
		// assign the new runningTotal
		this.min = runningTotal;
		
		if ( this.debug ) System.out.println("The length of the system is: " + this.min);
		
		
	// end of determineLength method....
	}

	
// end of the Tree class 	
}



// start of the Group class 
class Group {
	
	int start; 
	int end; 
	int length; 
	
	
	public Group (int start, int end) {
		
		this.start = start; 
		this.end = end; 
		this.length = end - start + 1; 
	// end of the Group constructor
	}
	
	 
    @Override
    public String toString() {
        return "\nGroup [start --> " + start + " :: end -> " + end +  " :: length -> " + length + " ] ";
    }
	
// end of the Group class 
}
