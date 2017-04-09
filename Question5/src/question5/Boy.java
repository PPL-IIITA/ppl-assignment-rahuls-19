package question5;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Boy 
	
{
	public String name = new String(new char[Constants.MAX_NAME_LENGTH]);
	public int attractiveness;
	public int budget;
	public int intelligence_level;
	public int min_attraction_requirement;
	public int type;
	public int committed;
	public int happiness;
	public final void getHappiness(Girl girl_friend, int total_gifts)
	{
		if (type == Constants.MISER)
		{
			happiness = budget - total_gifts;
		}
		else if (type == Constants.GENEROUS)
		{
			happiness = girl_friend.happiness;
		}

		else
		{
			happiness = girl_friend.intelligence_level;
		}
	}


    void copyFrom(Boy boy) {

    }
}