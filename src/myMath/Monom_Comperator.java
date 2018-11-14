package myMath;

import java.util.Comparator;

public class Monom_Comperator implements Comparator<Monom> {
	// ******** add your code below *********
	@Override
	public int compare(Monom m1, Monom m2) {
		if(m1.get_power() > m2.get_power())
			return 1;
		else if(m1.get_power() == m2.get_power())
		{
			if (m1.get_coefficient()>m2.get_coefficient())
				return 1;
			else if (m1.get_coefficient()==m2.get_coefficient()) 
				return 0;
			else 
				return -1;
		}

		else
			return -1;
	}

}



