// Timing test for loops: incrementing vs. decrementing (test against 0)
import java.io.*;
import java.math.*;
import java.util.*;

public class SortTime {
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
  return System.currentTimeMillis();
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
static void sorttime(int[] B) {
  int i;
  int[] A = new int[B.length];
  Integer[] Aint = new Integer[B.length];
  int totaltime, runs;
  int numruns = 20;

  println("Doing timings on the basis of " + numruns + " runs");

totaltime = 0;
for (runs=0; runs<numruns; runs++) {
  for (i=0; i<B.length; i++)
    Aint[i] = new Integer(B[i]);
  time1 = millis();
  selsort(Aint);
  time2 = millis();
  checkorder(Aint);
totaltime += (time2-time1);
}
  println("Standard Selection Sort: Size " + testsize + ", Time: " + totaltime);

totaltime = 0;
for (runs=0; runs<numruns; runs++) {
  for(i=0; i<B.length; i++) A[i] = B[i];
  time1 = millis();
  selsortcheck(A);
  time2 = millis();
  checkorder(A);
totaltime += (time2-time1);
}
  println("Standard Selection Sort: Size " + testsize + ", Time: " + totaltime);
}

// Same as selsort, but check if the swap is necessary
static void selsortcheck(int[] A) {
  for (int i=0; i<A.length-1; i++) { // Select i'th biggest record
    int bigindex = 0;                // Current biggest index
    for (int j=1; j<A.length-i; j++) // Find the max value
      if (A[j] > A[bigindex])        // Found something bigger  
        bigindex = j;                // Remember bigger index
    if (bigindex != A.length-i-1)
      swap(A, bigindex, A.length-i-1); // Put it into place
  }
}

@SuppressWarnings("unchecked") // Generic array allocation
static Boolean sorttest(int[] B) {
  int i;
  Integer[] A = new Integer[B.length];
  for (i=0; i<B.length; i++)
    A[i] = new Integer(B[i]);
  selsort(A);
  if (!checkorder(A)) return false;

  //  KVPair[] AKV = (KVPair[])new Object[B.length];
  //  for (i=0; i<B.length; i++)
  //    AKV[i] = new KVPair(new Integer(B[i]), new Integer(B[i]));
  //  inssort(A);
  //  if (!checkorder(A)) return false;
  return true;
}

/* *** ODSATag: Selectionsort *** */
static <T extends Comparable<T>> void selsort(T[] A) {
  for (int i=0; i<A.length-1; i++) {       // Select i'th biggest record
    int bigindex = 0;                      // Current biggest index
    for (int j=1; j<A.length-i; j++)       // Find the max value
      if (A[j].compareTo(A[bigindex]) > 0) // Found something bigger  
        bigindex = j;                      // Remember bigger index
    swap(A, bigindex, A.length-i-1);       // Put it into place
  }
}
/* *** ODSAendTag: Selectionsort *** */
static int numtests = 5;
static int testsize = 10000;
static boolean SUCCESS = true;
static long time1, time2;
static Random value;

public static void main(String args[]) throws IOException {
  int[] A = new int[testsize];
  value = new Random();

  for (int i=0; i<A.length; i++)
    A[i] = (Math.abs(value.nextInt()) % 1000) + 1;
//  for (int i=0; i<A.length; i++)
//    A[i] = i+1;
//  for (int i=0; i<A.length; i++)
//    A[i] = 200000 - i;

  sorttime(A);
}

}
