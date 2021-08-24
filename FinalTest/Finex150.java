public class Finex150
{
    public static int countOfEvens(int start, int end){
        int count = 0;
        for(int i = start; start <= end; i++){
            if(i % 2 == 0)
                count++;
        }
        return count;
    }

    public static int factorial(int num){
        int count = num;
        for(int i = num; i > 0; i--){
            count = count * num;
        }
        return count;
    }

    public static int maxOf(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]) 
                count = i;
        }
        return count;
    }

    public static void swapEnds(int[] nums){
        int first = nums[0];
        int last = nums[nums.length-1];

        nums[0] = last;
        nums[nums.length-1] = first;
    }
}
