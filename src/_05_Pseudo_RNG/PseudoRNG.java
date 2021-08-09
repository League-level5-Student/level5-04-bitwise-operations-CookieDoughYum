package _05_Pseudo_RNG;

public class PseudoRNG {
	/*
	 * It is impossible for a computer to come up with a series of numbers 
	 * that are truly random. They can, however, use mathematical algorithms
	 * to generate numbers that can seem random. These are called pseudo random 
	 * numbers.
	 * 
	 */
	
	//1. Create a member variable of type long called "seed"
	long seed;
	//2. Make a constructor that initializes the memeber variable
	PseudoRNG(long seed){
		this.seed=seed;
	}
	//3. Complete the steps inside the xorShift method
	
	//4. Complete the steps in the main method
	
	//5. Write your own pseudo random generation method. You can use the xor
	//    shift as a guide. Use the main method to test it.
	
	
	
	// This is called the xor shift. It is a very simple algorithm to generate
	// Pseudo random numbers. 
	long xorShift(){
		//1. Create a local long called seed and set it equal to the member variable 
		//   We will only use the local variable for the rest of the method
		long seed1=seed;
		//2. Shift seed to the left 13 bits and save the result
		long shifted13=seed1 << 13;
		//3. xor seed by the result of step 1 and save that result
		long xor=seed1 ^ shifted13;
		//4. Set seed equal to the result of step 2
	    seed1=xor;
		//5. Shift seed to the right 7 bits and save the result
		long shifted7=seed1 >> 7;
		//6. xor seed by the result of step 4 and save that result
		long xor1=seed1 ^ shifted7;		
		//7. Set seed equal to the result of step 5
		seed1=xor1;
		//8. Shift seed to the left 17 bits and save the result
		long shifted17=seed1 << 17;
		//9. xor seed by the result of step 7 and save that result
		long xor2=seed1 ^ shifted17;		
		//10. Set seed equal to the result of step 8
		seed1=xor2;
		//11. change the line below to return seed
		return seed1;
	
	}
	
	
	
	public static void main(String[] args) {
	
		//1. Create a PseudoRNG object with any seed. 
		PseudoRNG a=new PseudoRNG(1276389);
		long[] randomNums=new long[3];
		//2. Print the result of xorShift() 3 times and note the random numbers. 
		for(int i=0; i<3; i++) {
			randomNums[i]=a.xorShift();
		}
		//3. Create a second PSeudoRNG object with a different seed and print the result of xorShift 3 times.
		PseudoRNG b=new PseudoRNG(2698365);
		for(int j=0; j<3; j++) {
			b.xorShift();
		}
		//4. Run the tests a second time and notice that 3 random numbers are the same because the seed generates the same sequence of random numbers.
		
		//If you would like to set the seed with a number that is hard to predict, you can use System.currentTimeMillis().
	
	}
}


