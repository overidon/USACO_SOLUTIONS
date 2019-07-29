
/*
ID: omnimed1
LANG: JAVA
TASK: crypt1
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

public class crypt1 {

	
	
	/*
	 * TEST CASE -> 1
	 * 
	 * 
	 * 
	 * TEST CASE -> 4
	 * 
	 * 7
	 * 4 1 2 5 6 7 3
	 * 
	 * 
	 */


    public static boolean debug = false;
    public static boolean debug_heavy = false;
    public static boolean debug_failures = false; 
    public static boolean debug_elite = false; 

    public static int solutions = 0;
    public static HashSet <String> solSet = new HashSet<String>();

    public static Vector<Integer> mult0 = new Vector<Integer>();
    public static Vector<Integer> mult1 = new Vector<Integer>();
    public static Vector<Integer> part0 = new Vector<Integer>();
    public static Vector<Integer> part1 = new Vector<Integer>();

    public static Vector<Integer> prod  = new Vector<Integer>();

    // setup ad assign the permutation set-> vector
    public static Vector <Integer> v = new Vector<Integer>();
    
    public static int permCount = 0; 
    
    // EXPERIMENTAL 
    public static PrintWriter out2; 
    

    // begin the main driver method
    public static void main(String[] args) throws IOException {

        //BufferedReader f = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//crypt1.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

	    BufferedReader f = new BufferedReader(new FileReader("D:/ECLIP/USACO/crypt1/src/main/crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/ECLIP/USACO/crypt1/src/main/crypt1.out")));
		
        // REMOVE from system submission
        if ( debug_elite) out2 =  new PrintWriter(new BufferedWriter(new FileWriter("D:/ECLIP/USACO/crypt1/src/main/crypt1_DETAILS.out")));

        String line0 = f.readLine();
        String line1 = f.readLine();

        f.close();

        int setSize = Integer.parseInt(line0);

        if ( debug ) System.out.println("The size of the HashSet will be: " + setSize);


        StringTokenizer st = new StringTokenizer(line1);

        // make a HashSet to store valid numbers
        HashSet<Integer> set = new HashSet<Integer>();

        // loop through the
        for (int i = 0; i < setSize; i++) set.add( Integer.parseInt(st.nextToken()));

        // output the HashSet values
        if ( debug ) System.out.println("The valid set of numbers is: " + set + " \n");


        for ( int element: set) v.add(element);

        if ( debug ) System.out.println("The v -> Vector is : " + v);


        // set the initial permutation
        for ( int i = 0; i < 3; i++ ) mult0.add(v.get(0));
        for ( int i = 0; i < 2; i++ ) mult1.add(v.get(0));

        // set the initial blank result
        for ( int i = 0; i <= 3; i++ ) part0.add(0);
        for ( int i = 0; i <= 3; i++ ) part1.add(0);

        // set the initial blank product
        for ( int i = 0; i <= 4; i++ ) prod.add(0);

        //perm(set);


        systemPermuation(set);


        //if ( debug ) display( );
        if ( debug) System.out.println("\n\n ******** \n\n" + solSet);

        //solutions = solSet.size();
        
        if ( debug ) System.out.println("The size of the solution set is: " + solSet.size());
        
        if ( debug ) System.out.println("The total number of raw permutations is " + permCount);


        if ( debug ) System.out.println("\n\nThe total number of valid solutions is: " + solutions);

        out.println(solutions);

        out.close();
        
        // EXPERIMENTAL REMOVE...
        if ( debug) out2.close();

    // end of the main driver method
    }



    public static void systemPermuation(HashSet<Integer> set) {
    	
    	
    	int s = v.size();
    	
		// begin the mult0 series
		for (int l = 0; l < s; l++) {
			for (int m = 0; m < s; m++) {
				for (int r = 0; r < s; r++) {
					
					
					for (int j = 0; j < s; j++) {
						for (int k = 0; k < s; k++){
						
							mult0.set(0, v.get(l));
							mult0.set(1, v.get(m));
							mult0.set(2, v.get(r));
							
							mult1.set(0, v.get(j));
							mult1.set(1, v.get(k));
							

							
							if ( debug_heavy) {
								try {
									Thread.sleep(200);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
							
							if ( debug_heavy) {
								System.out.println("Multiplicand 0 -> "    + mult0);
								System.out.println("Multiplicand 1  ->   " + mult1 + " \n");
							}

							
							cleanPermutation( set );
							
							if ( debug) permCount++;
						
						// end of the mult1 -> index loop series...	
						}
					}
					

				// end of the mutlt0 INDEX -> loop series 	
				}
			}
		}
    	
    // end of the systemPermuation() method 
    }
    
    public static void cleanPermutation( HashSet<Integer> set ) {


        // ******** IMPORTANT *************
        // the focusPart refers to the index of the 2nd multiplicand
        // that we should look at...
        // thus a focusPart of 1 means that we are starting with the
        // rightMost element of the 2nd multiplicand

        // the reason why we start with 1 and then go to zero
        // is because the rules of this exercise is that there are only
        // 2 elements in the 2nd multiplicand allowed...
        
        if ( debug_heavy ) System.out.println("The PART on the right is being focused... ");
        int focusPart = 1;
        

        // test popPart with the first integer... meaning on the right...
        popPart(focusPart, mult0, mult1, part0,  set);
        

        if ( debug_heavy ) System.out.println("The PART on the LEFT is being focused... ");
        focusPart = 0;

        popPart(focusPart, mult0, mult1, part1,  set);
        

        // populating the product doesn't really need permutation
        // since it is based solely on the permutation results
        // of the partial products..
        popProd( set );
        
        if ( debug ) System.out.println("The PRODUCT IS: " + prod);

        if ( verifyAllSystems(set)) {
        	//if ( debug ) display( mult0, mult1, part0, part1, prod);
            if ( debug ) System.out.println("\n SOLUTION FOUND...incrementing Solutions by one!");

            // TESTING ... 
            solutions++;
           
            
        } else {
        	
        	if ( debug )  System.out.println("*** FAIL **** proceeding through data scan... ");
        }

        


        if ( debug_elite ) display( );
    
    // end of the cleanPermutations
    }


    
    public static boolean verifyPart0 (HashSet<Integer>set) {
    	
    	if ( part0.get(0) != 0 ) {
    		
    		if ( debug ) System.out.println("FAILURE due to first element is non-zero....");
    		return false; 
    	}
    	
    	for (int i = 1; i < part0.size(); i++) {
 
    		if ( !set.contains(part0.get(i))  ) return false;  
    	}
    	
    	return true; 
    }
    
    
    public static boolean verifyPart1 (HashSet<Integer>set) {
    	
    	if ( part1.get(0) != 0 ) {
    		
    		if ( debug ) System.out.println("FAILURE due to first element is non-zero....");
    		return false; 
    	}
    	
    	for (int i = 1; i < part1.size(); i++) {
 
    		if ( !set.contains(part1.get(i))  ) return false;  
    	}
    	
    	return true; 
    }
    
    
    public static boolean verifyProd (HashSet<Integer>set) {
    	
    	if ( prod.get(0) != 0 ){
    		
    		if ( debug ) System.out.println("FAILURE due to first element is non-zero....");
    		return false; 
    	}
    	
    	
    	for (int i = 1; i < prod.size(); i++) {
 
    		if ( !set.contains(prod.get(i))  ) return false; 
    	}
    	
    	return true; 
    }
    
    public static boolean verifyAllSystems(HashSet<Integer>set) {
    	
    	if ( debug ) display();
    	
    	
    	if ( !verifyPart0(set)) return false; 
    	if ( !verifyPart1(set)) return false; 
    	if ( !verifyProd(set)) return false; 
    	
    	
    	if ( debug ) System.out.println("The system has passed all SEIVE checks.... ");
    	
    	return true; 
    	
    // end of verifyAllSystems code.. 
    }

    public static void assignVector(int targetInt, Vector<Integer> target, int index) {


        target.set(index, targetInt);

        if ( debug) System.out.println("\n\n The target is: " + target);
    // end of assignVector
    }

    public static void popProd( HashSet<Integer> set) {

        // attempt to add up the product..
        // set the rightmost element of the product
        // it is impossible for this to be more than 9 based
        // on the previous rules...
        prod.set(4, part0.get(3));

        // set the second to rightmost element of the product
        // make sure to handle the additon properly
        int tempDigit = part0.get(2) + part1.get(3);
        int carry = 0;

        if ( tempDigit > 9) {
            carry = tempDigit / 10;
            tempDigit = tempDigit % 10;

        }

        // it made it through the sieve ... set the integer
        prod.set(3, tempDigit);

        // move onto the index of 1 of the product
        // this uses the first element of the part0 ...
        // and the second element of the part1...

        tempDigit = carry + part0.get(1) + part1.get(2);

        if ( tempDigit > 9) {
        	carry = tempDigit / 10;
            tempDigit = tempDigit % 10;
        } else {
            // reset the carry back to zero to be on the safe side...
            carry = 0;
        }

        // it made it through the sieve ... set the integer
        prod.set(2, tempDigit);

        // move onto the second to last element..
        tempDigit = carry + part1.get(1) + part0.get(0);
        

        if ( tempDigit > 9) {
        	carry = tempDigit / 10;
            tempDigit = tempDigit % 10;
        } else {
            // reset the carry back to zero to be on the safe side...
            carry = 0;
        }

        // it made it through the LAST sieve ... set the integer
        prod.set(1, tempDigit);
        
        prod.set(0, part1.get(0));
        

    // end of the populateProduct popProd method
    }
    


    public static void popPart(  int p, Vector<Integer> mult0, Vector<Integer> mult1, Vector<Integer> part, HashSet<Integer> set) {




        int last = mult0.get(2) * mult1.get(p);
        
        if ( debug) System.out.println("We are focusiong on mult1 index: " + p);
        
        

        int carry = 0;

        // begin last
        if ( last > 9) {


            if ( debug_heavy) {
                System.out.println("\nTHE LAST is of part0 is " + last );
                System.out.println("Carrying now....");
            }
            
            carry = last / 10;
            
            if ( debug_heavy) System.out.println("\nTHE LAST -> MID carry is of part0 is " + carry );
            last = last % 10;
            
        }  


        // begin mid
        int mid  = mult0.get(1) * mult1.get(p) + carry;

        if ( mid > 9) {

            if ( debug_heavy) System.out.println("\nTHE MID is of part0 is " + mid );

            carry = mid / 10;
            
            if ( debug_heavy) System.out.println("\nTHE MID -> LEFT carry is of part0 is " + carry );


            mid = mid % 10;
        } else {
        	carry = 0; 
        }



        // BEGIN the LEFT part of
        int left = mult0.get(0) * mult1.get(p) + carry;
        
        if ( left > 9) {
        	
        	carry  = left / 10; 
        	
        	left = left % 10; 
        	if ( debug_heavy) System.out.println("\nTHE LEFT  is of part0 is " + left );
        	if ( debug_heavy) System.out.println("\n LEFT -> FAR_LEFT carry is of part0 is " + carry );
        } else {
        	
        	carry = 0; 
        }

     
        
        int far_left = carry;

   
        part.set(3, last);
        part.set(2, mid);
        part.set(1, left);
        part.set(0, far_left);


    // end of the popPart method
    }

    public static boolean verifySet(int number, HashSet<Integer>set ) {


        // kick out on fail
        if ( !set.contains(number) ) return false;

        return true;
    // end of the verify set method...
    }


    // MARK: DISPLAY
    public static void display() {

    	System.out.println("\n\n*********************************** \n");
        System.out.println("\n\nThe first  MULT line is:            " + mult0);
        System.out.println("The second MULT line is:               " + mult1);
        System.out.println("                               ---------------");
        System.out.println("The first  PART product is:      " + part0);
        System.out.println("The second PART product is:   " + part1);
        System.out.println("                               ---------------");
        System.out.println("The product itself is:        " + prod);
        
        
        out2.println("\n\n*********************************** \n");
        out2.println("\n\nThe first  MULT line is:            " + mult0);
        out2.println("The second MULT line is:               " + mult1);
        out2.println("                               ---------------");
        out2.println("The first  PART product is:      " + part0);
        out2.println("The second PART product is:   " + part1);
        out2.println("                               ---------------");
        out2.println("The product itself is:        " + prod);

    // end of the display method
    }

// end of the crypt1 class
}

