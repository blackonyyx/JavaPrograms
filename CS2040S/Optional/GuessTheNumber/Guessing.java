public class Guessing {
    // Your local variables here
    private int low = 0;
    private int high = 1000;
    private int mid = (high-low)/2;
    /**
     * Implement how your algorithm should make a guess here
     */
    public int guess() {
    //Basically abstracts out the find middle line of bin search to guess
        this.mid = this.low+(this.high-this.low)/2;
        return this.mid;
    }
    /**
     * Implement how your algorithm should update its guess here
     */
    public void update(int answer) {
        if (answer==1){
            //guess is high
            this.high = mid;
            
        }else{
            this.low = this.mid+1;
        }
    }
}
