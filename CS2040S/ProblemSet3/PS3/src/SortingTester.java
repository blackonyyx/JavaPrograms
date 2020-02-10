import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SortingTester {

	/**
	 * Takes in a sorter and checks the sort
	 * How it works:
	 * Takes the given array making a deep copy and sorts with a model sorter from java util
	 * Then compares each element in the
	 * if it passes the correctness test, it prints out the resulting array from model sort + test case sort
	 * @param sorter
	 * @param size
	 * @return
	 */
	public static boolean checkSort(ISort sorter, int size){
		StopWatch watch = new StopWatch();
	    KeyValuePair[] sortMe = new KeyValuePair[]{KeyValuePair.make(12, 1), KeyValuePair.make(2, 5), KeyValuePair.make(3, 1),
				KeyValuePair.make(2, 7), KeyValuePair.make(9, 1), KeyValuePair.make(23, 4),
				KeyValuePair.make(5, 7), KeyValuePair.make(3, 5), KeyValuePair.make(7, 7), KeyValuePair.make(8, 3)};

		KeyValuePair[] unsorted = Arrays.stream(sortMe)
				.map(x -> x == null ? null : KeyValuePair.make(x.getKey(),x.getValue()))
				.toArray(KeyValuePair[]::new);
		KeyValuePair[] model = Arrays.stream(sortMe)
				.map(x -> x == null ? null : KeyValuePair.make(x.getKey(),x.getValue()))
				.toArray(KeyValuePair[]::new);
		Arrays.sort(model);
		watch.start();
		sorter.sort(sortMe);
		watch.stop();
		for (int i = 0; i <sortMe.length;i++){
			if (sortMe[i].getKey() != model[i].getKey()){
				System.out.println("model"+ Arrays.toString(model));
				System.out.println("dr evil"+ Arrays.toString(sortMe));
				return false;
			}
		}
		System.out.println("passed base test: "+ watch.getTime());
		System.out.println("model sort"+Arrays.toString(model));
		System.out.println("this function"+Arrays.toString(sortMe));
		watch.reset();
		Random r = new Random();
		KeyValuePair[] sortMe2 = new KeyValuePair[size];
		for (int j = 0; j<size;j++){
			sortMe2[j] = KeyValuePair.make(r.nextInt(),r.nextInt());
		}
		// Redefining the first 3 elements to be sorted in a predictable manner
		sortMe2[0] = KeyValuePair.make(Integer.MIN_VALUE,1);
		sortMe2[1] = KeyValuePair.make(Integer.MIN_VALUE,2);
		sortMe2[2] = KeyValuePair.make(Integer.MIN_VALUE,3);
		KeyValuePair[] model2 = Arrays.stream(sortMe2)
				.map(x -> x == null ? null : KeyValuePair.make(x.getKey(),x.getValue()))
				.toArray(KeyValuePair[]::new);
		watch.start();
		sorter.sort(sortMe2);
		watch.stop();
		Arrays.sort(model2);
		for (int k = 0; k <sortMe2.length;k++){
			if (sortMe2[k].getKey() != model2[k].getKey()){
				System.out.println("model2"+ Arrays.toString(model2));
				System.out.println("dr evil"+ Arrays.toString(sortMe2));
				return false;
			}
		}
		System.out.println("passed test: "+ watch.getTime());
		System.out.println(Arrays.toString(Arrays.copyOfRange(model2,0,4)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(sortMe2,0,4)));
		return true;
	}

	/**
	 * The isStable sort checker checks for both if the array is truely sorted, then if it is,
	 * checks for the value stored to see if it is the same.
	 * @param sorter
	 * @param size
	 * @return
	 */
	public static boolean isStable(ISort sorter, int size){
		StopWatch watch = new StopWatch();
		Random r = new Random();
		int count = 0;
		KeyValuePair[] sortMe2,model2;
		while (count<5) {
			sortMe2 = new KeyValuePair[size];
			for (int j = 0; j < size; j++) {
				sortMe2[j] = KeyValuePair.make(r.nextInt(size/2), r.nextInt(size/2));
			}
			if (size>=2){
				sortMe2[1] = KeyValuePair.make(Integer.MIN_VALUE,r.nextInt());
			}
			model2 = Arrays.stream(sortMe2)
					.map(x -> x == null ? null : KeyValuePair.make(x.getKey(), x.getValue()))
					.toArray(KeyValuePair[]::new);
			sorter.sort(sortMe2);
			Arrays.sort(model2);
			for (int k = 0; k < sortMe2.length; k++) {
				if (sortMe2[k].getKey() != model2[k].getKey()) {
					return false;
				}
				if (sortMe2[k].getValue() != model2[k].getValue()) {
					System.out.println("model2" + Arrays.toString(model2));
					System.out.println("not stable" + Arrays.toString(sortMe2));
					return false;
				}
			}
			count++;
			System.out.println("model2" + Arrays.toString(model2));
			System.out.println("stable" + Arrays.toString(sortMe2));
		}
		return true;
	}

	public static KeyValuePair[] specialGenerator(int size){
		return IntStream.generate(()->1)
				.limit(size)
				.mapToObj(x->KeyValuePair.make(x,x))
				.toArray(KeyValuePair[]::new);
	}
	/**
	 * Generates a randomised testcase KeyValuePair[] array based on the given input size
	 * @param size
	 * @return
	 */
  public static KeyValuePair[] randomGenerator(int size){
		Random r = new Random();
		return r.ints(size,0,size/2)
				.mapToObj(x->KeyValuePair.make(x,r.nextInt(size/2)))
				.toArray(KeyValuePair[]::new);
  }

	/**
	 * Takes in a array of KeyValuePairs and deep copies the array
	 * @param copy
	 * @return
	 */
  public static KeyValuePair[] deepCopy(KeyValuePair[]copy){
		return Arrays.stream(copy)
				.map(x -> x == null ? null : KeyValuePair.make(x.getKey(),x.getValue()))
				.toArray(KeyValuePair[]::new);
  }

	/**
	 * EdgeCase tester
	 * Assumptions: All sorting routines tested here have already gone through the testing pipeline and
	 * are thus assumed as correct sorting routines.
	 * The edge case tester tests an sorting routine with a stopwatch timer and prints out the relative times.
	 * Each test will be conducted 5 times and the mean result will be printed out.
	 * Tests:
	 * 1) Normal random array test.
	 * 2) Sorted Array test
	 * 3) Reversed Array test
	 * @param s sorting rotine under test.
	 */
	public static void edgeCaseTest(ISort s,int size){
		StopWatch time = new StopWatch();
		int count = 0;
		double printTime = 0;
		KeyValuePair[] array = randomGenerator(size);
		float timing = timeTestingUnit(array,s);
		System.out.printf("Testing on Normal unsorted array of %d size: %f\n",size,timing);
		//sorts array sequentially and times on the routine.
		Arrays.sort(array);
		timing = timeTestingUnit(array,s);
		System.out.printf("Testing on sorted array of %d size: %f\n",size,timing);
		//reverse array then applies same sorting routine

		reverseMe(array);
		timing = timeTestingUnit(array,s);
		System.out.printf("Testing on reversed sorted array of %d size: %f\n",size,timing);
		KeyValuePair[] specialTest = specialGenerator(size);
		timing = timeTestingUnit(specialTest,s);
		System.out.printf("Testing on special all val equivilent array of %d size: %f\n",size,timing);
	}
	public static void reverseMe(KeyValuePair[] arr){
		int mid = arr.length/2;
		int end = arr.length-1;
		KeyValuePair temp;
		for (int i=0; i<mid;i++){
			temp = arr[i];
			arr[i] = arr[end-i];
			arr[end-i] = temp;
		}
	}
	/**
	 * Takes in a array testcase and a sorter, times the sort
	 * 5 times, then takes the average
	 * @param array
	 * @param s
	 * @return timing of the sorting routine.
	 */
	public static float timeTestingUnit(KeyValuePair[] array,ISort s){
		int count = 0;
		StopWatch t = new StopWatch();
		KeyValuePair[] tester;
		while (count<5){
			tester = deepCopy(array);
			t.start();
			s.sort(tester);
			t.stop();
			count++;
		}
		return t.getTime()/5;
	}

	public static void main(String[] args){
		/*
		System.out.println("A:");
		checkSort(new SorterA(),20000);
		System.out.println("B:");
		checkSort(new SorterB(),20000);
		System.out.println("C:");
		checkSort(new SorterC(),2);
		System.out.println("D:");
		checkSort(new SorterD(),20000);
		System.out.println("E:");
		checkSort(new SorterE(),20000);
		System.out.println("F:");
		checkSort(new SorterF(),20000);
	    System.out.println("A:");
	    isStable(new SorterA(),20);
		System.out.println("B:");
		isStable(new SorterB(),20);
		System.out.println("D:");
		isStable(new SorterD(),20);
		System.out.println("E:");
		isStable(new SorterE(),20);
		System.out.println("F:");
		isStable(new SorterF(),20);
		 */
		/*System.out.println("A:");
		edgeCaseTest(new SorterA(),1000);
		System.out.println("B:");
		edgeCaseTest(new SorterB(),1000);
		System.out.println("D:");
		edgeCaseTest(new SorterD(),1000);
		System.out.println("E:");
		edgeCaseTest(new SorterE(),1000);
		System.out.println("F:");
		edgeCaseTest(new SorterF(),1000);
		*/
		System.out.println("A:");
		edgeCaseTest(new SorterA(),20000);
		System.out.println("B:");
		edgeCaseTest(new SorterB(),20000);
		System.out.println("D:");
		edgeCaseTest(new SorterD(),20000);
		System.out.println("E:");
		edgeCaseTest(new SorterE(),20000);
		/*System.out.println("F:");
		edgeCaseTest(new SorterF(),20000);

		 */
		}

	}
}
