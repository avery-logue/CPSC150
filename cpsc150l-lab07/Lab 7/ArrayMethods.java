public class ArrayMethods
{
    public static void swapArrayContents(int[] a, int[] b)
    {
        int[] copya = new int[a.length];
        int[] copyb = new int[a.length];
        
        for(int i = 0; i < copya.length; i++)
            copya[i] = a[i];
            
        for(int i = 0; i < copyb.length; i++)
            copyb[i] = b[i];
        
        for(int i = 0; i < copyb.length; i++)
        {
            a[i] = copyb[i];
            b[i] = copya[i];
        }
    }
    public static void replaceLessThan(int[] a, int n)
    {
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] < n)
                a[i] = n;
        }
    }
      public static int[] copyAndReplaceLessThan(int[] a, int n)
    {
        int[] copya = new int[a.length];
        
        for(int i = 0; i < copya.length; i++)
            copya[i] = a[i];
            
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] < n)
                copya[i] = n;
        }
        return copya;
    }
    public static int[] reverse(int[] a)
    {
        int[] copya = new int[a.length];
        int b = 0;
        for(int i = a.length - 1; i >= 0; i--)
        {
            copya[b] = a[i];
            b++;
        }
        
        return copya;
    }
  
}
