/**
 * The Optimization class contains a static routine to find the maximum in an array that changes direction at most once.
 */
public class Optimization {

    /**
     * A set of test cases.
     */
    static int[][] testCases = {
            {1, 3, 5, 7, 9, 11, 10, 8, 6, 4},
            {67, 65, 43, 42, 23, 17, 9, 100},
            {4, -100, -80, 15, 20, 25, 30},
            {2, 3, 4, 5, 6, 7, 8, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83}
    };

    /**
     * Assumption made:
     * There is minimally 4 elements in the array, such that the data in the array can be in such a case.
     * Returns the maximum item in the specified array of integers which changes direction at most ONCE.
     * Goal:
     * 1) Find the orientation of the array is it ascend-descend descend-ascend or already sorted
     * 2) Perform search routine.
     * 3) Perform comparison.
     * Most naive soln: O(n) by just iterating from start till end.
     * Desired Complexity: O(log n) using search routine equivalent to binary search.
     * Best case scenario: O(1) if case is not ascending-descending
     * @param dataArray an array of integers which changes direction at most once.
     * @return the maximum item in data Array
     */
    public static int searchMax(int[] dataArray) {
        int size = dataArray.length;
        int max = Integer.MIN_VALUE;
        if (size<4){
            //As the run time is trivial just iterate and find max.
            //To handle the case of array size being less than 4
            for (int i: dataArray){
                max = (i>max)?i:max;
            }
            return max;
        }
        boolean checkFront = (dataArray[0]<dataArray[1]);//is in ascending ie 1,2
        boolean checkBack = (dataArray[size-2]>dataArray[size-1]);//is in descending ie
        // if ascendingfront + descending back continue with binary search
        // if is one but not the other, implies array is fully sorted already. skip to 2)
        // else is descending front + ascending back => just take first and last index!
        if (!checkBack&&!checkFront){
            //means array sorted descending ascending.
            return Math.max(dataArray[0], dataArray[size - 1]);
        }else if(checkBack&&!checkFront||checkFront&&!checkBack){
            return Math.max(dataArray[0], dataArray[size - 1]);
        }else {
            //perform binary search only on case of ascending-descending
            //edge cases of last or first index being max value has been excluded already
            int j;// when binary search is required to define when confirmed the partitioning index
            int begin = 0;
            int end = size-1;
            int curr = 0;//current value being looked at
            while (begin<end){
                j = begin+(end-begin)/2;
                curr = dataArray[j];
                max = Math.max(curr,max);
                if (dataArray[j-1]>curr){
                    //if data on the left of curr is greater, move end index down
                    end = j;
                }else if(dataArray[j-1]<curr){
                    begin = j+1;
                }
            }
            return max;
        }
    }

    /**
     * A routine to test the searchMax routine.
     */
    public static void main(String[] args) {
        for (int[] testCase : testCases) {
            System.out.println(searchMax(testCase));
        }
    }
    /**
     * Optional Question Parts
     * 1) To signal an error, throw an error to the driver class function, which corresponds to the edge case that is
     * intended to 'break' the algorithm ( in cases where the error is caused by platform overheads such as eg int max value)
     * rather than algorithmic model problems.
     * When implementing an algorithm, its correct to let the java runtime environment to throw the error such that the implementer
     * can see what is wrong with the model.
     *
     * 2) If not all the elements in the array are unique, when searching for the max value, alter the check to:
     * have an function that checks the neighbouring indices until one is less than curr, (unless is at the far end of the array)
     * returns true otherwise false and goes to else check.
     * 3) 
     *
     * 4)
     * Postulating a guess, perhaps basing the evaluation on 2 neighbouring indices eg [1,4,6,8,7,5,3,2]
     * Otherwise, if that guess is wrong, I think it is not possible to find the max using a binary sort algorithm.
     */
}
