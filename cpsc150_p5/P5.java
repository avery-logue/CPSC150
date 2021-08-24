import java.util.Scanner;
import java.util.ArrayList;

public class P5 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        char choice;
        System.out.println("This program manages students and their courses.");
        do {
            choice = showMenu(kbd);
            if (choice == '1') {
                Student s = readStudent(kbd);
                students.add(s);
            } else if (choice == '2') {
                double average = calcAverage(students);
                System.out.println(String.format("The average for all students is %.2f", average));
            } else if (choice == '3')
                printStudentReport(kbd, students);
            else if (choice == '4')
                printCourseReport(kbd, students);
            else if (choice == '5')
                printAllStudentReport(students);
            else if (choice != '6') // bad choice entered
                System.out.println("Choice must be 1-6.");
            System.out.println();
        } while (choice != '6');
        System.out.println("*** Program exiting ***");
    }

    public static char showMenu(Scanner kbd) {
        System.out.print("Would you like to:\n\t" +
            "1. Add a student\n\t2. Calculate an average for all students\n\t" +
            "3. Print a report for a student\n\t4. Print a report for a class"
            + "\n\t5. Print a report for all students\n\t6.Quit\nEnter choice --> ");
        char o = kbd.next().charAt(0);
        System.out.println();
        return o;
    }

    /**
     * Adds a new Student, prompting the user to
     * enter a name of the Student, the courses
     * which the Student is taking, and the grades
     * that the Student has for each course.
     * Option 1 from the menu will call this method.
     * 
     * @param kbd - The Scanner from which we read
     *              in the name, courses, and grades.
     *              
     * @return - A new Student with the information
     *           that the user entered.
     */
    public static Student readStudent(Scanner kbd) {
        System.out.print("What is the student's name --> "); 
        String name = kbd.next();
        Student s = new Student(name);

        System.out.println("Enter information about " + name + "'s courses.");
        String course = "";
        int grade = -999;

        for (int i = 1 ; !course.equalsIgnoreCase("done") ; i++) {
            System.out.print("Enter the name of the course " + i + " (Enter 'done' to stop) --> ");
            course = kbd.next();

            if(!course.equalsIgnoreCase("done")) {
                System.out.print("Enter the grades for " + name + " in " + course + "(-1 to stop) -->");

                ArrayList<Double> grades = new ArrayList<Double>();
                grade = 0;
                while(grade >= 0) {
                    grade = kbd.nextInt(); // if >= 0 add it
                    if (grade >= 0) {
                        double dGrade = (double)grade;
                        grades.add(dGrade);
                    }
                }
                s.addCourse(course, grades);
            }
        }

        return s;
    }

    /**
     * Calculates the average of all the Students in
     * the given ArrayList. Option 1 from the menu
     * will call this method.
     * 
     * @param students - The ArrayList of Students to
     *                   calculate the average of.
     *              
     * @return - The average of all Students in the 
     *           ArrayList students if it is not empty,
     *           0.0 otherwise.
     */
    public static double calcAverage(ArrayList<Student> students) {
        if(students.size() == 0)
            return 0.0;
        double total = 0.0;
        for(Student s : students) {
            total += s.calcAverage();
        }

        double avg = total / students.size();

        return avg;
    }

    /**
     * Prints a summary a single Student in the
     * given ArrayList. The Student is searched
     * for, and if found, a summary is printed.
     * If the student is not found, it will print
     * a message saying so. Option 3 from the menu
     * will call this method.
     * 
     * @param kbd      - The Scanner from which we read
     *                   in the name, courses, and grades.
     * @param students - The ArrayList of Students to
     *                   search through and print the
     *                   summary of.
     */
    public static void printStudentReport(Scanner kbd, ArrayList<Student> students) {
        System.out.print("Enter the name of the student that you would like to find a report for --> ");
        String student = kbd.next();

        boolean found = false;
        int num = 0;

        for(int i = 0 ; i < students.size() ; i++) {
            if(students.get(i).getName().equalsIgnoreCase(student)) {
                found = true;
                num = i;
            }
        }

        if(found)
            System.out.println("Student Report: " + students.get(num).getSummary());
        else
            System.out.println("Name not found.");
    }

    /**
     * Prompts the user to enter a course, and
     * then prints the average of grades from all
     * Students across that course. If the user
     * enters a course that is not recognized, an
     * error message saying so will print. Option
     * 4 from the menu will call this method.
     * 
     * @param kbd      - The Scanner from which we read
     *                   in the course name.
     * @param students - The ArrayList of Students that
     *                   is searched through to obtain
     *                   the information that is printed.
     * 
     */
    public static void printCourseReport(Scanner kbd, ArrayList<Student> students) {
        System.out.print("Enter the course that you would like to print a report for --> ");
        String course = kbd.next();

        ArrayList<Double> totalList = new ArrayList<Double>();
        boolean found = false;
        double total = 0.0;
        int counter = 0;

        for(int i = 0 ; i < students.size(); i++) {
            ArrayList<StudentCourse> courses = students.get(i).getCourses();
            for(int j = 0; j < courses.size(); j++) {
                if(course.equalsIgnoreCase(courses.get(j).getName())) {
                    found = true;
                    ArrayList<Double> tempList = courses.get(j).getGrades();
                    for(int k = 0 ; k < courses.get(j).getGrades().size(); k++) {
                        totalList.add(tempList.get(k));
                        counter++;
                    }
                }
            }
        }

        if(!found) {
            System.out.println("Course not found.");
            return;
        }
        else {
            for(double d : totalList) {
                total += d;
            }
            double avg = total / counter;
            String o = String.format("Average for " + course + " across all students is %.2f", avg);
            System.out.println(o);
        }
    }

    /**
     * Prints a student report for all Students
     * in the given ArrayList called students.
     * Prints an error message if the given
     * ArrayList is empty.
     * 
     * @param students - The given ArrayList of
     *                   Students whose summaries
     *                   are printed.
     */
    public static void printAllStudentReport(ArrayList<Student> students) {
        if(students.size() == 0) {
            System.out.println("There are no students yet.");
        }
        //Access each students information and store into ArrayLists.
        for(Student s: students) {
            String o = ""; // start output string
            o += s.getName() + ": ["; //name of Student
            ArrayList<StudentCourse> courses = s.getCourses(); //get the courses that the Student is taking
            boolean outerLast = false; //last element variable for outer loop: this checks if the element
                                       //    being viewed is the last element in the ArrayList, so the program
                                       //    knows whether or not to put a bracket after it or not.
                                       
            int outerCount = 0; //Counter variable for outer loop: this counts each iteration and is
                                //    used in a conditional statement to set the value of outerLast.
            for(StudentCourse c: courses) {
                o += c.getName() + " ["; //name of course
                outerCount++; //increment outerCount
                ArrayList<Double> grades = c.getGrades(); //gets the grades ArrayList that
                                                          //Student s has for StudentCourse c
                boolean innerLast = false; //last element variable for inner loop: does the same
                                           //    as the outerLast variable
                int innerCount = 0; //counter variable for inner loop: does
                                    //    the same as the outerCount variable
                for(Double g: grades) {
                    o += g; //adds each grade to the output string
                    innerCount++; //increments innerCount
                    innerLast = (innerCount == grades.size()); //sets the boolean condition
                    if (!innerLast) //if this is NOT the last element in grades
                        o += ", "; //DON'T add bracket at end
                    else //if this IS the last element in grades
                        o += "]"; //ADD bracket at end
                }
                outerLast = (outerCount == courses.size()); //sets the boolean condition
                if(!outerLast) //if this is NOT the last element in courses
                    o += ", "; //DON'T add bracket at end
                else //if this IS the last element in courses
                    o += "]"; //ADD bracket at end
            }
            System.out.println(o); //print student, ending with newline
        }
    }
}