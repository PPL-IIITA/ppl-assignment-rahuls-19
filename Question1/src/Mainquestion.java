package ppl_assign;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.random;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mainquestion
{
	public static void main(String[] args) throws IOException
	{
              boy_generator();
               girl_generator();
                MakeCouple generator = new MakeCouple();
           
                generator.generateCouples();
           
           
        }

	public static void boy_generator () throws FileNotFoundException, IOException
	{
                Random rand = new Random();
                Boy[] boys = Arrays.initializeWithDefaultBoyInstances(Constants.NO_OF_BOYS);
                int i;
                int nameLength;
                int j;
                for (i = 0;i < Constants.NO_OF_BOYS;i++)
                    
                {
                    String str = "abcdefghiklmnopqrtuvwxyzQWERTYUIOPLKMJNHBGVFCDXSZA";
                    StringBuilder sb = new StringBuilder();
                    
                    for (j = 0;j < Constants.MAX_NAME_LENGTH - 1;j++)
                    {
                        sb.append(str.charAt(rand.nextInt(48)));
                    
                    }
                    boys[i].name = sb.toString();
                    boys[i].attractiveness = rand.nextInt(10000) % 10;
                    boys[i].budget = rand.nextInt(10000) % 5000;
                    boys[i].intelligence_level = rand.nextInt(10000) % 100;
                    boys[i].min_attraction_requirement = rand.nextInt(10000) % 10;
                    boys[i].type = rand.nextInt(10000) % 3;
                    boys[i].committed = 0;
                                        
                }       File List =  new File("boys.txt");
               FileWriter file = new FileWriter(List);
                
                
               int n = 60;
               file.write(n+"\n");
               file.write("----------------------------------------------------" + "\n" );
                for (i = 0;i < Constants.NO_OF_BOYS;i++)
                {       try {
                    file.write(boys[i].name + "\n" +boys[i].attractiveness+ "\n"+ boys[i].budget + "\n" + boys[i].intelligence_level +"\n" + boys[i].min_attraction_requirement + "\n" + boys[i].type + "\n" + boys[i].committed + "\n");
                    
                    file.write("----------------------------------------------------" + "\n" );
                } catch (IOException ex) {
                    Logger.getLogger(Mainquestion.class.getName()).log(Level.SEVERE, null, ex);
                }
	}       file.close();
            
             
	}

	public static void gift_generator()
	{   Random rand = new Random();
		
		Gift[] gifts = Arrays.initializeWithDefaultGiftInstances(Constants.NO_OF_GIFTS);
		for (int i = 0;i < Constants.NO_OF_GIFTS;i++)
		{
			gifts[i].price = rand.nextInt(10000) % 1000;
			gifts[i].value = rand.nextInt(10000) % 1000;
			gifts[i].type = rand.nextInt(10000) % 3;
		}
	}

	public static void girl_generator() throws IOException
	{
	
	Girl[] girls = Arrays.initializeWithDefaultGirlInstances(Constants.NO_OF_GIRLS);
	int i;
	int nameLength;
	int j;
        Random rand = new Random();
	for (i = 0;i < Constants.NO_OF_GIRLS;i++)
	{
             String str = "abcdefghiklmnopqrtuvwxyzAQZWSXEDCRFVTGBYHNUJMIKLO";
            StringBuilder sb = new StringBuilder();
		for (j = 0;j < Constants.MAX_NAME_LENGTH - 1;j++)
		{
                     sb.append(str.charAt(rand.nextInt(48)));
			
		}
		girls[i].name = sb.toString();
		girls[i].attractiveness = rand.nextInt(10000) % 10;
		girls[i].maintainance_budget = rand.nextInt(10000) % 5000;
		girls[i].intelligence_level = rand.nextInt(10000) % 100;
		girls[i].criterion = rand.nextInt(10000) % 3;
		girls[i].type = rand.nextInt(10000) % 3;
		girls[i].committed = 0;

	}
        File List = new File("girls.txt");
        FileWriter file = new FileWriter(List);
	
	int m = 60;
        file.write(m + "\n");
        file.write("----------------------------------------------------" + "\n" );
	for (i = 0;i < Constants.NO_OF_GIRLS;i++)
	{       
            file.write ( girls[i].name + "\n" + girls[i].attractiveness + "\n" + girls[i].maintainance_budget + "\n" + girls[i].intelligence_level + "\n" + girls[i].criterion + "\n" + girls[i].type + "\n" + girls[i].committed + "\n");
             
            file.write("----------------------------------------------------" + "\n" );
	}
	file.close();
        }
	
}