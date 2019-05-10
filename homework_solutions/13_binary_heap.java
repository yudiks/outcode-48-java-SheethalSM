/*
  * Homework 12 - Heap
  *
  *
  *  Prompt: Create a Heap class/constructor
  *
  *  The Heap will take in the following input:
  *
  *                type: argument should be either 'min' or 'max'. This will
  *                      dictate whether the heap will be a minheap or maxheap.
  *                      The comparator method will be affected by this
  *                      argument. See method description below
  *
  *  The Heap will have the following property:
  *
  *             storage: array
  *
  *                type: property that will be either 'min' or 'max'. This will
  *                      be dictated by
  *
  *  The Heap will have the following methods:
  *
  *             compare: takes in two arguments (a and b). Depending on the heap
  *                      type (minheap or maxheap), the comparator will behave
  *                      differently. If the heap is a minheap, then the compare
  *                      function will return true if a is less than b, false
  *                      otherwise. If the heap is a maxheap, then the compare
  *                      function will return true if a is greater than b, false
  *                      otherwise.
  *
  *                swap: takes in two indexes and swaps the elements at the two
  *                      indexes in the storage array
  *
  *                peak: returns the peak element of the storage array. This
  *                      will be the most minimum and maximum element for a
  *                      minheap and maxheap respectively
  *
  *                size: returns the number of elements in the heap
  *
  *              insert: inserts a value into the heap. Should begin by pushing
  *                      the value onto the end of the array, and then calling
  *                      the bubbleUp method from the last index of the array
  *
  *            bubbleUp: takes in an index, and considers the element at that
  *                      index to be a child. Continues to swap that child with
  *                      its parent value if the heap comparator condition is
  *                      not fulfilled
  *
  *          removePeak: removes the peak element from the heap and returns it.
  *                      Should begin by swapping the 0th-index element with the
  *                      last element in the storage array. Uses bubbleDown
  *                      method from the 0th index
  *
  *          bubbleDown: takes in an index, and considers the element at this
  *                      index to be the parent. Continues to swap this parent
  *                      element with its children if the heap comparator
  *                      condition is not fulfilled
  *
  *              remove: takes in a value and (if it exists in the heap),
  *                      removes that value from the heap data structure and
  *                      returns it. Should rearrange the rest of the heap to
  *                      ensure the heap comparator conditions are fulfilled
  *                      for all of its elements
  *
  *
  *
  *  Input:  N/A
  *  Output: A Heap instance
  *
  *  What are the time and auxilliary space complexities of the various methods?
  *
  */

import java.util.*;

class Heap {

  List<Integer> storage;
  String type;


  public Heap(String type) {
    this.type = type;
    this.storage = new ArrayList<Integer>();
  }

  // Time Complexity: O(1)
  // Auxiliary Space Complexity: O(1)
  public boolean compare(int a, int b){
    if (type.equals("max")) {
      return storage.get(a) > storage.get(b);
    } else {
      return storage.get(a) < storage.get(b);
    }
  }

  // Time Complexity: O(1)
  // Auxiliary Space Complexity: O(1)
  public void swap(int index1, int index2){
    int temp = storage.get(index1);
    storage.set(index1, storage.get(index2));
    storage.set(index2, temp);
  }

  // Time Complexity: O(1)
  // Auxiliary Space Complexity: O(1)
  public int peak(){
    return storage.get(0);
  }

  // Time Complexity: O(1)
  // Auxiliary Space Complexity: O(1)
  public int size(){
    return storage.size();
  }

  // Time Complexity: O(log(N))
  // Auxiliary Space Complexity: O(1)
  public void insert(int value){
    storage.add(value);
    bubbleUp(this.size() - 1);
  }

  // Time Complexity: O(log(N))
  // Auxiliary Space Complexity: O(1)
  public void bubbleUp(int index){
    if (index < 1 || index >= this.size()) {
      return;
    }

    int childIndex = index;
    int parentIndex = 0;

    if (childIndex % 2 == 0) {
      // even childIndex
      parentIndex = (childIndex - 2) / 2;
    } else {
      // odd childIndex
      parentIndex = (childIndex - 1) / 2;
    }

    while (childIndex > 0 && !compare(parentIndex, childIndex)) {
      swap(parentIndex, childIndex);

      childIndex = parentIndex;
      if (childIndex % 2 == 0) {
        parentIndex = (childIndex - 2) / 2;
      } else {
        parentIndex = (childIndex - 1) / 2;
      }
    }
  }

