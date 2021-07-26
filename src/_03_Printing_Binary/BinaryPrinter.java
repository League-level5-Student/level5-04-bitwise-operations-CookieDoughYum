package _03_Printing_Binary;

public class BinaryPrinter {
	/*
	 * Complete the methods below so they print the passed in parameter in binary.
	 * Do not use the Integer.toBinaryString method!
	 * Use the main method to test your methods.
	 */
	public static void printByteBinary(byte b) {
		// We first want to print the bit in the one's place
		// Shift b seven bits to the right
		System.out.print((b >> 7) & 1); 
		System.out.print((b >> 6) & 1);
		System.out.print((b >> 5) & 1);
		System.out.print((b >> 4) & 1);
		System.out.print((b >> 3) & 1);
		System.out.print((b >> 2) & 1);
		System.out.print((b >> 1) & 1);
		System.out.print((b >> 0) & 1);
		// Use the & operator to "mask" the bit in the one's place
		// This can be done by "anding" (&) it with the value of 1
		
		// Print the result using System.out.print (NOT System.out.println)
		
		//Use this method to print the remaining 7 bits of b
	}
	
	public static void printShortBinary(short s) {
		// Create 2 byte variables
		byte b=0;
		byte d=0;
		// Use bit shifting and masking (&) to save the first
		// 8 bits of s in one byte, and the second 8 bits of
		// s in the other byte
		b=(byte) (s & 0b11111111);
		d=(byte) ((s >> 8) & 0b11111111);
		// Call printByteBinary twice using the two bytes
		// Make sure they are in the correct order
		System.out.println();
		printByteBinary(b);
		System.out.println();
		printByteBinary(d);
	}
	
	public static void printIntBinary(int i) {
		// Create 2 short variables
		short a=0;
		short b=0;
		// Use bit shifting and masking (&) to save the first
		// 16 bits of i in one short, and the second 16 bits of
		// i in the other short
		a=(short) (i & 0xFFFF);
		b=(short) ((i >> 16) & 0xFFFF);
		// Call printShortBinary twice using the two short variables
		// Make sure they are in the correct order
		System.out.println();
		printShortBinary(a);
		System.out.println();
		printShortBinary(b);
	}
	
	public static void printLongBinary(long l) {
		// Use the same method as before to complete this method
		long c=0;
		long f=0;
		// Use bit shifting and masking (&) to save the first
		// 16 bits of i in one short, and the second 16 bits of
		// i in the other short
		c=(int) (l & 0xFFFFFFFF);
		f=(int) ((l >> 32) & 0xFFFFFFFF);
		// Call printShortBinary twice using the two short variables
		// Make sure they are in the correct order
		System.out.println();
		printIntBinary((int) c);
		System.out.println();
		printIntBinary((int) f);
	}
	
	public static void main(String[] args) {
		// Test your methods here
		printByteBinary((byte) 500);
		printShortBinary((short)500);
		printIntBinary(100000);
		printLongBinary((long)Long.MAX_VALUE-5);
	}
}
