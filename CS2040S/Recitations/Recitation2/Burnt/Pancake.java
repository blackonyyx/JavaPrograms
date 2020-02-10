public class Pancake{
    public boolean frontBurnt;
    public boolean backBurnt;
    public int size;
    public Pancake (int size,boolean frontBurnt, boolean backBurnt){
        this.size = size;
        this.frontBurnt = frontBurnt;
        this.backBurnt = backBurnt;
    }
    public void flipMe(){
        boolean temp = backBurnt;
        this.frontBurnt = this.backBurnt;
        this.backBurnt = temp;
    }
    public static Pancake makePancake(int s,boolean f, boolean b){
        return new Pancake(s,f,b);
    }
    public boolean frontBurnt(){
        return this.frontBurnt;
    }
    public int size(){
        return this.size;
    }
}
