package myMath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Efrat and Guy
 *
 */
public class Polynom implements Polynom_able{
	// ********** add your code below ***********
	private ArrayList<Monom> polymonom = new ArrayList<Monom>();
	private final Monom_Comperator cmpBypower = new Monom_Comperator();

	public Polynom()
	{

	}

	//הדפסת הפולינום אם מדובר בפולינום האפס תחזיר אפס אחרת תחזיר את הפולינום
	public Polynom(String str)
	{
		if (str!="")
		{
			String strArr[];
			strArr=str.split("\\+");
			String strArr2[];
			for (int i = 0; i < strArr.length; i++) {
				if (!strArr[i].contains("^"))
				{
					if (strArr[i].contains("*"))
						strArr2=strArr[i].split(Pattern.quote("*x"));
					else
						strArr2=strArr[i].split(Pattern.quote("x"));
				}
				else if (!strArr[i].contains("*")) {
					if (strArr[i].contains("^"))
						strArr2=strArr[i].split(Pattern.quote("x^"));
					else
						strArr2=strArr[i].split("x");
				}
				else
					strArr2=strArr[i].split(Pattern.quote("*x^"));
				double co;
				if (strArr2[0].equals("")) co=1;
			    if (strArr2[0].equals("-")){
					if (strArr2.length==2){
						String a = "-";
						a +=strArr2[1];
						co=Double.parseDouble(a);
					}
					else co=1;
				}
			    
				else
					co=Double.parseDouble(strArr2[0]);
				int power;
				if (strArr2.length==1)
					power = 0;
				else
					power=Integer.parseInt(strArr2[1]);
				Monom m = new Monom (co,power);
				add(m);
			}
		}
	}	



	//פולינום הוא חיבור של מספר מונומים f(x) = a_1X^b_1 + a_2*X^b_2 ... a_n*Xb_n,
	@Override
	public double f(double x) {
		double sum=0;
		Iterator<Monom> it = polymonom.iterator();
		while(it.hasNext())
		{
			Monom m = it.next();
			sum += m.f(x);
		}
		return sum;
	}



	//מתודה המוסיפה פולינום לפולינום קיים
	@Override
	public void add(Polynom_able p1) {
		Iterator<Monom> it = p1.iteretor();
		while(it.hasNext())
		{
			Monom m1 = it.next();
			this.add(m1);
		}
	}

	//הוספת מונום לפולינום קיים
	@Override
	public void add(Monom m1) {
		boolean samep = false;
		Iterator<Monom>iter= this.iteretor();
		while(iter.hasNext()) {
			Monom m = iter.next();
			if(m.get_power()==m1.get_power()) { // the power are the same
				m.add(m1);
				samep = true;
			}
		}
		if(samep==false) {//אם לא מצאתי מונום בעל אותה חזקה אז תוסיף אותו כמו שהוא לפולינום
			this.polymonom.add(m1);
			this.polymonom.sort(cmpBypower);// מיון הפולינום מחדש לפי חזקות
		}
	}

	public void substract(Polynom_able p1) {
		Iterator<Monom> it = p1.iteretor();
		while(it.hasNext())
		{
			Monom m1 = it.next();
			this.substract(m1);
		}
	}
	//החסרת מונום לפולינום קיים
	public void substract(Monom m1) {
		boolean samep = false;
		Iterator<Monom>iter= this.iteretor();
		while(iter.hasNext()) {
			Monom m = iter.next();
			if(m.get_power()==m1.get_power()) { // the power are the same
				m.substract(m1);
				samep = true;
			}
		}
		if(samep==false) {//אם לא מצאתי מונום בעל אותה חזקה אז תוסיף אותו כמו שהוא לפולינום
			this.polymonom.add(m1);
			this.polymonom.sort(cmpBypower);// מיון הפולינום מחדש לפי חזקות
		}
	}



	//הכפלת פולינום קיים בפולינום אחר
	@Override
	public void multiply(Polynom_able p1) {
		Polynom newpolynom = multiply(this,p1);
		this.polymonom = newpolynom.polymonom;
	}


