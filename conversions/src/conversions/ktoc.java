// "Kelvin" to "Celcius" Console Converter (Buffered Reader Method)

package conversions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ktoc {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
// TODO Auto-generated method stub
		
// Start of Execution Duration Log:
		long startTime=System.currentTimeMillis();
		
			
		
// Declare "br" variable
			BufferedReader br;
				
// Create console input for "Kelvin" to "Celcius" conversion
			System.out.println("Welcome ('',) Please input temperature in "
					+ "Kelvin bellow and hit ENTER:");		
			br = new BufferedReader(new InputStreamReader(System.in));
			
// Declare "k" variable with float data type and parse to reader
			float k = Float.parseFloat(br.readLine());
			
// Declare "c" variable with float data type & conversion formula (K-273.15F=C)
			float c = k - 273.15F;
			System.out.println("Thank,you!!! Celcius temperature is: "+ c + "c");
			
		
			
// End of Execution Duration Log:
		long endTime=System.currentTimeMillis();
		System.out.println("Execution Duration: " + (endTime-startTime) + "'milliseconds'");
	}

}
