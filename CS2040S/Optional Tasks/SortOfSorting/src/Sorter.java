import java.util.Arrays;
import java.util.stream.IntStream;

class Sorter {

    public static void sortStrings(String[] arr) {
        String[] seq = Arrays.stream(arr).toArray(String[]::new);
        System.out.println(Arrays.toString(seq));
        for (int i = 1; i < seq.length; i++) {
            String temp = seq[i];
            int j = i - 1;
            while ( j >= 0&&greaterThan(seq[j], temp) ) {
                seq[j + 1] = seq[j];
                j--;
            }
            seq[j + 1] = temp;
        }

        for (int k= 0; k<seq.length;k++){
            arr[k] = seq[k];
        }

        System.out.println(Arrays.toString(arr));
    }
    public static boolean greaterThan(String s1,String s2) {
        Character c11 = s1.charAt(0);
        Character c12 = s1.charAt(1);
        Character c21 = s2.charAt(0);
        Character c22 = s2.charAt(1);
        if (c11.compareTo(c21) >= 1) {
            return true;
        } else if (c11.compareTo(c21) <= -1) {
            return false;
        }else{
            return (c12.compareTo(c22)>=1);
        }
    }
}
