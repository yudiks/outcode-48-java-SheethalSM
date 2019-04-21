/*
 * Homework 03 - Decrease and Conquer
 * Utilize the decrease and conquer pattern to solve these problems.
 */


import java.io.*;
import java.util.*;

class Problems {

/*
 *
 *  Number of Ones
 *
 * *Given a sorted bit array (values of either 0 or 1), determine the number of 1's in the array.*
 *
 * **Parameters**
 * Input: arr {Array of Integers}
 * Output: {Integer}
 *
 * **Constraints**
 * Time: O(logN)
 * Space: O(1)
 *
 * **Examples**
 * `[0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1] --> 8`
 * `[0, 0, 0] --> 0`
 * `[0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1] --> 7`
 */

  //keep counter for 1
  public static int numberOfOnes(int[] arr) {
    // YOUR WORK HERE
    int x =1;
    if((arr.contains(x) && arr.length>=1)
    int low=0;
    int end=arr.length -1;
    int count=-1;
    while(low<=end)
    {
      int mid=(low+end)/2;
      if(A[mid]==x) {count = mid;}//x is the elem to be searched for so 1
      else if(x<A[mid]) 
      {end =mid-1;}
      else {
          low=mid+1;     
      }
      
    }
    return arr.length - mid;
  }

/*
 * Closest Value
 *
 * Given a sorted bit array of integers, and a target value, find the number in the array that is closest to the target.*
 *
 * **Parameters**
 * Input: arr {Array of Integers}
 * Input: target {Integer}
 * Output: {Integer}
 *
 * **Constraints**
 * If there are two numbers tied for the closest value, return the lowest value.
 *
 * Time: O(logN)
 * Space: O(1)
 *
 * **Examples**
 * `[1, 2, 3, 5, 5, 7, 9, 10, 11], 6 --> 5`
 * `[1, 2, 3], 8 --> 3`
 * `[1, 10, 22, 59, 67, 72, 100], 70 --> 72`
 */
//pseudocode: the last nubmer after array is target and search through the array to find target -- and return return target --
       //if target < mid, only search on left side, if target >mid search on right side
       //note: array is sorted
public static int closestValue(int[] arr, int target) {
  // YOUR WORK HERE
  int result =0;
  int low=0;
  int end= arr.length-1;
  if(contains(arr,target) //in the case that array contains target
  { result =target;
  } 
  if(target<arr[0])
     {
       result = arr[0];
     }
  int mid = (low+end)/2
     if(target<mid)
     {
       end=mid-1;
     }
     elseif(target>mid)
     {
       low = mid+1;
     }
     else{
        result = arr[mid];
     }
     
      if((arr[low]-target) < (target-arr[high]))   //googled this part... i was not sure how to even come up with answer
         {
           result = arr[low];
         }
     else{
          result = arr[end];
     }
  return result;
}
       


/*
 * Square Root
 *
 * Given an positive integer, find the square root.*
 *
 * **Parameters**
 * Input: value {Double}
 * Output: {Double}
 *
 * **Constraints**
 * Do not use a native built in method.
 * Ensure the result is accurate to 6 decimal places (0.000001)
 *
 * Time: O(logN)
 * Space: O(1)
 *
 * **Examples**
 * `4 --> 2.0`
 * `98 --> 9.899495`
 * `14856 --> 121.885192
 */
//this alg I checked for perfect squares until 25
 //find lowestprime factor of int, 
    //figure how many times(count) prime factor will have to multiply to get to square..
     //divide times count by 2 to get the root of the square
 //or else BST 
     //find middle, if mid*midd<n then go to the right side by increment by 1 and make itnew mid, else go to the left elems

public static Double squareRoot(Double n) {
  // YOUR WORK HERE
  int result=0;
  int low= 1;
  int end = n;
  int mid = (low+end)/2;
  if(mid*mid = n)//perfect case
  {
    result =mid;
  }
  if(mid*mid<n)
  {
    low = mid+1
      result = mid;
  }
  if(mid*mid>n)
  { 
    end = mid-1;
  }
  return result;
}


/*
 * Greater Values
 *
 * *Given an sorted array of integers, and a target value return the number of values greater the target.*
 *
 * **Parameters**
 * Input: arr {Array of Integers}
 * Input: target {Integer}
 * Output: {Integer}
 *
 * **Constraints**
 *
 * Time: O(logN)
 * Space: O(1)
 *
 * **Examples**
 * `[1, 2, 3, 5, 5, 7, 9, 10, 11], 5 --> 4`
 * `[1, 2, 3], 4 --> 0`
 * `[1, 10, 22, 59, 67, 72, 100], 13 --> 5`
 *
*/

public static int greaterValues(int[] arr, int target) {
  // YOUR WORK HERE
  //are you asking for all values above target values in an array. 
  int result=0;
  int start=0;
  int end= arr.length-1;
  while(start<=end)
  {
    mid = (start+end)/2;
    if(mid<target)
    {
      start=mid+1;
    }
    if(mid>target)
    {
      end = mid -1;
    }
    if(arr[mid] <= target && arr[mid+1] > target){
      {  return end - mid;}
  }
  return result;
}


/*
 * Sorted and Rotated Array [Extra Credit]
 *
 * *Given a array that is sorted an rotated, find out if a target value exists in the array.*
 *
 * An sorted array is rotated by taking an unknown amount of values from the beginning and placing it at the end.
 *
 * `[3, 4, 5, 1, 2]` is rotated left by 2.
 * `[99, 14, 25, 78, 93]` is rotated to the right by 1.
 *
 * **Parameters**
 * Input: arr {Array of Integers}
 * Input: target {Integer}
 * Output: {Boolean}
 *
 * **Constraints**
 * Time: O(logN)
 * Space: O(N)
 *
 * **Examples**
 * `[35, 46, 79, 102, 1, 14, 29, 31], 46 --> true`
 * `[35, 46, 79, 102, 1, 14, 29, 31], 47 --> false`
 * `[7, 8, 9, 10, 1, 2, 3, 4, 5, 6], 9 --> true`
 */

public static boolean rotatedArraySearch(int[] nums, int target) {
  // YOUR WORK HERE
  int start =0; 
  int end = nums.length-1;
  int mid = (start+end)/2;
  if(target ==nums[mid])
  {
    return true;
  }
  if(target<nums[mid])
  {
    end = mid-1;
  }
  elseif(target>nums[mid])
  {
    start = mid+1;
  }
  if(target<nums[end] && target>nums[mid])
  { 
    start = mid+1;
    end =nums.length-1;
  }
  if(target>nums[0] && target<nums[mid])
  { 
    start = 0;
    end =mid;
  }
  return false;
}

//i assume below algorithm is suppose to be recursive binary search Googled this recursive solution 
private static boolean binarySearch(int[] nums, int start, int end, int target) {
  // YOUR WORK HERE
  if (left>right)
  {
    return false;
  }
  int mid = (start+end)/2;
  if(nums[mid] == target)
  {
    return true;
  }
  elseif(target<nums[mid])
  {
     return binarySearch(nums, start, target, mid-1)
  }
  else
  {
    return binarySearch(nums,target,mid+1, end)
  }
  return false;
}


/*
 * Multiplication Using Russian Peasant [Extra Credit]
 *
 * *Given two positive integers, return its product using Russian Peasant method of multiplication*
 *
 * Read up on how to apply the Russian Peasant method [here](https: *en.wikipedia.org/wiki/Ancient_Egyptian_multiplication). It is also referred to as the Egyptian multiplication.
 *
 * **Parameters**
 * Input: a {Integer}
 * Input: b {Integer}
 * Output: {Integer}
 *
 * **Constraints**
 * Assume a <= b, and the value of a is N.
 *
 * Time: O(logN)
 * Space: O(1)
 *
 * **Examples**
 * `734, 487 --> 357458`
 * `846, 908--> 768168`
 */

public static int multiplicationRussianPeasant(int a, int b) {
  // YOUR WORK HERE
  return -1;
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

    // instantiate the testing of each module by resetting count and printing title of module
    int[] testCount = {0, 0};
    System.out.println("Number Of Ones Tests");

    // tests are in the form as shown
    assertTest(testCount, "should return correct number of ones for array with zeroes and ones", new Test() {
      public boolean execute() {
        int output = Problems.numberOfOnes(new int[]{0, 0, 0, 1, 1, 1});
        return output == 3;
      }
    });

    assertTest(testCount, "should return correct number of ones for array with all zeroes", new Test() {
      public boolean execute() {
        int output = Problems.numberOfOnes(new int[]{0, 0, 0, 0, 0, 0});
        return output == 0;
      }
    });

    assertTest(testCount, "should return correct number of ones for array with all ones", new Test() {
      public boolean execute() {
        int output = Problems.numberOfOnes(new int[]{1, 1, 1, 1, 1});
        return output == 5;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Closest Value Tests");

    assertTest(testCount, "should return correct closest value for number in the middle range", new Test() {
      public boolean execute() {
        int output = Problems.closestValue(new int[]{1, 2, 3, 5, 5, 7, 9, 10, 11}, 6);
        return output == 5;
      }
    });

    assertTest(testCount, "should return closest value for highest number", new Test() {
      public boolean execute() {
        int output = Problems.closestValue(new int[]{1, 2, 3}, 8);
        return output == 3;
      }
    });

    assertTest(testCount, "should return closest value for lowest number", new Test() {
      public boolean execute() {
        int output = Problems.closestValue(new int[]{-2, -1, 0}, -5);
        return output == -2;
      }
    });


    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");

    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Square Root Tests");

    assertTest(testCount, "should return correct square root for number < 10", new Test() {
      public boolean execute() {
        Double output = Problems.squareRoot(4.0);
        return output == 2.0;
      }
    });

    assertTest(testCount, "should return correct square root for number between 10 and 100", new Test() {
      public boolean execute() {
        Double output = Problems.squareRoot(98.0);
        return output == 9.899495;
      }
    });

    assertTest(testCount, "should return correct square root for number over 10,000", new Test() {
      public boolean execute() {
        Double output = Problems.squareRoot(14856.0);
        return output == 121.885192;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Greater Values Tests");

    assertTest(testCount, "should return greater values for number in the middle of the array", new Test() {
      public boolean execute() {
        int output = Problems.greaterValues(new int[] {1, 2, 3, 5, 5, 7, 9, 10, 11}, 5);
        return output == 4;
      }
    });

    assertTest(testCount, "should return 0 for number greater than largest in the array", new Test() {
      public boolean execute() {
        int output = Problems.greaterValues(new int[] {1, 2, 3}, 4);
        return output == 0;
      }
    });

    assertTest(testCount, "should return length of array for number less than least in the array", new Test() {
      public boolean execute() {
        int output = Problems.greaterValues(new int[] {1, 10, 22, 59, 67, 72, 100}, -2);
        return output == 7;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Rotated Sorted Array Tests");

    assertTest(testCount, "returns true when target is in the array", new Test() {
      public boolean execute() {
        boolean output = Problems.rotatedArraySearch(new int[] {35, 46, 79, 102, 1, 14, 29, 31}, 46);
        return output == true;
      }
    });

    assertTest(testCount, "returns false when target is not in the array", new Test() {
      public boolean execute() {
        boolean output = Problems.rotatedArraySearch(new int[] {35, 46, 79, 102, 1, 14, 29, 31}, 47);
        return output == false;
      }
    });

    assertTest(testCount, "returns true when target is the first number in the array", new Test() {
      public boolean execute() {
        boolean output = Problems.rotatedArraySearch(new int[] {7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 7);
        return output == true;
      }
    });

    assertTest(testCount, "returns true when target is the last number in the array", new Test() {
      public boolean execute() {
        boolean output = Problems.rotatedArraySearch(new int[] {7, 8, 9, 10, 1, 2, 3, 4, 5, 6}, 6);
        return output == true;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Multiplication Russian Tests");

    assertTest(testCount, "returns correct value for two integers", new Test() {
      public boolean execute() {
        int output = Problems.multiplicationRussianPeasant(734, 487);
        return output == 357458;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");

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
