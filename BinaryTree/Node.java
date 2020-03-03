/**
 * Node class that can be used for implementation of a AVL tree/Binary Tree Structure.
 * Has an height and weight attribute for augmentation.
 * Generic Class T that requires implementation of the Comparable interface
 * Can be further extended, but base implementation is of a Binary Structure with a left and 
 * right child node.
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    protected T value;
    protected Node<T> parent;
    protected Node<T> smallerDescendent;
    protected Node<T> largerDescendent;
    private int weight;
    private int height;
    public Node(T value){
        this.value = value;
    }
    public Node(T value,int height,int weight){
        this.value = value;
        this.height = height;
        this.weight = weight;
    }
    public Node(T value,int height){
        this.value = value;
        this.height = height;
    }
    public Node(T value,int weight, String s){
        this.value = value;
        this.weight = weight;
    }
    public void setParent(Node<T> n){
        this.parent = n;
    }
    public void setSmallerDescendent(Node<T> n){
        this.smallerDescendent = n;
        n.setParent(this);
    }
    public void setLargerDescendent(Node<T> n){
        this.largerDescendent = n;
        n.setParent(this);
    }
    public T get(){
        return this.value;
    }
    public int height(){
        return this.height;
    }
    public int weight(){
        return this.weight;
    }
    public Node<T> getSmallerDescendent(){
        return this.smallerDescendent;
    }
    public Node<T> getLargerDescendent(){
        return this.largerDescendent;
    }
    public boolean hasDescendents(){
        return !(this.smallerDescendent == null&&this.largerDescendent==null);
    }
    public boolean isRoot(){
        return parent == null;
    }
    public int compareTo(Node<T> that){
        return this.value.compareTo(that.value);
    }
    public boolean isLeaf(){
        return this.smallerDescendent==null&&this.largerDescendent==null;
    }
    public boolean isLeftChild(){
        return this.parent.getSmallerDescendent()==this;
    }
    public boolean isEqual(T value){
        return this.value.equals(value);
    }
    public void preorder(){
        System.out.print(this.value.toString() + " ");
        if (this.smallerDescendent != null){
            this.getSmallerDescendent().preorder();
        }
        if (this.largerDescendent != null){
            this.getLargerDescendent().preorder();
        }
    }
    public void inorder(){
        if (this.smallerDescendent != null){
            this.getSmallerDescendent().preorder();
        }
        System.out.print(this.value.toString() + " ");
        if (this.largerDescendent != null){
            this.getLargerDescendent().preorder();
        }
    }
    public void postorder(){
        if (this.smallerDescendent != null){
            this.getSmallerDescendent().preorder();
        }
        if (this.largerDescendent != null){
            this.getLargerDescendent().preorder();
        }
        System.out.print(this.value.toString() + " ");
    }
}
