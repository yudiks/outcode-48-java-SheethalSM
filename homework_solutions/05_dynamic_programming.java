/**
 *  Homework 05 - Dynamic Programming: Tabulation/Memoization
 *
 *
 *  Instructions: Dynammic programming takes a lot of practice to recognize as
 *                well as develop algorithms. Thus we will be working on a few
 *                different problems using dynammic programming.
 *
 *                As a reminder, here are the two dynamic programing approaches:
 *
 *      			(1) Overlapping subproblems - Memoization
 *      				  Recursion sometimes call subproblems repeatedly. These repeated
 *                calls lead to inefficient computations and an exponential time
 *                complexity.
 *
 *      			(2) Optimal substructure - Tabulation
 *      					The solution of a larger problem can be solved using
 *      					solutions of its subproblems.
 */

import java.util.*;

class Problems {

  /*
  *  1. Coin Sum
  *
  *          Given an array of coins and a target total, return how many
  *          unique ways there are to use the coins to make up that total.
  *
  *  Input:  coins {Integer Array}, total {Integer}
  *  Output: {Integer}
  *
  *
  * Example:
  *  Input:  [1,2,3], 4
  *  Output: 4
  *
  *          1+1+1+1
  *          1+3
  *          1+1+2
  *          2+2
  *
  *
  *  Input:  [2,5,3,6], 10
  *  Output: 5
  *
  *          2+3+5
  *          5+5
  *          2+3+2+3
  *          2+2+6
  *          2+2+2+2+2
  *
  *    Note: You have an unlimited number of each coin type. All coins in the
  *          coin array will be unique
  *          Order does not matter. Ex: One penny and one nickel to create six
  *          cents is equivalent to one nickel and one penny
  *
  */

  // Time Complexity: O(NK)
  // Auxiliary Space Complexity: O(N)
  // where N refers to the target total, and K refers to the length of the coins
  // array

  public static int coinSum(int[] coins, int total) {
    int[] table = new int[total + 1];
    table[0] = 1;

    for (int i = 0; i < coins.length; i++) {
      int coin = coins[i];
      for (int j = coin; j < table.length; j++) {
        table[j] = table[j] + table[j - coin];
      }
    }
    return table[table.length - 1];
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
    System.out.println("Coin Sum Tests");

    // tests are in the form as shown
    assertTest(testCount, "should work for first example case", new Test() {
      public boolean execute() {
        int output = Problems.coinSum(new int[]{1,2,3}, 4);
        return output == 4;
      }
    });

    assertTest(testCount, "should work for second example case", new Test() {
      public boolean execute() {
        int output = Problems.coinSum(new int[]{2,5,3,6}, 10);
        return output == 5;
      }
    });

    assertTest(testCount, "should work for a single coin", new Test() {
      public boolean execute() {
        int output = Problems.coinSum(new int[]{2}, 10);
        return output == 1;
      }
    });

    assertTest(testCount, "should work for a single coin", new Test() {
      public boolean execute() {
        int output = Problems.coinSum(new int[]{2}, 10);
        return output == 1;
      }
    });

    // print the result of tests passed for a module
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
