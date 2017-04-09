package question3;
public class Boy extends Gift
{
	public String name = new String(new char[Constants.MAX_NAME_LENGTH]);
	//public int attractiveness;
	//public int budget;
	//public int intelligence_level;
	public int min_attraction_requirement;
	
        int budget;
	public final void getHappiness(Girl girl_friend, int total_gifts)
	{
		if (type == Constants.MISER)
		{
			happiness = budget - total_gifts;
			// happiness = 0;

		}
		else if (type == Constants.GENEROUS)
		{
			happiness = girl_friend.happiness;
			//happiness = 0;
		}

		else
		{
			happiness = girl_friend.intelligence_level;
		}
	}

    void copyFrom(Boy boy) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
