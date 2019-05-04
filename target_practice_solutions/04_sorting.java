/*
 *  Target Practice 04 - Sorting
 *
 *  Problem 1: Quicksort
 *
 *  Prompt:    Given an unsorted array of integers, return the array
 *             sorted using quicksort.
 *
 *
 *  Input:     input {Array}
 *  Output:    {Array}
 *
 *  Example:   [3,9,1,4,7] --> [1,3,4,7,9]
 */

 import java.util.*;



 // Worse Time Complexity: O(N^2)
 // Worse Auxiliary Space Complexity: O(N)
 // Average Time Complexity: O(Nlog(N))
 // Average Auxiliary Space Complexity: O(log(N))
 class Quicksort {

   public static int[] compute(int[] input) {
     divide(input, 0, input.length - 1);
     return input;
   }

   private static void divide(int[] input, int begin, int end) {
     int mid = begin;

     if (begin >= end) {
       return;
     }
     for(int i = begin; i < end; i++){
       if(input[i] < input[end]){
         swap(input, mid, i);
         mid++;
       }
     }

     swap(input, mid, end);
     divide(input, begin, mid - 1);
     divide(input, mid + 1, end);
   }

   private static void swap(int[] arr, int i, int j){
     int temp = arr[i];
     arr[i] = arr[j];
     arr[j] = temp;
    }
 }





 ////////////////////////////////////////////////////////////
 ///////////////  DO NOT TOUCH TEST BELOW!!!  ///////////////
 ////////////////////////////////////////////////////////////

 // use the Main class to run the test cases
 class Main {
   private int[] testCount;

   // an interface to perform tests
   public interface Test {
     public boolean execute();
   }

   public static void main(String[] args) {

     int[] testCount = {0, 0};
     System.out.println("Quick Sort Tests");

     assertTest(testCount, "should sort example input", new Test() {
       public boolean execute() {
         Quicksort quicksort = new Quicksort();
         return arraysEqual(quicksort.compute(new int[]{3, 9, 1, 4, 7}), new int[]{1, 3, 4, 7, 9});
       }
     });

     assertTest(testCount, "should return empty array for empty input", new Test() {
       public boolean execute() {
         Quicksort quicksort = new Quicksort();
         return arraysEqual(quicksort.compute(new int[]{}), new int[]{});
       }
     });

     assertTest(testCount, "should sort single-element input", new Test() {
       public boolean execute() {
         Quicksort quicksort = new Quicksort();
         return arraysEqual(quicksort.compute(new int[]{10}), new int[]{10});
       }
     });

     assertTest(testCount, "should sort moderate-sized input", new Test() {
       public boolean execute() {
         Quicksort quicksort = new Quicksort();
         int[] input = new int[1000];
         for (int i = 0 ; i < input.length ; i++) {
           input[i] = (int) Math.floor(Math.random() * 1000);
         }
         int[] inputSorted = new int[1000];

         System.arraycopy(input, 0, inputSorted, 0, input.length);

         int[] solution = new int[1000];
         System.arraycopy(input, 0, solution, 0, input.length);
         input = quicksort.compute(input);

         Arrays.sort(solution);
         return isSorted(input) && arraysEqual(input, solution);
       }
     });

     assertTest(testCount, "should sort large-sized input", new Test() {
       public boolean execute() {
         Quicksort quicksort = new Quicksort();
         int[] input = new int[1000000];
         for (int i = 0 ; i < input.length ; i++) {
           input[i] = (int) Math.floor(Math.random() * 1000000);
         }
         int[] inputSorted = new int[1000000];

         System.arraycopy(input, 0, inputSorted, 0, input.length);

         int[] solution = new int[1000000];
         System.arraycopy(input, 0, solution, 0, input.length);
         input = quicksort.compute(input);

         Arrays.sort(solution);
         return isSorted(input) && arraysEqual(input, solution);
       }
     });

     // print the result of tests passed for a module
     System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");
   }


   // function for checking if arrays are equal
   private static boolean arraysEqual(int[] arr1, int[] arr2) {
     if (arr1.length != arr2.length) {
       return false;
     }

     for (int i = 0 ; i < arr1.length ; i++) {
       if (arr1[i] != arr2[i]) {
         return false;
       }
     }

     return true;
   }

   // checks if array is sorted in linear time
   private static boolean isSorted(int[] input) {
     if (input.length < 2) {
       return true;
     }

     for (int i = 1 ; i < input.length ; i++) {
       if (input[i-1] > input[i]) {
         return false;
       }
     }

     return true;
   }

   // do not edit below, this is to wrap the test and check for exceptions
   private static void assertTest(int[] count, String name, Test test) {
     String pass = "false";
     count[1]++;

     try {
       if (test.execute()) {
         pass = " true";
         count[0]++;
       }
     } catch(Exception e) {}
     String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
     System.out.println(result);
   }

 }
