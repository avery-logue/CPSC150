/**
 * @author Avery Logue
 * @version 11/15/2017
 */
public class Person
{
    private PersonName name = new PersonName("");
    private int age = 0;
    
    public Person(){
        name = new PersonName("no name");
    }
    public Person(String aName, int anAge){
     name = new PersonName(aName);
     age = anAge;
    }
    public String getName(){
        String nameStr = name.getEntireName();
        return nameStr;
    }
    public void setName(String aName){
        name = new PersonName(aName);
    }
    public int getAge(){
        return age;   
    }
    public void setAge(int anAge){
        age = anAge;   
    }
    public boolean canDrive(){
        if(age >= 16)
            return true;
        else
            return false;
    }
    public static boolean canDrive(int anAge){
        if(anAge >= 16)
            return true;
        else
            return false;
    }
}
