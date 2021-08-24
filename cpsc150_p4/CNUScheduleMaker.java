import java.util.Scanner;
public class CNUScheduleMaker {
    private Course[] courses;
    private Scanner kbd = new Scanner(System.in);

    public CNUScheduleMaker(Scanner myKbd){
        kbd = myKbd;
    }

    public String getDays(String className){
        String days;
        boolean invalidDays = false;
        do{
            invalidDays = false;
            System.out.print("Enter the days that your class meets: M for Monday,T for Tuesday, W for Wednesday, R for Thursday and F for Friday --> ");
            days = kbd.next();
            days.toUpperCase();
            for ( int i = 0 ; i < days.length() && !invalidDays; i++ ){
                if(days.charAt(i) == ('M') || days.charAt(i) == ('T') || days.charAt(i) == ('W') || days.charAt(i) == ('R') || days.charAt(i) == ('F')){
                }
                else{
                    System.out.print(days.charAt(i) + " is not a valid day. ");
                    invalidDays = true;
                }
            }
        } while(invalidDays);

        return days;
    }

    public Time getStart(String courseName){
        System.out.print("What time does " + courseName + " start? --> "); 

        Time tempTime = new Time();

        return tempTime.readTime(kbd);
    }

    public Time getEnd(String courseName,Time startTime){
        System.out.print("How many minutes does " + courseName + " last? --> ");
        int len = kbd.nextInt();

        return startTime.addMinutes(len);
    }

    public void getInfo(){
        Time startTime = new Time();
        Time endTime = new Time();

        //int n = 0;
        System.out.print("How many courses are you taking? --> ");
        int numCourses = kbd.nextInt();
        Course[] courses = new Course[numCourses];

        for(int i = 0; i < numCourses; i ++){
            System.out.print("What is the name of class number " + i);
            String className = kbd.next();
            String days = getDays(className);
            startTime = getStart(className);
            endTime = getEnd(className, startTime);
            Course tempCourse = new Course(className, startTime, endTime, days);
            courses[i] = tempCourse;
        }
    }
    
    public void printSchedule() {
    }
    
    public static void main(String[ ] args) {
        Scanner kbd = new Scanner(System.in);
        CNUScheduleMaker mySchedule = new CNUScheduleMaker(kbd);
        mySchedule.getInfo( );
        mySchedule.printSchedule( );
    }

}
