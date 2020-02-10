class Main{
    public static void main(String[] args){
        int output = MysteryFunction(3,3);
        System.out.println("The answer is: "+ output+".");
    }
    static int MysteryFunction(int A,int B){
        int c = 1;
        int d = A;
        int e= B;
        while (e>0){
            if (2*(e/2)!=e){
                c = c*d;
            }
            d = d*d;
            e = e/2;
        }
        return c;
    }
}