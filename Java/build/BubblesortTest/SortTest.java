// Top part of sort timing framework
// This part contains all of the test harness for defining the tests
// to be run.

import java.io.*;
import java.math.*;
import java.util.*;
import java.lang.reflect.*;
import java.lang.Integer;



public class SortTest {
// In the end, everything ends up inside a class named "SortTime"

/** Initialize the random variable */
static Random value = new Random(); // Hold the Random class object

/** Create a random number function from the standard Java Random
    class. Turn it into a uniformly distributed value within the
    range 0 to n-1 by taking the value mod n.
    @param n The upper bound for the range.
    @return A value in the range 0 to n-1.
*/


// The timer variables
static long time1, time2;
static long totaltime;


// The full size of the various lists.
// The idea is to set up some number of test runs in this space.
// For full timing tests, this should be 1,000,000.
// But for debugging purposes, might want to make it shorter to speed
// things up.
final static int TESTSIZE = 10000;


// ====================================================================
// The various arrays and lists used by the sorting process
static Integer[] size10 = new Integer[TESTSIZE];
static Integer[] size100 = new Integer[TESTSIZE];
static Integer[] size1000 = new Integer[TESTSIZE];
static Integer[] size10000 = new Integer[TESTSIZE];
static Integer[] size10Asc;
static Integer[] size100Asc;
static Integer[] size1000Asc;
static Integer[] size10000Asc;
static Integer[] size10Des;
static Integer[] size100Des;
static Integer[] size1000Des;
static Integer[] size10000Des;
static Integer[] size10Ide;
static Integer[] size100Ide;
static Integer[] size1000Ide;
static Integer[] size10000Ide;
static Integer[] size10FewDup;
static Integer[] size100FewDup;
static Integer[] size1000FewDup;
static Integer[] size10000FewDup;
static Integer[] size10SomeDup;
static Integer[] size100SomeDup;
static Integer[] size1000SomeDup;
static Integer[] size10000SomeDup;
static Integer[] size10ManyDup;
static Integer[] size100ManyDup;
static Integer[] size1000ManyDup;
static Integer[] size10000ManyDup;
static Integer[] size10SlightlyDis;
static Integer[] size100SlightlyDis;
static Integer[] size1000SlightlyDis;
static Integer[] size10000SlightlyDis;


static LinkedList<Integer> arrayList = new LinkedList<Integer>();
static LinkedList<Double> arrayListD = new LinkedList<Double>();
static LinkedList<LinkedList<Integer>> bucket = new LinkedList<LinkedList<Integer>>();


//double array
static double[] dsize10 = new double[TESTSIZE];
static double[] dsize100 = new double[TESTSIZE];
static double[] dsize1000 = new double[TESTSIZE];
static double[] dsize10000 = new double[TESTSIZE];
static double[] dsize10Asc = new double[TESTSIZE];
static double[] dsize100Asc = new double[TESTSIZE];
static double[] dsize1000Asc = new double[TESTSIZE];
static double[] dsize10000Asc = new double[TESTSIZE];
static double[] dsize10Des = new double[TESTSIZE];
static double[] dsize100Des = new double[TESTSIZE];
static double[] dsize1000Des = new double[TESTSIZE];
static double[] dsize10000Des = new double[TESTSIZE];
static double[] dsize10Ide = new double[TESTSIZE];
static double[] dsize100Ide = new double[TESTSIZE];
static double[] dsize1000Ide = new double[TESTSIZE];
static double[] dsize10000Ide = new double[TESTSIZE];
static double[] dsize10FewDup = new double[TESTSIZE];
static double[] dsize100FewDup = new double[TESTSIZE];
static double[] dsize1000FewDup = new double[TESTSIZE];
static double[] dsize10000FewDup = new double[TESTSIZE];
static double[] dsize10SomeDup = new double[TESTSIZE];
static double[] dsize100SomeDup = new double[TESTSIZE];
static double[] dsize1000SomeDup = new double[TESTSIZE];
static double[] dsize10000SomeDup = new double[TESTSIZE];
static double[] dsize10ManyDup = new double[TESTSIZE];
static double[] dsize100ManyDup = new double[TESTSIZE];
static double[] dsize1000ManyDup = new double[TESTSIZE];
static double[] dsize10000ManyDup = new double[TESTSIZE];
static double[] dsize10SlightlyDis = new double[TESTSIZE];
static double[] dsize100SlightlyDis = new double[TESTSIZE];
static double[] dsize1000SlightlyDis = new double[TESTSIZE];
static double[] dsize10000SlightlyDis = new double[TESTSIZE];


static int[] int10;      // For lists of size 10
static int[] int10Asc;
static int[] int10Des;
static int[] int10Ide;
static int[] int10FewDup;
static int[] int10SomeDup;
static int[] int10ManyDup;
static int[] int10SlightlyDis;
static int[] int100;     // For lists of size 100
static int[] int100Asc;
static int[] int100Des;
static int[] int100Ide;
static int[] int100FewDup;
static int[] int100SomeDup;
static int[] int100ManyDup;
static int[] int100SlightlyDis;
static int[] int1000;     // For lists of size 1000
static int[] int1000Asc;
static int[] int1000Des;
static int[] int1000Ide;
static int[] int1000FewDup;
static int[] int1000SomeDup;
static int[] int1000ManyDup;
static int[] int1000SlightlyDis;
static int[] int10000;     // For lists of size 10000
static int[] int10000Asc;
static int[] int10000Des;
static int[] int10000Ide;
static int[] int10000FewDup;
static int[] int10000SomeDup;
static int[] int10000ManyDup;
static int[] int10000SlightlyDis;
static int[] int100000;     // For lists of size 100000
static int[] int100000Asc;
static int[] int100000Des;
static int[] int100000Ide;
static int[] int100000FewDup;
static int[] int100000SomeDup;
static int[] int100000ManyDup;
static int[] int100000SlightlyDis;
static int[] int1000000;     // For lists of size 1000000
static int[] int1000000Asc;
static int[] int1000000Des;
static int[] int1000000Ide;
static int[] int1000000FewDup;
static int[] int1000000SomeDup;
static int[] int1000000ManyDup;
static int[] int1000000SlightlyDis;



public static void main(String[]args){

	sorttime();
}

static int random(int n) {
  return Math.abs(value.nextInt()) % n;
}


// ====================================================================
// Swap section: Swap the values in a list
// Add more versions of swap as needed.

// Swap for double arrays
static void swapDouble(double[] A, int i, int j) {
  double temp = A[i];
  A[i] = A[j];
  A[j] = temp;
}

// Swap for Integer arrays
static void swapInteger(Integer[] A, int i, int j) {
  int temp = A[i];
  A[i] = A[j];
  A[j] = temp;
}

// ====================================================================
// Permute section: Randomly permute the values in a list
// Add more versions of permute as needed.

static void permute(int[] A, int startpos, int length) {
  for (int i = startpos + length; i > startpos; i--) // for each i
    swap(A, i-1, startpos + random(length)); // swap A[i-1] with a random
}                                            // position in the range 0 to i-1.


static void permuteInteger(Integer[] A, int startpos, int length) {
  for (int i = startpos + length; i > startpos; i--) // for each i
    swapInteger(A, i-1, startpos + random(length)); // swap A[i-1] with a random
}                                            // position in the range 0 to i-1.



static void permuteDouble(double[] A, int startpos, int length) {
  for (int i = startpos + length; i > startpos; i--) // for each i
    swapDouble(A, i-1, startpos + random(length)); // swap A[i-1] with a random
}                                            // position in the range 0 to i-1.


static void fewDuplicates(int[] A, int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0; i<(length*0.1); i++)
	{
		randomValue = random(length);
		randomValue2 = random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue)
		{
			randomValue = random(length);
			randomValue2 = random(length);
		}
		A[randomValue] = randomValue2;
	}
	
	
}

