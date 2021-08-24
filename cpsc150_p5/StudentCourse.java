import java.util.ArrayList;
/**
 * Write a description of class StudentCourse here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentCourse {

    private String courseName;
    private ArrayList<Double> courseGrades;

    /**
     * Default constructor for StudentCourse. Creates an empty
     *     StudentCourse with an empty name and grades ArrayList.
     */
    public StudentCourse() {
        courseName = "";
        courseGrades = new ArrayList<Double>();
    }

    /**
     * Constructor for StudentCourse. Creates a StudentCourse
     *     with the given name and an empty grades ArrayList.
     *     
     * @param name - The name for the StudentCourse.
     */
    public StudentCourse(String name) {
        courseName = name;
        courseGrades = new ArrayList<Double>();
    }

    /**
     * Constructor for StudentCourse. Creates a StudentCourse
     *     with the given name and an empty grades ArrayList.
     *     
     * @param name   - The name for the StudentCourse.
     * @param grades - The ArrayList of grades for the StudentCourse.
     */
    public StudentCourse(String name, ArrayList<Double> grades) {
        courseName = name;
        if(grades != null) {
            courseGrades = grades;
            courseGrades = getGrades();
        }
        else
            courseGrades= new ArrayList<Double>();
    }

    /**
     * Gets the name of this StudentCourse.
     * 
     * @return - The name of this StudentCourse.
     */
    public String getName() {
        return courseName;
    }

    /**
     * Sets the name of this StudentCourse.
     * 
     * @param in - The name to set.
     */
    public void setName(String in) {
        courseName = in;
    }

    /**
     * Gets a deep copy of the list of grades.
     * 
     * @return - A deep copy of the list of grades.
     */
    public ArrayList<Double> getGrades() {
        ArrayList<Double> copy = new ArrayList<Double>();

        for (Double d : courseGrades)
            copy.add(d);

        return copy;
    }

    /**
     * Adds a grade to the list of grades for this course.
     * 
     * @param grade - The grade to add.
     */
    public void addGrade(double grade) {
        courseGrades.add(grade);
    }

    /**
     * Calculates the average grade from the list of grades.
     * 
     * @return - The average of the list of grades. Returns 0.0 if list is empty.
     */
    public double calcAverage() {
        double total = 0;
        double avg;

        if(courseGrades.isEmpty()) {
            return 0.0;
        }
        else {
            for(int i = 0 ; i < courseGrades.size() ; i++ ) {
                total += courseGrades.get(i);
            }

            avg = total / courseGrades.size();
            
            return avg;
        }
    }

    /**
     * Returns a String representation of this StudentCourse.
     * 
     * @return - <CourseName> <Grades>
     */
    public String toString() {
        return courseName + " " + courseGrades.toString();
    }

    /**
     * Determines if this StudentCourse is equal to another Object.
     *  
     * @param o - The other object.
     * 
     * @return  -  true if equal, false otherwise.
     */
    public boolean equals(Object o) {
        if (o.getClass().equals(this.getClass())) {
            StudentCourse other = (StudentCourse) o;
            if (!courseName.equalsIgnoreCase(other.courseName))
                return false;
            else {
                if (courseGrades.size() != other.courseGrades.size())
                    return false;
                else {
                    for (int i = 0; i < courseGrades.size(); i++)
                        if (!courseGrades.get(i).equals(other.courseGrades.get(i)))
                            return false;
                    return true;
                }
            }
        } else
            return false;
    }
}
 