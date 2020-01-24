/**
 * Contains static routines for solving the problem of balancing m jobs on p processors
 * with the constraint that each processor can only perform consecutive jobs.
 */
public class LoadBalancing {

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
    public static boolean feasibleLoad(int[] jobSize, int queryLoad, int p) {
        return fLoad(jobSize,queryLoad,p,false);
    }

    public static boolean fLoad(int[] jobSize, int queryLoad, int p,boolean repeat){
        int[] distrib = new int[p];
        int curr = 0;
        for (int i=0;i<distrib.length;i++){
            while (curr<jobSize.length&&((distrib[i]+jobSize[curr])<=queryLoad)){
                distrib[i] += jobSize[curr];
                curr++;
            }
            if (i==p-1){
                //add the rest of the array to this last processor
                for (curr=curr;curr<jobSize.length;curr++){
                    distrib[i] +=jobSize[curr];
                }
            }
        }
        if (distrib[p-1]>queryLoad&&!repeat){
            //if it fails and is not recursed
            //perform routine on the reverse of jobSizeArray
            //from https://www.java67.com/2016/10/3-ways-to-reverse-array-in-java-coding-interview-question.html
            // reverses the array so I can blackbox reuse algorithm with recursion.
            for(int i=0; i<jobSize.length/2; i++){
                int temp = jobSize[i];
                jobSize[i] = jobSize[jobSize.length -i -1];
                jobSize[jobSize.length -i -1] = temp;
            }
            return fLoad(jobSize,queryLoad,p,true);

        }else if(distrib[p-1]>queryLoad){
            return false;
        }else {
            return true;
        }
    }
    /**
     * Returns the minimum achievable load given the specified jobs and number of processors.
     * Time complexity of the algorithm: O(n)
     * @param jobSize the sizes of the jobs to be performed
     * @param p the number of processors
     * @return the maximum load for a job assignment that minimizes the maximum load
     */
    public static int findLoad(int[] jobSize, int p) {
        int begin = 1;
        int end = 0;
        //get sum of jobsize as upper boundary
        for (int i : jobSize){
            end += i;
        }
        int mid = 0;
        while (begin<end){
            mid = begin + (end-begin)/2;
            if (feasibleLoad(jobSize,mid,p)==true){
                end = mid;
            }else{
                begin = mid+1;
            }
        }
        return begin;
    }

    // These are some arbitrary testcases.
    public static int[][] testCases = {
            {1, 3, 5, 7, 9, 11, 10, 8, 6, 4},
            {67, 65, 43, 42, 23, 17, 9, 100},
            {4, 100, 80, 15, 20, 25, 30},
            {2, 3, 4, 5, 6, 7, 8, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83},
            {7}
    };

    /**
     * Some simple tests for the findLoad routine.
     */
    public static void main(String[] args) {
        for (int p = 1; p < 30; p++) {
            System.out.println("Processors: " + p);
            for (int[] testCase : testCases) {
                System.out.println(findLoad(testCase, p));
            }
        }
    }
}
