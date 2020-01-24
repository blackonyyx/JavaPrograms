import java.util.Arrays;
import java.util.stream.*;
public class PasswordEncoder {
    ShiftRegister encoding;
    int[] seed;
    private String solution;
    private PasswordEncoder(int[] seed){
        this.seed = seed;
        this.encoding = new ShiftRegister(seed.length,seed.length/2);
        this.encoding.setSeed(this.seed);
        this.solution = this.encoding.getBit();
    }

    /**
     * Takes in a Password String
     * Converts it to a
     * @param s a password string.
     * @return PasswordEncoder with seed made from the password.
     */
    public static PasswordEncoder passwordGenerator(String s){
        String binary = s.chars().mapToObj(x->Integer.toBinaryString(x)).reduce("",(x,y)->x+y);
        int[] newSeed = new int[binary.length()];
        for (int i = 0;i<binary.length();i++){
            newSeed[i] = Character.getNumericValue(binary.charAt(i));
        }
        return new PasswordEncoder(newSeed);
    }

    /**
     * Returns the string representation of the current bit;
     * @return String representation of current shift status;
     */
    public String getBit(){
        return this.encoding.getBit();
    }

    /**
     * Scrambles the current shift registery by i times
     * @param i
     * @return String representation of current bit size.
     */
    public String scramble(int i){
        this.encoding.generate(i);
        return this.getBit();
    }

    /**
     * Bruteforce decrypts the binary seed
     * @return String representation of the Binary formed by the string.
     */
    private long decryptMeAtAllCosts(){
        String current = this.getBit();
        long i = 0;
        while (!this.solution.equals(current)){
            scramble(1);
            current = this.getBit();
            i++;
        }
        return i;
    }

}
