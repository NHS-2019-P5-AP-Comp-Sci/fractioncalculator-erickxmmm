
/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.Scanner;

public class FracCalc {

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner s = new Scanner(System.in);
		String problem = "";

		while (!problem.equals("quit")) {
			System.out.print("Type your problem here: ");
			problem = s.nextLine();
			if (!problem.equals("quit")) {
				System.out.println(produceAnswer(problem));
			}
		}
		s.close();

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
		// TODO: Implement this function to produce the solution to the input

		// Parsing line of Input
		// Finds index of the 1st space
		int a = input.indexOf(" ");
		// Substring from beginning to space before operators(+, /, -, *)
		String operand1 = input.substring(0, a);

		String new1 = input.substring(a + 1, input.length());
		// finds index of the 2nd space
		int a2 = new1.indexOf(" ");
		// operator between 1st and 2nd space
		String operator = new1.substring(0, a2);

		String new2 = new1.substring(a2, new1.length());
		// substring of space after operator to the end
		String operand2 = new2.substring(a2, new2.length());

		// Various operations
		while (operand2.indexOf(" ") > 0) {
			int a3 = operand2.indexOf(" ");
			String value = operand2.substring(0, a3);
			String new3 = operand2.substring(a3 + 1, operand2.length());
			int a4 = new3.indexOf(" ");
			String operator2 = new3.substring(a4 - 1, a4);
			operand2 = new3.substring(a4 + 1, new3.length());
			String newProblem = operand1 + " " + operator + " " + value;
			operand1 = produceAnswer(newProblem);
			operator = operator2;
		}

		// Parsing First operand "1/2" + 1/3
		String whole = operand1;
		String num = "";
		String denom = "";
		int dex = operand1.indexOf("/");

		if (dex > 0) {
			int underscore = operand1.indexOf("_");
			if (underscore > 0) {
				whole = operand1.substring(0, underscore);
				num = operand1.substring(underscore + 1, dex);
				denom = operand1.substring(dex + 1, operand1.length());
			} else {
				whole = "0";
				num = operand1.substring(underscore + 1, dex);
				denom = operand1.substring(dex + 1, operand1.length());
			}

		} else {
			num = "0";
			denom = "1";
		}

		// Parsing Second Operand 1/2 + "1/3"

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

		// Change strings to integers
		int whole_1 = Integer.parseInt(whole);
		int num_1 = Integer.parseInt(num);
		int denom_1 = Integer.parseInt(denom);

		int whole_2 = Integer.parseInt(whole2);
		int num_2 = Integer.parseInt(num2);
		int denom_2 = Integer.parseInt(denom2);

		// changes to improper fraction
		num_1 += denom_1 * Math.abs(whole_1);
		if (whole_1 < 0) {
			num_1 *= -1;
		}

		num_2 += denom_2 * Math.abs(whole_2);
		if (whole_2 < 0) {
			num_2 *= -1;
		}

		// Variables for Final return
		int numerator = 0;
		int denominator = 0;
		int whole_ = 0;

		// If denominator = 0, quit
		if (denom_1 == 0 || denom_2 == 0) {
			return "Invalid input";
		}

		// If incorrect -> quit
		if (operator.length() > 1) { 
			return "Invalid input";
		} 

		// Adding
		if (operator.equals("+")) {
			num_1 *= denom_2;
			num_2 *= denom_1;
			numerator = num_1 + num_2;
			denominator = denom_1 * denom_2;
		}

		// Subtracting
		if (operator.equals("-")) {
			num_1 *= denom_2;
			num_2 *= denom_1;
			numerator = num_1 - num_2;
			denominator = denom_1 * denom_2;
		}

		// Multiplying
		if (operator.equals("*")) {
			numerator = num_1 * num_2;
			denominator = denom_1 * denom_2;
			if (num_1 == 0 || num_2 == 0) {
				return 0 + "";
			}
		}

		// Dividing
		if (operator.equals("/")) {
			numerator = num_1 * denom_2;// done
			denominator = denom_1 * num_2;// done
		}

		// Makes numerator (-) instead of denominator
		if (denominator < 0 && numerator > 0) {// done
			denominator *= -1;// done
			numerator *= -1;// done
		} // done

		// Change to mixed fraction if numerator is (+)
		while (numerator / denominator >= 1) {
			numerator -= denominator;
			whole_ += 1;
		}

		// Convert to mixed fraction if numerator is (-)
		while (numerator / denominator <= -1) {
			numerator += denominator;
			whole_ -= 1;// done
		}

		// Remove signs from numerator and denominator if there is a whole#
		if (whole_ != 0) {
			numerator = Math.abs(numerator);
			denominator = Math.abs(denominator);
		}

		// Reduces fraction
		int last = 1;
		for (int i = 1; i <= Math.abs(numerator) && i <= Math.abs(denominator); i++) {
			if (numerator % i == 0 && denominator % i == 0)
				last = i;
		}
		numerator /= last;
		denominator /= last;

		// FINAL OUTPUT
		if (whole_ == 0) {
			if (numerator == 0) {
				return "0";
			} else {
				return numerator + "/" + denominator;
			}
		} else if (numerator == 0 || denominator == 1) {
			return whole_ + "";
		} else {
			return whole_ + "_" + numerator + "/" + denominator;
		}
	}
}