
/**
 * Write a description of class Array2DMethods here.
 *
 * @author Avery Logue
 * @version 11/1/17
 */
public class Array2DMethods
{
    public static int[] sumRows(int[][] a)
    {
        int[] num = {};
        if (a == null)
        {
            return num;
        }
        
        int [] sumRows = new int[a.length];
        
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                sumRows[i] += a[i][j];
                if (a[i].length == 0)
                {
                    return null;
                }
            }
        }
        return sumRows;
    }
    
    public static int[] getRow(int [][] a, int n)
    {
           if (a == null || n >= a.length)
            return null;
            
          return a[n];
    }
    
    public static double average(int[][] a)
    {
        if (a == null)
            return 0;
            
        double av = 0.0;
        int sum =  0;
        int count = 0;
        
        for (int[] i : a)
        {
            for (int j : i)
            {
                sum += j;
                count++;
            }
        }
        
        if (count > 0)
            av = ((double)sum)/((double)count);
        
        return av;
    }
}
