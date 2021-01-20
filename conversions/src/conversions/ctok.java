// "Celsius" to "Kelvin" Console Converter (Buffered Reader Method)

package conversions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ctok {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
// TODO Auto-generated method stub
		
// Start of Execution Duration Log:
		long startTime=System.currentTimeMillis();
		
			
			
// Declare "br" variable
			BufferedReader br;
				
// Create console input for "Celcius" to "Kelvin" conversion
			System.out.println("Welcome ('',) Please input temperature in "
					+ "Celcius bellow and hit ENTER:");		
			br = new BufferedReader(new InputStreamReader(System.in));
				
// Declare "c" variable with float data type and parse to reader
			float c = Float.parseFloat(br.readLine());
			
// Declare "k" variable with float data type & conversion formula (C + 273,15F = K)
			float k = c + 273.15F;
			System.out.println("Thank,you!!! The Kelvin temperature is: "+ k + "K");

		
		
// End of Execution Duration log:
		long endTime=System.currentTimeMillis();
		System.out.println("Execution Duration: " + (endTime-startTime) + "'milliseconds'");
	}

}
