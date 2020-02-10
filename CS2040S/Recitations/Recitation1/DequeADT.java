interface DequeADT<T>{
    void push_front(T item);
    boolean push_back(T item);
    T pop_front();
    T pop_back();
    T peek_front();
    T peek_back();
}
