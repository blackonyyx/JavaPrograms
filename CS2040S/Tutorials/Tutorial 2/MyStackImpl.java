class MyStackImpl implements MyStack{
    MyVector stk;
    int size;
    int limit;
    public MyStackImpl(){
        this.stk = new MyVector();
        this.size = 0;
        this.limit = 10;
    }
    public MyStackImpl(boolean t){
        this.limit = (t)?Integer.MAX_VALUE:10;
        this.size = 0;
        this.stk = new MyVector();
    }
    public boolean push(Integer v){
        if (this.size+1 <this.limit){
            this.stk.append(v);
            this.size++;
            return true;
        }else{
            System.out.println("Stack is full!")
            return false;
        }
    }
    public Integer pop(){
        if (!isEmpty()){
            this.size--;
            return this.stk.remove;
        }else{
            return null;
        }
    }

}

