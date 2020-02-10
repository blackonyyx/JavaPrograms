import java.io.*;
import java.math.*;
import java.util.*;

class Game {
	// Be very careful with public static variables. 
	// There are like universal global variables.
	// This tends to be very bad programming style.
	// How could you fix this?
	public static int clock = 0;

	public static void reset(){
		clock = 0;
	}

	public static void main(String[] args) {
			Player PlayerOne = new Player();
			Player PlayerTwo = new Player();
			// Notice that both players share the same clock.

			PlayerOne.wasteTime();
			PlayerTwo.beUseful();
			PlayerTwo.wasteTime();
			PlayerOne.beUseful();
			reset();
			PlayerOne.beUseful();
	}
}