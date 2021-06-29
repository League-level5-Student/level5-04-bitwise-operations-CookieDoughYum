package _00_Binary_Conversion;

import java.util.ArrayList;

public class DecimalToBinary {
	public static void main(String[] args) {
		//Converting a decimal number to binary is a little trickier.
		
		//EXAMPLE: Convert 43 to binary
		
		/*
		 * Step 1: Divide the number by 2.
		 * Step 2: Write down the remainder from the division.
		 *         For example, 5 / 2 => 2 remainder 1, so write a 1.
		 * Step 3: Repeat steps 1 and 2 until the number is 0.
		 *    Example, convert decimal 43 into binary:
		 *    43
		 *    43 / 2 = 21 remainder 1
		 *    21 / 2 = 10 remainder 1
		 *    10 / 2 = 5  remainder 0
		 *    5  / 2 = 2  remainder 1
		 *    2  / 2 = 1  remainder 0
		 *    1  / 2 = 0  remainder 1
		 *    0 reached, END
		 *    
		 *    Starting from the bottom, write the remainders from left to right.
		 *    1 0 1 0 1 1 = 43!
		 *
		 * Why this method works:
		 * ----------------------
		 * The division by 2 and round down is the same as a binary right shift by 1.
		 * For example, the number 7 in binary is 111b. If we shift all the bits once to the
		 * right the number is 11b, which is 3 (remember, there are no fractions for integers
		 * so it's not 11.1b. The rightmost binary 1 is discarded).
		 *
		 * Checking the remainder is the same as checking if the rightmost binary digit 
		 * was a 1 or a 0 after the right shift removed it from the binary number.
		 *
		 * As the decimal number is continually divided by 2 (binary right shifted), the
		 * number keeps getting smaller until it reaches 0 and all the binary digits are
		 * accounted for.
		 * 
		 *     decimal      binary
		 *        43        101011
		 *        21         10101 (notice the rightmost 1 is gone!)
		 *        10          1010
		 *         5           101
		 *         2            10
		 *         1             1
		 *         0             0
		 *
		 * Challenge:
		 * ----------
		 * What about negative decimal numbers? Does the same method work? Below is a
		 * method that converts a decimal integer to a String of binary digits. Enter
		 * a negative number and check if it matches your calculations.
		 *  *hint* https://en.wikipedia.org/wiki/Two%27s_complement
		 * 
		*/
	
		//convertDecimalToBinary(-72);
		System.out.println( convertDecimalToBinary( -72 ) );
	}
	
    public static String convertDecimalToBinary(int decimalNum) {
        String binaryStr = "";
    
        do {
            // 1. Logical right shift by 1
            int quotient = Math.abs(decimalNum) >>> 1;
        
            // 2. Check remainder and add '1' or '0'
            if(Math.abs(decimalNum) % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }
            
            decimalNum = quotient;
            
        // 3. Repeat until number is 0
        } while( decimalNum != 0 );
        
    	  String tempValue="";
    	  ArrayList<Character> binaryValues=new ArrayList<Character>();
    	  //ArrayList<Character> NumValues=new ArrayList<Character>();
    	  
    	  for(int i=0; i<binaryStr.length(); i++) {
    		 if(binaryStr.charAt(i)=='0') {
    			 binaryValues.add('1');
    		 }
    		 else if(binaryStr.charAt(i)=='1') {
    			 binaryValues.add('0');
    		 }
    	  }
    	  
    	  for(int j=0; j<binaryValues.size(); j++) {
    		  tempValue=tempValue+binaryValues.get(j);
    	  }
    	  
    	  //System.out.println(binaryStr);
    	  //System.out.println(tempValue);
    	  
    	  String realValue="";
    	  int length=tempValue.length()-1;
    	  int length2=tempValue.length()-2;
    	  
    	  if(tempValue.charAt(tempValue.length()-1)=='0') {
    		  realValue=tempValue+1;
    	  }
    	  else if(tempValue.charAt(length)=='1') {
    		  //length-1 is set to 0 and length-2 is set to 1
    		  
    		  for (char ch: tempValue.toCharArray()) {
    			  int index=tempValue.indexOf(ch);
    			  if(index!=length || index!=length2) {
    				  System.out.println();
    				  realValue.concat(String.valueOf(ch));
    			  }
    			  else if(index==length2) {
    				  realValue.concat("1");
    			  }
    			  else if(index==length){
    				  realValue.concat("0");
    			  }
    			  //realValue=realValue+ch;
    		  }
    	  }
    	  
          return realValue;
        
        /*
        *Negative Decimal To Binary:
        *1. Get Binary of Abs. Value
        *2. Convert 0's to 1's and 1's to 0's *Called 1's complement
        *3. Add that binary to 0000 0001 * always start at the right collumn
        *4. If the last digit of the 1's complement is a 1, then set the previous digit to a 1, and set the far right digit to a 0
        */
    }
}