static void fewDuplicatesDouble(double[] A, int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0; i<(length*0.1); i++)
	{
		randomValue = random(length);
		randomValue2 = random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue)
		{
			randomValue = random(length);
			randomValue2 = random(length);
		}
		A[randomValue] = randomValue2;
	}
	
	
}

static void fewDuplicatesInteger(Integer[] A, int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0; i<(length*0.1); i++)
	{
		randomValue = random(length);
		randomValue2 = random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue)
		{
			randomValue = random(length);
			randomValue2 = random(length);
		}
		A[randomValue] = randomValue2;
	}
	
	
}

static void someDuplicates(int[] A,int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0;i<(length*0.2); i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}
		A[randomValue]=randomValue2;
	}
}

static void someDuplicatesInteger(Integer[] A,int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0;i<(length*0.2); i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}
		A[randomValue]=randomValue2;
	}
}

static void someDuplicatesDouble(double[] A,int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0;i<(length*0.2); i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}
		A[randomValue]=randomValue2;
	}
}

static void manyDuplicates(int[] A,int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0;i<(length*0.5); i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}
		A[randomValue]=randomValue2;
	}
}

static void manyDuplicatesInteger(Integer[] A,int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0;i<(length*0.5); i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}
		A[randomValue]=randomValue2;
	}
}

static void manyDuplicatesDouble(double[] A,int startpos, int length){
	int randomValue, randomValue2;
	for(int i=0;i<(length*0.5); i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}
		A[randomValue]=randomValue2;
	}
}

static void slightlyDisordered(int[] A,int startpos, int length){
	int temp,randomValue,randomValue2;
	for(int i=0;i<(length*0.1);i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}	
		temp=A[randomValue];
		A[randomValue]=A[randomValue2];
		A[randomValue2]=temp;
	}
}

static void slightlyDisorderedInteger(Integer[] A,int startpos, int length){
	int temp,randomValue,randomValue2;
	for(int i=0;i<(length*0.1);i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}	
		temp=A[randomValue];
		A[randomValue]=A[randomValue2];
		A[randomValue2]=temp;
	}
}

static void slightlyDisorderedDouble(double[] A,int startpos, int length){
	int randomValue,randomValue2;
	double temp;
	for(int i=0;i<(length*0.1);i++){
		randomValue=random(length);
		randomValue2=random(length);
		while(randomValue==randomValue2 && A[randomValue]==randomValue){
			randomValue=random(length);
			randomValue2=random(length);
		}	
		temp=A[randomValue];
		A[randomValue]=A[randomValue2];
		A[randomValue2]=temp;
	}
}



// ====================================================================
// This section is for initializing the various lists for the many
// tests.
// Add a new version of "setup" for each data type.
// Add to each version of "setup" for additional tests.

