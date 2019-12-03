
/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String problem = "";
		
		//While the problem doesn't equal quit keep running
		while(!problem.equals("quit")) {
			System.out.print("Type your problem here: ");
			problem = s.nextLine();
			if(!problem.equals("quit")) {
				System.out.println(produceAnswer(problem));
			}
		}
		
		s.close();
		/*System.out.println("Type your problem here: ");
		String response = s.nextLine();
		System.out.println(produceAnswer(response));
		*/

		

		// TODO: Read the input from the user and call produceAnswer with an equation

	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
        //Finds first space of users input
        int a = input.indexOf(" "); 
        //Gives layout of users input by using space as reference
        String operand1 = input.substring(0, a); 
        String operator = input.substring(a + 1, a + 2); 
        String operand2 = input.substring(a + 3, input.length()); 

        // First operand  "1/2" + 1/3
        String whole = operand1;
        String num = "";
        String denom = "";
        int dex = operand1.indexOf("/");

        if (dex > 0) {
                int underscore1 = operand1.indexOf("_");
                if (underscore1 > 0) {
                       whole = operand1.substring(0, underscore1);
                       num = operand1.substring(underscore1 + 1, dex);
                       denom = operand1.substring(dex + 1, operand1.length());
                } else {
                       whole = "0";
                       num  = operand1.substring(underscore1 + 1, dex);
                       denom = operand1.substring(dex + 1, operand1.length());
                }

        } else {
                num = "0";
                denom = "1";
        }

        // Second Operand 1/2 + "1/3"
        String whole2 = operand2;
        String num2 = "";
        String denom2 = "";
        int dex2 = operand2.indexOf("/");

        if (dex2 > 0) {
                int underscore2 = operand2.indexOf("_");
                if (underscore2 > 0) {
                       whole2 = operand2.substring(0, underscore2);
                       num2 = operand2.substring(underscore2 + 1, dex2);
                       denom2 = operand2.substring(dex2 + 1, operand2.length());
                } else {
                       whole2 = "0";
                       num2 = operand2.substring(underscore2 + 1, dex2);
                       denom2 = operand2.substring(dex2 + 1, operand2.length());
                }

        } else {
                num2 = "0";
                denom2 = "1";
        }

        /*
        * System.out.println(whole1 + " " + numerator1 + " " + denominator1);
        * System.out.println(operator); System.out.println(whole2 + " " + numerator2 +
        * " " + denominator2);
        */

        int whole_1= Integer.parseInt(whole);
        int num_1= Integer.parseInt(num);
        int denom_1 = Integer.parseInt(denom);

        int whole_2= Integer.parseInt(whole2);
        int num_2 = Integer.parseInt(num2);
        int denom_2 = Integer.parseInt(denom2);

        /*
        * System.out.println(int_whole1 + " " + int_numerator1 + " " +
        * int_denominator1); System.out.println(int_whole2 + " " + int_numerator2 + " "
        * + int_denominator2);
        */

        // convert to improper fraction
        num_1 += denom_1 * Math.abs(whole_1);
        if (whole_1 < 0) {
        	num_1 *= -1;
        }

        num_2 += denom_2 * Math.abs(whole_2);
        if (whole_2 < 0) {
        	num_2 *= -1;
        }

        //For final return
        int numerator = 0;
        int denominator = 0;
        int whole_ = 0;

        // addition calculation
        // multiply whole values to fraction to get a common denominator

        if (operator.equals("+")) {
        	num_1 *= denom_2;
        	num_2 *= denom_1;

                // show denominator value is correct
                int temp_denominator = denom_1;
                denom_1 *= denom_2;
                denom_2 *= temp_denominator;

                numerator = num_1 + num_2;
                denominator = denom_1;
        }

        // subtraction calculation
        if (operator.equals("-")) {
        	num_1 *= denom_2;
        	num_2 *= denom_1;

                // show denominator value is correct
                int temp_denominator = denom_1;
                denom_1 *= denom_2;
                denom_2 *= temp_denominator;

                numerator = num_1 - num_2;
                denominator = denom_2;
        }
        // multiplication calculation
        if (operator.equals("*")) {
                numerator = num_1 * num_2;
                denominator = denom_1 * denom_2;
        }

        // division calculation
        if (operator.equals("/")) {
        	numerator = num_1 * denom_2;
        	denominator = denom_1 * num_2;
        }

        // convert to mixed fraction if numerator is positive
        while (numerator / denominator >= 1) {
        	numerator -= denominator;
        	whole_ += 1;
        }

        // convert to mixed fraction if numerator is negative
        while (numerator / denominator <= -1) {
        	numerator += denominator;
        	whole_ -= 1;
        }

        if (whole_ != 0) {
        	numerator = Math.abs(numerator);
        	denominator = Math.abs(denominator);
        }
        // final output
        if (whole_ == 0) {
                return numerator + "/" + denominator;
        } else if (numerator == 0 && denominator == 1) {
                return whole_ + "";
        } else {
                return whole_ + "_" + numerator + "/" + denominator;
        }
 }
}

// TODO: Fill in the space below with any helper methods that you think you will
// need


		
	
	
	  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// TODO: Implement this function to produce the solution to the input

		//return operand2;
	

	// TODO: Fill in the space below with any helper methods that you think you will
	// need




		

			

