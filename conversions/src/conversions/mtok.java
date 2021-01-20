// "Mile's" to "Kilometer's" Console Converter

package conversions;

import java.util.Scanner;

public class mtok {

	public static void main(String[] args) {
		
// TODO Auto-generated method stub
		
// Start of execution duration log
		long startTime=System.currentTimeMillis();
		
			
		
// Declare "mls" & "kms" variables
			double mls, kms;

// Getting user input using Scanner
			System.out.println("Welcome ('',) Please input distance in "
					+ "Mile's bellow and hit ENTER:");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			mls = input.nextDouble();

// Conversion & OutPut
			kms = mls * 1.6;
			System.out.println("Thank,you!!! Distance in Kilometer's is: "+ kms + "kms");
			
		
			
// End of Execution Duration log:
	    long endTime=System.currentTimeMillis();
	    System.out.println("Execution Duration: " + (endTime-startTime) + "'milliseconds'");
	}

}
