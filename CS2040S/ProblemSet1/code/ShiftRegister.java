///////////////////////////////////
// This is the main shift register class.
// Notice that it implements the ILFShiftRegister interface.
// You will need to fill in the functionality.
///////////////////////////////////

/**
 * class ShiftRegister
 * @author Tan Hin Khai Stephen
 * Description: implements the ILFShiftRegister interface.
 * Naive Implementation with primative int array
 * I think it could perhaps be done more efficiently using a doubly linked list
 */
public class ShiftRegister implements ILFShiftRegister {
    ///////////////////////////////////
    // Create your class variables here
    ///////////////////////////////////
    // TODO:
    int[] array;//
    int tap;//index of the element to compare to
    int size;

    ///////////////////////////////////
    // Create your constructor here:
    ///////////////////////////////////
    ShiftRegister(int size, int tap) {
        // TODO:
        this.size = size;
        this.array = new int[this.size];
        this.tap = size-tap-1;
    }

    ///////////////////////////////////
    // Create your class methods here:
    ///////////////////////////////////
    /**
     * setSeed
     * @param seed
     * Description:
     * Time: O(n) to reverse the array.
     * O(1) space as the components have already been initialised
     */
    //@Override
    public void setSeed(int[] seed) {
        // TODO:
        //this.array = seed;
        int count = 0;
        for(int i = this.size-1;i>=0;i--){
            this.array[count]=seed[i];
            count++;
        }
    }

    /**
     * shift
     * @return xor bitwise feedback
     * Description:
     * Time Complexity : O(size)
     *         Iteration through the array
     * Space Complexity: O(size)
     *         Due to creating a new array and assignment to this.array
     */
    //@Override
    public int shift() {
        // TODO:
        int[] shifted = new int[this.size];
        //System.out.println(array[tap]);
        int xorbitfeedback = array[tap]^array[0];
        int count = 0;
        for (int i=1;i<this.array.length;i++){
            shifted[count] = this.array[i];
            count++;
        }
        shifted[this.size-1] = xorbitfeedback;
        this.array = shifted;
        return xorbitfeedback;
    }

    /**
     * generate
     * @param k
     * @return
     * Description:
     * Time complexity: O(k*size)
     * Space Complexity O(size), unless k>size then O(k)
     */
    //@Override
    public int generate(int k) {
        // TODO:
        String output = "";//generates k sized array
        for (int i = 0;i<k;i++){
            output +=String.valueOf(this.shift());
        }
        return toBinary(output);
    }

    /**
     * Returns the integer representation for a binary int array.
     * Base 2 -> Base 10
     * @param string
     * @return int
     */
    private int toBinary(String bins) {
        return Integer.parseInt(bins,2);
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i : array){
            str.append(i);
        }
        return str.toString();
    }
    public String getBit(){
        return this.toString();
    }
}

