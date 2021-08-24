public class EssentialArrayMethods
{
   public static String toStringFor()
   {
       String a = "";
       int[] x={3, 45, 17, 2, -1, 44, 9, 23, 67, 2, -6, -23, -100, 12, 5, 1212};
       
       for(int i = 0; i < x.length; i ++)
        {
            a += x[i];
           if(i != x.length - 1)
              a += " ";
           
        }
       return a;
   }
   public static String toStringWhile()
   {
       String a = "";
       int[] x={3, 45, 17, 2, -1, 44, 9, 23, 67, 2, -6, -23, -100, 12, 5, 1212};
       int i = 0;
       while(i < x.length)
        {
            a += x[i];
           if(i != x.length - 1)
              a += " ";
           i++;
        }
       return a;
   }
   public static String toStringForEach()
   {
       int[] x={3, 45, 17, 2, -1, 44, 9, 23, 67, 2, -6, -23, -100, 12, 5, 1212};
       String a = "";
       
       for(int i : x)
        {
            a += i;
           if(i != x.length - 1)
           {
              a += " ";
           }
        }
       a = a.substring(0, a.length() -1);
       return a;
   }
   public static String reverseWhile()
   {
       String a = "";
       int[] x={3, 45, 17, 2, -1, 44, 9, 23, 67, 2, -6, -23, -100, 12, 5, 1212};
       int i = x.length-1;
       while(i >= 0)
        {
            a += x[i];
           if(i != 0)
              a += " ";
           i--;
        }
       return a;
   }
   public static String oddIndicesFor()
   {
       String a = "";
       int[] x={3, 45, 17, 2, -1, 44, 9, 23, 67, 2, -6, -23, -100, 12, 5, 1212};
       
       for(int i = 0; i < x.length; i++)
            if(i % 2 != 0)
            {
               a += x[i];
             if(i != 0)
               a += " ";
            }
            a = a.substring(0, a.length() -1);
            return a;
   }
   public static double averageForEach()
   {
       int[] x={3, 45, 17, 2, -1, 44, 9, 23, 67, 2, -6, -23, -100, 12, 5, 1212};
       double average = 0.0;
       for(int i : x)
           average += i;
       return average/(x.length);    

   }
}