static void setupDouble() {
  int startpos; // Each tests start position in array
  int numtests; // Number of tests of this size
  int i, j;

  numtests = TESTSIZE/10;
 for (i=0; i<numtests; i++) {
    startpos = 10 * i;
    for (j=0; j<10; j++){
      dsize10[startpos + j] = j;
      dsize10Asc[startpos + j] = j; //ascending order size of 10
      dsize10Des[startpos + j] = 10-j-1;
      dsize10Ide[startpos + j] = 9;
      dsize10FewDup[startpos + j] = j;
      dsize10SomeDup[startpos + j] = j;
      dsize10ManyDup[startpos + j] = j;
      dsize10SlightlyDis[startpos + j] = j;

    }
    permuteDouble(dsize10, startpos, 10);
    fewDuplicatesDouble(dsize10FewDup,startpos,10);
    someDuplicatesDouble(dsize10SomeDup,startpos,10);
    manyDuplicatesDouble(dsize10ManyDup,startpos,10);
    slightlyDisorderedDouble(dsize10SlightlyDis,startpos,10);
  }

  numtests = TESTSIZE/100;
 for (i=0; i<numtests; i++) {
    startpos = 100 * i;
    for (j=0; j<100; j++){
      dsize100[startpos + j] = j;
      dsize100Asc[startpos + j] = j; //ascending order size of 100
      dsize100Des[startpos + j] = 100-j-1;
      dsize100Ide[startpos + j] = 99;
      dsize100FewDup[startpos + j] = j;
      dsize100SomeDup[startpos + j] = j;
      dsize100ManyDup[startpos + j] = j;
      dsize100SlightlyDis[startpos + j] = j;

    }
    permuteDouble(dsize100, startpos, 100);
    fewDuplicatesDouble(dsize100FewDup,startpos,100);
    someDuplicatesDouble(dsize100SomeDup,startpos,100);
    manyDuplicatesDouble(dsize100ManyDup,startpos,100);
    slightlyDisorderedDouble(dsize100SlightlyDis,startpos,100);
  }

  numtests = TESTSIZE/1000;
 for (i=0; i<numtests; i++) {
    startpos = 1000 * i;
    for (j=0; j<1000; j++){
      dsize1000[startpos + j] = j;
      dsize1000Asc[startpos + j] = j; //ascending order size of 1000
      dsize1000Des[startpos + j] = 1000-j-1;
      dsize1000Ide[startpos + j] = 999;
      dsize1000FewDup[startpos + j] = j;
      dsize1000SomeDup[startpos + j] = j;
      dsize1000ManyDup[startpos + j] = j;
      dsize1000SlightlyDis[startpos + j] = j;

    }
    permuteDouble(dsize1000, startpos, 1000);
    fewDuplicatesDouble(dsize1000FewDup,startpos,1000);
    someDuplicatesDouble(dsize1000SomeDup,startpos,1000);
    manyDuplicatesDouble(dsize1000ManyDup,startpos,1000);
    slightlyDisorderedDouble(dsize1000SlightlyDis,startpos,1000);
  }

  numtests = TESTSIZE/10000;
 for (i=0; i<numtests; i++) {
    startpos = 10000 * i;
    for (j=0; j<10000; j++){
      dsize10000[startpos + j] = j;
      dsize10000Asc[startpos + j] = j; //ascending order size of 10000
      dsize10000Des[startpos + j] = 10000-j-1;
      dsize10000Ide[startpos + j] = 9999;
      dsize10000FewDup[startpos + j] = j;
      dsize10000SomeDup[startpos + j] = j;
      dsize10000ManyDup[startpos + j] = j;
      dsize10000SlightlyDis[startpos + j] = j;
    }
    permuteDouble(dsize10000, startpos, 10000);
    fewDuplicatesDouble(dsize10000FewDup,startpos,10000);
    someDuplicatesDouble(dsize10000SomeDup,startpos,10000);
    manyDuplicatesDouble(dsize10000ManyDup,startpos,10000);
    slightlyDisorderedDouble(dsize10000SlightlyDis,startpos,10000);
  }

}
static void setupInteger() {

  int startpos; // Each tests start position in array
  int numtests; // Number of tests of this size
  int i, j;
  size10Asc = new Integer[TESTSIZE];
  size10Des = new Integer[TESTSIZE];
  size10Ide = new Integer[TESTSIZE];
  size10FewDup = new Integer[TESTSIZE];
  size10SomeDup = new Integer[TESTSIZE];
  size10ManyDup = new Integer[TESTSIZE];
  size10SlightlyDis = new Integer[TESTSIZE];

  numtests = TESTSIZE/10;
 for (i=0; i<numtests; i++) {
    startpos = 10 * i;
    for (j=0; j<10; j++){
      size10[startpos + j] = j;
      size10Asc[startpos + j] = j; //ascending order size of 10
      size10Des[startpos + j] = 10-j-1;
      size10Ide[startpos + j] = 9;
      size10FewDup[startpos + j] = j;
      size10SomeDup[startpos + j] = j;
      size10ManyDup[startpos + j] = j;
      size10SlightlyDis[startpos + j] = j;

    }
    permuteInteger(size10, startpos, 10);
    fewDuplicatesInteger(size10FewDup,startpos,10);
    someDuplicatesInteger(size10SomeDup,startpos,10);
    manyDuplicatesInteger(size10ManyDup,startpos,10);
    slightlyDisorderedInteger(size10SlightlyDis,startpos,10);
  }


  size100Asc = new Integer[TESTSIZE];
  size100Des = new Integer[TESTSIZE];
  size100Ide = new Integer[TESTSIZE];
  size100FewDup = new Integer[TESTSIZE];
  size100SomeDup = new Integer[TESTSIZE];
  size100ManyDup = new Integer[TESTSIZE];
  size100SlightlyDis = new Integer[TESTSIZE];

  numtests = TESTSIZE/100;
 for (i=0; i<numtests; i++) {
    startpos = 100 * i;
    for (j=0; j<100; j++){
      size100[startpos + j] = j;
      size100Asc[startpos + j] = j; //ascending order size of 100
      size100Des[startpos + j] = 100-j-1;
      size100Ide[startpos + j] = 99;
      size100FewDup[startpos + j] = j;
      size100SomeDup[startpos + j] = j;
      size100ManyDup[startpos + j] = j;
      size100SlightlyDis[startpos + j] = j;

    }
    permuteInteger(size100, startpos, 100);
    fewDuplicatesInteger(size100FewDup,startpos,100);
    someDuplicatesInteger(size100SomeDup,startpos,100);
    manyDuplicatesInteger(size100ManyDup,startpos,100);
    slightlyDisorderedInteger(size100SlightlyDis,startpos,100);

  }

  size1000Asc = new Integer[TESTSIZE];
  size1000Des = new Integer[TESTSIZE];
  size1000Ide = new Integer[TESTSIZE];
  size1000FewDup = new Integer[TESTSIZE];
  size1000SomeDup = new Integer[TESTSIZE];
  size1000ManyDup = new Integer[TESTSIZE];
  size1000SlightlyDis = new Integer[TESTSIZE];

  numtests = TESTSIZE/1000;
 for (i=0; i<numtests; i++) {
    startpos = 1000 * i;
    for (j=0; j<1000; j++){
      size1000[startpos + j] = j;
      size1000Asc[startpos + j] = j; //ascending order size of 1000
      size1000Des[startpos + j] = 1000-j-1;
      size1000Ide[startpos + j] = 999;
      size1000FewDup[startpos + j] = j;
      size1000SomeDup[startpos + j] = j;
      size1000ManyDup[startpos + j] = j;
      size1000SlightlyDis[startpos + j] = j;

    }
    permuteInteger(size1000, startpos, 1000);
    fewDuplicatesInteger(size1000FewDup,startpos, 1000);
    someDuplicatesInteger(size1000SomeDup,startpos,1000);
    manyDuplicatesInteger(size1000ManyDup,startpos,1000);
    slightlyDisorderedInteger(size1000SlightlyDis,startpos,1000);

  }

  size10000Asc = new Integer[TESTSIZE];
  size10000Des = new Integer[TESTSIZE];
  size10000Ide = new Integer[TESTSIZE];
  size10000FewDup = new Integer[TESTSIZE];
  size10000SomeDup = new Integer[TESTSIZE];
  size10000ManyDup = new Integer[TESTSIZE];
  size10000SlightlyDis = new Integer[TESTSIZE];

  numtests = TESTSIZE/10000;
 for (i=0; i<numtests; i++) {
    startpos = 10000 * i;
    for (j=0; j<10000; j++){
      size10000[startpos + j] = j;
      size10000Asc[startpos + j] = j; //ascending order size of 10000
      size10000Des[startpos + j] = 10000-j-1;
      size10000Ide[startpos + j] = 9999;
      size10000FewDup[startpos + j] = j;
      size10000SomeDup[startpos + j] = j;
      size10000ManyDup[startpos + j] = j;
      size10000SlightlyDis[startpos + j] = j;
    }
    permuteInteger(size10000, startpos, 10000);
    fewDuplicatesInteger(size10000FewDup,startpos,10000);
    someDuplicatesInteger(size10000SomeDup,startpos,10000);
    manyDuplicatesInteger(size10000ManyDup,startpos,10000);
    slightlyDisorderedInteger(size10000SlightlyDis,startpos,10000);

  }
}
static void setupint() {
  int startpos; // Each tests start position in array
  int numtests; // Number of tests of this size
  int i, j;

  // int array of size 10: Uniform random distribution
  int10 = new int[TESTSIZE];
  int10Asc = new int[TESTSIZE];
  int10Des = new int[TESTSIZE];
  int10Ide = new int[TESTSIZE];
  int10FewDup = new int[TESTSIZE];
  int10SomeDup = new int[TESTSIZE];
  int10ManyDup = new int[TESTSIZE];
  int10SlightlyDis = new int[TESTSIZE];

  numtests = TESTSIZE/10;
  for (i=0; i<numtests; i++) {
    startpos = 10 * i;
    for (j=0; j<10; j++){
      int10[startpos + j] = j;
      int10Asc[startpos+j] = j;
      int10Des[startpos+j] = 10-j-1;
      int10Ide[startpos+j] = 9;
      int10FewDup[startpos+j] = j;
      int10SomeDup[startpos+j] = j;
      int10SlightlyDis[startpos+j] = j;
      int10ManyDup[startpos+j] = j;
    }
    permute(int10, startpos, 10);
    fewDuplicates(int10FewDup,startpos,10);
    someDuplicates(int10SomeDup,startpos,10);
    manyDuplicates(int10ManyDup,startpos,10);
    slightlyDisordered(int10SlightlyDis,startpos,10);
  }



  // int array of size 100: Uniform random distribution
  int100 = new int[TESTSIZE];
  int100Asc = new int[TESTSIZE];
  int100Des = new int[TESTSIZE];
  int100Ide = new int[TESTSIZE];
  int100FewDup = new int[TESTSIZE];
  int100SomeDup = new int[TESTSIZE];
  int100ManyDup = new int[TESTSIZE];
  int100SlightlyDis = new int[TESTSIZE];

  numtests = TESTSIZE/100;
  for (i=0; i<numtests; i++) {
    startpos = 100 * i;
    for (j=0; j<100; j++){
      int100[startpos + j] = j;
      int100Asc[startpos+j] = j;
      int100Des[startpos+j] = 100-j-1;
      int100Ide[startpos+j] = 99;
      int100FewDup[startpos+j] = j;
      int100SomeDup[startpos+j] = j;
      int100ManyDup[startpos+j] = j;
      int100SlightlyDis[startpos+j] = j;

    }
    permute(int100, startpos, 100);
    fewDuplicates(int100FewDup,startpos,100);
    someDuplicates(int100SomeDup,startpos,100);
    manyDuplicates(int100ManyDup,startpos,100);
    slightlyDisordered(int100SlightlyDis,startpos,100);

  }


 // int array of size 1000: Uniform random distribution
  int1000 = new int[TESTSIZE];
  int1000Asc = new int[TESTSIZE];
  int1000Des = new int[TESTSIZE];
  int1000Ide = new int[TESTSIZE];
  int1000FewDup = new int[TESTSIZE];
  int1000SomeDup = new int[TESTSIZE];
  int1000ManyDup = new int[TESTSIZE];
  int1000SlightlyDis = new int[TESTSIZE];

  numtests = TESTSIZE/1000;
  for (i=0; i<numtests; i++) {
    startpos = 1000 * i;
    for (j=0; j<1000; j++){
      int1000[startpos + j] = j;
      int1000Asc[startpos+j] = j;
      int1000Des[startpos+j] = 1000-j-1;
      int1000Ide[startpos+j] = 999;
      int1000FewDup[startpos+j] = j;
      int1000SomeDup[startpos+j] = j;
      int1000ManyDup[startpos+j] = j;
      int1000SlightlyDis[startpos+j] = j;

    }
    permute(int1000, startpos, 1000);
    fewDuplicates(int1000FewDup,startpos,1000);
    someDuplicates(int1000SomeDup,startpos,1000);
    manyDuplicates(int1000ManyDup,startpos,1000);
    slightlyDisordered(int1000SlightlyDis,startpos,1000);

  }

 // int array of size 10000: Uniform random distribution
  int10000 = new int[TESTSIZE];
  int10000Asc = new int[TESTSIZE];
  int10000Des = new int[TESTSIZE];
  int10000Ide = new int[TESTSIZE];
  int10000FewDup = new int[TESTSIZE];
  int10000SomeDup = new int[TESTSIZE];
  int10000ManyDup = new int[TESTSIZE];
  int10000SlightlyDis = new int[TESTSIZE];

  numtests = TESTSIZE/10000;
  for (i=0; i<numtests; i++) {
    startpos = 10000 * i;
    for (j=0; j<10000; j++){
      int10000[startpos + j] = j;
      int10000Asc[startpos+j] = j;
      int10000Des[startpos+j] = 10000-j-1;
      int10000Ide[startpos+j] = 9999;
      int10000FewDup[startpos+j] = j;
      int10000SomeDup[startpos+j] = j;
      int10000ManyDup[startpos+j] = j;
      int10000SlightlyDis[startpos+j] = j;

    }
    permute(int10000, startpos, 10000);
    fewDuplicates(int10000FewDup,startpos,10000);
    someDuplicates(int10000SomeDup,startpos,10000);
    manyDuplicates(int10000ManyDup,startpos,10000);
    slightlyDisordered(int10000SlightlyDis,startpos,10000);

  }

 // int array of size 100000: Uniform random distribution
  int100000 = new int[TESTSIZE];
  int100000Asc = new int[TESTSIZE];
  int100000Des = new int[TESTSIZE];
  int100000Ide = new int[TESTSIZE];
  int100000FewDup = new int[TESTSIZE];
  int100000SomeDup = new int[TESTSIZE];
  int100000ManyDup = new int[TESTSIZE];
  int100000SlightlyDis = new int[TESTSIZE];

  numtests = TESTSIZE/100000;
  for (i=0; i<numtests; i++) {
    startpos = 100000 * i;
    for (j=0; j<100000; j++){
      int100000[startpos + j] = j;
      int100000Asc[startpos+j] = j;
      int100000Des[startpos+j] = 100000-j-1;
      int100000Ide[startpos+j] = 99999;
      int100000FewDup[startpos+j] = j;
      int100000SomeDup[startpos+j] = j;
      int100000ManyDup[startpos+j] = j;
      int100000SlightlyDis[startpos+j] = j;

    }
    permute(int100000, startpos, 100000);
    fewDuplicates(int100000FewDup,startpos,100000);
    someDuplicates(int100000SomeDup,startpos,100000);
    manyDuplicates(int100000ManyDup,startpos,100000);
    slightlyDisordered(int100000SlightlyDis,startpos,100000);

  }

 // int array of size 1000000: Uniform random distribution
  int1000000 = new int[TESTSIZE];
  int1000000Asc = new int[TESTSIZE];
  int1000000Des = new int[TESTSIZE];
  int1000000Ide = new int[TESTSIZE];
  int1000000FewDup = new int[TESTSIZE];
  int1000000SomeDup = new int[TESTSIZE];
  int1000000ManyDup = new int[TESTSIZE];
  int1000000SlightlyDis = new int[TESTSIZE];

  numtests = TESTSIZE/1000000;
  for (i=0; i<numtests; i++) {
    startpos = 1000000 * i;
    for (j=0; j<1000000; j++){
      int1000000[startpos + j] = j;
      int1000000Asc[startpos+j] = j;
      int1000000Des[startpos+j] = 1000000-j-1;
      int1000000Ide[startpos+j] = 999999;
      int1000000FewDup[startpos+j] = j;
      int1000000SomeDup[startpos+j] = j;
      int1000000ManyDup[startpos+j] = j;
      int1000000SlightlyDis[startpos+j] = j;

    }
    permute(int1000000, startpos, 1000000);
    fewDuplicates(int1000000FewDup,startpos,1000000);
    someDuplicates(int1000000SomeDup,startpos,1000000);
    manyDuplicates(int1000000ManyDup,startpos,1000000);
    slightlyDisordered(int1000000SlightlyDis,startpos,1000000);

  }
}



