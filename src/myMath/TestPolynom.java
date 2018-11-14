package myMath;

public class TestPolynom {
	public static void main(String[] args) {
		tmultiply();
		troot();
		tadd();
		tequals();	
	}
	private static Polynom create_random_polynom(int c) {
		Polynom newpoly = new Polynom();
		for(int i=0;i<c;i++) {
			double a = (Math.random()-0.5)*1000;
			a = (int)a;
			a = a/50;
			Monom m1 = new Monom(a,i);
			newpoly.add(m1);
		}
		return newpoly;
	}
	private static void tequals() {
		Polynom newp1 = create_random_polynom(4);
		Polynom newp2 = create_random_polynom(5);
		Polynom newp11 = new Polynom();
		newp11.add(newp1);
		if(newp1.equals(newp2)) {
			System.err.println(newp1+" != "+newp2);
	
		}
		if(newp1.equals(newp2)) {
			System.err.println(newp1+" == "+newp11);

		}
	}
	private static void tadd() {
		Polynom newp1 = create_random_polynom(4);
		Polynom newp2 = create_random_polynom(5);
		Polynom newp3 = new Polynom();
		newp3.add(newp2);
		System.out.println(newp1+" + ");
		System.out.println(newp2+" = ");
		System.out.println(newp3);
	}
	private static void tmultiply() {
		Polynom newp1 = create_random_polynom(2);
		Polynom newp2 = create_random_polynom(3);
		Polynom newp3 = new Polynom();
		newp3.add(newp2);
		newp3.multiply(newp1);
		System.out.println(newp1+" * ");
		System.out.println(newp2+" = ");
		System.out.println(newp3);
		newp3.substract(newp1);
		System.out.println(newp3);
		

	}	
	private static void troot() {
		Polynom newp1 = create_random_polynom(2);
		Monom newm1 = new Monom(-1000,0);
		Monom newm2 = new Monom(1,3);
		newp1.add(newm1);
		newp1.add(newm2);
		double a = newp1.root(0, 100, 0.01);
		System.out.println(a);
	}
}
