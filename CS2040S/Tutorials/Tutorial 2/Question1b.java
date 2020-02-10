import java.util.Scanner;
import java.util.Stack;

class Question1b{
    /**
     * But what if there are multiple kinds of brackets?, then when we pop, we must check that
     * the enclosing bracket was the same kind of bracket as the poped bracket.
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stk = new Stack<>();
        boolean flag= true;
        while (sc.hasNext()){
            String s = sc.next();
            if (s.equals("(")&&!stk.empty()){
                stk.push(1);
            }else if(s.equals(")")&&!stk.empty()){
                stk.pop();
            }else{
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
