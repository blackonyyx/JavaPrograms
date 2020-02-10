import java.util.Random;
class GriddleGorgon{
   private Random faulty;
   public GriddleGorgon (){
       this.faulty = new Random();
   }
   /**
    * Makes a burnt pancake out of a randomised variable.
    * if val <0.5, then front is burnt, else back is burnt.
    */
   public Pancake makeBurntPancake(int size){
        if (faulty.nextFloat()<0.5){
            return Pancake.makePancake(size,true,false);
        }else{
            return Pancake.makePancake(size,false,true);
        }
   }

}


