// "Kilometer's" to "Mile's" Console Converter (Scanner Method)

package conversions;

import java.util.Scanner;

public class ktom {

	public static void main(String[] args) {
		
// TODO Auto-generated method stub
		
// Start of execution duration log
		long startTime=System.currentTimeMillis();
		
			
		
// Declare "kms" & "mls"variables
        	double kms, mls;
 
// Getting user input using Scanner
        	System.out.println("Welcome ('',) Please input distance in "
					+ "Kilometer's bellow and hit ENTER:");
        	@SuppressWarnings("resource")
        	Scanner input = new Scanner(System.in);
        	kms = input.nextDouble();
 
// Conversion & OutPut
        	mls = kms / 1.6;
        	System.out.println("Thank,you!!! Distance in Mile's is: " + mls +"mi" );
 
        
        	
// End of Execution Duration log:
        long endTime=System.currentTimeMillis();
        System.out.println("Execution Duration: " + (endTime-startTime) + "'milliseconds'");
	}

}