	//פונקציית עזר - הכפלת שני פולינומים
	public static Polynom multiply(Polynom_able p1, Polynom_able p2) {
		Iterator<Monom> it2 = p2.iteretor();
		Polynom newpolynom = new Polynom();
		if (p1.isZero()) return (Polynom)p2;
		else if (p2.isZero()) return (Polynom)p1;
		while(it2.hasNext()){
			Polynom poly = new Polynom(p1.toString());
			Monom m=it2.next();
			poly.multiply(m);
			newpolynom.add(poly);
		}
		return newpolynom;
	}


	// פונקציית עזר - הכפלת מונום בפולינום
	public void multiply(Monom m){
		Iterator<Monom> it1 = this.iteretor();
		if (m.get_coefficient()==0){
			this.polymonom.clear();
		}
		else {
			while (it1.hasNext()){
				Monom m1 = it1.next();
				m1.multiply(m);
			}
		}
	}

	// האם פולינום  שווה לפולינום הקיים
	@Override
	public boolean equals(Polynom_able p1) {
		boolean same = true;
		Iterator<Monom> it1 = this.iteretor();
		Iterator<Monom> it2 = p1.iteretor();
		if (this.size() == p1.size())
			while (it2.hasNext()){
				Monom m = it1.next();
				Monom m1=it2.next();
				if (!m.equals(m1)){
					same = false;
					return same;
				}
			}
		return same;
	}


	// פונקציית עזר לבדיקת גודל פולינום
	public int size(){
		return this.polymonom.size();
	}

	//בדיקה האם מדובר בפולינום האפס
	@Override
	public boolean isZero() {
		boolean zero= true;
		if (this.polymonom.size()!=0){
			zero= false;
		}
		return zero;
	}



	//חישוב שורש הפולינום 
	@Override
	public double root(double x0, double x1, double eps) {
		double y0 = f(x0);
		double y1 = f(x1);

		try {
			if (y0*y1>0) throw new Exception("there is no root");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		double x2 = (x0+x1)/2;
		double y2 = f(x2);

		if (Math.abs(y2)<Math.abs(eps)) return x2;
		if (y0 < 0)
		{
			if (y2>0)
			{
				return root(x0,x2,eps);
			}
			else
			{
				return root(x2,x1,eps);
			}
		}
		else
		{
			if (y2>0)
			{
				return root (x2,x1,eps);
			}
			else
			{
				return root (x0,x2,eps);
			}
		}
	}


	//מתודת העתקה עמוקה של פולינום
	@Override
	public Polynom_able copy() {
		Polynom copyp=new Polynom();
		Iterator<Monom> it = this.iteretor();
		while(it.hasNext()) {
			Monom m1 = it.next();
			copyp.add(new Monom(m1));
		}
		return copyp;
	}


	// חישוב נגזרת של פולינום
	@Override
	public Polynom_able derivative() {
		Polynom p1=new Polynom();
		Iterator<Monom> it = this.iteretor();
		while(it.hasNext()) {
			Monom m1 = it.next().derivatives();
			p1.add(m1);
		}
		return p1;
	}


	// חישוב שטח,מחשב את אינטגרל רימן
	@Override
	public double area(double x0, double x1, double eps) {
		double rectangleNumber = (x1-x0)/eps;
		double sum = 0;
		for (int i = 0; i < rectangleNumber; i++) {
			sum+=eps*f(x0+i*eps);
		}
		return sum;
	}


	@Override
	public Iterator<Monom> iteretor() {
		Iterator <Monom> iter = polymonom.iterator();
		return iter;
	}


	@Override
	public String toString() {
		String polynom = "";
		for (int i = 0; i < polymonom.size(); i++) {
			if (polymonom.get(i).get_coefficient()!=0){
				polynom += polymonom.get(i);
				if (i<polymonom.size()-1)
					polynom+="+";
			}
		}
		if (polynom == ""){
			polynom = "0";
			return polynom;
		}
		return polynom;
	}

}