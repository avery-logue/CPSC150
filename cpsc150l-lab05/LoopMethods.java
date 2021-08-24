public class LoopMethods
{
    public static int sumSeries(int start, int end)
    {
        int count = 0;
        
        for(int i = 0; start <= end; i++)
        {
            count += start;
            start++;
        }
        return count;
    }
    public static int factorial(int n)
    {
        int count = 1;
        if(n > 0)
        {
            for(int i = 1; i <= n; i++)
            {
                count = count * i;
            }
        }
        return count;
    }
}
