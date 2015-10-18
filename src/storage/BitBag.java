package storage;

import java.util.Arrays;

public class BitBag {
	
	private int[] bitArray; // each slot holds 31 bits
	private int n; // array size
		
	public BitBag() {
		this(1);
	}

	public BitBag(int n) {
		bitArray = new int[n];
		this.n = n;
	}	
	
	// Binary representation of the array
	private String decToBin() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i : bitArray) {
	
			int zeros = 0;
			while(i > 0) {
				if(i % 2 == 0) sb.append("0");
				else sb.append("1");	
				i /= 2;
				zeros--;
			}
			// append zeros
			zeros += 31;
			while(zeros > 0) {
				sb.append("0");
				zeros--;
			}
			sb.append(" ");
		}
	
		sb.setLength(sb.length() - 1); // delete last white space

		return sb.toString();
	}

	public int binToDec(String bin) {
		
		int num = 0;
		int pos = 0;
		
		for(int i = bin.length() - 1; i >= 0; i --)  {
			
			if(bin.charAt(i) == '1') {
				num += (int) Math.pow(2, pos);
			}
			pos++;
		}
		
		return num;
	}

	// Sets the nth bit of the pattern
	public void set(int n) {
		if(n < 0) throw new IndexOutOfBoundsException("index < 0");
		if(n > (bitArray.length * 31) - 1) resize(n); // Expand array
		
		int mask = (int) Math.pow(2, n - (31 * (n/31)));
		
		bitArray[ n / 31 ] = bitArray[ n / 31 ] | mask;
	}
	
	private void resize(int n) {
		// Create a larger array
		int[] expanded = new int[ (n / 31) + 1];
		
		// Dump bitArray into expanded
		for(int i = 0; i < bitArray.length; i++) {
			expanded[i] = bitArray[i];
		}
		bitArray = expanded;
		this.n = bitArray.length;
	}

	// Gets the nth bit of the pattern
	public int get(int n) {
		if(n < 0) throw new IndexOutOfBoundsException("index < 0");
		if(n > (bitArray.length * 31) - 1) throw new IndexOutOfBoundsException("index > size");
			
		int mask = (int) Math.pow(2, n - (31 * (n/31)));
		return (bitArray[ n / 31 ] & mask) == 0 ? 0 : 1;	
	}

	// Clears the nth bit
	public void clear(int n) {
		int mask = ~(int) Math.pow(2, n - (31 * (n/31)));
		bitArray[ n / 31 ] = bitArray[ n / 31 ] & mask;
	}

	// Clear all bits in array
	public void clearAll() {
		bitArray = new int[n];	
	}
	
	@Override	
	public String toString() {
		return decToBin();		
	}

	// Prints the numerical form of the array
	public void printArray() {
		System.out.println(Arrays.toString(bitArray));	
	}
}