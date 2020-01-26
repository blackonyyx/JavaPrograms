/**
 * The node class contains the value stored in the node
 */
class Node<T>{
    private T value;
    public Node(T value){
        this.value = value;
    }
    public T getValue(){
        return this.value;
    }
    @SuppressWarnings("unchecked")
    public boolean equals(Object o){
        if (o instanceof Node){
            return ((Node<T>) o).getValue().equals(this.value);
        }else{
            return false;
        }
    }
    public int hashCode(){
        return this.value.hashCode();
    }
    public String toString(){
        return this.value.toString();
    }
}
