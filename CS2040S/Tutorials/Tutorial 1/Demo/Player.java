import java.io.*;
import java.math.*;
import java.util.*;

class Player implements IPlayer, IAnimal{
	
	// It is strange (and bad) programming practice that the player
	// is accessing a global variable in another class.
	// How could this be improved?

	public void wasteTime(){
		Game.clock++;
	}

	public void beUseful(){
		System.out.println(Game.clock + " seconds have passed!");
	}

	public void makeNoise(){
		System.out.println("I am a lion.  Roar.");
	}
}