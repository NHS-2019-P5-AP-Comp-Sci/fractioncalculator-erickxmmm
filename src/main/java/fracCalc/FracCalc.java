
/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Type your problem here: ");
		String response = s.nextLine();
		System.out.println(produceAnswer(response));

		// produceAnswer();

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
		String operand1 = "";
		String operator = "";
		String operand2 = "";

		int first = 0;
		int second = 0;

		// Splits u[p the first operand
		second = input.indexOf(" ");
		operand1 = input.substring(first, second);
		input = input.substring(second + 1);
		// Finds and splits up the operator
		second = input.indexOf(" ");
		operator = input.substring(first, second);
		input = input.substring(second + 1);
		// splits up the last operand which should just be the rest of the input
		operand2 = input;
		System.out.println(input);
		
//		int whole2;
		int num;
		int denom;
		int dex = operand2.indexOf("_");
		if(dex > 0) {
			String whole2 = operand2.substring(0,dex);
			operand2 = operand2.substring(dex + 1);
			dex = operand2.indexOf("/");
			num = Integer.parseInt(operand2.substring(0,dex));
			denom = Integer.parseInt(operand2.substring(dex + 1));
			String part2 = "whole:" + whole2 + " numerator:" + num + " denominator:" + denom;
			return part2;
		}
		else {
			dex = operand2.indexOf("/");
			if (dex > 0) {
				num = Integer.parseInt(operand2.substring(0, dex));
				denom = Integer.parseInt(operand2.substring(dex + 1));
				String part2 = "whole:0" + " numerator:" + num + " denominator:" + denom;
				return part2;
			}
			else {
				String part2 = "whole:" + operand2 + " numerator:0" + " denominator:1";
				return part2;
			}
		}
	}
}
		

		// TODO: Implement this function to produce the solution to the input

		//return operand2;
	

	// TODO: Fill in the space below with any helper methods that you think you will
	// need




		

			
