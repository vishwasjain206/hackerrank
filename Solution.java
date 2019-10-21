import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        Map <Integer,Integer> hm = new HashMap <Integer,Integer> ();
        hm.put(1, 31);
        hm.put(2, 28);
        hm.put(3, 31);
        hm.put(4, 30);
        hm.put(5, 31);
        hm.put(6, 30);
        hm.put(7, 31);
        hm.put(8, 31);
        
        if (year != 1918)
        {
            int day=0;
            int month=1;
            while (256 - day > 31)
            {
                day = day + hm.get(month);
                month ++;
                
            }
            int diff = 0;
            if (day < 256)
            {
                if (256 - day <= 30)
                {
                    diff = 256 - day; 
                }
                if (256 - day == 31)
                {
                    if (hm.get(month) == 31)
                    {
                        
                        diff = 31;
                    }
                    else if (hm.get(month) == 30)
                    {
                        diff = 1;
                        month = month + 1;
                    }
                }
            }

            int day1 ;
            day1 = diff;
            if (leapYear(year))
            {
                if (day1 != 1)
                {day1 = day1 - 1;}
                else 
                {month = month - 1;
                day1=hm.get(month);

                }
            }
             String datetoken= Integer.toString(day1)  + "." +  "0"  + Integer.toString(month) + "." + Integer.toString(year);
            return datetoken;
        }
        else if (year == 1918)
        {
            return "26.09.1918";
            
        }
        return null;


    }
    static boolean leapYear(int year){
        if (year < 1918) 
        {
            if (year % 4 == 0)
            {
                return true;
            }
            else return false;
        }
        else 
        {
            if (year % 400 == 0)
            {
                return true;
            }
            else if ((year % 4 == 0 ) && (year % 100 != 0 ))
            {
                return true;
            }
            return false;
        }   
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
