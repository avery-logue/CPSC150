public class Car
{
    private Person driver;
    private Person[] passengers;

    public Car(){
        driver = null;
        passengers = new Person[4];
    }

    public Car(int aCapacity){
        driver = null;
        if(aCapacity < 4)
            passengers = new Person[4];
        else if(aCapacity > 8)
            passengers = new Person[8];
        else
            passengers = new Person[aCapacity];
    }

    public int getCapacity(){
        return passengers.length;
    }

    public int getOccupancy(){
        int numpeople = 0;
        for(int i = 0; i < passengers.length; i ++)
            if(passengers[i] != null)
                numpeople++;
        return numpeople;   
    }

    public boolean hasRoom(){
        if(getOccupancy() == getCapacity())
            return true;
        return false;
    }

    public Person getDriver(){
        if(driver == null)
            return null;
        return driver;
    }

    public boolean hasPassenger(Person person){
        boolean isPassenger = false;
        if(person == null)
            isPassenger = false;
        for(int i = 0; i < passengers.length; i++){
            if(person.equals(passengers[i]))
                isPassenger = true;
        }
        return isPassenger;
    }

    public boolean setDriver(Person person){
        if(person == null)
            return false;
        if(!hasRoom())
            return false;
        if(canDrive(person) && hasPassenger(person))
            return true;
        return false;
    }

    public Person[] getPassengers(){
        Person[] copy = new Person[passengers.length];

        for(int i = 0; i < passengers.length; i ++)
            copy[i] = passengers[i];

        return copy;
    }

    public boolean addPassenger(Person person){
        if(person == null)
            return false;
        if(getOccupancy() == passengers.length)
            return false;
        if(hasPassenger(person))
            return false;

        boolean added = false;

        for(int i = 0; i < passengers.length && !added; i++)
            if(passengers[i] == null){
                passengers[i] = person;
                added = true;
            }
        return added;
    }

    public boolean removePassenger(Person person){
        if(person == null || !hasPassenger(person))
            return false;
        for(int i = 0; i < passengers.length; i++)
            if(person == driver)
                passengers[i] = null;

        return true;
    }

    public boolean canDrive(Person person){
        if(person == null && !canDrive(person))
            return false;
        return true;
    }

}
