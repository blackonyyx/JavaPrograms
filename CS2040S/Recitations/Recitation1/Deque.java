import java.util.List;
import java.util.ArrayList;

public class Deque implements DequeADT<Integer>{
     List<Integer> deque;
     public Deque(List<Integer> l){
         this.deque = new ArrayList<>(l);
     }
     public Deque(){
         this.deque = new ArrayList<>();
     }
     public void push_front(Integer item){
         this.deque.add(0,item);
     }
     public boolean push_back(Integer item){
         return this.deque.add(item);
     }
     public Integer pop_front(){
         return(this.isEmpty())?null: this.deque.remove(0);
     }

     public Integer pop_back(){
         return(this.isEmpty())?null: this.deque.remove(this.deque.size()-1);
     }

     public boolean isEmpty(){
         return this.deque.isEmpty();
     }
     public Integer peek_front(){
         return (this.isEmpty())?null:this.deque.get(0);
     }
     public Integer peek_back(){
         return (this.isEmpty())? null:this.deque.get(this.deque.size()-1);
     }
}
