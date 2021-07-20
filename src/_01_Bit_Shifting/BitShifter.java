package _01_Bit_Shifting;

public class BitShifter {
	public static void main(String[] args) {
		// 1. Jot down the value of num in binary.
		int num = 4;
		//int numShifted = num >> 1;
		//100
		// 2. Print the value of numShifted, and convert that value to binary.
		String binaryStr="";
		
		for(int i=0; i<3; i++) {
		num <<=1;
		}
		
        do {
        	int num2 = num >>> 1;
        	
            // 1. Logical right shift by 1
            // 2. Check remainder and add '1' or '0'
            if(num % 2 != 0 ){
                binaryStr = '1' + binaryStr;
            } else {
                binaryStr = '0' + binaryStr;
            }
            
            num = num2;
            
        // 3. Repeat until number is 0
        } while( num != 0 );
        System.out.println(binaryStr);
        
		// 3. Compare the two binary values. Can you figure out what the << operator is for?
		
		// 4. Try shifting num 3 places.
		
		// FYI: Binary values can be shifted to the right as well using the >> operator.	
	}
}
