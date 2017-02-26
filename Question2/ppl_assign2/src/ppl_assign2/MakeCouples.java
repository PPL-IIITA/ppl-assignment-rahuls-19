package ppl_assign2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MakeCouples
{
  

	public final void generateCouples() throws FileNotFoundException, IOException
	{
	/* Generating couples requires the function to read from the list of boys and girls from their respective files and then
	based on the criterion and preference as per the requirements, form couples */
	int i = 0;
	int j = 0;
	int selectIndex = -1;
	int couple_count = 0;
	boolean committed_flag = false;
        Boy[] boys = Arrays.initializeWithDefaultBoyInstances(Constants.NO_OF_BOYS);
	Girl[] girls = Arrays.initializeWithDefaultGirlInstances(Constants.NO_OF_GIRLS);
	Couple[] couples = Arrays.initializeWithDefaultCoupleInstances(Constants.NO_OF_GIRLS);
	// The file List_of_Boys.txt contains the list of randomly generated boys which is read and stored in the array.
	FileReader fi = new FileReader("List_of_boys.txt");
        BufferedReader buf = new BufferedReader(fi);
      
	int temp = Integer.parseInt(buf.readLine());

	     while(i<= 49)
                {       
                    boys[i].name = buf.readLine();
                    boys[i].attractiveness = Integer.parseInt(buf.readLine());
                    boys[i].budget = Integer.parseInt(buf.readLine());
                    boys[i].intelligence_level = Integer.parseInt(buf.readLine());
                    boys[i].min_attraction_requirement =Integer.parseInt(buf.readLine());
                    boys[i].type = Integer.parseInt(buf.readLine());
                    boys[i].committed = Integer.parseInt(buf.readLine());
                    //com = buf.readLine();
			i++;
		}
		buf.close();

	
	i = 0;
        FileReader file = new FileReader("List_of_girls.txt");
        BufferedReader buff =  new BufferedReader(file);
      

        	temp = Integer.parseInt(buff.readLine());

	while(i<= 49)
                {
			        girls[i].name = buff.readLine();
                                girls[i].attractiveness = Integer.parseInt(buff.readLine());
                                girls[i].maintainance_budget = Integer.parseInt(buff.readLine());
                                girls[i].intelligence_level =Integer.parseInt(buff.readLine());
                                girls[i].criterion =Integer.parseInt(buff.readLine());
                                girls[i].type = Integer.parseInt(buff.readLine());
                                girls[i].committed = Integer.parseInt(buff.readLine());
                               //com = buff.readLine();
                                i++;

		}
		buff.close();
                 File list = new File("couples.txt");
         FileWriter Out = new FileWriter(list);
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
			
                        Out.write(boys[selectIndex].name + "\n" + boys[selectIndex].attractiveness + "\n" + boys[selectIndex].budget + "\n" + boys[selectIndex].intelligence_level + "\n" + boys[selectIndex].min_attraction_requirement + "\n" +boys[selectIndex].type + "\n" + boys[selectIndex].committed + "\n" + girls[i].name + "\n" + girls[i].attractiveness + "\n" + girls[i].maintainance_budget +"\n" + girls[i].intelligence_level + "\n" + girls[i].criterion + "\n" +girls[i].type + "\n" + girls[i].committed + "\n");
		}
		selectIndex = -1;

	}
        Out.close(); 

	}

    /**
     *
     */
    public final void giveGifts()
	{
            try {
                int i = 0;
                int j;
                int couple_count;
                int minGiftIndex = 0;
                int moneySpent = 0;
                int moneyLeft;
                int maxGiftIndex = 0;
                boolean luxury_gift = false;
                Couple[] couples = Arrays.initializeWithDefaultCoupleInstances(100);
                
                Gift[] gifts = Arrays.initializeWithDefaultGiftInstances(200);
                FileReader fi = new FileReader("couples.txt");
                BufferedReader couples_file = new BufferedReader(fi);
               
                System.out.print("Hello\n");
                
                
                while (i < 49)
                {
                    
                    try {
                        couples[i].boy.name =couples_file.readLine();
                        couples[i].boy.attractiveness = Integer.parseInt(couples_file.readLine());
                        couples[i].boy.budget = Integer.parseInt(couples_file.readLine());
                        couples[i].boy.intelligence_level = Integer.parseInt(couples_file.readLine());
                        couples[i].boy.min_attraction_requirement = Integer.parseInt(couples_file.readLine());
                        couples[i].boy.type = Integer.parseInt(couples_file.readLine());
                        couples[i].boy.committed = Integer.parseInt(couples_file.readLine());
                        couples[i].girl.name = couples_file.readLine();
                        couples[i].girl.attractiveness = Integer.parseInt(couples_file.readLine());
                        couples[i].girl.maintainance_budget = Integer.parseInt(couples_file.readLine());
                        couples[i].girl.intelligence_level = Integer.parseInt(couples_file.readLine());
                        couples[i].girl.criterion = Integer.parseInt(couples_file.readLine());
                        couples[i].girl.type = Integer.parseInt(couples_file.readLine());
                        couples[i].girl.committed = Integer.parseInt(couples_file.readLine());
                     
                        i++;
                    } catch (IOException ex) {
                        Logger.getLogger(MakeCouples.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                couple_count = i;
                int[] total_cost = new int[200];
                int[] total_value = new int[200];
                couples_file.close();
                
                i = 0;
                
                FileReader fii = new FileReader("List_of_Gifts.txt");
                BufferedReader gifts_file = new BufferedReader(fii);
                while(i < 200){
                    
                    gifts[i].price = Integer.parseInt(gifts_file.readLine());
                    gifts[i].value =  Integer.parseInt(gifts_file.readLine());
                    gifts[i].type =  Integer.parseInt(gifts_file.readLine());
                    gifts[i].luxury_rating =  Integer.parseInt(gifts_file.readLine());
                    gifts[i].difficulty =  Integer.parseInt(gifts_file.readLine());
                    gifts[i].utility_value  =  Integer.parseInt(gifts_file.readLine());
                    gifts[i].utility_class = Integer.parseInt(gifts_file.readLine());
                    gifts[i].used =  Integer.parseInt(gifts_file.readLine());
                    System.out.println(gifts[i].price + gifts[i].value+ gifts[i].type+ gifts[i].luxury_rating+ gifts[i].difficulty+ gifts[i].utility_value+gifts[i].utility_class+gifts[i].used);
                    
                    i++;
                }
                
                
                for (i = 0;i < couple_count;i++)
                {
                    moneySpent = 0;
                    moneyLeft = couples[i].boy.budget;
                    luxury_gift = false;
                    if (i >= 1)
                    {
                        for (j = 0;j < 200;j++)
                        {
                            if (gifts[j].used == 0)
                            {
                                minGiftIndex = j;
                                break;
                            }
                        }
                    }
                    for (j = 0;j < 200;j++)
                    {
                        if (gifts[j].price < gifts[minGiftIndex].price && gifts[j].used == 0)
                        {
                            minGiftIndex = j;
                        }
                        if (gifts[j].price > gifts[maxGiftIndex].price && gifts[j].used == 0)
                        {
                            maxGiftIndex = j;
                        }
                    }
                    for (j = 0;j < 200;j++)
                    {
                        if (couples[i].boy.type == Constants.MISER)
                        {
                            if (gifts[j].used == 1 || gifts[minGiftIndex].price > couples[i].boy.budget || gifts[minGiftIndex].price > moneyLeft || moneySpent > couples[i].girl.maintainance_budget)
                            {
                                continue;
                            }
                            else
                            {
                                if (gifts[minGiftIndex].used == 0)
                                {
                                    gifts[minGiftIndex].used = 1;
                                    moneySpent += gifts[minGiftIndex].price;
                                    moneyLeft -= gifts[minGiftIndex].price;
                                    total_cost[i] += gifts[minGiftIndex].price;
                                    total_value[i] += gifts[minGiftIndex].value;
                                    System.out.print("Couple ");
                                    System.out.print(i);
                                    System.out.print(": Gift of price ");
                                    System.out.print(gifts[minGiftIndex].price);
                                    System.out.print("and value ");
                                    System.out.print(gifts[minGiftIndex].value);
                                    System.out.print(" was given by ");
                                    System.out.print(couples[i].boy.name);
                                    System.out.print(" to ");
                                    System.out.print(couples[i].girl.name);
                                    System.out.print("\n");
                                    System.out.print("MISER\n");
                                }
                                
                            }
                            
                        }
                        else if (couples[i].boy.type == Constants.GENEROUS)
                        {
                            if (gifts[j].used == 1 || gifts[j].price > couples[i].boy.budget || gifts[minGiftIndex].price > moneyLeft || moneySpent >= couples[i].girl.maintainance_budget)
                            {
                                continue;
                            }
                            else
                            {
                                gifts[j].used = 1;
                                moneySpent += gifts[j].price;
                                moneyLeft -= gifts[j].price;
                                total_cost[i] += gifts[j].price;
                                total_value[i] += gifts[j].value;
                                System.out.print("Couple ");
                                System.out.print(i);
                                System.out.print(": Gift of price ");
                                System.out.print(gifts[j].price);
                                System.out.print("and value ");
                                System.out.print(gifts[i].value);
                                System.out.print(" was given by ");
                                System.out.print(couples[i].boy.name);
                                System.out.print(" to ");
                                System.out.print(couples[i].girl.name);
                                System.out.print("\n");
                                System.out.print("GENEROUS\n");
                            }
                        }
                        else
                        {
                            if (gifts[j].used == 1 || gifts[minGiftIndex].price > couples[i].boy.budget || gifts[minGiftIndex].price > moneyLeft || moneySpent > couples[i].girl.maintainance_budget)
                            {
                                continue;
                            }
                            else
                            {
                                if (gifts[j].type == Constants.LUXURY && luxury_gift == false)
                                {
                                    gifts[j].used = 1;
                                    luxury_gift = true;
                                    moneySpent += gifts[j].price;
                                    moneyLeft -= gifts[j].price;
                                    total_cost[i] += gifts[j].price;
                                    total_value[i] += gifts[j].value;
                                    System.out.print("Couple ");
                                    System.out.print(i);
                                    System.out.print(": Gift of price ");
                                    System.out.print(gifts[j].price);
                                    System.out.print("and value ");
                                    System.out.print(gifts[i].value);
                                    System.out.print(" was given by ");
                                    System.out.print(couples[i].boy.name);
                                    System.out.print(" to ");
                                    System.out.print(couples[i].girl.name);
                                    System.out.print("\n");
                                    System.out.print("LUXURY\n");
                                }
                                else
                                {
                                    gifts[j].used = 1;
                                    moneySpent += gifts[j].price;
                                    moneyLeft -= gifts[j].price;
                                    total_cost[i] += gifts[j].price;
                                    total_value[i] += gifts[j].value;
                                    System.out.print("Couple ");
                                    System.out.print(i);
                                    System.out.print(": Gift of price ");
                                    System.out.print(gifts[j].price);
                                    System.out.print("and value ");
                                    System.out.print(gifts[i].value);
                                    System.out.print(" was given by ");
                                    System.out.print(couples[i].boy.name);
                                    System.out.print(" to ");
                                    System.out.print(couples[i].girl.name);
                                    System.out.print("\n");
                                    System.out.print("LUXURY\n");
                                }
                                
                            }
                        }
                    }
                }
                for (i = 0;i < couple_count;i++)
                {
                    couples[i].girl.getHappiness(total_cost[i], total_value[i]);
                    couples[i].boy.getHappiness(couples[i].girl, total_cost[i]);
                    couples[i].happiness = couples[i].boy.happiness + couples[i].girl.happiness;
                    System.out.print("Happiness of couple ");
                    System.out.print(i);
                    System.out.print("is ");
                    System.out.print(couples[i].boy.happiness);
                    System.out.print(" ");
                    System.out.print(couples[i].girl.happiness);
                    System.out.print(" ");
                    System.out.print(couples[i].happiness);
                    System.out.print("\n");
                    couples[i].find_compatibility();
                    
                }
                

                //Couple::k_happy(couples,couple_count,12);
                //Couple.k_happy(new Couple(couples), couple_count, 12);

              //  Couple::k_compatible(couples, couple_count, 12);
                //Couple.k_compatible(new Couple(couples), couple_count, 12);
            } catch (IOException ex) {
                Logger.getLogger(MakeCouples.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

    

}
