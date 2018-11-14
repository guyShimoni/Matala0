package myMath;


/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Efrat and Guy
 *
 */
public class Monom implements function{
	
	private double _coefficient; 
	private int _power; 

	public Monom()
	{

	}
	
	public Monom(double a, int b){
		this.set_coefficient(a);//להגדיר מקדם
		this.set_power(b);// להגדיר חזקה
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	public int get_power() {
		return _power;
	}
	public double get_coefficient() {
		return _coefficient;
	}
	private void set_coefficient(double a){
		this._coefficient = a;
	}

	private void set_power(int b) {
		this._power = b;
	}
	
	@Override
	public double f(double x) {
		return get_coefficient()*(Math.pow(x,get_power()));
	}
	
	//בדיקה האם החזקה שלילית ובדיקה האם המקדם הוא אפס כי זה מספר ממשי
	public boolean negative(){
		boolean ans= true;
		if (this.get_power()<0 || this.get_coefficient()==0){
			ans= false;
		}
		return ans;
	}
	//חיבור בין שני מונומים
	public void add(Monom m) {
		if (this.get_power()==m.get_power()){
			set_coefficient(this.get_coefficient() + m.get_coefficient());
		}
		else {
			this.add(m);
			System.out.print("Error, the power are differant!");
		}
	}
	//כפל בין שני מונומים
	public void multiply(Monom m){
		this.set_coefficient(this.get_coefficient()*m.get_coefficient());
		this.set_power(this.get_power()+m.get_power());
	}

	// נגזרת של מונום
	public Monom derivatives(){
		double coefficient = this.get_coefficient()*this.get_power();
		int power = this.get_power()-1;
		return new Monom(coefficient,power);
	}
	//חיסור בין שני מונומים
	public void substract(Monom m){
		if (this.get_power()==m.get_power()){
			this.set_coefficient(this.get_coefficient() - m.get_coefficient());
		}
		else {
			System.out.print("Error, the power are differant!");
		}
	}
	public boolean equals(Monom m) {
		boolean same=false;
		if (this.get_coefficient()==m.get_coefficient() && this.get_power()==m.get_power()){
			same=true;
		}
		return same;
	}


	@Override
	public String toString() {
		if (this.get_power()==0)
			return ""+ this.get_coefficient()+"*x^0";
		if (this.get_power()==1)
			return ""+ this.get_coefficient()+"*x^1";
		if (this.get_coefficient()==0)
			return "";
		else
			return "" + this.get_coefficient() + "*x^"+ this.get_power();
		
			}	

}
