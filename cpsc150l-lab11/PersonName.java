public class PersonName
{
    private int numberOfNames;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffixName;

    public PersonName(){
        numberOfNames = 0;
        firstName = "";
        middleName = "";
        lastName = "";
        suffixName = "";
    }

    public PersonName (String wholeName){
        String[] names = wholeName.split(" ");
        numberOfNames = names.length;

        if(numberOfNames == 1)
        {
            firstName = names[0];
        }
        else if(numberOfNames == 2){
            firstName = names[0];
            lastName = names[1];
        }
        else if(numberOfNames == 3){
            firstName = names[0];
            middleName = names[1];
            lastName = names[2];
        }
        else if(numberOfNames == 4){
            firstName = names[0];
            middleName = names[1];
            lastName = names[2];
            suffixName = names[3];
        }
    }

}