  // Time Complexity: O(log(N))
  // Auxiliary Space Complexity: O(1)
  public int removePeak(){
    swap(0, size() - 1);
    int toReturn = storage.remove(size()-1);
    bubbleDown(0);
    return toReturn;
  }

  // Time Complexity: O(log(N))
  // Auxiliary Space Complexity: O(1)
  public void bubbleDown(int index){
    if (index >= this.size()) {
      return;
    }

    int parentIndex = index;
    int childIndex1 = 2 * parentIndex + 1;
    int childIndex2 = 2 * parentIndex + 2;
    int masterChildIndex = 0;

    if (childIndex1 >= this.size()) {
      return;
    } else if (childIndex2 > this.size()) {
      // combine two middle else if cases possibly
      masterChildIndex = childIndex1;
    } else if (compare(childIndex1, childIndex2)) {
      masterChildIndex = childIndex1;
    } else {
      masterChildIndex = childIndex2;
    }

    while (parentIndex < this.size() - 1 && !compare(parentIndex, masterChildIndex)) {
      swap(parentIndex, masterChildIndex);

      parentIndex = masterChildIndex;
      childIndex1 = 2 * parentIndex + 1;
      childIndex2 = 2 * parentIndex + 2;

      if (childIndex1 >= this.size()) {
        return;
      } else if (childIndex2 >= this.size()) {
        // combine two middle else if cases possibly
        masterChildIndex = childIndex1;
      } else if (compare(childIndex1, childIndex2)) {
        masterChildIndex = childIndex1;
      } else {
        masterChildIndex = childIndex2;
      }
    }
  }

