
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
   
    	//produceAnswer();
    	
    
        // TODO: Read the input from the user and call produceAnswer with an equation

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
    	//Assign op1, 2, and operator to empty string 
    	String operand1 = "";
    	String operator = "";
    	String operand2 = "";
    	
    	String t ="";
    	for (int i = 0; i < input.length(); i++) {
    		if(input.charAt(i) == ' ') {
    			if(operand1.equals("")) {
    				operand1 = t;
    				t ="";
    				
    		  }else {
    			  operator = t;
    			  t = "";
    		  }
    		}else if (i == input.length() - 1) {
    			t += input.charAt(i);
    			operand2 = t;
    		}else {
    			t += input.charAt(i);
    		}
    	
    	
        // TODO: Implement this function to produce the solution to the input

       // return "";
    }
    	//Print out second operand by return
    	return operand2;
    	
 
    // TODO: Fill in the space below with any helper methods that you think you will need

    }
}
