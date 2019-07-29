
/*
ID: omnimed1
LANG: JAVA
TASK: combo
*/



// REMOVE before submission... 
package main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Vector;





public class combo {
	
	public static boolean debug = true;
	

	public static Vector<Integer> sol_A = new Vector<Integer>(); 	// FARMER actual combo 
	public static Vector<Integer> sol_B = new Vector<Integer>();    // FACTORY actual combo 
	
	// p will represent the active permutation 
	public static Vector<Integer> p = new Vector<Integer>();
	
	// used for knowing the max number on the lock
	public static int max; 
	

	
	public static Vector< Vector<Integer>> farmerPos = new Vector<Vector<Integer>>();
	public static Vector< Vector<Integer>> masterPos = new Vector<Vector<Integer>>();
	
	// the valid solutions... 
	public static HashSet<String> solutions = new HashSet<String>();

	
	public static int count = 0; 
	
	
	
	// begin the main method... 
	public static void main(String[] args) throws IOException {
		
        //BufferedReader f = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//combo.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

	    BufferedReader f = new BufferedReader(new FileReader("D:/ECLIP/USACO/combo/src/main/combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/ECLIP/USACO/combo/src/main/combo.out")));
		
        // store the max number for the permutations... 
        max = Integer.parseInt(f.readLine());
        
        

        StringTokenizer s = new StringTokenizer(f.readLine());
        
        sol_A.add( Integer.parseInt(s.nextToken()));
        sol_A.add( Integer.parseInt(s.nextToken()));
        sol_A.add( Integer.parseInt(s.nextToken()));
        
        StringTokenizer t = new StringTokenizer(f.readLine());
        
        sol_B.add( Integer.parseInt(t.nextToken()));
        sol_B.add( Integer.parseInt(t.nextToken()));
        sol_B.add( Integer.parseInt(t.nextToken()));
            
         

        
        if ( debug ) System.out.println("The FARMERS combo is -> : " + sol_A);
        if ( debug ) System.out.println("The MASTER  combo is -> : " + sol_B + "\n");
        
        // close the file input
        f.close();
        

        if ( max > 2) {
        	
            prep(true);
            prep(false);
        } else {
        	
        	smallPrep();
        	
        }

        
        if ( debug ) System.out.println("The farmerPos data " + farmerPos);
        if ( debug ) System.out.println("The masterPos data " + masterPos + " \n");
        
        
        verify();
        
        if ( debug ) System.out.println("The size of the solution set is: " + solutions.size());
        
        int answer = 1; 
        
        if ( max > 1) answer = solutions.size(); 
        

        
        out.println(answer);
        
        out.close();
        

    // end of the main driver method
	}
	
	public static boolean verify () {
		
		int vSize = farmerPos.get(0).size();
		
		// first check against the farmer's combo 
		for (int l = 0; l < vSize; l++) {
			for (int m = 0; m < vSize; m++) {
				for (int r = 0; r < vSize; r++) {
					
					int left  = farmerPos.get(0).get(l);
					int mid   = farmerPos.get(1).get(m);
					int right = farmerPos.get(2).get(r);
					String c = left + "-" + mid + "-" + right;
					
					if ( debug ) System.out.println("PERM ID: " + count + " FARMER is: " + c);
					
					if ( debug ) count++;
					
					
					int left_m  = masterPos.get(0).get(l);
					int mid_m   = masterPos.get(1).get(m);
					int right_m = masterPos.get(2).get(r);
					String c_m = left_m + "-" + mid_m + "-" + right_m;
					
					if ( debug ) System.out.println("PERM ID: " + count + " MASTER is: " + c_m);
					
					if ( debug ) count++;
					
					solutions.add(c);
					solutions.add(c_m);
					
				// end of the standard permutation loop for each number 
				}
			}
		}

		
		
		

		
		// return true by default... 
		return true; 
	// end of the verify function.. 
	}
	
	public static void smallPrep() {
		
		Vector<Integer> AV_0 = new Vector<Integer>();
		
		for (int i = 0; i <= 2; i++ ) {
			for (int j = 1; j <= max; j++){
				AV_0.add(j);
			}
			
			farmerPos.add(AV_0);
			masterPos.add(AV_0);
			
		}
		

		
	// end of the small_prep method	
	}
	
	
	public static void prep( boolean isFarmer) {
		
		for (int i = 0; i < 3; i++) {
			Vector<Integer> AV_0 = new Vector<Integer>();
			
			int a_0;
			if ( isFarmer) {
				a_0 = sol_A.get(i);
			} else {
				a_0 = sol_B.get(i);
			}
			
			// first add self
			AV_0.add(a_0);
			
			// add the plus one :)
			int add = a_0 == max ? 1 : a_0 + 1;
			AV_0.add(add);
			
			// add the plus two :d
			add = a_0 == max ? 2 : a_0 == max - 1 ? 1  : a_0 + 2; 
			AV_0.add(add);
			
			// add the minus one 
			add = a_0 == 1 ? max : a_0 -1; 
			AV_0.add(add);
			
			// add the minus two 
			add = a_0 == 1 ? max - 1 : a_0 == 2 ? max : a_0 -2; 
			AV_0.add(add);
			
			if (isFarmer) {
				farmerPos.add(AV_0);
			} else {
				masterPos.add(AV_0);
			}
				
		// end of the for loop 
		}
	
		

		
	// end of the prep class 
	}

	
// end of the combo class 
}
