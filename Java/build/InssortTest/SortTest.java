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
static void sorttime(){

 // inssort
 setupint();


 funcInssort(int10,10,"inssort");
 System.out.println("inssort Time for lists of size 10: "+ totaltime);
 
 funcInssort(int10Asc,10,"inssort");
 System.out.println("inssort Time for lists of size 10 in ascending order: "+ totaltime);
 
 funcInssort(int10Des,10,"inssort");
 System.out.println("inssort Time for lists of size 10 in descending order: "+ totaltime);
 
 funcInssort(int10Ide,10,"inssort");
 System.out.println("inssort Time for lists of size 10 idendical keys: "+ totaltime);
 
 funcInssort(int10FewDup,10,"inssort");
 System.out.println("inssort Time for lists of size 10 Few Duplicates: "+ totaltime);
 
 funcInssort(int10SomeDup,10,"inssort");
 System.out.println("inssort Time for lists of size 10 Some Duplicates: "+ totaltime);
 
 funcInssort(int10ManyDup,10,"inssort");
 System.out.println("inssort Time for lists of size 10 Many Duplicates: "+ totaltime);
 
 funcInssort(int10SlightlyDis,10,"inssort");
 System.out.println("inssort Time for lists of size 10 Slightly Distributed: "+ totaltime);
 
 System.out.println();
 
 funcInssort(int100,100,"inssort");
 System.out.println("inssort Time for lists of size 100: "+totaltime);
 
 funcInssort(int100Asc,100,"inssort");
 System.out.println("inssort Time for lists of size 100 in ascending order: "+ totaltime);
 
 funcInssort(int100Des,100,"inssort");
 System.out.println("inssort Time for lists of size 100 in descending order: "+ totaltime);
 
 funcInssort(int100Ide,100,"inssort");
 System.out.println("inssort Time for lists of size 100 idendical keys: "+ totaltime);
 
 funcInssort(int100FewDup,100,"inssort");
 System.out.println("inssort Time for lists of size 100 Few Duplicates: "+ totaltime);
 
 funcInssort(int100SomeDup,100,"inssort");
 System.out.println("inssort Time for lists of size 100 Some Duplicates: "+ totaltime);
 
 funcInssort(int100ManyDup,100,"inssort");
 System.out.println("inssort Time for lists of size 100 Many Duplicates: "+ totaltime);
 
 funcInssort(int100SlightlyDis,100,"inssort");
 System.out.println("inssort Time for lists of size 100 Slightly Distributed: "+ totaltime);
 
 System.out.println();
 
 funcInssort(int1000,1000,"inssort");
 System.out.println("inssort Time for lists of size 1000: "+totaltime);
 
 funcInssort(int1000Asc,1000,"inssort");
 System.out.println("inssort Time for lists of size 1000 in ascending order: "+ totaltime);
 
 funcInssort(int1000Des,1000,"inssort");
 System.out.println("inssort Time for lists of size 1000 in descending order: "+ totaltime);
 
 funcInssort(int1000Ide,1000,"inssort");
 System.out.println("inssort Time for lists of size 1000 idendical keys: "+ totaltime);
 
 funcInssort(int1000FewDup,1000,"inssort");
 System.out.println("inssort Time for lists of size 1000 Few Duplicates: "+ totaltime);
 
 funcInssort(int1000SomeDup,1000,"inssort");
 System.out.println("inssort Time for lists of size 1000 Some Duplicates: "+ totaltime);
 
 funcInssort(int1000SlightlyDis,1000,"inssort");
 System.out.println("inssort Time for lists of size 1000 Slightly Distributed: "+ totaltime);
 
 funcInssort(int1000ManyDup,1000,"inssort");
 System.out.println("inssort Time for lists of size 1000 Many Duplicates: "+ totaltime);
 
 System.out.println();

 funcInssort(int10000,10000,"inssort");
 System.out.println("inssort Time for lists of size 10000: "+totaltime);
 
 funcInssort(int10000Asc,10000,"inssort");
 System.out.println("inssort Time for lists of size 10000 in ascending order: "+ totaltime);
 
 funcInssort(int10000Des,10000,"inssort");
 System.out.println("inssort Time for lists of size 10000 in descending order: "+ totaltime);
 
 funcInssort(int10000Ide,10000,"inssort");
 System.out.println("inssort Time for lists of size 10000 idendical keys: "+ totaltime);
 
 funcInssort(int10000FewDup,10000,"inssort");
 System.out.println("inssort Time for lists of size 10000 Few Duplicates: "+ totaltime);
 
 funcInssort(int10000SomeDup,10000,"inssort");
 System.out.println("inssort Time for lists of size 10000 Some Duplicates: "+ totaltime);
 
 funcInssort(int10000SlightlyDis,10000,"inssort");
 System.out.println("inssort Time for lists of size 10000 Slightly Distributed: "+ totaltime);
 
 funcInssort(int10000ManyDup,10000,"inssort");
 System.out.println("inssort Time for lists of size 10000 Many Duplicates: "+ totaltime);

    System.out.println();
 /*
 funcInssort(int100000,100000,"inssort");
 System.out.println("inssort Time for lists of size 100000: "+totaltime);
 
 funcInssort(int100000Asc,100000,"inssort");
 System.out.println("inssort Time for lists of size 100000 in ascending order: "+ totaltime);
 
 funcInssort(int100000Des,100000,"inssort");
 System.out.println("inssort Time for lists of size 100000 in descending order: "+ totaltime);
 
 funcInssort(int100000Ide,100000,"inssort");
 System.out.println("inssort Time for lists of size 100000 idendical keys: "+ totaltime);
 
 funcInssort(int100000FewDup,100000,"inssort");
 System.out.println("inssort Time for lists of size 100000 Few Duplicates: "+ totaltime);
 
 funcInssort(int100000SomeDup,100000,"inssort");
 System.out.println("inssort Time for lists of size 100000 Some Duplicates: "+ totaltime);
 
 funcInssort(int100000SlightlyDis,100000,"inssort");
 System.out.println("inssort Time for lists of size 100000 Slightly Distributed: "+ totaltime);
 
 funcInssort(int100000ManyDup,100000,"inssort");
 System.out.println("inssort Time for lists of size 100000 Many Duplicates: "+ totaltime);
 
 System.out.println();

 funcInssort(int1000000,1000000,"inssort");
 System.out.println("inssort Time for lists of size 1000000: "+totaltime);
 
 funcInssort(int1000000Asc,1000000,"inssort");
 System.out.println("inssort Time for lists of size 1000000 in ascending order: "+ totaltime);
 
 funcInssort(int1000000Des,1000000,"inssort");
 System.out.println("inssort Time for lists of size 1000000 in descending order: "+ totaltime);
 
 funcInssort(int1000000Ide,1000000,"inssort");
 System.out.println("inssort Time for lists of size 1000000 idendical keys: "+ totaltime);
 
 funcInssort(int1000000FewDup,1000000,"inssort");
 System.out.println("inssort Time for lists of size 1000000 Few Duplicates: "+ totaltime);
 
 funcInssort(int1000000SomeDup,1000000,"inssort");
 System.out.println("inssort Time for lists of size 1000000 Some Duplicates: "+ totaltime);
 
 funcInssort(int1000000SlightlyDis,1000000,"inssort");
 System.out.println("inssort Time for lists of size 1000000 Slightly Distributed: "+ totaltime);
 
 funcInssort(int1000000ManyDup,1000000,"inssort");
 System.out.println("inssort Time for lists of size 1000000 Many Duplicates: "+ totaltime); */


 // inssort2
 setupint();
 System.out.println();
 
 
 funcInssort(int10,10,"inssort2");
 System.out.println("inssort2 Time for lists of size 10: "+ totaltime);
 
 funcInssort(int10Asc,10,"inssort2");
 System.out.println("inssort2 Time for lists of size 10 in ascending order: "+ totaltime);
 
 funcInssort(int10Des,10,"inssort2");
 System.out.println("inssort2 Time for lists of size 10 in descending order: "+ totaltime);
 
 funcInssort(int10Ide,10,"inssort2");
 System.out.println("inssort2 Time for lists of size 10 idendical keys: "+ totaltime);
 
 funcInssort(int10FewDup,10,"inssort2");
 System.out.println("inssort2 Time for lists of size 10 Few Duplicates: "+ totaltime);
 
 funcInssort(int10SomeDup,10,"inssort2");
 System.out.println("inssort2 Time for lists of size 10 Some Duplicates: "+ totaltime);
 
 funcInssort(int10ManyDup,10,"inssort2");
 System.out.println("inssort2 Time for lists of size 10 Many Duplicates: "+ totaltime);
 
 funcInssort(int10SlightlyDis,10,"inssort2");
 System.out.println("inssort2 Time for lists of size 100 Slightly Distributed: "+ totaltime);
 
 System.out.println();
 
 funcInssort(int100,100,"inssort2");
 System.out.println("inssort2 Time for lists of size 100: "+totaltime);
 
 funcInssort(int100Asc,100,"inssort2");
 System.out.println("inssort2 Time for lists of size 100 in ascending order: "+ totaltime);
 
 funcInssort(int100Des,100,"inssort2");
 System.out.println("inssort2 Time for lists of size 100 in descending order: "+ totaltime);
 
 funcInssort(int100Ide,100,"inssort2");
 System.out.println("inssort2 Time for lists of size 100 idendical keys: "+ totaltime);
 
 funcInssort(int100FewDup,100,"inssort2");
 System.out.println("inssort2 Time for lists of size 100 Few Duplicates: "+ totaltime);
 
 funcInssort(int100SomeDup,100,"inssort2");
 System.out.println("inssort2 Time for lists of size 100 Some Duplicates: "+ totaltime);
 
 funcInssort(int100SlightlyDis,100,"inssort2");
 System.out.println("inssort2 Time for lists of size 100 Slightly Distributed: "+ totaltime);
 
 funcInssort(int100ManyDup,100,"inssort2");
 System.out.println("inssort2 Time for lists of size 100 Many Duplicates: "+ totaltime);
 
 System.out.println();
 
 funcInssort(int1000,1000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000: "+totaltime);
 
 funcInssort(int1000Asc,1000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000 in ascending order: "+ totaltime);
 
 funcInssort(int1000Des,1000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000 in descending order: "+ totaltime);
 
 funcInssort(int1000Ide,1000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000 idendical keys: "+ totaltime);
 
 funcInssort(int1000FewDup,1000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000 Few Duplicates: "+ totaltime);
 
 funcInssort(int1000SomeDup,1000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000 Some Duplicates: "+ totaltime);
 
 funcInssort(int1000SlightlyDis,1000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000 Slightly Distributed: "+ totaltime);
 
 funcInssort(int1000ManyDup,1000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000 Many Duplicates: "+ totaltime);
 
 System.out.println();

 funcInssort(int10000,10000,"inssort2");
 System.out.println("inssort2 Time for lists of size 10000: "+totaltime);
 
 funcInssort(int10000Asc,10000,"inssort2");
 System.out.println("inssort2 Time for lists of size 10000 in ascending order: "+ totaltime);
 
 funcInssort(int10000Des,10000,"inssort2");
 System.out.println("inssort2 Time for lists of size 10000 in descending order: "+ totaltime);
 
 funcInssort(int10000Ide,10000,"inssort2");
 System.out.println("inssort2 Time for lists of size 10000 idendical keys: "+ totaltime);
 
 funcInssort(int10000FewDup,10000,"inssort2");
 System.out.println("inssort2 Time for lists of size 10000 Few Duplicates: "+ totaltime);
 
 funcInssort(int10000SomeDup,10000,"inssort2");
 System.out.println("inssort2 Time for lists of size 10000 Some Duplicates: "+ totaltime);
 
 funcInssort(int10000SlightlyDis,10000,"inssort2");
 System.out.println("inssort2 Time for lists of size 10000 Slightly Distributed: "+ totaltime);
 
 funcInssort(int10000ManyDup,10000,"inssort2");
 System.out.println("inssort2 Time for lists of size 10000 Many Duplicates: "+ totaltime);

 System.out.println();
/*
 funcInssort(int100000,100000,"inssort2");
 System.out.println("inssort2 Time for lists of size 100000: "+totaltime);
 
 funcInssort(int100000Asc,100000,"inssort2");
 System.out.println("inssort2 Time for lists of size 100000 in ascending order: "+ totaltime);
 
 funcInssort(int100000Des,100000,"inssort2");
 System.out.println("inssort2 Time for lists of size 100000 in descending order: "+ totaltime);
 
 funcInssort(int100000Ide,100000,"inssort2");
 System.out.println("inssort2 Time for lists of size 100000 idendical keys: "+ totaltime);
 
 funcInssort(int100000FewDup,100000,"inssort2");
 System.out.println("inssort2 Time for lists of size 100000 Few Duplicates: "+ totaltime);
 
 funcInssort(int100000SomeDup,100000,"inssort2");
 System.out.println("inssort2 Time for lists of size 100000 Some Duplicates: "+ totaltime);
 
 funcInssort(int100000SlightlyDis,100000,"inssort2");
 System.out.println("inssort2 Time for lists of size 100000 Slightly Distributed: "+ totaltime);
 
 funcInssort(int100000ManyDup,100000,"inssort2");
 System.out.println("inssort2 Time for lists of size 100000 Many Duplicates: "+ totaltime);
 
 System.out.println();
 
 funcInssort(int1000000,1000000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000000: "+totaltime);
 
 funcInssort(int1000000Asc,1000000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000000 in ascending order: "+ totaltime);
 
 funcInssort(int1000000Des,1000000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000000 in descending order: "+ totaltime);
 
 funcInssort(int1000000Ide,1000000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000000 idendical keys: "+ totaltime);
 
 funcInssort(int1000000FewDup,1000000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000000 Few Duplicates: "+ totaltime);
 
 funcInssort(int1000000SomeDup,1000000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000000 Some Duplicates: "+ totaltime);
 
 funcInssort(int1000000SlightlyDis,1000000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000000 Slightly Distributed: "+ totaltime);
 
 funcInssort(int1000000ManyDup,1000000,"inssort2");
 System.out.println("inssort2 Time for lists of size 1000000 Many Duplicates: "+ totaltime);
*/
 System.out.println();
 
 setupInteger();
 
 
 funcInssortInteger(size10,10,"inssortInteger");
 System.out.println("inssort Time for lists of size 10 Integer random distribution: "+ totaltime);
 
 funcInssortInteger(size10Asc,10,"inssortInteger");
 System.out.println("inssort Time for lists of size 10 Integer in ascending order: "+ totaltime);
 
 funcInssortInteger(size10Des,10,"inssortInteger");
 System.out.println("inssort Time for lists of size 10 Integer in decreasing order: "+ totaltime);
 
 funcInssortInteger(size10Ide,10,"inssortInteger");
 System.out.println("inssort Time for lists of size 10 Integer idendical keys: "+ totaltime);
 
 funcInssortInteger(size10FewDup,10,"inssortInteger");
 System.out.println("inssort Time for lists of size 10 Integer Few Duplicates: "+ totaltime);
 
 funcInssortInteger(size10SomeDup,10,"inssortInteger");
 System.out.println("inssort Time for lists of size 10 Integer Some Duplicates: "+ totaltime);
 
 funcInssortInteger(size10ManyDup,10,"inssortInteger");
 System.out.println("inssort Time for lists of size 10 Integer Many Duplicates: "+ totaltime);
 
 funcInssortInteger(size10SlightlyDis,10,"inssortInteger");
 System.out.println("inssort Time for lists of size 10 Integer Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortInteger(size100,100,"inssortInteger");
 System.out.println("inssort Time for lists of size 100 Integer random distribution: "+ totaltime);
 
 funcInssortInteger(size100Asc,100,"inssortInteger");
 System.out.println("inssort Time for lists of size 100 Integer in ascending order: "+ totaltime);
 
 funcInssortInteger(size100Des,100,"inssortInteger");
 System.out.println("inssort Time for lists of size 100 Integer in decreasing order: "+ totaltime);
 
 funcInssortInteger(size100Ide,100,"inssortInteger");
 System.out.println("inssort Time for lists of size 100 Integer idendical keys: "+ totaltime);
 
 funcInssortInteger(size100FewDup,100,"inssortInteger");
 System.out.println("inssort Time for lists of size 100 Integer Few Duplicates: "+ totaltime);
 
 funcInssortInteger(size100SomeDup,100,"inssortInteger");
 System.out.println("inssort Time for lists of size 100 Integer Some Duplicates: "+ totaltime);
 
 funcInssortInteger(size100ManyDup,100,"inssortInteger");
 System.out.println("inssort Time for lists of size 100 Integer Many Duplicates: "+ totaltime);
 
 funcInssortInteger(size100SlightlyDis,100,"inssortInteger");
 System.out.println("inssort Time for lists of size 100 Integer Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortInteger(size1000,1000,"inssortInteger");
 System.out.println("inssort Time for lists of size 1000 Integer random distribution: "+ totaltime);
 
 funcInssortInteger(size100Asc,1000,"inssortInteger");
 System.out.println("inssort Time for lists of size 1000 Integer in ascending order: "+ totaltime);
 
 funcInssortInteger(size1000Des,1000,"inssortInteger");
 System.out.println("inssort Time for lists of size 1000 Integer in decreasing order: "+ totaltime);
 
 funcInssortInteger(size1000Ide,1000,"inssortInteger");
 System.out.println("inssort Time for lists of size 1000 Integer idendical keys: "+ totaltime);
 
 funcInssortInteger(size1000FewDup,1000,"inssortInteger");
 System.out.println("inssort Time for lists of size 1000 Integer Few Duplicates "+ totaltime);
 
 funcInssortInteger(size1000SomeDup,1000,"inssortInteger");
 System.out.println("inssort Time for lists of size 1000 Integer Some Duplicates "+ totaltime);
 
 funcInssortInteger(size1000ManyDup,1000,"inssortInteger");
 System.out.println("inssort Time for lists of size 1000 Integer Many Duplicates "+ totaltime);
 
 funcInssortInteger(size1000SlightlyDis,1000,"inssortInteger");
 System.out.println("inssort Time for lists of size 1000 Integer Slightly Disordered: "+ totaltime);
 
 System.out.println();

 funcInssortInteger(size10000,10000,"inssortInteger");
 System.out.println("inssort Time for lists of size 10000 Integer random distribution: "+ totaltime);
 
 funcInssortInteger(size10000Asc,10000,"inssortInteger");
 System.out.println("inssort Time for lists of size 10000 Integer in ascending order: "+ totaltime);
 
 funcInssortInteger(size10000Des,10000,"inssortInteger");
 System.out.println("inssort Time for lists of size 10000 Integer in decreasing order: "+ totaltime);
 
 funcInssortInteger(size10000Ide,10000,"inssortInteger");
 System.out.println("inssort Time for lists of size 10000 Integer idendical keys: "+ totaltime);
 
 funcInssortInteger(size10000FewDup,10000,"inssortInteger");
 System.out.println("inssort Time for lists of size 10000 Integer Few Duplicates: "+ totaltime);
 
 funcInssortInteger(size10000SomeDup,10000,"inssortInteger");
 System.out.println("inssort Time for lists of size 10000 Integer Some Duplicates: "+ totaltime);
 
 funcInssortInteger(size10000ManyDup,10000,"inssortInteger");
 System.out.println("inssort Time for lists of size 10000 Integer Many Duplicates: "+ totaltime);
 
 funcInssortInteger(size10000SlightlyDis,10000,"inssortInteger");
 System.out.println("inssort Time for lists of size 10000 Integer Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortInteger(size10,10,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10 Integer random distribution: "+ totaltime);
 
 funcInssortInteger(size10Asc,10,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10 Integer in ascending order: "+ totaltime);
 
 funcInssortInteger(size10Des,10,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10 Integer in decreasing order: "+ totaltime);
 
 funcInssortInteger(size10Ide,10,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10 Integer idendical keys: "+ totaltime);
 
 funcInssortInteger(size10FewDup,10,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10 Integer Few Duplicates: "+ totaltime);
 
 funcInssortInteger(size10ManyDup,10,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10 Integer Many Duplicates: "+ totaltime);
 
 funcInssortInteger(size10SomeDup,10,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10 Integer Some Duplicates: "+ totaltime);
 
 funcInssortInteger(size10SlightlyDis,10,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10 Integer Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortInteger(size100,100,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 100 Integer random distribution: "+ totaltime);
 
 funcInssortInteger(size100Asc,100,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 100 Integer in ascending order: "+ totaltime);
 
 funcInssortInteger(size100Des,100,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 100 Integer in decreasing order: "+ totaltime);
 
 funcInssortInteger(size100Ide,100,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 100 Integer idendical keys: "+ totaltime);
 
 funcInssortInteger(size100FewDup,100,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 100 Integer Few Duplicates: "+ totaltime);
 
 funcInssortInteger(size100SomeDup,100,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 100 Integer Some Duplicates: "+ totaltime);
 
 funcInssortInteger(size100ManyDup,100,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 100 Integer Many Duplicates: "+ totaltime);
 
 funcInssortInteger(size100SlightlyDis,100,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 100 Integer Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortInteger(size1000,1000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 1000 Integer random distribution: "+ totaltime);
 
 funcInssortInteger(size1000Asc,1000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 1000 Integer in ascending order: "+ totaltime);
 
 funcInssortInteger(size1000Des,1000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 1000 Integer in decreasing order: "+ totaltime);
 
 funcInssortInteger(size1000Ide,1000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 1000 Integer idendical keys: "+ totaltime);
 
 funcInssortInteger(size1000FewDup,1000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 1000 Integer Few Duplicates "+ totaltime);
 
 funcInssortInteger(size1000SomeDup,1000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 1000 Integer Some Duplicates "+ totaltime);
 
 funcInssortInteger(size1000ManyDup,1000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 1000 Integer Many Duplicates "+ totaltime);
 
 funcInssortInteger(size1000SlightlyDis,1000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 1000 Integer Slightly Disordered: "+ totaltime);
 
 System.out.println();

 funcInssortInteger(size10000,10000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10000 Integer random distribution: "+ totaltime);
 
 funcInssortInteger(size10000Asc,10000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10000 Integer in ascending order: "+ totaltime);
 
 funcInssortInteger(size10000Des,10000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10000 Integer in decreasing order: "+ totaltime);
 
 funcInssortInteger(size10000Ide,10000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10000 Integer idendical keys: "+ totaltime);
 
 funcInssortInteger(size10000FewDup,10000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10000 Integer Few Duplicates: "+ totaltime);
 
 funcInssortInteger(size10000SomeDup,10000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10000 Integer Some Duplicates: "+ totaltime);
 
 funcInssortInteger(size10000ManyDup,10000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10000 Integer Many Duplicates: "+ totaltime);
 
 funcInssortInteger(size10000SlightlyDis,10000,"inssort2Integer");
 System.out.println("inssort2 Time for lists of size 10000 Integer Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 setupDouble();
 
 funcInssortDouble(dsize10Asc,10,"inssortDouble");
 System.out.println("inssort Time for lists of size 10 double in ascending order: "+ totaltime);
 
 funcInssortDouble(dsize10Des,10,"inssortDouble");
 System.out.println("inssort Time for lists of double 10 in decreasing order: "+ totaltime);
 
 funcInssortDouble(dsize10Ide,10,"inssortDouble");
 System.out.println("inssort Time for lists of size 10 double idendical keys: "+ totaltime);
 
 funcInssortDouble(dsize10FewDup,10,"inssortDouble");
 System.out.println("inssort Time for lists of size 10 double Few Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10SomeDup,10,"inssortDouble");
 System.out.println("inssort Time for lists of size 10 double Some Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10ManyDup,10,"inssortDouble");
 System.out.println("inssort Time for lists of size 10 double Many Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10SlightlyDis,10,"inssortDouble");
 System.out.println("inssort Time for lists of size 10 double Slightly Disordered: "+ totaltime);
 
 
 System.out.println();
 
 funcInssortDouble(dsize100Asc,100,"inssortDouble");
 System.out.println("inssort Time for lists of size 100 double in ascending order: "+ totaltime);
 
 funcInssortDouble(dsize100Des,100,"inssortDouble");
 System.out.println("inssort Time for lists of double 100 in decreasing order: "+ totaltime);
 
 funcInssortDouble(dsize100Ide,100,"inssortDouble");
 System.out.println("inssort Time for lists of size 100 double idendical keys: "+ totaltime);
 
 funcInssortDouble(dsize100FewDup,100,"inssortDouble");
 System.out.println("inssort Time for lists of size 100 double Few Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize100SomeDup,100,"inssortDouble");
 System.out.println("inssort Time for lists of size 100 double Some Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize100ManyDup,100,"inssortDouble");
 System.out.println("inssort Time for lists of size 100 double Many Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize100SlightlyDis,100,"inssortDouble");
 System.out.println("inssort Time for lists of size 100 double Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortDouble(dsize1000Asc,1000,"inssortDouble");
 System.out.println("inssort Time for lists of size 1000 double in ascending order: "+ totaltime);
 
 funcInssortDouble(dsize1000Des,1000,"inssortDouble");
 System.out.println("inssort Time for lists of double 1000 in decreasing order: "+ totaltime);
 
 funcInssortDouble(dsize1000Ide,1000,"inssortDouble");
 System.out.println("inssort Time for lists of size 1000 double idendical keys: "+ totaltime);
 
 funcInssortDouble(dsize1000FewDup,1000,"inssortDouble");
 System.out.println("inssort Time for lists of size 1000 double Few Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize1000SomeDup,1000,"inssortDouble");
 System.out.println("inssort Time for lists of size 1000 double Some Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize1000ManyDup,1000,"inssortDouble");
 System.out.println("inssort Time for lists of size 1000 double Many Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize1000SlightlyDis,1000,"inssortDouble");
 System.out.println("inssort Time for lists of size 1000 double Slightly Disordered: "+ totaltime);
 
 System.out.println();

 funcInssortDouble(dsize10000Asc,10000,"inssortDouble");
 System.out.println("inssort Time for lists of size 10000 double in ascending order: "+ totaltime);
 
 funcInssortDouble(dsize10000Des,10000,"inssortDouble");
 System.out.println("inssort Time for lists of double 10000 in decreasing order: "+ totaltime);
 
 funcInssortDouble(dsize10000Ide,10000,"inssortDouble");
 System.out.println("inssort Time for lists of size 10000 double idendical keys: "+ totaltime);
 
 funcInssortDouble(dsize10000FewDup,10000,"inssortDouble");
 System.out.println("inssort Time for lists of size 10000 double Few Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10000SomeDup,10000,"inssortDouble");
 System.out.println("inssort Time for lists of size 10000 double Some Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10000ManyDup,10000,"inssortDouble");
 System.out.println("inssort Time for lists of size 10000 double Many Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10000SlightlyDis,10000,"inssortDouble");
 System.out.println("inssort Time for lists of size 10000 double Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortDouble(dsize10Asc,10,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10 double in ascending order: "+ totaltime);
 
 funcInssortDouble(dsize10Des,10,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10 double in decreasing order: "+ totaltime);
 
 funcInssortDouble(dsize10Ide,10,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10 double idendical keys: "+ totaltime);
 
 funcInssortDouble(dsize10FewDup,10,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10 double Few Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10ManyDup,10,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10 double Many Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10SomeDup,10,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10 double Some Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10SlightlyDis,10,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10 double Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortDouble(dsize100Asc,100,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 100 double in ascending order: "+ totaltime);
 
 funcInssortDouble(dsize100Des,100,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 100 double in decreasing order: "+ totaltime);
 
 funcInssortDouble(dsize100Ide,100,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 100 double idendical keys: "+ totaltime);
 
 funcInssortDouble(dsize100FewDup,100,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 100 double Few Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize100SomeDup,100,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 100 double Some Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize100ManyDup,100,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 100 double Many Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize100SlightlyDis,100,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 100 double Slightly Disordered: "+ totaltime);
 
 System.out.println();
 
 funcInssortDouble(dsize1000Asc,1000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 1000 double in ascending order: "+ totaltime);
 
 funcInssortDouble(dsize1000Des,1000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 1000 double in decreasing order: "+ totaltime);
 
 funcInssortDouble(dsize1000Ide,1000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 1000 double idendical keys: "+ totaltime);
 
 funcInssortDouble(dsize1000FewDup,1000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 1000 double Few Duplicates "+ totaltime);
 
 funcInssortDouble(dsize1000SomeDup,1000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 1000 double Some Duplicates "+ totaltime);
 
 funcInssortDouble(dsize1000ManyDup,1000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 1000 double Many Duplicates "+ totaltime);
 
 funcInssortDouble(dsize1000SlightlyDis,1000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 1000 double Slightly Disordered: "+ totaltime);
 
 System.out.println();

 funcInssortDouble(dsize10000Asc,10000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10000 double in ascending order: "+ totaltime);
 
 funcInssortDouble(dsize10000Des,10000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10000 double in decreasing order: "+ totaltime);
 
 funcInssortDouble(dsize10000Ide,10000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10000 double idendical keys: "+ totaltime);
 
 funcInssortDouble(dsize10000FewDup,10000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10000 double Few Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10000SomeDup,10000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10000 double Some Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10000ManyDup,10000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10000 double Many Duplicates: "+ totaltime);
 
 funcInssortDouble(dsize10000SlightlyDis,10000,"inssort2Double");
 System.out.println("inssort2 Time for lists of size 10000 double Slightly Disordered: "+ totaltime);

}
// Standard insertion sort
static void inssort(int[] A, int length) {
  int temp;
  for (int i = 1; i < length; i++) // Insert i'th record
    for (int j = i; (j>0) && (A[j] < A[j-1]); j--) {
      swap(A, j, j-1);
    }
}


// Standard insertion sort for Integer class
static void inssortInteger(Integer[] A, int length) {
int temp;
for (int i = 1; i <length; i++) // Insert i'th record
for (int j = i; (j>0) && (A[j].compareTo(A[j-1]) < 0); j--) {
swapInteger(A, j, j-1);
}
}

// Standard insertion sort for double type array
static void inssortDouble(double[] A, int length) {
int temp;
for (int i = 1; i <length; i++) // Insert i'th record
for (int j = i; (j>0) && (A[j] < A[j-1]); j--) {
swapDouble(A, j, j-1);
}
}

// Same as standard insertion sort, except get rid of the swap
// function call
static void inssort2Integer(Integer[] A, int length) {
Integer temp;
for (int i = 1; i < length; i++) // Insert i'th record
for (int j = i; (j>0) && (A[j].compareTo(A[j-1]) < 0); j--) {
temp = A[j]; A[j] = A[j-1]; A[j-1] = temp;
}
}


// Same as standard insertion sort, except get rid of the swap
// function call
static void inssort2Double(double[] A, int length) {
double temp;
for (int i = 1; i < length; i++) // Insert i'th record
for (int j = i; (j>0) && (A[j] < A[j-1]); j--) {
temp = A[j]; A[j] = A[j-1]; A[j-1] = temp;
}
}

// Same as standard insertion sort, except get rid of the swap
// function call
static void inssort2(int[] A, int length) {
  int temp;
  for (int i = 1; i < length; i++) // Insert i'th record
    for (int j = i; (j>0) && (A[j] < A[j-1]); j--) {
      temp = A[j]; A[j] = A[j-1]; A[j-1] = temp;
    }
}

    @SuppressWarnings("unchecked")
     static void funcInssort(int[] A,int length,String methodName){
        try {
            int [] array = new int[A.length];
            SortTest s = new SortTest();
            Class cls = s.getClass();
            Class[] c = new Class[2];
            c[0] = array.getClass();
            c[1] = int.class;
            Method method = cls.getDeclaredMethod(methodName,c);
            method.setAccessible(true);

            int i;
            totaltime = 0;
            for (i=0; i<20; i++)
            {
                for(int z=0; z<length;z++)
                    array [z]= A[z];
                time1 = millis();
                Object[] arguments = { array,length };
                method.invoke(s,arguments);
                time2 = millis();
                totaltime += (time2-time1);
            }
            totaltime = totaltime/20;

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }

    @SuppressWarnings("unchecked")
     static void funcInssortDouble(double[] A,int length,String methodName){
        try {
            double [] array = new double[A.length];
            SortTest s = new SortTest();
            Class cls = s.getClass();
            Class[] c = new Class[2];
            c[0] = array.getClass();
            c[1] = int.class;
            Method method = cls.getDeclaredMethod(methodName,c);
            method.setAccessible(true);

            int i;
            totaltime = 0;
            for (i=0; i<20; i++)
            {
                for(int z=0; z<length;z++)
                    array [z]= A[z];
                time1 = millis();
                Object[] arguments = { array,length };
                method.invoke(s,arguments);
                time2 = millis();
                totaltime += (time2-time1);
            }
            totaltime = totaltime/20;

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")

static void funcInssortInteger(Integer[] A,int length,String methodName){
    try {
        Integer [] array = new Integer[A.length];
        SortTest s = new SortTest();
        Class cls = s.getClass();
        Class[] c = new Class[2];
        c[0] = array.getClass();
        c[1] = int.class;
        Method method = cls.getDeclaredMethod(methodName,c);
        method.setAccessible(true);

        int numruns = 20;
        int i;
        totaltime = 0;
        for (i=0; i<numruns; i++)
        {
            for(int z=0; z<length;z++)
                array [z]= A[z];
            time1 = millis();
            Object[] arguments = { array,length };
            method.invoke(s,arguments);
            time2 = millis();
            totaltime += (time2-time1);
        }
        totaltime = totaltime/20;
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}


}

