package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args) 
    {
    	// asks the user for input, if they say "quit" then it will end the program
    	Scanner input = new Scanner(System.in);
    	String user = "";
    	while (!user.equals("quit")) {
    		  	System.out.println("Input: ");
    		  	user = input.nextLine(); 
    		  	if (!user.contentEquals("quit")) {
    		  		String operand2 = produceAnswer(user);
    		  		System.out.println(operand2);
    		  	}  
    	}
  

    }

    public static String produceAnswer(String input)
    {  
    	//start splitting each string into the two numbers and the operator
    	int space1 = input.indexOf(" ");
    	int space2 = input.lastIndexOf(" ");
    	int length = input.length();
    	String firstOperand = input.substring(0,space1);
    	String operator = input.substring(space1+1,space2);
    	String secondOperand = input.substring(space2+1,length);
    	
    	//splits the numbers into an array for each number containing their whole number, numerator, and denominator
        int fraction1[] = fractioner(firstOperand);
        int fraction2[] = fractioner(secondOperand);
        
        //changes all mixed fractions to improper fractions
        int addNumerator1;
        if (fraction1[2] != 0) {
        addNumerator1 = fraction1[0] * fraction1[2];
        } else {
        	addNumerator1 = fraction1[0];
        }
        if (fraction1[0] < 0) {
        	addNumerator1 += (fraction1[1])*-1;
        }else {
        	addNumerator1 += fraction1[1];
        } 
        int addNumerator2;
        if (fraction2[2] != 0) {
            addNumerator2 = fraction2[0] * fraction2[2];
            } else {
            	addNumerator2 = fraction2[0];
            }
        if (fraction2[0] < 0) {
        	addNumerator2 += (fraction2[1])*-1;
        }else {
        	addNumerator2 += fraction2[1];
        }
        int finalNumerator=0;
        int finalDenominator=0;
        
        //starts sectioning out the calculator part which deal with the operator
        	//does the + part
        	if (operator.equals("+")) {
        		//checks if the denominator doesnt exist and its a whole number, if it is a whole number it makes it a improper fraction over 1
        		if (fraction1[2] == 0) {
        			fraction1[2] = 1;
        		}
        		if (fraction2[2] == 0) {
        			fraction2[2] = 1;
        		}
        		
        		//checks for same denominator if not it makes them both the same 
        		if (fraction1[2] == fraction2[2]) {
        			finalNumerator = addNumerator1 + addNumerator2;
        			finalDenominator = fraction1[2];
        		}else {
        			addNumerator1 *= fraction2[2];
        			addNumerator2 *= fraction1[2];
        			finalNumerator = addNumerator1 + addNumerator2;
        			finalDenominator = fraction1[2] * fraction2[2];
        		}
        		
        	//does the - part
        	}else if (operator.equals("-")) {
        		//makes any whole numbers to a fraction over 1
        		if (fraction1[2] == 0) {
        			fraction1[2] = 1;
        		}
        		if (fraction2[2] == 0) {
        			fraction2[2] = 1;
        		}
        		
        		//checks for same denominator, if not makes them the same and calaculates result
        		if (fraction1[2] == fraction2[2]) {
        			finalNumerator = addNumerator1 - addNumerator2;
        			finalDenominator = fraction1[2]; 
        		}else {
        			addNumerator1 *= fraction2[2];
        			addNumerator2 *= fraction1[2];
        			finalNumerator = addNumerator1 - addNumerator2;
        			finalDenominator = fraction1[2] * fraction2[2];
        		}
        	
        	//does the * part
        	}else if (operator.equals("*")) {
        		//converts whole numbers to fractions over 1
        		if (fraction1[2] == 0) {
        			fraction1[2] = 1;
        		}
        		if (fraction2[2] == 0) {
        			fraction2[2] = 1;
        		}
        		//carries out the calculations
        		finalNumerator = addNumerator1 * addNumerator2;
        		finalDenominator = fraction1[2] * fraction2[2];
        		
        	//does the / part
            }else if (operator.equals("/")) {
            	//converts any whole numbers to fractions over 1
        		if (fraction1[2] == 0) {
        			fraction1[2] = 1;
        		}
        		if (fraction2[2] == 0) {
        			fraction2[2] = 1;
        		}
        		//carries out the calculations
            	finalNumerator = addNumerator1 * fraction2[2];
            	finalDenominator = fraction1[2] * addNumerator2;
            }
        	
        //starts converting answers so  i can print/return them
        String printer = "";
        
        //changes the improper fraction to a mixed fraction and gets the whole number for it
        int whole = finalNumerator/finalDenominator;
        int num = 0;
        
        //checks if there is a whole number so it can carry or drop the sign
        if (whole == 0) {
        	num = finalNumerator % finalDenominator;
        }else {
           	num = Math.abs(finalNumerator) % (finalDenominator);
        }
        
        //reduces the numerator and denominator by any number below 100
       	for (int i = 100; i >= 1; i--) {
       		if (num%i == 0 && finalDenominator%i == 0) {
       			num = num / i;
       			finalDenominator = finalDenominator/i;
       		}
       	}
       	
       	
       	String wholeS = Integer.toString(whole);
       	String numS = "";
       	String dem = "";
       	//checks if there is a whole number so it can form the final string
       	if (wholeS.equals("0")){
       		numS = Integer.toString(num);
       		dem = Integer.toString(finalDenominator);
       	//checks if the whole number is less than 0 or negative
       	} else if (Integer.parseInt(wholeS) < 0){
       		numS = Integer.toString(num);
       		dem = Integer.toString(Math.abs(finalDenominator));
       	} else {
       		numS = Integer.toString(num);
       		dem = Integer.toString(Math.abs(finalDenominator));
       	}
       	
       	//checks for numerator or if answer is just a whole number
        if (numS.equals("0")) {
        	printer = (wholeS);
        }else if (wholeS.equals("0")){
        	int a = Integer.parseInt(dem);
        	int b = Integer.parseInt(numS);
        	
        	//gets the printing format depending on the whole number and numerator
        	if (a < 0 && b < 0) {
            	printer = (numS + "/" + dem);
        	}else if (a < 0 && b > 0){
        		printer = ("-" + numS + "/" + Integer.toString(Math.abs(a)));
        	}else {
        		printer = (numS + "/" + dem);
        	}
        	
        }else {
        printer = (wholeS + "_" +numS + "/" + dem);
        }
        return printer;
    }
    
    //function to get the whole number, numerator, and denominator
    public static int[] fractioner(String input) {
    	//gets the indexes of the "_" and "/"
    	int whole = input.indexOf("_");
    	int fractionSpot = input.indexOf("/");
    	int length = input.length();
    	//gets array to store the 3 values
    	int fraction[] = {0,0,0};
    	
    	//checks if fraction exists or just a whole number
    	if (fractionSpot != -1) {
    		String numerator = "";
    		if (whole != -1) {
    			numerator = input.substring(whole+1,fractionSpot);
    		}else {
    			numerator = input.substring(0,fractionSpot);
    		}
    		fraction[1] = Integer.parseInt(numerator);
    		String denominator = input.substring(fractionSpot+1,length);
    		fraction[2] = Integer.parseInt(denominator);
    	}
    	
    	//checks if its just a fraction or if just a whole number
    	if (whole != -1) {
    		String wholeString = input.substring(0,whole);
    		fraction[0] = Integer.parseInt(wholeString);
    	}
    	if (whole == -1 && fractionSpot == -1) {
    		fraction[0] = Integer.parseInt(input);
    	}

    	return fraction;
    	
    }
}
