package ppl_assign2;

public class Couple
{
	public Boy boy = new Boy();
	public Girl girl = new Girl();
	public int happiness;
	public int compatibility;

  /*  Couple(Couple[] couples) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
 

   /* Couple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/   

    /*Couple(Couple[] couples) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    */

    Couple() {
//       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Couple(Couple[] couples) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   



	//The find_compatibility() function calculates the comaptibility of a particular couple by using the formula as given.
	public final void find_compatibility()
	{
		compatibility = (boy.budget - girl.maintainance_budget) + Math.abs(boy.attractiveness - girl.attractiveness) + Math.abs(girl.intelligence_level - boy.intelligence_level);
	}

	//The k_happy function accepts an array of couples and the value entered by the user,k
	public static void k_happy(Couple[] couples, int n, int k)
	{
		int[] done = new int[200];
		int maxHappyIndex = 0; //The function finds out the k-happiest couples and then prints them in order.
		int i;
		int j;
		for (i = 0;i < k;i++)
		{
			for (j = 0;j < n;j++)
			{
				if (done[j] == 0)
				{
					maxHappyIndex = j;
					break;
				}
			}
			for (j = 0;j < n;j++)
			{
				if (done[j] == 0 && couples[j].happiness > couples[maxHappyIndex].happiness)
				{
					maxHappyIndex = j;

				}
			}
			System.out.print(couples[maxHappyIndex].boy.name);
			System.out.print(" ");
			System.out.print(couples[maxHappyIndex].girl.name);
			System.out.print(" ");
			System.out.print(couples[maxHappyIndex].happiness);
			System.out.print("\n");
			done[maxHappyIndex] = 1;
		}
	}

	//The k_compatible function accepts an array of couples and the value entered by the user,k
	public final void k_compatible(Couple[] couples, int n, int k)
	{
		int[] done = new int[200];
		int maxCompatibleIndex = 0; //The function finds out the k most compatible couples and then prints them in order.
		int i;
		int j;
		for (i = 0;i < k;i++)
		{
			for (j = 0;j < n;j++)
			{
				if (done[j] == 0)
				{
					maxCompatibleIndex = j;
					break;
				}
			}
			for (j = 0;j < n;j++)
			{
				if (done[j] == 0 && couples[j].compatibility > couples[maxCompatibleIndex].compatibility)
				{
					maxCompatibleIndex = j;

				}
			}
			System.out.print(couples[maxCompatibleIndex].boy.name);
			System.out.print(" ");
			System.out.print(couples[maxCompatibleIndex].girl.name);
			System.out.print(" ");
			System.out.print(couples[maxCompatibleIndex].compatibility);
			System.out.print("\n");
			done[maxCompatibleIndex] = 1;
		}
	}
}