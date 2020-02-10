import java.util.List;

class MyLinkedList<T> implements Queue<T>{
    Node<T> start;
    Node<T> end;
    Integer size;

    public MyLinkedList(){
    }
    public Node<T> make(T value){
        return new Node<>(value);
    }
    public void populate(List<T> l){
        int i = 0;
        Node<T> traverse = null;
        this.size = l.size();
        while (i<l.size()){
            Node<T> n = make(l.get(i));
            if (i==0){
                this.start = n;
                traverse = n;
            }else{
                traverse.setNext(n);
                n.setBack(traverse);
                traverse = n;
            }

            if (i== l.size()-1){
                this.end = traverse;
            }
            i++;
        }
    }
    /**
     * offer is a method that takes in a object of type T and appends it to the back of the LinkedList
     * should always return true.
     * The offer function, takes in a T value, makes it into a node n
     * Temp is assigned to the previous end, 
     * n is assigned to the back of the list
     * then setback is called on node, set next is called on temp
     */
    public boolean offer(T value){
        Node<T> n = make(value);
        Node<T> temp = this.end;
        this.end = n;
        n.setBack(temp);
        temp.setNext(n);
        this.size++;
        return true;
    }
    public boolean isEmpty(){
        return this.start == null;
    }
    public T poll(){
        Node<T> popped = this.start;
        if (this.end==this.start){
            this.end = null;
            this.start = null;
            //applicable if only one item in queue
        }else{
            Node<T> newHead = popped.next();
            this.start = popped.next();
        }
        return popped.get();
    }
    public Integer size(){
        return this.size;
    }

    public T get(int index){
        if (index < 0 || index>this.size-1){
            System.out.println("Invalid index");
            return null;
        }
        int i = 0;
        Node<T> traverse = this.start;
        while (i<index){
            traverse = traverse.next();
            i--;
        }
        return traverse.get();
    }

    public String toString(){
        if (isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int i =0;
        Node<T> travel = this.start;

        while (i<this.size){
            sb.append(travel.toString());
            sb.append(" ,");
            i++;
        }
        sb.replace(sb.length()-1,sb.length()-1,"]");
        return sb.toString();
    }
}
