interface QueueADT<T>{
    boolean enqueue(T value);
    T dequeue();
    T peek();
}
