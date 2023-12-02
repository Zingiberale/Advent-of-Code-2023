import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1
{

	public static void main(String[] args)
    {
		BufferedReader reader;

		try
        {
			reader = new BufferedReader(new FileReader("text.txt"));
			String line = reader.readLine();
            int firstNumber;
            int lastNumber;
            String comboNumber = "";
            int totalNumber = 0;

			while (line != null)
            {
				//System.out.println(line);
                firstNumber = getFirstNumber(line);
                lastNumber = getLastNumber(line);
                //System.out.println(" for line " + line);
                //System.out.println(" first number is " + firstNumber);
                //System.out.println(" last number is " + lastNumber);
                comboNumber = Integer.toString(firstNumber) + Integer.toString(lastNumber);
                //System.out.println(" combined number is " + comboNumber);
                totalNumber = totalNumber + Integer.parseInt(comboNumber);
                //System.out.println(" new total number is " + totalNumber);
				line = reader.readLine();
			}

            System.out.println("Total Number is " + totalNumber);

			reader.close();
		} catch (IOException e)
        {
			e.printStackTrace();
		}
	}

    public static int getFirstNumber(String line)
    {
        int firstNumber = 0;
        for (int i=0; i < line.length(); i++)
        {
            try 
            {
                //firstNumber = Integer.parseInt(String.valueOf(line.charAt(i))); 
                //System.out.println(line.charAt(i) + " is a valid integer");
                //return firstNumber;
                return Integer.parseInt(String.valueOf(line.charAt(i)));
            }  
            catch (NumberFormatException e)
            { 
                //System.out.println(line.charAt(i) + " is not a valid integer"); 
            } 
        }
        System.out.println("No valid integers detected oh dear that's bad");
        return firstNumber;
    }

    public static int getLastNumber(String line)
    {
        char ch;
        int lastNumber = 0;
        String reverseLine = "";

        for (int i=0; i < line.length(); i++)
        {
            ch = line.charAt(i);
            reverseLine = ch + reverseLine;
        }
        //System.out.println("reverse line = " + reverseLine); 

        for (int i=0; i < reverseLine.length(); i++)
        {
            try 
            {
                //lastNumber = Integer.parseInt(String.valueOf(reverseLine.charAt(i))); 
                //System.out.println(reverseLine.charAt(i) + " is a valid integer");
                //return lastNumber;
                return Integer.parseInt(String.valueOf(reverseLine.charAt(i)));
            }  
            catch (NumberFormatException e)
            { 
                //System.out.println(reverseLine.charAt(i) + " is not a valid integer"); 
            } 
        }
        System.out.println("No valid integers detected oh dear that's bad");
        return lastNumber;
    }
}