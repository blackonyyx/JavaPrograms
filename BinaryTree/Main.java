import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        BinarySearchTree<Integer> b1 = new BinarySearchTree<>(l,true);
        b1.preorder();
        b1.inorder();
        b1.addItem(10);
        b1.inorder();
    }
}
