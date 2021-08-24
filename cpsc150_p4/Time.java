public class Time {

    private int hour;
    private int minute;

    /**
     * Default constructor for Time. This sets both hours and minutes to 0.
     */
    public Time() {
        hour = 0;
        minute = 0;
    }

    /**
     * Constructor for Time. Sets hours to the first
     *     parameter, and minutes to the second parameter.
     *
     * @param Hours    The number to be stored in hour, representing the hours of Time.
     * @param Minutes  The number to be stored in minute, representing the minutes of Time.
     */
    public Time(int Hours, int Minutes) {
        hour = Hours;
        minute = Minutes;
    }

    /**
     * This method creates a new Time object whose time is its time
     *     plus a user specified number of minutes.
     *
     * @param addMinutes
     *
     * @return addedTime - The Time object with addMinutes added to it.
     */
    public Time addMinutes(int addMinutes) {
        Time addedTime;
        
        int beginHours = hour;
        int beginMinutes = minute;
        
        int totMinutes = addMinutes + beginMinutes;
        
        int finalHours;
        int finalMinutes;
        
        if (totMinutes < 60) {
            finalHours = beginHours;
            addedTime = new Time(finalHours, totMinutes);
        }
        else {
            int tempHours = totMinutes / 60;
            int tempMinutes = totMinutes % 60;
            int totHours = beginHours + tempHours;
            
            addedTime = new Time(totHours, tempMinutes);
        }

        return addedTime;
    }

    /**
     * Gets the hours in a course.
     * @return the hours in a course.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Gets the minutes in a course.
     * @return the minutes in a course.
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Formats the time in a String to "HH:MM".
     * @return the time formatted as "HH:MM".
     */
    public String toString() {
        String time = "";
        
        String hourStr = Integer.toString(hour);
        String minStr = Integer.toString(minute);
        
        if(hourStr.length() == 1 && minStr.length() == 1)
            time = "0" + hourStr + ":" + "0" + minStr;
        else if (hourStr.length() == 2 && minStr.length() == 1)
            time = hourStr + ":" + "0" + minStr;
        else if (hourStr.length() == 1 && minStr.length() == 2)
            time = "0" + hourStr + ":" + minStr;
        else if (hourStr.length() == 2 && minStr.length() == 2)
            time = hourStr + ":" + minStr;
        
            return time;
    }

    /**
     * This method reads in a time from a Scanner (of form HHMM or HH:MM) and returns it as a Time object.
     *
     * @param scnr The Scanner from which we read in the time.
     * @return The Time contained in the Scanner.
     */
    public static Time readTime(java.util.Scanner scnr) {
        String s = scnr.next();
        if (isNumber(s)) {
            int nbr = Integer.parseInt(s);
            int minutes = nbr % 100;
            int hours = nbr / 100;
            return new Time(hours, minutes);
        }
        int colonIndex = s.indexOf(':');
        if (colonIndex == -1) {
            System.out.println("Invalid time format");
            System.exit(1);
        }
        int hours = Integer.parseInt(s.substring(0, colonIndex));
        int minutes = Integer.parseInt(s.substring(colonIndex + 1));
        return new Time(hours, minutes);
    }

    /**
     * Returns true if String is a number, false otherwise
     * Is static because it does not use any instance variables
     * isNumber("123") returns true. isNumber("1L") returns false.
     * Note: This method uses exceptions, which we will not learn this
     * semester.
     *
     * @param str String to check
     * @returns true if str holds a number, false otherwise
     */
    public static boolean isNumber(String str) {
        try {
            int nbr = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
