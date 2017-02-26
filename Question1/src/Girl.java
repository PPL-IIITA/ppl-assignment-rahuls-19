package ppl_assign;
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
	public final void getHappiness(int total_gifts, int total_gift_value)
	{
		if (type == Constants.CHOOSY)
		{
			happiness = (int) Math.log(total_gifts - maintainance_budget);
		}
		else if (type == Constants.NORMAL)
		{
			happiness = total_gifts - maintainance_budget + total_gift_value;
		}
		else
		{
			happiness = (int)Math.exp((total_gifts - maintainance_budget)) % 10;
		}
	}

   

    void copyFrom(Girl girl) {
        
    }

}