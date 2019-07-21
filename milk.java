/*
ID: overidon
LANG: JAVA
TASK: milk
*/


// REMEMBER TO REMOVE before submittal... 
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * STORY:    --> The Merry Milk Maker buys milk from farmers... packages it anto 1 and 2 unit bottles 
 * 			     then he sells that milk to Grocery stores. 
 * 
 * IMPERATIVE -> The Packaging costs are high 
 * 				 Buy the cheapest milk possible. 
 * 				 We know exactly how much milk is needed each day... 
 * 
 * 				 Each farmer knows how much milk they can produce
 * 				 Each farmer also sets their daily clearly
 * 
 *  GIVEN -----> 1. The daily requirement of MILK
 *  			 2. The cost per unit of milk PER FARMER
 *  			 3. The amount of milk available (INTEGERS) for each farmer
 *  
 *  INPUT --->   Multiple lines with 2 Data points ( INTEGERS ) each line
 *  			 
 *  			 LINE ONE ......
 *  			 The first Data point is the Integer representing the total number of needed Milk units
 *  			 The second Data point of the first line represents the total number of farmers avaialable
 *  
 *  			 ALL OTHER LINES....
 *   			 The first data point is the cost of the milk in cents for that farmer
 *   	         The second data point is the amount of units available for that farmer
 *  
 *  
 * 	OUTPUT  ---> Output an INTEGER on a single line that represents the total cost of the 
 * 				 BEST total prices for all the milk purchased... 
 * 				 That satisfies the farmer's needs. 
 * 
 * 				 THIS integer is in the total COST in terms of CENTS
 * 
 * 
 * 
 */


public class milk {

	
	// begin the main driver method... 
	public static void main(String[] args) throws IOException {
		
		
		//BufferedReader f = new BufferedReader(new FileReader(System.getProperty("user.dir") + "//milk.in"));
		
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		
		
		// input file name goes above
	    BufferedReader f = new BufferedReader(new FileReader("D:/ECLIP/USACO/milk/src/main/milk.in"));
  
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:/ECLIP/USACO/milk/src/main/milk.out")));

		ArrayList<Farmer> farmers = new ArrayList<Farmer>();
		
		StringTokenizer first = new StringTokenizer(f.readLine());
		
		boolean debug = false; 
		
		int requiredMilk = Integer.parseInt(first.nextToken());
		int totalFarmers = Integer.parseInt(first.nextToken());
		
		
		if ( debug ) System.out.println("There is " + requiredMilk + " needed Milk units and " + totalFarmers + " Total farmers.");
		if ( debug ) System.out.println("\n ****** constructing the farmers now ******** \n");
		
		// begin farmer construction for loop 
		for (int i = 0; i < totalFarmers; i++) {
			Farmer farmer_0X = new Farmer();
			
			// extract information from the input data.... 
			StringTokenizer data = new StringTokenizer(f.readLine());
			int aPrice = Integer.parseInt(data.nextToken());
			int aUnits = Integer.parseInt(data.nextToken());
			
			// set the object's data points 
			farmer_0X.setPrice(aPrice);
			farmer_0X.setUnits(aUnits);
			
			// add the object to the ArrayList
			farmers.add(farmer_0X);
			
		// end farmer construction for loop 
		}
		
		// close the input file
		f.close();
		
		// prepare the sorting of the farmers by using a lambda comparator
		Comparator<Farmer> compareByPrice = (Farmer o1, Farmer o2) -> o1.getPrice().compareTo(o2.getPrice());
		
		// sort them using the comparator from lowest price to highest price. 
		Collections.sort(farmers, compareByPrice);
		
		if ( debug ) System.out.println(farmers);
		
		// create an integer to represent the running total of acquired milk units
		int acquired = 0; 
		
		// create an integer to represent the total cost of the milk purchased
		int cost = 0; 
		

		for (int i = 0; i < farmers.size(); i++) {
			
			int avail = farmers.get(i).getUnits();
			
			// is there more milk available than necessary?
			// perhaps just enough? 
			if ( avail + acquired >= requiredMilk ) {
				
				// only take what you need 
				int purchased = requiredMilk - acquired; 
				
				
				int bundleCost = purchased * farmers.get(i).getPrice();
				
				acquired += purchased;
				
				// increment the total cost by the bundleCost 
				cost += bundleCost; 
			} else {
				
				// take all of that farmers milk 
				int purchased = avail;
				int bundleCost = purchased * farmers.get(i).getPrice();
				
				acquired += purchased;
				// increment the total cost by the bundleCost 
				cost += bundleCost; 
			}
			
			// exit case 
			if ( acquired >= requiredMilk ) {
				i = farmers.size();
			}
		
			
		// end of the for loop for the purchasing of the farmers. 
		}
			


		

		if ( debug) System.out.println("\nThe total cost of the milk is: " + cost);
		
		out.println(cost);
		
		out.close();

		
		
	// end of the main driver method... 
	}
	

	
// end of the milk class
}


class Farmer implements Comparable< Farmer >{
	  
	    private Integer milkPrice;
	    
	    private int units;
	     
	    public Integer getPrice() {
	        return milkPrice;
	    }
	    
	    public Integer getUnits() {
	        return units;
	    }
	    
	    public void setPrice(Integer milkPrice) {
	        this.milkPrice = milkPrice;
	    }
	    
	    public void setUnits(int units) {
	    	this.units = units;
	    }
	    

	 
	    @Override
	    public String toString() {
	        return "\nFarmer [milkPrice --> " + milkPrice + " :: UNITS -> " + units + " ] ";
	    }
	 
	    @Override
	    public int compareTo(Farmer o) {
	        return this.getPrice().compareTo(o.getPrice());
	    }


}
