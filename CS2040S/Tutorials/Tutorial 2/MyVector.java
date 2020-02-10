
class MyVector{
    Integer[] vect;
    int endBuffer;
    int startBuffer;
    int size;
    public MyVector(Integer[] l){
        this.vect = l;
        this.endBuffer = l.length-1;
        this.startBuffer = 0;
        this.size = l.length;
    }
    public MyVector(){
        this.vect = new Integer[2];
        this.startBuffer = 0;
        this.endBuffer = 0;
        this.size = 0;
    }
    /**
     * Adds new value to the end of the vector.
     */
    public void append(Integer val){
        if (endBuffer+1 > vect.length-1){
            System.out.println("Doubling Op carried out");
            expansion();//initialises the doubling operation
        }
        this.endBuffer++;
        this.size++;
        this.vect[this.endBuffer] = val;
        
    }
    public void expansion(){
        Integer[] vector = new Integer[this.vect.length*2];
        int end = 0;
        for (Integer i:vect){
            vector[end] = i;
            end++;
        }
        this.endBuffer = end;
        this.startBuffer = 0;
    }
    public Integer remove(int index){
        int ret = vect[index+this.startBuffer];
        for (int i = index+this.startBuffer;i<endBuffer;i++){
            vect[i] = vect[i+1];
        }
        this.endBuffer--;
        return ret;
    }
    public boolean isEmpty(){
        return this.startBuffer == this.endBuffer;
    }
    public int length(){
        return (isEmpty())?0:this.startBuffer-this.endBuffer + 1;
    }
    public Integer get(int i){
        return this.vect[this.startBuffer+i];
    }
}
