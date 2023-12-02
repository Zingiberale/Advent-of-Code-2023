package Day_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day2
{
	public static void main(String[] args)
    {
		BufferedReader reader;
        try
        {
            int total = 0;

            reader = new BufferedReader(new FileReader("Day_2/text.txt"));
            String line = reader.readLine();

            while (line != null)
            {

                total = total + isLineValid(line);

                

                line = reader.readLine();
            }
            System.out.println("Total = " + total);
            reader.close();

        }            
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public static int isLineValid(String line)
    {
        line = line.replaceAll("[^a-zA-Z0-9 ]", "");

        String[] arr = line.split(" ");  

        
        
        int lineNumber = Integer.parseInt(arr[1]);

        //System.out.println(lineNumber);

        for (int i=2; i < arr.length; i = i + 2)
        {
            if (Integer.parseInt(arr[i]) >= 15)
            {
                return 0;
            }
            else if (Integer.parseInt(arr[i]) == 14)
            {
                if (arr[i + 1].equals("green") || arr[i + 1].equals("red"))
                    return 0;
            }
            else if (Integer.parseInt(arr[i]) == 13)
            {
                if (arr[i + 1].equals("red"))
                    return 0;
            }
        }
        return lineNumber;
    };
}