
public class BitBag {
	
	int bitPattern;
	private String strBitPattern;
	
	public Bit() {
		bitPattern = 0;
		strBitPattern = "";	
	}	
	
	public String decToBin() {
		StringBuilder sb = new StringBuilder();
		int bit = bitPattern;
		
		while(bit > 0) {
			if(bit % 2 == 0) sb.append("0");
			else sb.append("1");	
			bit /= 2;		
		}

		return sb.reverse().toString();
	}

	public int binToDec(String bin) {
		StringBuilder sb = new StringBuilder();
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
	
	public int getInt() {
		return bitPattern;	
	}

	// Sets the nth bit of the pattern
	public void set(int n) {
		int mask = (int) Math.pow(2, n);
		bitPattern = bitPattern | mask;
	}
	
	// Gets the nth bit of the pattern
	public int get(int n) {
		int mask = (int) Math.pow(2, n);
		return (bitPattern & mask) == 0 ? 0 : 1;	
	}

	// Clears the nth bit
	public void clear(int n) {
		int mask = ~(int) Math.pow(2, n);
		bitPattern = bitPattern & mask; 		
	}

	public void clearAll() {
		bitPattern = 0;	
	}

	public BitBag and(BitBag b) {
		return this.bitPattern & b.bitPattern;
	}

	public static void main(String[] args) {
		BitBag b = new BitBag();
		b.set(0);
		b.set(2);
		b.set(3);
			
		System.out.println(b.decToBin());
		b.clear(2);
		System.out.println(b.decToBin());
		b.clear(3);
		System.out.println(b.decToBin());
	}
}
