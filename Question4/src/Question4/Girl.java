package Question4;

import java.util.*;


public class Girl
{
	public String name = new String(new char[Constants.MAX_NAME_LENGTH]);
	public int attractiveness;
	public int maintainance_budget;
	public int intelligence_level;
	public int criterion;
	public int type;
	public int committed;
	public int happiness;
    

	//The function getHappiness in the Girl class is used to calculate the happiness of a girl with total gift cost and total gift_value as parameters.
	public final void getHappiness(int total_gifts, int total_gift_value)
	{
		if (type == Constants.CHOOSY) //These if else conditions ensure that happiness of the girls is calculated based on the type of girl i.e. CHOOSY, NORMAL or DESPERATE
		{
			 happiness = (int) Math.log(total_gifts - maintainance_budget);
			// happiness = 0;
		}
		else if (type == Constants.NORMAL)
		{
			happiness = (total_gifts - maintainance_budget) + total_gift_value;
		}
		else
		{
			happiness = (int)Math.exp((total_gifts - maintainance_budget) % 5);
		}
	}

    void copyFrom(Girl girl) {
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}