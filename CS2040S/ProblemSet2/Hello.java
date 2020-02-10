/**
 * Contains static routines for solving the problem of balancing m jobs on p processors
 * with the constraint that each processor can only perform consecutive jobs.
 */
import java.util.Arrays;
import java.util.Scanner;
public class Hello{

    /**
     * Checks if it is possible to assign the specified jobs to the specified number of processors such that no
     * processor's load is higher than the specified query load.
     * pseudocode:
     * FOR i=1:p
     *      while (next workload<=query && index of jobSize<jobSize.length)
     *          ADD TO INDEX
     *      IF IS LAST P: ADD THE REST OF THE JOBS
     *      PERFORM COMPARISON TO QUERY
     * RETURN TRUE IF PASSES
     * ELSE PERFORM SAME ROUTINE BUT ITERATING THROUGH JOBSIZE BACKWARDS.
     *
     * Time Complexity: O(n) // due to 2 passes through jobSize array
     * Space Complexity: O(m)//dependent on p: number of processors
     * @param jobSize the sizes of the jobs to be performed
     * @param queryLoad the maximum load allowed for any processor
     * @param p the number of processors
     * @return true iff it is possible to assign the jobs to p processors so that no processor has more than queryLoad load.
     */
    public static boolean boolCheck(int[] array, int bound) {
        for (int i =0;i<=bound;i++){
            if (array[i] == 1){
                return true;
            }
        }
        return false;
    }

    public static void encoderSimulator(int i){
        int[][] twodim = new int[i][i];
        for (int j=0;j<i;j++){
            for (int k=0;k<i;k++){
                if (j==k){
                    twodim[j][k] = 1;
                }else{
                    twodim[j][k] = 0;
                }
            }
        }
        for (int arr = 0;arr<i;arr++){
            findNumber(twodim[arr]);
        }
    }
    /**
     * Returns the minimum achievable load given the specified jobs and number of processors.
     * Time complexity of the algorithm: O(n)
     * @param jobSize the sizes of the jobs to be performed
     * @param p the number of processors
     * @return the maximum load for a job assignment that minimizes the maximum load
     */
    public static int findNumber(int[] array) {
        int begin = 0;
        int end = array.length-1;
        int[] encode = new int[log2(array.length)];
        //get sum of jobsize as upper boundary
        int mid = 0;
        int count = 0;
        while (begin<end){
            mid = begin + (end-begin)/2;
            if (boolCheck(array,mid)){
                end = mid;
                encode[count] = 1;
            }else{
                begin = mid+1;
                encode[count] = 0;
            }
            count++;
        }
        System.out.print("\n"+Arrays.toString(encode)+"\n");
        return begin;
    }

    public static int log2(int arraylen){
        int x = (int) Math.ceil(Math.log(arraylen)/Math.log(2));
        return x;
    }

    /**
     * Some simple tests for the findLoad routine.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            encoderSimulator(sc.nextInt());
        }
    }
}