// Swap for int arrays
static void swap(int[] A, int i, int j) {
  int temp = A[i];
  A[i] = A[j];
  A[j] = temp;
}

// Swap for int arrays
static void swap(Object[] A, int i, int j) {
  Object temp = A[i];
  A[i] = A[j];
  A[j] = temp;
}


// Convenience functions for consistency with Processing code

static public void println(String s) {
  System.out.println(s);
}

static public long millis() {
  return System.nanoTime();
}
static Boolean checkorder(int[] A) {
  Boolean status = true;
  for (int i=1; i<A.length; i++)
    if (A[i] < A[i-1]) {
      println("Error! Value " + A[i] + " at position " + i +
              " was less than " + A[i-1] + " at position " + (i-1));
      status = false;
    }
  return status;
}

static <T extends Comparable<T>> Boolean checkorder(T[] A) {
  Boolean status = true;
  for (int i=1; i<A.length; i++)
    if (A[i].compareTo(A[i-1]) < 0) {
      println("Error! Value " + A[i] + " at position " + i +
              " was less than " + A[i-1] + " at position " + (i-1));
      status = false;
    }
  return status;
}
static void sorttime() {

// inssort
setupint();


bubblesortcheck(int10,10);
System.out.println("bubblesortcheck Time for lists of size 10: "+ totaltime);

bubblesortcheck(int10Asc,10);
System.out.println("bubblesortcheck Time for lists of size 10 in ascending order: "+ totaltime);

bubblesortcheck(int10Des,10);
System.out.println("bubblesortcheck Time for lists of size 10 in descending order: "+ totaltime);

bubblesortcheck(int10Ide,10);
System.out.println("bubblesortcheck Time for lists of size 10 idendical keys: "+ totaltime);

bubblesortcheck(int10FewDup,10);
System.out.println("bubblesortcheck Time for lists of size 10 Few Duplicates: "+ totaltime);

bubblesortcheck(int10SomeDup,10);
System.out.println("bubblesortcheck Time for lists of size 10 Some Duplicates: "+ totaltime);

bubblesortcheck(int10ManyDup,10);
System.out.println("bubblesortcheck Time for lists of size 10 Many Duplicates: "+ totaltime);

bubblesortcheck(int10SlightlyDis,10);
System.out.println("bubblesortcheck Time for lists of size 10 Slightly Distributed: "+ totaltime);

System.out.println();

bubblesortcheck(int100,100);
System.out.println("bubblesortcheck Time for lists of size 100: "+totaltime);

bubblesortcheck(int100Asc,100);
System.out.println("bubblesortcheck Time for lists of size 100 in ascending order: "+ totaltime);

bubblesortcheck(int100Des,100);
System.out.println("bubblesortcheck Time for lists of size 100 in descending order: "+ totaltime);

bubblesortcheck(int100Ide,100);
System.out.println("bubblesortcheck Time for lists of size 100 idendical keys: "+ totaltime);

bubblesortcheck(int100FewDup,100);
System.out.println("bubblesortcheck Time for lists of size 100 Few Duplicates: "+ totaltime);

bubblesortcheck(int100SomeDup,100);
System.out.println("bubblesortcheck Time for lists of size 100 Some Duplicates: "+ totaltime);

bubblesortcheck(int100ManyDup,100);
System.out.println("bubblesortcheck Time for lists of size 100 Many Duplicates: "+ totaltime);

bubblesortcheck(int100SlightlyDis,100);
System.out.println("bubblesortcheck Time for lists of size 100 Slightly Distributed: "+ totaltime);

System.out.println();

bubblesortcheck(int1000,1000);
System.out.println("bubblesortcheck Time for lists of size 1000: "+totaltime);

bubblesortcheck(int1000Asc,1000);
System.out.println("bubblesortcheck Time for lists of size 1000 in ascending order: "+ totaltime);

bubblesortcheck(int1000Des,1000);
System.out.println("bubblesortcheck Time for lists of size 1000 in descending order: "+ totaltime);

bubblesortcheck(int1000Ide,1000);
System.out.println("bubblesortcheck Time for lists of size 1000 idendical keys: "+ totaltime);

bubblesortcheck(int1000FewDup,1000);
System.out.println("bubblesortcheck Time for lists of size 1000 Few Duplicates: "+ totaltime);

bubblesortcheck(int1000SomeDup,1000);
System.out.println("bubblesortcheck Time for lists of size 1000 Some Duplicates: "+ totaltime);

bubblesortcheck(int1000SlightlyDis,1000);
System.out.println("bubblesortcheck Time for lists of size 1000 Slightly Distributed: "+ totaltime);

bubblesortcheck(int1000ManyDup,1000);
System.out.println("bubblesortcheck Time for lists of size 1000 Many Duplicates: "+ totaltime);

System.out.println();

bubblesortcheck(int10000,10000);
System.out.println("bubblesortcheck Time for lists of size 10000: "+totaltime);

bubblesortcheck(int10000Asc,10000);
System.out.println("bubblesortcheck Time for lists of size 10000 in ascending order: "+ totaltime);

bubblesortcheck(int10000Des,10000);
System.out.println("bubblesortcheck Time for lists of size 10000 in descending order: "+ totaltime);

bubblesortcheck(int10000Ide,10000);
System.out.println("bubblesortcheck Time for lists of size 10000 idendical keys: "+ totaltime);

bubblesortcheck(int10000FewDup,10000);
System.out.println("bubblesortcheck Time for lists of size 10000 Few Duplicates: "+ totaltime);

bubblesortcheck(int10000SomeDup,10000);
System.out.println("bubblesortcheck Time for lists of size 10000 Some Duplicates: "+ totaltime);

bubblesortcheck(int10000SlightlyDis,10000);
System.out.println("bubblesortcheck Time for lists of size 10000 Slightly Distributed: "+ totaltime);

bubblesortcheck(int10000ManyDup,10000);
System.out.println("bubblesortcheck Time for lists of size 10000 Many Duplicates: "+ totaltime);

System.out.println();


// inssort
setupint();


bubblesortcheck2(int10,10);
System.out.println("bubblesortcheck2 Time for lists of size 10: "+ totaltime);

bubblesortcheck2(int10Asc,10);
System.out.println("bubblesortcheck2 Time for lists of size 10 in ascending order: "+ totaltime);

bubblesortcheck2(int10Des,10);
System.out.println("bubblesortcheck2 Time for lists of size 10 in descending order: "+ totaltime);

bubblesortcheck2(int10Ide,10);
System.out.println("bubblesortcheck2 Time for lists of size 10 idendical keys: "+ totaltime);

bubblesortcheck2(int10FewDup,10);
System.out.println("bubblesortcheck2 Time for lists of size 10 Few Duplicates: "+ totaltime);

bubblesortcheck2(int10SomeDup,10);
System.out.println("bubblesortcheck2 Time for lists of size 10 Some Duplicates: "+ totaltime);

bubblesortcheck2(int10ManyDup,10);
System.out.println("bubblesortcheck2 Time for lists of size 10 Many Duplicates: "+ totaltime);

bubblesortcheck2(int10SlightlyDis,10);
System.out.println("bubblesortcheck2 Time for lists of size 10 Slightly Distributed: "+ totaltime);

System.out.println();

bubblesortcheck2(int100,100);
System.out.println("bubblesortcheck2 Time for lists of size 100: "+totaltime);

bubblesortcheck2(int100Asc,100);
System.out.println("bubblesortcheck2 Time for lists of size 100 in ascending order: "+ totaltime);

bubblesortcheck2(int100Des,100);
System.out.println("bubblesortcheck2 Time for lists of size 100 in descending order: "+ totaltime);

bubblesortcheck2(int100Ide,100);
System.out.println("bubblesortcheck2 Time for lists of size 100 idendical keys: "+ totaltime);

bubblesortcheck2(int100FewDup,100);
System.out.println("bubblesortcheck2 Time for lists of size 100 Few Duplicates: "+ totaltime);

bubblesortcheck2(int100SomeDup,100);
System.out.println("bubblesortcheck2 Time for lists of size 100 Some Duplicates: "+ totaltime);

bubblesortcheck2(int100ManyDup,100);
System.out.println("bubblesortcheck2 Time for lists of size 100 Many Duplicates: "+ totaltime);

bubblesortcheck2(int100SlightlyDis,100);
System.out.println("bubblesortcheck2 Time for lists of size 100 Slightly Distributed: "+ totaltime);

System.out.println();

bubblesortcheck2(int1000,1000);
System.out.println("bubblesortcheck2 Time for lists of size 1000: "+totaltime);

bubblesortcheck2(int1000Asc,1000);
System.out.println("bubblesortcheck2 Time for lists of size 1000 in ascending order: "+ totaltime);

bubblesortcheck2(int1000Des,1000);
System.out.println("bubblesortcheck2 Time for lists of size 1000 in descending order: "+ totaltime);

bubblesortcheck2(int1000Ide,1000);
System.out.println("bubblesortcheck2 Time for lists of size 1000 idendical keys: "+ totaltime);

bubblesortcheck2(int1000FewDup,1000);
System.out.println("bubblesortcheck2 Time for lists of size 1000 Few Duplicates: "+ totaltime);

bubblesortcheck2(int1000SomeDup,1000);
System.out.println("bubblesortcheck2 Time for lists of size 1000 Some Duplicates: "+ totaltime);

bubblesortcheck2(int1000SlightlyDis,1000);
System.out.println("bubblesortcheck2 Time for lists of size 1000 Slightly Distributed: "+ totaltime);

bubblesortcheck2(int1000ManyDup,1000);
System.out.println("bubblesortcheck2 Time for lists of size 1000 Many Duplicates: "+ totaltime);

System.out.println();

bubblesortcheck2(int10000,10000);
System.out.println("bubblesortcheck2 Time for lists of size 10000: "+totaltime);

bubblesortcheck2(int10000Asc,10000);
System.out.println("bubblesortcheck2 Time for lists of size 10000 in ascending order: "+ totaltime);

bubblesortcheck2(int10000Des,10000);
System.out.println("bubblesortcheck2 Time for lists of size 10000 in descending order: "+ totaltime);

bubblesortcheck2(int10000Ide,10000);
System.out.println("bubblesortcheck2 Time for lists of size 10000 idendical keys: "+ totaltime);

bubblesortcheck2(int10000FewDup,10000);
System.out.println("bubblesortcheck2 Time for lists of size 10000 Few Duplicates: "+ totaltime);

bubblesortcheck2(int10000SomeDup,10000);
System.out.println("bubblesortcheck2 Time for lists of size 10000 Some Duplicates: "+ totaltime);

bubblesortcheck2(int10000SlightlyDis,10000);
System.out.println("bubblesortcheck2 Time for lists of size 10000 Slightly Distributed: "+ totaltime);

bubblesortcheck2(int10000ManyDup,10000);
System.out.println("bubblesortcheck2 Time for lists of size 10000 Many Duplicates: "+ totaltime);

System.out.println();

System.out.println();

System.out.println();

System.out.println();

setupInteger();


bubblecheckswap(size10,10);
System.out.println("bubblecheckswap Time for lists of size 10 Integer random distribution: "+ totaltime);

bubblecheckswap(size10Asc,10);
System.out.println("bubblecheckswap Time for lists of size 10 Integer in ascending order: "+ totaltime);

bubblecheckswap(size10Des,10);
System.out.println("bubblecheckswap Time for lists of size 10 Integer in decreasing order: "+ totaltime);

bubblecheckswap(size10Ide,10);
System.out.println("bubblecheckswap Time for lists of size 10 Integer idendical keys: "+ totaltime);

bubblecheckswap(size10FewDup,10);
System.out.println("bubblecheckswap Time for lists of size 10 Integer Few Duplicates: "+ totaltime);

bubblecheckswap(size10SomeDup,10);
System.out.println("bubblecheckswap Time for lists of size 10 Integer Some Duplicates: "+ totaltime);

bubblecheckswap(size10ManyDup,10);
System.out.println("bubblecheckswap Time for lists of size 10 Integer Many Duplicates: "+ totaltime);

bubblecheckswap(size10SlightlyDis,10);
System.out.println("bubblecheckswap Time for lists of size 10 Integer Slightly Disordered: "+ totaltime);

System.out.println();

bubblecheckswap(size100,100);
System.out.println("bubblecheckswap Time for lists of size 100 Integer random distribution: "+ totaltime);

bubblecheckswap(size100Asc,100);
System.out.println("bubblecheckswap Time for lists of size 100 Integer in ascending order: "+ totaltime);

bubblecheckswap(size100Des,100);
System.out.println("bubblecheckswap Time for lists of size 100 Integer in decreasing order: "+ totaltime);

bubblecheckswap(size100Ide,100);
System.out.println("bubblecheckswap Time for lists of size 100 Integer idendical keys: "+ totaltime);

bubblecheckswap(size100FewDup,100);
System.out.println("bubblecheckswap Time for lists of size 100 Integer Few Duplicates: "+ totaltime);

bubblecheckswap(size100SomeDup,100);
System.out.println("bubblecheckswap Time for lists of size 100 Integer Some Duplicates: "+ totaltime);

bubblecheckswap(size100ManyDup,100);
System.out.println("bubblecheckswap Time for lists of size 100 Integer Many Duplicates: "+ totaltime);

bubblecheckswap(size100SlightlyDis,100);
System.out.println("bubblecheckswap Time for lists of size 100 Integer Slightly Disordered: "+ totaltime);

System.out.println();

bubblecheckswap(size1000,1000);
System.out.println("bubblecheckswap Time for lists of size 1000 Integer random distribution: "+ totaltime);

bubblecheckswap(size100Asc,1000);
System.out.println("bubblecheckswap Time for lists of size 1000 Integer in ascending order: "+ totaltime);

bubblecheckswap(size1000Des,1000);
System.out.println("bubblecheckswap Time for lists of size 1000 Integer in decreasing order: "+ totaltime);

bubblecheckswap(size1000Ide,1000);
System.out.println("bubblecheckswap Time for lists of size 1000 Integer idendical keys: "+ totaltime);

bubblecheckswap(size1000FewDup,1000);
System.out.println("bubblecheckswap Time for lists of size 1000 Integer Few Duplicates "+ totaltime);

bubblecheckswap(size1000SomeDup,1000);
System.out.println("bubblecheckswap Time for lists of size 1000 Integer Some Duplicates "+ totaltime);

bubblecheckswap(size1000ManyDup,1000);
System.out.println("bubblecheckswap Time for lists of size 1000 Integer Many Duplicates "+ totaltime);

bubblecheckswap(size1000SlightlyDis,1000);
System.out.println("bubblecheckswap Time for lists of size 1000 Integer Slightly Disordered: "+ totaltime);

System.out.println();

bubblecheckswap(size10000,10000);
System.out.println("bubblecheckswap Time for lists of size 10000 Integer random distribution: "+ totaltime);

bubblecheckswap(size10000Asc,10000);
System.out.println("bubblecheckswap Time for lists of size 10000 Integer in ascending order: "+ totaltime);

bubblecheckswap(size10000Des,10000);
System.out.println("bubblecheckswap Time for lists of size 10000 Integer in decreasing order: "+ totaltime);

bubblecheckswap(size10000Ide,10000);
System.out.println("bubblecheckswap Time for lists of size 10000 Integer idendical keys: "+ totaltime);

bubblecheckswap(size10000FewDup,10000);
System.out.println("bubblecheckswap Time for lists of size 10000 Integer Few Duplicates: "+ totaltime);

bubblecheckswap(size10000SomeDup,10000);
System.out.println("bubblecheckswap Time for lists of size 10000 Integer Some Duplicates: "+ totaltime);

bubblecheckswap(size10000ManyDup,10000);
System.out.println("bubblecheckswap Time for lists of size 10000 Integer Many Duplicates: "+ totaltime);

bubblecheckswap(size10000SlightlyDis,10000);
System.out.println("bubblecheckswap Time for lists of size 10000 Integer Slightly Disordered: "+ totaltime);

System.out.println();

// inssort
setupint();


unwikipedia(int10,10);
System.out.println("unwikipedia Time for lists of size 10: "+ totaltime);

unwikipedia(int10Asc,10);
System.out.println("unwikipedia Time for lists of size 10 in ascending order: "+ totaltime);

unwikipedia(int10Des,10);
System.out.println("unwikipedia Time for lists of size 10 in descending order: "+ totaltime);

unwikipedia(int10Ide,10);
System.out.println("unwikipedia Time for lists of size 10 idendical keys: "+ totaltime);

unwikipedia(int10FewDup,10);
System.out.println("unwikipedia Time for lists of size 10 Few Duplicates: "+ totaltime);

unwikipedia(int10SomeDup,10);
System.out.println("unwikipedia Time for lists of size 10 Some Duplicates: "+ totaltime);

unwikipedia(int10ManyDup,10);
System.out.println("unwikipedia Time for lists of size 10 Many Duplicates: "+ totaltime);

unwikipedia(int10SlightlyDis,10);
System.out.println("unwikipedia Time for lists of size 10 Slightly Distributed: "+ totaltime);

System.out.println();

unwikipedia(int100,100);
System.out.println("unwikipedia Time for lists of size 100: "+totaltime);

unwikipedia(int100Asc,100);
System.out.println("unwikipedia Time for lists of size 100 in ascending order: "+ totaltime);

unwikipedia(int100Des,100);
System.out.println("unwikipedia Time for lists of size 100 in descending order: "+ totaltime);

unwikipedia(int100Ide,100);
System.out.println("unwikipedia Time for lists of size 100 idendical keys: "+ totaltime);

unwikipedia(int100FewDup,100);
System.out.println("unwikipedia Time for lists of size 100 Few Duplicates: "+ totaltime);

unwikipedia(int100SomeDup,100);
System.out.println("unwikipedia Time for lists of size 100 Some Duplicates: "+ totaltime);

unwikipedia(int100ManyDup,100);
System.out.println("unwikipedia Time for lists of size 100 Many Duplicates: "+ totaltime);

unwikipedia(int100SlightlyDis,100);
System.out.println("unwikipedia Time for lists of size 100 Slightly Distributed: "+ totaltime);

System.out.println();

unwikipedia(int1000,1000);
System.out.println("unwikipedia Time for lists of size 1000: "+totaltime);

unwikipedia(int1000Asc,1000);
System.out.println("unwikipedia Time for lists of size 1000 in ascending order: "+ totaltime);

unwikipedia(int1000Des,1000);
System.out.println("unwikipedia Time for lists of size 1000 in descending order: "+ totaltime);

unwikipedia(int1000Ide,1000);
System.out.println("unwikipedia Time for lists of size 1000 idendical keys: "+ totaltime);

unwikipedia(int1000FewDup,1000);
System.out.println("unwikipedia Time for lists of size 1000 Few Duplicates: "+ totaltime);

unwikipedia(int1000SomeDup,1000);
System.out.println("unwikipedia Time for lists of size 1000 Some Duplicates: "+ totaltime);

unwikipedia(int1000SlightlyDis,1000);
System.out.println("unwikipedia Time for lists of size 1000 Slightly Distributed: "+ totaltime);

unwikipedia(int1000ManyDup,1000);
System.out.println("unwikipedia Time for lists of size 1000 Many Duplicates: "+ totaltime);

System.out.println();

unwikipedia(int10000,10000);
System.out.println("unwikipedia Time for lists of size 10000: "+totaltime);

unwikipedia(int10000Asc,10000);
System.out.println("unwikipedia Time for lists of size 10000 in ascending order: "+ totaltime);

unwikipedia(int10000Des,10000);
System.out.println("unwikipedia Time for lists of size 10000 in descending order: "+ totaltime);

unwikipedia(int10000Ide,10000);
System.out.println("unwikipedia Time for lists of size 10000 idendical keys: "+ totaltime);

unwikipedia(int10000FewDup,10000);
System.out.println("unwikipedia Time for lists of size 10000 Few Duplicates: "+ totaltime);

unwikipedia(int10000SomeDup,10000);
System.out.println("unwikipedia Time for lists of size 10000 Some Duplicates: "+ totaltime);

unwikipedia(int10000SlightlyDis,10000);
System.out.println("unwikipedia Time for lists of size 10000 Slightly Distributed: "+ totaltime);

unwikipedia(int10000ManyDup,10000);
System.out.println("unwikipedia Time for lists of size 10000 Many Duplicates: "+ totaltime);

System.out.println();


// inssort
setupint();


wikipedia2(int10,10);
System.out.println("wikipedia2 Time for lists of size 10: "+ totaltime);

wikipedia2(int10Asc,10);
System.out.println("wikipedia2 Time for lists of size 10 in ascending order: "+ totaltime);

wikipedia2(int10Des,10);
System.out.println("wikipedia2 Time for lists of size 10 in descending order: "+ totaltime);

wikipedia2(int10Ide,10);
System.out.println("wikipedia2 Time for lists of size 10 idendical keys: "+ totaltime);

wikipedia2(int10FewDup,10);
System.out.println("wikipedia2 Time for lists of size 10 Few Duplicates: "+ totaltime);

wikipedia2(int10SomeDup,10);
System.out.println("wikipedia2 Time for lists of size 10 Some Duplicates: "+ totaltime);

wikipedia2(int10ManyDup,10);
System.out.println("wikipedia2 Time for lists of size 10 Many Duplicates: "+ totaltime);

wikipedia2(int10SlightlyDis,10);
System.out.println("wikipedia2 Time for lists of size 10 Slightly Distributed: "+ totaltime);

System.out.println();

wikipedia2(int100,100);
System.out.println("wikipedia2 Time for lists of size 100: "+totaltime);

wikipedia2(int100Asc,100);
System.out.println("wikipedia2 Time for lists of size 100 in ascending order: "+ totaltime);

wikipedia2(int100Des,100);
System.out.println("wikipedia2 Time for lists of size 100 in descending order: "+ totaltime);

wikipedia2(int100Ide,100);
System.out.println("wikipedia2 Time for lists of size 100 idendical keys: "+ totaltime);

wikipedia2(int100FewDup,100);
System.out.println("wikipedia2 Time for lists of size 100 Few Duplicates: "+ totaltime);

wikipedia2(int100SomeDup,100);
System.out.println("wikipedia2 Time for lists of size 100 Some Duplicates: "+ totaltime);

wikipedia2(int100ManyDup,100);
System.out.println("wikipedia2 Time for lists of size 100 Many Duplicates: "+ totaltime);

wikipedia2(int100SlightlyDis,100);
System.out.println("wikipedia2 Time for lists of size 100 Slightly Distributed: "+ totaltime);

System.out.println();

wikipedia2(int1000,1000);
System.out.println("wikipedia2 Time for lists of size 1000: "+totaltime);

wikipedia2(int1000Asc,1000);
System.out.println("wikipedia2 Time for lists of size 1000 in ascending order: "+ totaltime);

wikipedia2(int1000Des,1000);
System.out.println("wikipedia2 Time for lists of size 1000 in descending order: "+ totaltime);

wikipedia2(int1000Ide,1000);
System.out.println("wikipedia2 Time for lists of size 1000 idendical keys: "+ totaltime);

wikipedia2(int1000FewDup,1000);
System.out.println("wikipedia2 Time for lists of size 1000 Few Duplicates: "+ totaltime);

wikipedia2(int1000SomeDup,1000);
System.out.println("wikipedia2 Time for lists of size 1000 Some Duplicates: "+ totaltime);

wikipedia2(int1000SlightlyDis,1000);
System.out.println("wikipedia2 Time for lists of size 1000 Slightly Distributed: "+ totaltime);

wikipedia2(int1000ManyDup,1000);
System.out.println("wikipedia2 Time for lists of size 1000 Many Duplicates: "+ totaltime);

System.out.println();

wikipedia2(int10000,10000);
System.out.println("wikipedia2 Time for lists of size 10000: "+totaltime);

wikipedia2(int10000Asc,10000);
System.out.println("wikipedia2 Time for lists of size 10000 in ascending order: "+ totaltime);

wikipedia2(int10000Des,10000);
System.out.println("wikipedia2 Time for lists of size 10000 in descending order: "+ totaltime);

wikipedia2(int10000Ide,10000);
System.out.println("wikipedia2 Time for lists of size 10000 idendical keys: "+ totaltime);

wikipedia2(int10000FewDup,10000);
System.out.println("wikipedia2 Time for lists of size 10000 Few Duplicates: "+ totaltime);

wikipedia2(int10000SomeDup,10000);
System.out.println("wikipedia2 Time for lists of size 10000 Some Duplicates: "+ totaltime);

wikipedia2(int10000SlightlyDis,10000);
System.out.println("wikipedia2 Time for lists of size 10000 Slightly Distributed: "+ totaltime);

wikipedia2(int10000ManyDup,10000);
System.out.println("wikipedia2 Time for lists of size 10000 Many Duplicates: "+ totaltime);

System.out.println();

System.out.println();

setupInteger();


bubblesort(size10,10);
System.out.println("bubblesort Time for lists of size 10 Integer random distribution: "+ totaltime);

bubblesort(size10Asc,10);
System.out.println("bubblesort Time for lists of size 10 Integer in ascending order: "+ totaltime);

bubblesort(size10Des,10);
System.out.println("bubblesort Time for lists of size 10 Integer in decreasing order: "+ totaltime);

bubblesort(size10Ide,10);
System.out.println("bubblesort Time for lists of size 10 Integer idendical keys: "+ totaltime);

bubblesort(size10FewDup,10);
System.out.println("bubblesort Time for lists of size 10 Integer Few Duplicates: "+ totaltime);

bubblesort(size10SomeDup,10);
System.out.println("bubblesort Time for lists of size 10 Integer Some Duplicates: "+ totaltime);

bubblesort(size10ManyDup,10);
System.out.println("bubblesort Time for lists of size 10 Integer Many Duplicates: "+ totaltime);

bubblesort(size10SlightlyDis,10);
System.out.println("bubblesort Time for lists of size 10 Integer Slightly Disordered: "+ totaltime);

System.out.println();

bubblesort(size100,100);
System.out.println("bubblesort Time for lists of size 100 Integer random distribution: "+ totaltime);

bubblesort(size100Asc,100);
System.out.println("bubblesort Time for lists of size 100 Integer in ascending order: "+ totaltime);

bubblesort(size100Des,100);
System.out.println("bubblesort Time for lists of size 100 Integer in decreasing order: "+ totaltime);

bubblesort(size100Ide,100);
System.out.println("bubblesort Time for lists of size 100 Integer idendical keys: "+ totaltime);

bubblesort(size100FewDup,100);
System.out.println("bubblesort Time for lists of size 100 Integer Few Duplicates: "+ totaltime);

bubblesort(size100SomeDup,100);
System.out.println("bubblesort Time for lists of size 100 Integer Some Duplicates: "+ totaltime);

bubblesort(size100ManyDup,100);
System.out.println("bubblesort Time for lists of size 100 Integer Many Duplicates: "+ totaltime);

bubblesort(size100SlightlyDis,100);
System.out.println("bubblesort Time for lists of size 100 Integer Slightly Disordered: "+ totaltime);

System.out.println();

bubblesort(size1000,1000);
System.out.println("bubblesort Time for lists of size 1000 Integer random distribution: "+ totaltime);

bubblesort(size100Asc,1000);
System.out.println("bubblesort Time for lists of size 1000 Integer in ascending order: "+ totaltime);

bubblesort(size1000Des,1000);
System.out.println("bubblesort Time for lists of size 1000 Integer in decreasing order: "+ totaltime);

bubblesort(size1000Ide,1000);
System.out.println("bubblesort Time for lists of size 1000 Integer idendical keys: "+ totaltime);

bubblesort(size1000FewDup,1000);
System.out.println("bubblesort Time for lists of size 1000 Integer Few Duplicates "+ totaltime);

bubblesort(size1000SomeDup,1000);
System.out.println("bubblesort Time for lists of size 1000 Integer Some Duplicates "+ totaltime);

bubblesort(size1000ManyDup,1000);
System.out.println("bubblesort Time for lists of size 1000 Integer Many Duplicates "+ totaltime);

bubblesort(size1000SlightlyDis,1000);
System.out.println("bubblesort Time for lists of size 1000 Integer Slightly Disordered: "+ totaltime);

System.out.println();

bubblesort(size10000,10000);
System.out.println("bubblesort Time for lists of size 10000 Integer random distribution: "+ totaltime);

bubblesort(size10000Asc,10000);
System.out.println("bubblesort Time for lists of size 10000 Integer in ascending order: "+ totaltime);

bubblesort(size10000Des,10000);
System.out.println("bubblesort Time for lists of size 10000 Integer in decreasing order: "+ totaltime);

bubblesort(size10000Ide,10000);
System.out.println("bubblesort Time for lists of size 10000 Integer idendical keys: "+ totaltime);

bubblesort(size10000FewDup,10000);
System.out.println("bubblesort Time for lists of size 10000 Integer Few Duplicates: "+ totaltime);

bubblesort(size10000SomeDup,10000);
System.out.println("bubblesort Time for lists of size 10000 Integer Some Duplicates: "+ totaltime);

bubblesort(size10000ManyDup,10000);
System.out.println("bubblesort Time for lists of size 10000 Integer Many Duplicates: "+ totaltime);

bubblesort(size10000SlightlyDis,10000);
System.out.println("bubblesort Time for lists of size 10000 Integer Slightly Disordered: "+ totaltime);

System.out.println();



}

