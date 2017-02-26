package ppl_assign;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MakeCouple
{
	public final void generateCouples() throws IOException
	{
		int i = 0;
		int j = 0;
		int selectIndex = -1;
		int couple_count = 0;
	boolean committed_flag = false;
	Boy[] boys = Arrays.initializeWithDefaultBoyInstances(Constants.NO_OF_BOYS);
	Girl[] girls = Arrays.initializeWithDefaultGirlInstances(Constants.NO_OF_GIRLS);
	Couple[] couples = Arrays.initializeWithDefaultCoupleInstances(Constants.NO_OF_GIRLS);
		FileReader file1 = new FileReader("boys.txt");
        BufferedReader buf =  new BufferedReader(file1);
                int temp = Integer.parseInt(buf.readLine());
                 String com = buf.readLine();
                while(i<= 149)
        {       
               boys[i].name = buf.readLine();
                    boys[i].attractiveness = Integer.parseInt(buf.readLine());
                    boys[i].budget = Integer.parseInt(buf.readLine());
                    boys[i].intelligence_level = Integer.parseInt(buf.readLine());
                    boys[i].min_attraction_requirement =Integer.parseInt(buf.readLine());
                    boys[i].type = Integer.parseInt(buf.readLine());
                    boys[i].committed = Integer.parseInt(buf.readLine());
                    com = buf.readLine();
			i++;
		}
		buf.close();

	
	i = 0;
	FileReader file = new FileReader("girls.txt");
        BufferedReader buff =  new BufferedReader(file);
      

        	temp = Integer.parseInt(buff.readLine());
                 com = buff.readLine();
		System.out.print("Program is working\n");
		while(i<= 149)
                {
			        girls[i].name = buff.readLine();
                                girls[i].attractiveness = Integer.parseInt(buff.readLine());
                                girls[i].maintainance_budget = Integer.parseInt(buff.readLine());
                                girls[i].intelligence_level =Integer.parseInt(buff.readLine());
                                girls[i].criterion =Integer.parseInt(buff.readLine());
                                girls[i].type = Integer.parseInt(buff.readLine());
                                girls[i].committed = Integer.parseInt(buff.readLine());
                               com = buff.readLine();
                                i++;

		}
		buff.close();
	File list = new File("couples.txt");
         FileWriter Out = new FileWriter(list);
	Out.write (" | "+"    Boys       " + " | " + "     Girls      " +"| \n");
         Out.write (" ------------------------------------- "+"\n");
	for (i = 0;i < Constants.NO_OF_GIRLS;i++)
	{
		
		for (j = 0;j < Constants.NO_OF_BOYS;j++)
		{
			if (boys[j].committed == 1 || girls[i].maintainance_budget > boys[j].budget || girls[i].attractiveness < boys[j].min_attraction_requirement)
			{
				continue;
			}
			else
			{
				committed_flag = true;
				if (selectIndex == -1)
				{
					selectIndex = j;
				}
				if (girls[i].criterion == Constants.MOST_ATTRACTIVE)
				{
					if (boys[j].attractiveness > boys[selectIndex].attractiveness)
					{
						selectIndex = j;
					}
				}
				if (girls[i].criterion == Constants.MOST_RICH)
				{
					if (boys[j].budget > boys[selectIndex].budget)
					{
						selectIndex = j;
					}
				}
				if (girls[i].criterion == Constants.MOST_INTELLIGENT)
				{
					if (boys[j].intelligence_level > boys[selectIndex].intelligence_level)
					{
						selectIndex = j;
					}
				}
			}
		}
		if (committed_flag == true)
		{
			boys[selectIndex].committed = 1;
			girls[i].committed = 1;

                        couples[couple_count].boy = boys[selectIndex];
			couples[couple_count].boy.copyFrom(boys[selectIndex]);
 
                        couples[couple_count].girl = girls[i];
			couples[couple_count].girl.copyFrom(girls[i]);
			couple_count++;
			committed_flag = false;
		     
		Out.write (" | "+boys[selectIndex].name + " | " + girls[i].name +" | \n");
                Out.write (" ------------------------------------- "+"\n");
 
		}
               
                
		selectIndex = -1;

	}
        Out.close(); 

	}
}


