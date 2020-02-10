import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
class Question1c {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        while (sc.hasNextInt()){
            q1.offer(sc.nextInt());
        }
        sortWithQueue(q1, q2);
    }
}


