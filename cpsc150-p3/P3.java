
/**
 * Write a description of class P3 here.
 *
 * @author William Dzubak
 * @author Avery Logue
 * 
 * @version Last Updated October 24th, 2017
 */

import java.util.Scanner;

public class P3
{
    public static void main(String[ ] args)
    {
        Scanner kbd = new Scanner(System.in);
        
        System.out.print("How many courses are you taking? ");
        int nbrCourses = kbd.nextInt( );
        
        // there will be a max of 5 class meetings for each course,
        // so the size of the array is nbrCourses * 5
        
        int[ ] startTime = new int[nbrCourses*5];
        
        int[ ] endTime = new int[nbrCourses*5];
        
        String[ ] names = new String[nbrCourses*5];
        
        char[ ] days = new char[nbrCourses*5];
        
        // the actual number of class meetings is nbrTimes
        int nbrTimes = getInfo(kbd, startTime, endTime, names, days, nbrCourses );
        
        printSchedule(startTime, endTime, names, days, nbrTimes );
    }
    
    public static String toTime(int time)
    {
        String timeStr = Integer.toString(time);
        
        if(time < 10)
            timeStr = ("00:0" + time);
            
        else
            timeStr = String.format("%02d", time / 100) + ":" + (time % 100);
        
        return timeStr;
    }
    
    public static int getStart(Scanner kbd, String courseName, char day)
    {
        System.out.println("What time does " + courseName + " start on " + day + "? Enter time as an " +
                            "integer with a 24 hour clock (e.g., 2:15pm would be entered as 1415) -> ");
                            
        int time = kbd.nextInt();
        
        return time;
    }
    
    public static int calcEnd(int begin, int length) //begin = 930 length = 50
    {
        int beginHours = begin / 100; //beginHours = 9
        int beginMinutes = begin % 100; //beginMinutes = 30
        
        int totMinutes = beginMinutes + length; //totMinutes = 80
        
        int finalTime;
        
        if(totMinutes < 60)
        {
            finalTime = (beginHours * 100) + totMinutes; 
            return finalTime;
        }
        else
        {
            int tempHours = totMinutes / 60; //tempHours = 1
            int tempMinutes = totMinutes % 60; //tempMinutes = 20
            int totHours = (beginHours + tempHours) * 100; //totHours = 1000
            
            finalTime = totHours + tempMinutes; //finalTime = 1020
            
            return finalTime;
        }
    }
    
    public static int getEnd(Scanner kbd, int startTime, String courseName, char day)
    {
        System.out.println("How many minutes does " + courseName + " last on " + day + "? --> ");
        
        int length = kbd.nextInt();
        
        int endTime = calcEnd(startTime, length);
        
        return endTime;
    }
    
    public static String getDays(Scanner kbd, String className)
    {
        String days;
        boolean invalidDays = false;
        do
        {
            System.out.print("Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday --> ");
            days = kbd.nextLine();
            
            for ( int i = 0 ; i < days.length() ; i++ )
            {
                if(days.charAt(i) == ('M') || days.charAt(i) == ('T') || days.charAt(i) == ('W') || days.charAt(i) == ('R') || days.charAt(i) == ('F'))
                {
                    invalidDays = false;
                    break;
                }
                else
                {
                    System.out.print(days.charAt(i) + " is not a valid day. ");
                    invalidDays = true;
                }
            }
        } while(invalidDays);
        
        return days;
    }
    
    public static int getInfo(Scanner kbd, int [ ] startTime, int[ ] endTime,
                              String[ ] names, char[ ] dayInSched, int nbrCourses )
    {
        return 5; //FIXME
    }
    
    public static void printSchedule(int[ ] startTime, int[ ] endTime,
                                     String[ ] names, char[ ] days, int length)
    {
        //FIXME
    }
}
