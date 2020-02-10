import java.util.List;
import java.util.ArrayList;

public class Queue implements QueueADT<Integer>{
     List<Integer> queue;
     public Queue(List<Integer> l){
         this.queue = new ArrayList<>(l);
     }
     public Queue(){
         this.queue = new ArrayList<>();
     }
     public boolean enqueue(Integer item){
         return this.queue.add(item);
     }
     public Integer dequeue(){
         return(this.isEmpty())?null: this.queue.remove(0);
     }
     public boolean isEmpty(){
         return this.queue.isEmpty();
     }
     public Integer peek(){
         return (this.isEmpty())?null:this.queue.get(0);
     }
}
