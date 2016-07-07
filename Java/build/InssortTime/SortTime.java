
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

 /*   System.out.println();
 
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
static void inssort(int[] A, int startpos, int length) {
  int temp;
  for (int i = startpos + 1; i < startpos + length; i++) // Insert i'th record
    for (int j = i; (j>startpos) && (A[j] < A[j-1]); j--) {
      swap(A, j, j-1);
    }
}


// Standard insertion sort for Integer class
static void inssortInteger(Integer[] A, int startpos, int length) {
int temp;
for (int i = startpos + 1; i < startpos + length; i++) // Insert i'th record
for (int j = i; (j>startpos) && (A[j].compareTo(A[j-1]) < 0); j--) {
swapInteger(A, j, j-1);
}
}

// Standard insertion sort for double type array
static void inssortDouble(double[] A, int startpos, int length) {
int temp;
for (int i = startpos + 1; i < startpos + length; i++) // Insert i'th record
for (int j = i; (j>startpos) && (A[j] < A[j-1]); j--) {
swapDouble(A, j, j-1);
}
}

// Same as standard insertion sort, except get rid of the swap
// function call
static void inssort2Integer(Integer[] A, int startpos, int length) {
Integer temp;
for (int i = startpos + 1; i < startpos + length; i++) // Insert i'th record
for (int j = i; (j>startpos) && (A[j].compareTo(A[j-1]) < 0); j--) {
temp = A[j]; A[j] = A[j-1]; A[j-1] = temp;
}
}


// Same as standard insertion sort, except get rid of the swap
// function call
static void inssort2Double(double[] A, int startpos, int length) {
double temp;
for (int i = startpos + 1; i < startpos + length; i++) // Insert i'th record
for (int j = i; (j>startpos) && (A[j] < A[j-1]); j--) {
temp = A[j]; A[j] = A[j-1]; A[j-1] = temp;
}
}

// Same as standard insertion sort, except get rid of the swap
// function call
static void inssort2(int[] A, int startpos, int length) {
  int temp;
  for (int i = startpos + 1; i < startpos + length; i++) // Insert i'th record
    for (int j = i; (j>startpos) && (A[j] < A[j-1]); j--) {
      temp = A[j]; A[j] = A[j-1]; A[j-1] = temp;
    }
}

    static void radixSortInteger(LinkedList<Integer> array,int length)
    {

        int size = array.size();

        LinkedList<Integer> bucket = new LinkedList<Integer>();
        int power = 1;

        for(int z=0;z<length;z++){
            bucket.add(z,0);
        }

        for(int j=0; j<3;j++)
        {
            for(int k=0;k<length;k++)
            {
                bucket.add((array.get(k)/power)%10,array.get(k));
            }

        
        array.clear();

        for(int l=0;l<length;l++)
        {

            array.add(l,bucket.get(l));

        }

            power = power*10;
       }

     }

    static void radixSortDouble(LinkedList<Double> array,int length)
    {

        int size = array.size();

        LinkedList<Double> bucket = new LinkedList<Double>();
        int power = 1;

        for(int z=0;z<length;z++){
            bucket.add(z,0.0);
        }

        for(int j=0; j<3;j++)
        {
            for(int k=0;k<length;k++)
            {
                bucket.add(((array.get(k).intValue())/power)%10,array.get(k));
            }

            array.clear();

            for(int l=0;l<length;l++)
            {

                array.add(l,bucket.get(l));

            }

            power = power*10;
        }

    }


    @SuppressWarnings("unchecked")
     static void funcInssort(int[] A,int length,String methodName){
        try {
            int [] array = new int[A.length];
            SortTime s = new SortTime();
            Class cls = s.getClass();
            Class[] c = new Class[3];
            c[0] = array.getClass();
            c[1] = int.class;
            c[2] = int.class;
            Method method = cls.getDeclaredMethod(methodName,c);
            method.setAccessible(true);

            int i;
            totaltime = 0;
            for (i=0; i<TESTSIZE; i += length)
            {
                time1 = millis();
                Object[] arguments = { A, i,length };
                method.invoke(s,arguments);
                time2 = millis();
                totaltime += (time2-time1);
            }

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }

    @SuppressWarnings("unchecked")
     static void funcInssortDouble(double[] A,int length,String methodName){
        try {
            double [] array = new double[A.length];
            SortTime s = new SortTime();
            Class cls = s.getClass();
            Class[] c = new Class[3];
            c[0] = array.getClass();
            c[1] = int.class;
            c[2] = int.class;
            Method method = cls.getDeclaredMethod(methodName,c);
            method.setAccessible(true);

            int i;
            totaltime = 0;
            for (i=0; i<TESTSIZE; i += length)
            {
                time1 = millis();
                Object[] arguments = { A, i,length };
                method.invoke(s,arguments);
                time2 = millis();
                totaltime += (time2-time1);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")

static void funcInssortInteger(Integer[] A,int length,String methodName){
    try {
        Integer [] array = new Integer[A.length];
        SortTime s = new SortTime();
        Class cls = s.getClass();
        Class[] c = new Class[3];
        c[0] = array.getClass();
        c[1] = int.class;
        c[2] = int.class;
        Method method = cls.getDeclaredMethod(methodName,c);
        method.setAccessible(true);

        int i;
        totaltime = 0;
        for (i=0; i<TESTSIZE; i += length)
        {
            time1 = millis();
            Object[] arguments = { A, i,length };
            method.invoke(s,arguments);
            time2 = millis();
            totaltime += (time2-time1);
        }
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
}

