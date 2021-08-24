import java.util.ArrayList;

/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Student {
    private String studentName;
    private ArrayList<StudentCourse> courses;
    
    /**
     * Default constructor for Student.
     * Creates a new Student object with name of "no name"
     * and a empty ArrayList of courses.
     */
    public Student() {
        studentName = "no name";
        courses = new ArrayList<StudentCourse>();
    }
    
    /**
     * Constructor for Student.
     * Creates a new Student object with the given name
     * and an empty ArrayList of courses.
     * 
     * @param name - The name to be assigned to the Student
     */
    public Student(String name) {
        studentName = name;
        courses = new ArrayList<StudentCourse>();
    }
    
    /**
     * Gets the name of the Student.
     * 
     * @return The name of the student.
     */
    public String getName() {
        return studentName;
    }
    
    /**
     * Sets the name of the Student to the given name.
     * 
     * @param in - The given name.
     */
    public void setName(String in) {
        studentName = in;
    }
    
    /**
     * Gets a deep copy of the list of courses.
     * 
     * @return - A deep copy of courses. This is an ArrayList of type StudentCourse.
     */
    public ArrayList<StudentCourse> getCourses() {
        ArrayList<StudentCourse> copy = new ArrayList<StudentCourse>();

        for (StudentCourse c : courses)
            copy.add(new StudentCourse(c.getName(), c.getGrades()));

        return copy;
    }
    
    /**
     * Adds a new StudentCourse with the given name
     *     and list of grades to the list of courses.
     *     
     * @param name   - The name for the new course.
     * @param grades - The list of grades for the new course.
     */
    public void addCourse(String name, ArrayList<Double> grades) {
        courses.add(new StudentCourse(name, grades));
    }
    
    /**
     * Gets the average for a given course.
     * 
     * @param name - The name of the given course.
     * 
     * @return - The average for the course with course name name,
     *           or a negative number if not found.
     */
    public double getCourseAverage(String name){
        double total = 0;
        boolean isgrade = false;
        ArrayList<Double> grade = new ArrayList<Double>();
        double avg = 0.0;
        for(int i = 0 ; i < courses.size(); i++){
            if(name.equalsIgnoreCase(courses.get(i).getName())){
                isgrade = true;
                grade = ((courses.get(i)).getGrades());
            }
        }
        if(!isgrade)
            return -1;
        else{ 
            for(int j = 0 ; j < grade.size() ; j++ ){
                total += grade.get(j);
            }
            avg = total / grade.size();
            return avg;
        }
    }

    /**
     * Calculates the average of all courses in the list of courses.
     * This method calls StudentCourse's calcAverage method.
     * 
     * @return  - The average of all courses in the list of courses, 0.0 otherwise.
     */
    public double calcAverage() {
        if(courses.size() == 0)
            return 0.0;

        double total = 0.0;

        for(StudentCourse c : courses) {
            total += c.calcAverage();
        }

        double avg = total / courses.size();
        
        return avg;
    }

    /**
     * Returns a summary of the Student as a String.
     * This method is called when the user enters choice 5
     * from the main menu in P5's main method.
     * 
     * @return - *studentName* Average: *averageOfAllCourses* Courses: *courseNames*
     */
    public String getSummary() {
        if(courses.size() == 0) {
            return studentName + " Average: " + ( String.format("%.2f", calcAverage() ) ) + " Courses:";
        }
        
        String o = String.format(studentName + " Average: " + ( String.format("%.2f", calcAverage() ) ) + " Courses: ");
        
        for (int i = 0 ; i < courses.size(); i++) {
            if(i == courses.size() -1)
                o += courses.get(i).getName();
            else
                o += courses.get(i).getName() + " ";
        }
        return o;
    }

    /**
     * Returns a String representation of the Student object.
     * This method is called when the user enters choice 5
     * from the main menu in P5's main method.
     * 
     * @return "*studentName*: *courses*"
     */
    public String toString() {
        return studentName + ": " + courses.toString();
    }

    /**
     * Determines whether or not this equals another Object.
     *
     * @param o The other Object.
     * @return true if equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (o.getClass().equals(this.getClass())) {
            Student other = (Student) o;
            if (!this.studentName.equalsIgnoreCase(other.studentName))
                return false;
            else {
                if (this.courses.size() != other.courses.size())
                    return false;
                else {
                    for (int i = 0; i < this.courses.size(); i++)
                        if (!this.courses.get(i).equals(other.courses.get(i)))
                            return false;
                    return true;
                }
            }
        } else
            return false;
    }
}
