public class Node<T>{
    T value;
    Node<T> next;
    Node<T> back;
    public Node(T value){
        this(value,null, null);
    }
    private Node(T value, Node<T> next, Node<T> back){
        this.value = value;
        this.next = next;
        this.back = back;
    }
    public T get(){
        return this.value;
    }
    /**
     * Sets the node to be next after this node
     */
    public void setNext(Node<T> n){
        this.next = n;
    }
    public void setBack(Node<T> n){
        this.back = n;
    }
    public Node<T> next(){
        return this.next;
    }
    public Node<T> back(){
        return this.back;
    }
    public String toString(){
        return this.value.toString();
    }
}

