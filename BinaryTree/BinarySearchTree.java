import java.util.List;
import java.util.ArrayList;
/**
 * Basic Binary Tree Structure.
 */
public class BinarySearchTree<T extends Comparable<T>>{
    Node<T> root;
    int height;
    int size;
    public BinarySearchTree(List<T> l,boolean sorted){
        if (!sorted){
            this.root = recursiveBuild(l);
        }else{
            this.root = recursiveSortedBuild(l);
        }
    }
    /**
     * Performs a build operation on the sorted list.
     */
    public Node<T> recursiveSortedBuild(List<T> vals){
        if (vals == null|| vals.size() == 0){
            return null;
        }else if (vals.size() == 1){
            return new Node<T>(vals.get(0));
        }else if (vals.size() == 2){
            return new Node<T>(vals.get(0));
        }else if (vals.size() == 2){
            Node<T> n1 = new Node<>(vals.get(0));
            Node<T> n2 = new Node<>(vals.get(1));
            n2.setSmallerDescendent(n1);
            return n2;
        }else{
            int m = (vals.size()%2==1)? vals.size()/2: vals.size()/2-1;
            Node<T> n = new Node<>(vals.get(m));
            n.setSmallerDescendent(recursiveSortedBuild(vals.subList(0,m)));
            n.setLargerDescendent(recursiveSortedBuild(vals.subList(m+1,vals.size())));
            return n;
        }
    }
    /**
     * Inserts a new item into the BST in order.
     * Does NOT auto balance
     */
    public void addItem(T item){
        Node<T> n = this.root;
        Node<T> inserted = new Node<>(item);
        boolean flag = true;
        while (!n.isLeaf()){
            if (inserted.compareTo(n)<=0){
                n = n.getSmallerDescendent();
                flag = true;
            }else{
                n = n.getLargerDescendent();
                flag = false;
            }
        }
        if (flag){
            n.setSmallerDescendent(inserted);
        }else{
            n.setLargerDescendent(inserted);
        }
    }


    /**
     * Performs the datastructures equivlent of quicksort with a randomised pivot.
     */
    public Node<T> recursiveBuild(List<T> vals){
        if (vals ==null||vals.size()==0){
            return null;
        }else if(vals.size() == 1){
            return new Node<T>(vals.get(0));
        }else if (vals.size() == 2){
            Node<T> n1 = new Node<>(vals.get(0));
            Node<T> n2 = new Node<>(vals.get(1));
            if (n1.compareTo(n2) <=0){
                n2.setSmallerDescendent(n1);
                return n2;
            }else{
                n1.setSmallerDescendent(n2);
                return n1;
            }
        }else{
            int m = (vals.size()%2==1)? vals.size()/2: vals.size()/2-1;
            Node<T> n = new Node<T>(vals.get(m));
            vals.remove(m);
            List<T> left = new ArrayList<>();
            List<T> right = new ArrayList<>();
            for (T item: vals){
                if (item.compareTo(n.get())<=0){
                    left.add(item);
                }else{
                    right.add(item);
                }
            }
            n.setSmallerDescendent(recursiveBuild(left));
            n.setLargerDescendent(recursiveBuild(right));
            return n;
        }
    }

    /**
     * Queries for a value in the Binary Search tree.
     */
    public boolean contains(T value){
        Node<T> n = this.root;
        while (!n.isLeaf()&&!n.get().equals(value)){
            if (value.compareTo(n.value)<=0){
                n = n.getSmallerDescendent();
            }else{
                n = n.getLargerDescendent();
            }
        }
        return n.get().equals(value);
    }
    public T getValue(T value){
        if (contains(value)){
            Node<T> n = this.root;
            while (!n.isLeaf()&&!n.get().equals(value)){
                if (value.compareTo(n.value)<=0){
                    n = n.getSmallerDescendent();
                }else{
                    n = n.getLargerDescendent();
                }
            }
            return n.get();
        }else {
            return null;
        }
    }
    /**
     * Calls the wrapped preorder traversal of the root node.
     */
    public void preorder(){
        Node<T> n = this.root;
        System.out.println( "Preorder Traversal\nRoot : " + this.root.get());
        this.root.preorder();
        System.out.println("");
    }
    /**
     * Calls the wrapped inorder traversal of the root node.
     */
    public void inorder(){
        System.out.println( "Inorder Traversal \nRoot : " + this.root.get());
        this.root.inorder();
        System.out.println("");
    }
    /**
     * Calls the wrapped postorder traversal of the root node.
     */
    public void postorder(){
        System.out.println( "Postorder Traversal \nRoot : " + this.root.get());
        this.root.postorder();
        System.out.println("");
    }
    /**
     * Uses a queue to enumerate the level order traversal of the tree
     */

}
