package myMath;
/**
 * This class represents a simple main class with some basic tests (not JUnit Testing - should be using Junit!!)
 * @author Efrat and Guy
 *
 */
public class TestMonom {
	public static void main(String[] args) {
		test_add();
		test_multiply();
		test_equals();
	}
	private static void test_equals() {
		double a1 = 2.5;
		int b1 = 2;
		Monom m1 = new Monom(a1,b1);
		Monom m2 = new Monom(a1,b1+1);
		Monom m3 = new Monom(a1+0.001,b1);
		Monom m4 = new Monom(m1);
		System.out.println(m1+" != "+m2);
		System.out.println(m1+" != "+m3);
		System.out.println(m1+" == "+m4);
		if(m1.equals(m2)) {
			System.err.println(m1+" != "+m2);
			throw new RuntimeException("Error: Monom equals method is wrong!");		
		}
		if(m1.equals(m3)) {
			System.err.println(m1+" != "+m3);
			throw new RuntimeException("Error: Monom equals method is wrong!");		
		}
		if(!m1.equals(m4)) {
			System.err.println(m1+" == "+m4);
			throw new RuntimeException("Error: Monom equals method is wrong!");		
		}
	}
	private static void test_multiply() {
		double a1 = 2.5, a2 = 3;
		int b1 = 2, b2 = 4;
		Monom m1 = new Monom(a1,b1);
		Monom m2 = new Monom(a2,b2);
		Monom m3 = new Monom(m1);
		m3.multiply(m2);

		System.out.println(m1+" * "+m2+" = "+m3);
		Monom m4 = new Monom(a1*a2, b1+b2);
		if(!m3.equals(m4)) {
			System.err.println(m3+" != "+m4);
			throw new RuntimeException("Error: Monom s method is wrong!");		
		}
	}
	private static void test_add() {
		//	double a1 = 2.5;
		//	int b1 = 2;
		Monom m1 = new Monom(3.0,4);
		Monom m3 = new Monom(1.0,1);
		m3.add(m1);
		System.out.println(""+m3);

		//	System.out.println(m1+" + "+m1+" = "+m3);
		//	Monom m4 = new Monom(a1+a1, b1);
		//	if(!m3.equals(m4)) {
		//		System.err.println(m3+" != "+m4);
		//		throw new RuntimeException("Error: Monom add method is wrong!");		
	}
}

