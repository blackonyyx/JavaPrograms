import java.util.Arrays;

public class FindSpyLowestCost implements IFindSpies {
    int[] snakesFound;//contains all found snakes and always sends them on a mission
    //int upper;//to be the last index to send on a mission.
    //int lower;//to be the first index to send on a mission.
    int[] allIdentified;
    /**
     * Psudocode:
     * while not found all snakes Repeat{
     *      if not all spies found:
     *          lower bound constant
     *          Repeat{
     *          searcher will binary search top half
     *              send for mission up till the current bound + any snakes identified in the previous iterations
     *              if true will bring the current search bound up to mid and perform the divide step again
     *              else if false brings the search bound down to the half that returns false
     *          when one is found:
     *              break
     *         }
     *         Amend the upper bound to the search term minus 1
     *         append the list of identified snakes with the new term.
     * }
     * The amendment is that we will apply binary search both on the top and bot of the
     * array, rather than working from just the top, using a modulo on the found index.
     */
    @Override
    public int[] findSpies(int N, int k, IMissionControl missionControl) {
        this.snakesFound = FindSpyMinimumSteps.initSnakes(k);
        this.allIdentified = new int[N];
        int lower = 0;
        int upper = N-1;// initialise at the top
        int searchupper = upper;
        int searchlower = lower;
        int finder = 0;
        int found = 0;
        while (this.checkStatus()){
            if (found!=0) {
                System.out.println("I am activated");
                lower = (found%2==1)?lower:searchupper+1;
                upper = (found%2==0)?searchlower-1:upper;
            }
            searchupper = upper;
            searchlower = lower;
            if (found%2 == 0) {
                while (searchlower < searchupper) {
                    System.out.println("search lower " + searchlower);
                    finder = searchlower + (searchupper - searchlower) / 2;
                    if (checkSnakes(missionControl, N, lower, finder, k) == true) {
                        searchupper = finder;
                    } else {
                        searchlower = finder + 1;
                    }
                }
                this.snakesFound[found] = searchlower;
                this.allIdentified[searchlower] = 1;
                System.out.println("Snake "+this.allIdentified[searchlower]);
                found++;
            }else {
                while (searchupper<searchlower){
                    System.out.println("search upper "+ searchupper);
                    finder = searchlower-(searchupper-searchlower)/2;
                    if (checkSnakes(missionControl,N,upper,finder,k)==true){
                        searchupper
                    }
                }
            }

        }
        return this.allIdentified;
    }

    /**
     * Takes all in the upper bound and lower bound on a mission along with any identified spies
     * @param test
     * @param size
     * @param start
     * @param end
     * @return
     */

    public boolean checkSnakes(IMissionControl test,int size,int start,int end,int k){
        int[] mission = new int[size];
        System.out.println("end is"+end);
        for (int i = start; i<=end; i++){
            mission[i] = 1;
        }
        for (int j : this.snakesFound){
            if (j==Integer.MAX_VALUE){
                break;
            }else{
                mission[j] = 1;
            }
        }
        //if k > number on mission
        System.out.println(Arrays.toString(mission));
        return test.sendForMission(mission);
    }
    /**
     * Takes in k and initialises a array of Integer MAX value to denote unfilled
     * @param k
     * @return
     */
    public static int[] initSnakes(int k){
        int[] sneks = new int[k];
        for (int i = 0; i < k;i++){
            sneks[i] = Integer.MAX_VALUE;
        }
        return sneks;
    }

    /**
     * Checks if all snakes are found
     * @return if last index is  integer.max returns true
     */
    public boolean checkStatus(){
        return (this.snakesFound[snakesFound.length-1]==Integer.MAX_VALUE);
    }
}