// A flag check if a pass did not have any swaps, which lets us quit
static void bubblesortcheck(int[] A,int length) {

int [] tmp = new int[length];
int numruns = 20;
int runs;
for (runs=0; runs<numruns; runs++) {
    for (int i=0; i<length; i++) tmp[i] = A[i];
long startTime=System.nanoTime();
  for (int i=0; i<length-1; i++) {// Insert i'th record
    boolean swaps = false;
    for (int j=1; j<length-i; j++)
      if (tmp[j-1] > tmp[j]) {
        swap(tmp, j-1, j);
        swaps = true;
      }
  //  if(!swaps) { println("Quit at " + i); break; }  // Can quit early
  }
long endTime   = System.nanoTime();
totaltime += (endTime - startTime);
}
totaltime = totaltime/numruns;
}

// Modify the flag to check position of last swap taken
static void bubblesortcheck2(int[] A,int length) {

int [] tmp = new int[length];
int numruns = 20;
int runs;
for (runs=0; runs<numruns; runs++) {
for (int i=0; i<length; i++) tmp[i] = A[i];
long startTime=System.nanoTime();
  for (int i=0; i<length-1; i++) {// Insert i'th record
    int lastseen = 0;
    int top = length;
    for (int j=1; j<top; j++)
      if (tmp[j-1] > tmp[j]) {
        swap(tmp, j-1, j);
        lastseen = j-1;
      }
    top = lastseen;
  //  if (top == 0) { println("Quit at " + i); break; }  // Can quit early
  }
long endTime   = System.nanoTime();
 totaltime += (endTime - startTime);
}
totaltime = totaltime/numruns;
}

