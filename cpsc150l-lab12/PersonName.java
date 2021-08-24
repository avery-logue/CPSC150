public class PersonName {
    private int numberOfNames;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffixName;

    public PersonName() {
        numberOfNames = 0;
        firstName = "";
        lastName = "";
        middleName = "";
        suffixName = "";
    }

    public PersonName(String wholeName) {
        String[] names = wholeName.split(" ");
        numberOfNames = names.length;

        if (numberOfNames == 1) {
            firstName = names[0].trim();
            middleName = "";
            lastName = "";
            suffixName = "";
        } 
        else if (numberOfNames == 2) {
            firstName = names[0].trim();
            lastName = names[1].trim();
            middleName = "";
            suffixName = "";
        } 
        else if (numberOfNames == 3) {
            firstName = names[0].trim();
            middleName = names[1].trim();
            lastName = names[2].trim();
            suffixName = "";
        } 
        else if (numberOfNames == 4) {
            firstName = names[0].trim();
            middleName = names[1].trim();
            lastName = names[2].trim();
            suffixName = names[3].trim();
        }
    }

    public void setFirstName(String name) {
        if(firstName == "")
            numberOfNames++;
            
        firstName = name.trim();   

    }

    public String getFirstName() {
        return firstName.trim();
    }

    public void setMiddleName(String name) {
        numberOfNames++;
        middleName = name.trim();
    }

    public String getMiddleName() {
        return middleName.trim();
    }

    public void setLastName(String name) {
        numberOfNames++;
        this.lastName = name.trim();
    }

    public String getLastName() {
        return lastName.trim();
    }

    public String getSuffixName() {
        return suffixName.trim();
    }

    public void setSuffixName(String name) {
        numberOfNames++;
        this.suffixName = name.trim();
    }

    public int getNumberOfNames() {
        return numberOfNames;
    }

    public String getEntireName(){
        if(numberOfNames == 1){
            return firstName;
        }
        else if(numberOfNames == 2){
            return firstName + " " + lastName;
        }
        else if(numberOfNames == 3){
            return firstName.trim()+ " " + middleName.trim() + " " + lastName.trim();
        }
        else{
            return firstName.trim()+ " " + middleName.trim() + " " + lastName.trim() + " " + suffixName.trim();
        }
    }

    public String getInitials(){
        String initial1 = firstName.substring(0, 1);
        String initial2 = "";
        String initial3 = "";

        if(middleName != ""){
            initial2 = middleName.substring(0,1);
        }
        if(lastName != ""){
            initial3 = lastName.substring(0,1);
        }
        return initial1 + initial2 + initial3;
    }
}