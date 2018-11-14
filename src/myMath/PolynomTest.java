package myMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomTest {


	@Test
	public void testPolynomString() {
		Polynom junit19 = new Polynom ("2.0*x^1+3.0*x^2+1.0*x^3");
		assertEquals("2.0*x^1+3.0*x^2+1.0*x^3",junit19.toString());
	}
	
	@Test
	public void testF() {
		Polynom junit20 = new Polynom ("3*x^1+-3*x^2+1*x^3");
		int a = (int)junit20.f(1);
		assertEquals(1,a);
	}
	
	
	@Test
	public void testAddPolynom_able() {
	Polynom unit1= new Polynom ("3.0*x^2+5.0*x^7");
	Polynom unit2=new Polynom ("7.0*x^8");
	 unit1.add(unit2);
		String s = "3.0*x^2+5.0*x^7+7.0*x^8";
		assertEquals(s,unit1.toString());
		
	}
	
	@Test
	public void testAddMonom() {
	Polynom unit21= new Polynom ("4*x^6+5*x^7");
	Polynom unit22=new Polynom ("5*x^8");
	 unit21.add(unit22);
		String s1 = "4.0*x^6+5.0*x^7+5.0*x^8";
		assertEquals(s1,unit21.toString());
		
	}
	
	
	@Test
	public void testSubstractPolynom_able() {
		Polynom junit3 = new Polynom ("3.0*x^1+3.0*x^2+2.0*x^3+2.0*x^4");
		Polynom junit4 = new Polynom ("2.0*x^1+2.0*x^2+1.0*x^3");
		junit3.substract(junit4);
		assertEquals("1.0*x^1+1.0*x^2+1.0*x^3+2.0*x^4",junit3.toString());
	}
	
	
	@Test
	public void testSubstractMonom() {
		Polynom unit33= new Polynom ("4*x^6+5*x^7");
		Polynom unit44=new Polynom ("2*x^6");
		 unit33.substract(unit44);
			String s1 = "2.0*x^6+5.0*x^7";
			assertEquals(s1,unit33.toString());
	}
	
	@Test
	public void testMultiplyPolynom_able() {
		Polynom junit5 = new Polynom ("3.0*x^0+3.0*x^2");
		Polynom junit6 = new Polynom ("2.0*x^0+2.0*x^2");
		junit5.multiply(junit6);
		assertEquals("6.0*x^0+12.0*x^2+6.0*x^4",junit5.toString());
	
	}
	
	@Test
	public void testMultiplyPolynom_ablePolynom_able() {
		Polynom junit7 = new Polynom ("3.0*x^0+3.0*x^2");
		Polynom junit8 = new Polynom ("2.0*x^0+2.0*x^2");
		assertEquals("6.0*x^0+12.0*x^2+6.0*x^4",Polynom.multiply(junit7,junit8).toString());
	}
	

	@Test
	public void testMultiplyMonom() {
		Polynom junit9 = new Polynom ("3.0*x^0+3.0*x^2");
		Monom junit10 = new Monom (2.0,0);
		junit9.multiply(junit10);
		assertEquals("6.0*x^0+6.0*x^2",junit9.toString());
	}
	

	@Test
	public void testEqualsPolynom_able() {
		Polynom junit11 = new Polynom ("3.0*x^0+2.0*x^2");
		Polynom junit12 = new Polynom ("3.0*x^0+2.0*x^2");
		assertTrue(junit11.equals(junit12));

	}
	@Test
	public void testSize() {
		Polynom junit13 = new Polynom ("3.0*x^0+2.0*x^2+4.5*x^3");
		assertEquals(3,junit13.size());
	}
	
	@Test
	public void testIsZero() {
		Polynom junit14 = new Polynom ("");
		assertTrue(junit14.isZero());
	}
	//איך מחזירים מספר ממשי?
	@Test
	public void testRoot() {
		Polynom junit15 = new Polynom ("-3.0*x^0+1.0*x^2");
		int f = (int)junit15.root(1, 2, 0.01);
		assertEquals(1,f);
	}
	
	@Test
	public void testCopy() {
		Polynom junit16 = new Polynom ("3.0*x^0+2.0*x^2+4.5*x^3");
		Polynom junit17 = new Polynom ("-3.0*x^0+1.0*x^2");
		junit17 =(Polynom)junit16.copy() ;
		assertEquals("3.0*x^0+2.0*x^2+4.5*x^3",junit17.toString());
		
	}
	
	@Test
	public void testDerivative() {
		Polynom junit18 = new Polynom ("3.0*x^0+2.0*x^2+4*x^3");
		String w = ""+junit18.derivative();
		assertEquals("4.0*x^1+12.0*x^2",w);
	}
	
	//איך מחזירים מספר ממשי?
	@Test
	public void testArea() {
		Polynom junit23 = new Polynom ("-3.0*x^0+1.0*x^2");
		int r = (int)junit23.area(0, 1, 0.01);
		assertEquals(-2,r);
		
	}

	@Test
	public void testToString() {
		Polynom junit24 = new Polynom ("3.0*x^0+2.0*x^2+4*x^3");
		assertEquals("3.0*x^0+2.0*x^2+4.0*x^3",junit24.toString());
	}
	

}