// Wikipedia article "optimization" to only swap up to the last swap seen
/* *** ODSATag: BubblesortCheck *** */
static void bubblecheckswap(Integer[] A,int length) {
Integer [] tmp = new Integer[length];
int numruns = 20;
int runs;
for (runs=0; runs<numruns; runs++) {
for (int i=0; i<length; i++) tmp[i] = new Integer(A[i]);
long startTime=System.nanoTime();
  int n = tmp.length - 1;
  while (n > 0) {
    int newn = 0;
    for (int i = 0; i < n; i++) {
      /* if this pair is out of order */
      if (tmp[i].compareTo(tmp[i+1]) > 0) {
        swap(tmp, i, i+1);
        newn = i;
      }
    }
    n = newn;
  }
long endTime   = System.nanoTime();
 totaltime += (endTime - startTime);
}
totaltime = totaltime/numruns;


}
/* *** ODSAendTag: BubblesortCheck *** */

// Wikipedia article "optimization" to only swap up to the last swap seen
static void unwikipedia(int[] A,int length) {
int [] tmp = new int[length];
int numruns = 20;
int runs;
for (runs=0; runs<numruns; runs++) {
for (int i=0; i<length; i++) tmp[i] = A[i];
long startTime=System.nanoTime();

  int n = tmp.length-1;
  while (n>0) {
    for (int i=0; i<n; i++)
      /* if this pair is out of order */
      if (tmp[i] > tmp[i+1]) {
        swap(tmp, i, i+1);
      }
    n -= 1;
  }
long endTime   = System.nanoTime();
 totaltime += (endTime - startTime);
}
totaltime = totaltime/numruns;

}

