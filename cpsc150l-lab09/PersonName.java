/*
 * This is a class that contains methods relating to names of people.
 * @author Your magnificent lab TA.
 */
public class PersonName {
    /*
     * This method counts the number of names inside of a name.
     * @param wholename The name to parse.
     * @return The number of names in wholename.
     */
    public int numberNames(String wholeName)
    {
        int numNames = 0;
        wholeName = wholeName.trim();
        
        if(wholeName.length() != 0)
           {
               numNames = 1;
           }
           
        for(int i = 0; i < wholeName.length(); i++)
        {
           if(wholeName.charAt(i) == ' ' && wholeName.charAt(i + 1) != ' ')
           {
               numNames ++;
           }
        }
        return numNames;
    }
    /*
     * The method you can use to check your code's output.
     * This is what you will turn into various jUnit tests in Ex 2.
     */
    public static void main(String[] args)
    {
        PersonName one = new PersonName();

        System.out.println("'Bobby Smith' has "+one.numberNames("Bobby Smith")+" name.");
        System.out.println("'Bobby L. Smith' has "+one.numberNames("Bobby L. Smith")+" name.");
        System.out.println("'  Bobby  Paul Smith Jr.  ' has "+one.numberNames("  Bobby  Paul Smith Jr.  ")+" name.");
        System.out.println("'Bobby has "+one.numberNames("Bobby")+" name.");
        System.out.println("'' has "+one.numberNames("")+" name.");
    }
}
