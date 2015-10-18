package storage.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import storage.BitBag;

public class BitBagTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testSet() {
				
		// 31 zeros 0000000000000000000000000000000
		
		BitBag b = new BitBag();
		b.set(4);
		b.set(5);
		b.set(12);
		b.set(20);
		b.set(30);
		b.set(126);
		Assert.assertEquals(b.toString(), "0000110000001000000010000000001 "
				+ "0000000000000000000000000000000 0000000000000000000000000000000 "
				+ "0000000000000000000000000000000 0010000000000000000000000000000");
	}
	
	@Test
	public void testGet() {
		BitBag b = new BitBag();
				
		b.set(0);
		b.set(5);
		b.set(30);
		b.set(1000000);
		
		Assert.assertEquals("Get set bit", 
				b.get(0), 1);
		Assert.assertEquals("Get set bit", 
				b.get(5), 1);
		Assert.assertEquals("Get set bit", 
				b.get(30), 1);
		Assert.assertEquals("Get set bit", 
				b.get(1000000), 1);
		Assert.assertEquals("Get clear bit", 
				b.get(20), 0);
		Assert.assertEquals("Get clear bit", 
				b.get(129), 0);
	}
	
	@Test
	public void testClear() {
				
		BitBag b = new BitBag();
		b.set(12);
		b.set(30);
		
		b.clear(12);
		Assert.assertEquals("Clear a set bit",
				b.toString(), "0000000000000000000000000000001");
		
		b.clear(12);
		Assert.assertEquals("Clear a clear bit",
				b.toString(), "0000000000000000000000000000001");
		
		b.clear(30);
		Assert.assertEquals("Clear a set bit on the edge of the array",
				b.toString(), "0000000000000000000000000000000");
		
		b.set(4);
		b.set(5);
		b.set(12);
		b.set(20);
		b.set(30);
		b.set(126);
		
		b.clear(30);
		Assert.assertEquals("Clear a set bit in a larger array",
				b.toString(), "0000110000001000000010000000000 "
						+ "0000000000000000000000000000000 0000000000000000000000000000000 "
						+ "0000000000000000000000000000000 0010000000000000000000000000000");
	}
	
	@Test
	public void testClearAll() {
		BitBag b = new BitBag();
		
		b.set(0);
		b.set(5);
		b.set(12);
		b.set(15);
		b.set(24);
		b.set(30);
		b.clearAll();
		Assert.assertEquals("31-bit", 
				b.toString(), "0000000000000000000000000000000");
		
		b = new BitBag();
		b.set(0);
		b.set(5);
		b.set(12);
		b.set(40);
		b.set(52);
		b.set(61);
		b.clearAll();
		Assert.assertEquals("62-bit", 
				b.toString(), "0000000000000000000000000000000 0000000000000000000000000000000");
	}
	
	@Test
	public void testOutOfBoundsSet() {
		BitBag b = new BitBag();
		
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("index < 0");
		b.set(-1);
	}
	
	@Test
	public void testOutOfBoundsGet() {
		BitBag b = new BitBag();
		
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("index < 0");
		b.get(-1);
		
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("index > size");
		b.get(500000000);
	}

}