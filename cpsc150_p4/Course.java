public class Course {

    private String name;
    private Time startTime;
    private Time endTime;
    private char[] days;
    private int nbrMeetingsPerWeek;

    /**
     * Default constructor for Course. This sets names to an empty string, days to an array of length 5, nbrMeetingsPerWeek to 0,
     *      startTime's hours and minutes to 0, and endtime's hours and minutes to 0.
     */
    public Course() {
        name = "";
        days = new char[5];
        nbrMeetingsPerWeek = 0;
        startTime = new Time();
        endTime = new Time();
    }
    
    /**
     * Constructor for Time. Sets hours to the first
     *     parameter, and minutes to the second parameter.
     *
     * @param courseName The name of the course
     * @param start The start time of the course
     * @param end The end time of the course
     * @param meetDays The days the course meets
     */
    public Course(String courseName, Time start, Time end, String meetDays) {

        name = courseName;

        startTime = start; //TODO: Copy?

        endTime = end; //TODO: Copy?
        
        days = new char[meetDays.length()];

        for (int i = 0; i < meetDays.length(); i++) {
            days[i] = meetDays.charAt(i);
            nbrMeetingsPerWeek++;
        }
    }
    
    /**
     * Formats the course in a String to "name: days startTime-endTime" with a newline
     * @returns courseString The formatted string
     */
    public String toString() {

        String courseString = "";

        for (int i = 0 ; i < days.length ; i++) {
            courseString += (name + ": " + days[i] + " " + startTime + "-" + endTime +'\n');
        }
        return courseString;
    }

}
