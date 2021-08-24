public class IfElseQuiz
{
    public static int sumDifference(int pOne, int pTwo)
        {
            if(pOne > pTwo)
                return pOne - pTwo;
            else if(pOne < pTwo)
                return pOne + pTwo;
            else
                return -1;
        }
    public static String fooBar(int a)
    {
        if(a % 3 == 0 && a % 5 == 0)
            return "foobar";
        else if(a % 3 == 0)
            return "foo";
        else if(a % 5 == 0)
            return "bar";
        else 
            return "none";
    }
}   