// Wikipedia article "optimization" rewritten with a for loop
static void wikipedia2(int[] A,int length) {
int [] tmp = new int[length];
int numruns = 20;
int runs;
for (runs=0; runs<numruns; runs++) {
for (int i=0; i<length; i++) tmp[i] = A[i];
long startTime=System.nanoTime();


  int newn;
  int loopcnt = 0;
  for(int n=length-1; n>0; n=newn) {
    loopcnt++;
    newn = 0;
    for (int i=0; i<n; i++)
      /* if this pair is out of order */
      if (tmp[i] > tmp[i+1]) {
        swap(tmp, i, i+1);
        newn = i;
      }
  }
 // println("Loopcnt was " + loopcnt);
long endTime   = System.nanoTime();
 totaltime += (endTime - startTime);
}
totaltime = totaltime/numruns;

}


@SuppressWarnings("unchecked") // Generic array allocation
static Boolean sorttest(int[] B,int length) {


  int i;
  Integer[] A = new Integer[B.length];
  for (i=0; i<B.length; i++)
    A[i] = new Integer(B[i]);
  bubblesort(A,length);
  if (!checkorder(A)) return false;

  //  KVPair[] AKV = (KVPair[])new Object[B.length];
  //  for (i=0; i<B.length; i++)
  //    AKV[i] = new KVPair(new Integer(B[i]), new Integer(B[i]));
  //  inssort(A);
  //  if (!checkorder(A)) return false;
  return true;



}

/* *** ODSATag: Bubblesort *** */
static void bubblesort(Integer[] A,int length) {
Integer [] tmp = new Integer[length];
int numruns = 20;
int runs;
for (runs=0; runs<numruns; runs++) {
for (int i=0; i<length; i++) tmp[i] = new Integer(A[i]);
long startTime=System.nanoTime();

  for (int i=0; i<length-1; i++) // Insert i'th record
    for (int j=1; j<length-i; j++)
      if (tmp[j-1].compareTo(tmp[j]) > 0)
        swap(tmp, j-1, j);
long endTime   = System.nanoTime();
 totaltime += (endTime - startTime);
}
totaltime = totaltime/numruns;

}
/* *** ODSAendTag: Bubblesort *** */

}