  /*To implement remove, iterate through the array until you find the index
  where the value to be removed is located. When found, swap this element
  with the last element of the storage array, and then pop it off. Then run
  bubbleUp and bubbleDown from the index where the last index was swapped in.*/
  // Time Complexity: O(log(N))
  // Auxiliary Space Complexity: O(1)
  public boolean remove(int value){
    for (int i = 0 ; i < this.size() ; i++) {
      if (storage.get(i) == value) {
        swap(i, this.size() - 1);
        int temp = storage.remove(size()-1);
        bubbleUp(i);
        bubbleDown(i);
        return true;
      }
    }
    return false;
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
    System.out.println("Heap Class");

    // tests are in the form as shown
    assertTest(testCount, "able to create an instance", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        return heap instanceof Heap;
      }
    });

    assertTest(testCount, "has storage field", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getDeclaredField("storage");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "has type field", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getDeclaredField("type");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "default storage set to an array", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          return heap.getClass().getDeclaredField("storage").getType().isAssignableFrom(List.class) || heap.getClass().getDeclaredField("storage").getType().isAssignableFrom(ArrayList.class);
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "default type property is set to \'min\'", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        return heap.type.equals("min");
      }
    });

    assertTest(testCount, "default type property is set to \'max\'", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        return heap.type.equals("max");
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap compare method");

    // tests are in the form as shown
    assertTest(testCount, "has compare method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("compare", new Class[] { int.class, int.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "returns true for minheap if element at first argument index is less than element at second argument index", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage.add(1);
        heap.storage.add(10);
        return heap.compare(0, 1) == true;
      }
    });

    assertTest(testCount, "returns false for minheap if element at first argument index is greater than element at second argument index", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage.add(10);
        heap.storage.add(1);
        return heap.compare(0, 1) == false;
      }
    });

    assertTest(testCount, "return true for maxheap if element at first argument index is greater than element at second argument index", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage.add(10);
        heap.storage.add(1);
        return heap.compare(0, 1) == true;
      }
    });

    assertTest(testCount, "return false for maxheap if element at first argument index is less than element at second argument index", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage.add(1);
        heap.storage.add(10);
        return heap.compare(0, 1) == false;
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap swap method");

    // tests are in the form as shown
    assertTest(testCount, "has swap method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("swap", new Class[] { int.class, int.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "should be able to swap the locations of two elements given two indices", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage.add(1);
        heap.storage.add(5);
        heap.storage.add(10);
        heap.swap(0, 2);
        return heap.storage.get(0) == 10 && heap.storage.get(2) == 1;
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap peak method");

    // tests are in the form as shown
    assertTest(testCount, "has peak method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("peak", new Class[] {});
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "should return the 0th element of the storage array", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage.add(1);
        heap.storage.add(5);
        heap.storage.add(10);
        return heap.peak() == 1;
      }
    });

    assertTest(testCount, "upon building out your insert method, should return the smallest element for a minheap", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.insert(2);
        heap.insert(5);
        heap.insert(10);
        heap.insert(1);
        return heap.peak() == 1;
      }
    });

    assertTest(testCount, "upon building out your insert method, should return the largest element for a maxheap", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.insert(2);
        heap.insert(5);
        heap.insert(10);
        heap.insert(1);
        return heap.peak() == 10;
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap size method");

    // tests are in the form as shown
    assertTest(testCount, "has size method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("size", new Class[] {});
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "returns number of elements in the storage array", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage.add(1);
        heap.storage.add(5);
        heap.storage.add(10);
        return heap.size() == 3;
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap insert method");

    // tests are in the form as shown
    assertTest(testCount, "has insert method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("insert", new Class[] { int.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "should be able to insert a single element", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.insert(5);
        return heap.storage.get(0) == 5;
      }
    });

    assertTest(testCount, "should be able to insert multiple elements into a minheap and have peak element be smallest element", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.insert(5);
        heap.insert(10);
        heap.insert(7);
        heap.insert(1);
        heap.insert(8);
        heap.insert(6);
        return heap.peak() == 1;
      }
    });

    assertTest(testCount, "should be able to insert multiple elements into a maxheap and have peak element be largest element", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.insert(5);
        heap.insert(10);
        heap.insert(7);
        heap.insert(1);
        heap.insert(8);
        heap.insert(6);
        return heap.peak() == 10;
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap bubbleUp method");

    // tests are in the form as shown
    assertTest(testCount, "has bubbleUp method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("bubbleUp", new Class[] { int.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "should be able to \'bubble up\' an element if its minheap condition is not fulfilled", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage = new ArrayList<Integer>(Arrays.asList(2,4,7,6,9,10,8,1));
        heap.bubbleUp(7);
        return heap.storage.equals(new ArrayList<Integer>(Arrays.asList(1,2,7,4,9,10,8,6)));
      }
    });

    assertTest(testCount, "should be able to \'bubble up\' an element if its maxheap condition is not fulfilled", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage = new ArrayList<Integer>(Arrays.asList(9,8,5,7,3,6,2,10));
        heap.bubbleUp(7);
        return heap.storage.equals(new ArrayList<Integer>(Arrays.asList(10,9,5,8,3,6,2,7)));
      }
    });

    assertTest(testCount, "should not perform bubbling up if minheap conditions are fulfilled", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage = new ArrayList<Integer>(Arrays.asList(1,2,7,4,9,10,8,6));
        heap.bubbleUp(7);
        return heap.storage.equals(new ArrayList<Integer>(Arrays.asList(1,2,7,4,9,10,8,6)));
      }
    });

    assertTest(testCount, "should not perform bubbling up if maxheap conditions are fulfilled", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage = new ArrayList<Integer>(Arrays.asList(10,9,5,8,3,6,2,7));
        heap.bubbleUp(7);
        return heap.storage.equals(new ArrayList<Integer>(Arrays.asList(10,9,5,8,3,6,2,7)));
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap removePeak method");

    // tests are in the form as shown
    assertTest(testCount, "has removePeak method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("removePeak", new Class[] { });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "should be able to remove a single element", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.insert(5);
        heap.removePeak();
        return heap.storage.size() == 0;
      }
    });

    assertTest(testCount, "should be able to remove and return peak element for a minheap and rearrange minheap accordingly", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage = new ArrayList<Integer>(Arrays.asList(1,2,7,4,9,10,8,6));
        int peak = heap.removePeak();
        return peak == 1 && heap.storage.equals(new ArrayList<>(Arrays.asList(2,4,7,6,9,10,8)));
      }
    });

    assertTest(testCount, "should be able to remove and return peak element for a maxheap and rearrange maxheap accordingly", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage = new ArrayList<Integer>(Arrays.asList(10,9,5,8,3,6,2,7));
        int peak = heap.removePeak();
        return peak == 10 && heap.storage.equals(new ArrayList<>(Arrays.asList(9,8,5,7,3,6,2)));
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap bubbleDown method");

    // tests are in the form as shown
    assertTest(testCount, "has bubbleDown method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("bubbleDown", new Class[] { int.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "should be able to \'bubble down\' an element if its minheap condition is not fulfilled", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage = new ArrayList<Integer>(Arrays.asList(10,1,2,7,4,9,8,6));
        heap.bubbleDown(0);
        return heap.storage.equals(new ArrayList<>(Arrays.asList(1,4,2,7,10,9,8,6)));
      }
    });

    assertTest(testCount, "should be able to \'bubble down\' an element if its maxheap condition is not fulfilled", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage = new ArrayList<Integer>(Arrays.asList(2,10,9,5,8,3,6,7));
        heap.bubbleDown(0);
        return heap.storage.equals(new ArrayList<>(Arrays.asList(10,8,9,5,2,3,6,7)));
      }
    });

    assertTest(testCount, "should not perform bubbling down if minheap conditions are fulfilled", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage = new ArrayList<Integer>(Arrays.asList(1,2,7,4,9,10,8,6));
        heap.bubbleDown(0);
        return heap.storage.equals(new ArrayList<>(Arrays.asList(1,2,7,4,9,10,8,6)));
      }
    });

    assertTest(testCount, "should not perform bubbling down if maxheap conditions are fulfilled", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage = new ArrayList<Integer>(Arrays.asList(10,9,5,8,3,6,2,7));
        heap.bubbleDown(0);
        return heap.storage.equals(new ArrayList<>(Arrays.asList(10,9,5,8,3,6,2,7)));
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Heap remove method");

    // tests are in the form as shown
    assertTest(testCount, "has remove method", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        try {
          heap.getClass().getMethod("remove", new Class[] { int.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "is able to remove specified value from minheap", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage = new ArrayList<Integer>(Arrays.asList(1,2,7,4,9,10,8,6));
        boolean removed = heap.remove(10);
        return removed && heap.storage.equals(new ArrayList<>(Arrays.asList(1,2,6,4,9,7,8)));
      }
    });

    assertTest(testCount, "is able to remove specified value from maxheap", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage = new ArrayList<Integer>(Arrays.asList(10,9,5,8,3,6,2,7));
        boolean removed = heap.remove(6);
        return removed && heap.storage.equals(new ArrayList<>(Arrays.asList(10,9,7,8,3,5,2)));
      }
    });

    assertTest(testCount, "is able to remove last value from minheap", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage = new ArrayList<Integer>(Arrays.asList(1,2,7,4,9,10,8,6));
        boolean removed = heap.remove(6);
        return removed && heap.storage.equals(new ArrayList<>(Arrays.asList(1,2,7,4,9,10,8)));
      }
    });

    assertTest(testCount, "is able to remove last value from maxheap", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage = new ArrayList<Integer>(Arrays.asList(10,9,5,8,3,6,2,7));
        boolean removed = heap.remove(7);
        return removed && heap.storage.equals(new ArrayList<>(Arrays.asList(10,9,5,8,3,6,2)));
      }
    });

    assertTest(testCount, "does not remove anything from minheap if value does not exist", new Test() {
      public boolean execute() {
        Heap heap = new Heap("min");
        heap.storage = new ArrayList<Integer>(Arrays.asList(1,2,7,4,9,10,8,6));
        heap.remove(3);
        return heap.storage.equals(new ArrayList<>(Arrays.asList(1,2,7,4,9,10,8,6)));
      }
    });

    assertTest(testCount, "does not remove anything from maxheap if value does not exist", new Test() {
      public boolean execute() {
        Heap heap = new Heap("max");
        heap.storage = new ArrayList<Integer>(Arrays.asList(10,9,5,8,3,6,2,7));
        heap.remove(4);
        return heap.storage.equals(new ArrayList<>(Arrays.asList(10,9,5,8,3,6,2,7)));
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
