import java.util.Arrays;
public class Pancakes{
    public static void main(String[] args){
        int[] flipMe = new int[]{7,5,2,3,6,4,9,8};
        int flips = flipMeOff(flipMe);
        System.out.println(flips);
    }
    /**
     * The psudocode to follow.
     * Generally, a greedy approach to flip the max size pancake to the top 
     * ->flip it down then decrease boundary of consideration by 1
     *  Continue this strategy until fully sorted
     */
    public static int flipMeOff(int[] stack){
        int bound = stack.length-1;
        int max = 0;
        int flips = 0;
        while (!isSorted(stack)){
            max = findMax(stack,bound);
            flip(stack,max);
            System.out.println(Arrays.toString(stack));
            flip(stack,bound);
            System.out.println(Arrays.toString(stack));
            flips+=2;
            bound--;
        }
        return flips;
    }
    /*
     * Finds the max element within the bounds
     */
    public static int findMax(int[] stack,int bound){
        int max = 0;
        for (int i=0;i<=bound;i++){
            max = (stack[max]>stack[i])? max:i;
        }
        return max;
    }
    /*
     * Reverses the array taking filpped as the index boundary
     */
    public static void flip(int[] stack, int flipped){
        int temp = 0;
        int mid = (flipped %2 ==1)?(flipped+1)/2:flipped/2;
        int f = flipped;
        for (int i = 0; i< mid;i++){
            temp = stack[i];
            stack[i] = stack[f-i];
            stack[f-i] = temp;
        }
    }
    /*
     * Checks if array is sorted
     */
    public static boolean isSorted(int[] l){
        for (int i = 0; i<l.length-2;i++){
            if (l[i]>l[i+1]){
                return false;
            }
        }
        return true;
    }
}
