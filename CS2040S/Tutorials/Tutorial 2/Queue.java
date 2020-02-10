import java.util.List;
interface Queue<T>{
    void populate(List<T> l);
    boolean offer(T value);
    boolean isEmpty();
    T poll();
    Integer size();
}

