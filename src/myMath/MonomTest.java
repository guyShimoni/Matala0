package myMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonomTest {
	
	@Test
	public void testMonomMonom() {
		Monom junit1 = new Monom (4.5,6);
		assertEquals("4.5*x^6",junit1.toString());
	}

	@Test
	public void testGet_power() {
		Monom junit2 = new Monom (3,6);
		int s =junit2.get_power();
		assertEquals(6,s);
	}
	
	@Test
	public void testGet_coefficient() {
		Monom junit16 = new Monom (4,6);
		String d = ""+junit16.get_coefficient();
		assertEquals("4.0",d);
	}
	
	
	@Test
	public void testF() {
		Monom junit3 = new Monom (3,6);
		int a = (int) junit3.f(1);
		assertEquals(3,a);
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testNegative() {
		Monom junit4 = new Monom (3,-6);
		boolean ans= junit4.negative();
		assertFalse(ans);
	}
	
	@Test
	public void testAdd() {
		Monom junit5 = new Monom (3.0,3);
		Monom junit6 = new Monom (3.0,3);
		junit5.add(junit6);
		assertEquals("6.0*x^3",junit5.toString());
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testMultiply() {
		Monom junit7 = new Monom (3.0,3);
		Monom junit8 = new Monom (5.0,4);
		junit7.multiply(junit8);
		assertEquals("15.0*x^7",junit7.toString());
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testDerivatives() {
		Monom junit9 = new Monom (3,3);
		Monom junit10 = new Monom (junit9.derivatives());
		assertEquals("9.0*x^2",junit10.toString());
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testSubstract() {
		Monom junit14 = new Monom (3,3);
		Monom junit15 = new Monom (5,3);
		junit14.substract(junit15);
		assertEquals("-2.0*x^3",junit14.toString());
	//	fail("Not yet implemented");
	}

	@Test
	public void testEqualsMonom() {
		Monom junit11 = new Monom (3.0,4);
		Monom junit12 = new Monom (3.0,4);
		assertEquals(junit11.toString(),junit12.toString());
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testToString() {
		Monom junit13 = new Monom (3.0,4);
		assertEquals("3.0*x^4",junit13.toString());
		//fail("Not yet implemented");
	}

}
