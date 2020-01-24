import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;

/**
 * ShiftRegisterTest
 * @author dcsslg
 * Description: set of tests for a shift register implementation
 */
public class ShiftRegisterTest {

    /**
     * getRegister returns a shiftregister to test
     * @param size
     * @param tap
     * @return a new shift register
     * Description: to test a shiftregister, update this function
     * to instantiate the shift register
     */
    ILFShiftRegister getRegister(int size, int tap){
        return new ShiftRegister(size, tap);
    }

    /**
     * Test shift with simple example
     */
    @Test
    public void testShift1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = {0,1,0,1,1,1,1,0,1};
        r.setSeed(seed);
        int[] expected = {1,1,0,0,0,1,1,1,1,0};
        for (int i=0; i<10; i++){
            assertEquals(expected[i], r.shift());
        }
    }

    /**
     * Test generate with simple example
     */
    @Test
    public void testGenerate1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = {0,1,0,1,1,1,1,0,1};
        r.setSeed(seed);
        int[] expected = {6,1,7,2,2,1,6,6,2,3};
        for (int i=0; i<10; i++){
            assertEquals("GenerateTest", expected[i], r.generate(3));
        }
    }

    /**
     * Test register of length 1
     */
    @Test
    public void testOneLength() {
        ILFShiftRegister r = getRegister(1, 0);
        int[] seed = {1};
        r.setSeed(seed);
        int[] expected = {0,0,0,0,0,0,0,0,0,0,};
        for (int i=0; i<10; i++){
            assertEquals(expected[i], r.generate(3));
        }
    }
    /**
     * Test with erroneous seed.
     * A way to handle the exeception is to make the function setSeed()
     * throw a error that abstracts out the details eg: IndexException and instead throws a
     * Error eg: SeedMismatchException, that informs the user what they did that caused the error
     * This allows the program to handle the exceptional code gracefully without breaking the abstraction barrier
     * between the implementation and the usage of the program.

    @Test
    public void testError() {
        ILFShiftRegister r = getRegister(4, 1);
        int[] seed = {1,0,0,0,1,1,0};
        r.setSeed(seed);
        r.shift();
        r.generate(4);
    }
    */
    /**
     * Test with alternating 1s and 0s
     */
    @Test
    public void testOnesLength() {
        ILFShiftRegister r = getRegister(10, 4);
        int[] seed = {1,0,1,0,1,0,1,0,1,0};
        r.setSeed(seed);
        int[] expected = {1,1,1,1,1,1,1,1,1,1,0};
        for (int i=0; i<12; i++){
            assertEquals(expected[i], r.shift());
        }
    }
    ILFShiftRegister generateRandomRegister(){

        ILFShiftRegister r = getRegister(100, 40);
        Random rg = new Random();
        int[] seed = new int[100];
        for (int i = 0;i<seed.length;i++){
            seed[i] = rg.nextInt(1);
        }
        r.setSeed(seed);
        return r;

    }
    /*Assuming correctness of algorithm from previous tests.
     *Testing Algorithm timed performance
     *Vary size and tap of generateRandomRegister to test for different sizes
     *and tap.
     *Referenced: https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java
     */
    @Test
    public void testPerformance(){
        long[] timings = new long[3];
        int[] instance = new int[] {10,30,100,1000,3000};
        long startTime,endTime,duration;
        ILFShiftRegister r;
        for (int i=0;i<timings.length;i++){
            r = generateRandomRegister();
            for (int j=0;j<instance.length;j++){

                startTime= System.nanoTime();
                r.generate(instance[j]);
                endTime = System.nanoTime();
                duration = (endTime-startTime)/1000000;
                System.out.print("For generate("+instance[j]+"): "+duration+" ");
                timings[i]+=duration;
            }
            System.out.println("Total time: "+timings[i]);
        }
    }
}
