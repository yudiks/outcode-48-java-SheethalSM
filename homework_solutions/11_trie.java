/**
 *  Homework 11 - Trie
 *
 *  Problem 1: TrieNode class
 *
 *  Prompt:    Create a TrieNode class
 *             The TrieNode class should contain the following properties:
 *
 *                 value:   {Char}
 *                  next:   {Map}
 *                   end:   {Boolean}
 *
 *
 *  Problem 2:  Trie class
 *
 *  Prompt:     Create a Trie class
 *              The Trie class should contain the following properties:
 *
 *                  root:   {TrieNode}
 *
 *              The Trie class should also contain the following methods:
 *
 *                insert:   A method that adds a word.
 *
 *                          Input:     word {String}
 *                          Output:    void
 *
 *                isWord:   A method that checks whether a word is in the trie.
 *
 *                          Input:     word {String}
 *                          Output:    Boolean
 *
 *              isPrefix:   A method that checks whether an input is a prefix of
 *                          a word in the string.
 *
 *                          Input:     prefix {String}
 *                          Output:    Boolean
 *
 *            startsWith:   A method that returns all words that starts with an
 *                          input word.
 *
 *                          Input:     prefix {String}
 *                          Output:    String[]
 *
 *          EXTRA CREDIT:
 *                remove:   Removes a word from the trie.
 *
 *                          Input:     word {String}
 *                          Output:    void
 */

import java.util.*;


// DO NOT EDIT
// TrieNode class
class TrieNode {
  public Character value;
  public Map<Character, TrieNode> next = new HashMap<>();
  public boolean end = false;

  public TrieNode(Character value) {
      this.value = value;
  }
}

class Trie {


  public TrieNode root = new TrieNode('\u0000');

  public boolean insert(String word) {
    TrieNode current = this.root;
    char[] chars = word.toCharArray();
    char letter;

    for(int i = 0; i < chars.length; i++) {
      letter = chars[i];
      if(!current.next.containsKey(letter)) {
        current.next.put(letter, new TrieNode(letter));
      }
      current = current.next.get(letter);
    }
    current.end = true;
    return true;
  }

  public boolean isWord(String word) {
    if(word == "") {
      return false;
    }
    TrieNode current = this._search(word);
    return current != null && current.end;
  }

  public boolean isPrefix(String prefix) {
    if(prefix == "") {
      return true;
    }
    TrieNode current = this._search(prefix);
    return current != null;
  }

  public ArrayList<String> startsWith(String prefix) {
    TrieNode current = this._search(prefix);
    if(current == null) { return null; }
    ArrayList<String> results = new ArrayList<String>();
    results = _traverseNode(current);

    String temp;

    for (int i = 0; i < results.size(); i++) {
      temp = prefix + results.get(i);
      results.set(i, temp);
    }

    return results;
  }

  public void remove(String word) {
    if(word.equals("")){ return; }
    TrieNode current = this.root;

    Stack<TrieNode> stack = new Stack<TrieNode>();

    char[] characters = word.toCharArray();

    for(int i = 0; i < characters.length; i++) {
      stack.push(current);
      current = current.next.get(characters[i]);
      if(current == null) { return; }
    }
     current.end = false;

     if(current.next.keySet().size() > 0) { return; }

     char previousLetter;
     while(!current.end && stack.size() > 0) {
       previousLetter = current.value;
       current = stack.pop();
       current.next.remove(previousLetter);
     }

  }

  private TrieNode _search(String word) {
      TrieNode current = this.root;
      char[] chars = word.toCharArray();
      char letter;

      for(int i = 0; i < chars.length; i++) {
        letter = chars[i];
        if(!current.next.containsKey(letter)) {
          return null;
        }
        current = current.next.get(letter);
      }
      return current;
  }

  private ArrayList<String> _traverseNode(TrieNode node) {
    ArrayList<String> results = new ArrayList<String>();
    dfs(node, "", results);
    return results;
  }

  private void dfs(TrieNode current, String path, ArrayList<String> results) {
    if(current == null) {
      return;
    }
    if(current.end) { results.add(path);}
    for(Character key : current.next.keySet()) {
      dfs(current.next.get(key), path + key,results);
    }
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
    System.out.println("TrieNode Class");

    // tests are in the form as shown
    assertTest(testCount, "able to create an instance", new Test() {
      public boolean execute() {
        Character ch = new Character('a');
        TrieNode node = new TrieNode(ch);
        return node instanceof TrieNode;
      }
    });

    assertTest(testCount, "has value property", new Test() {
      public boolean execute() {
        Character ch = new Character('a');
        TrieNode node = new TrieNode(ch);
        try {
          node.getClass().getDeclaredField("value");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "has end property", new Test() {
      public boolean execute() {
        Character ch = new Character('a');
        TrieNode node = new TrieNode(ch);
        try {
          node.getClass().getDeclaredField("end");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "end property instatiated to false", new Test() {
      public boolean execute() {
        Character ch = new Character('a');
        TrieNode node = new TrieNode(ch);
        return node.end == false;
      }
    });

    assertTest(testCount, "able to assign a end upon instantiation", new Test() {
      public boolean execute() {
        Character ch = new Character('a');
        TrieNode node = new TrieNode(ch);
        node.end = true;
        return node.end == true;
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Trie Class");


    assertTest(testCount, "able to create an instance", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        return trie instanceof Trie;
      }
    });

    assertTest(testCount, "has root property", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        try {
          trie.getClass().getDeclaredField("root");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    assertTest(testCount, "root property is a TrieNode", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        return trie.root instanceof TrieNode;
      }
    });

    assertTest(testCount, "has root property", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        try {
          trie.getClass().getDeclaredField("root");
          return true;
        } catch (Exception e) {
          return false;
        }
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Trie Insert Method");


    assertTest(testCount, "has insert method", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        try {
          trie.getClass().getMethod("insert", new Class[] { String.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "able to insert a word into empty trie", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        return trie.root.next.containsKey('c') && trie.root.next.get('c').next.containsKey('a') && trie.root.next.get('c').next.get('a').next.containsKey('t') && (trie.root.next.get('c').next.get('a').next.get('t').end == true);
      }
    });

    assertTest(testCount, "able to insert words that overlap into trie", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("car");
        return trie.root.next.containsKey('c') && trie.root.next.get('c').next.containsKey('a') && trie.root.next.get('c').next.get('a').next.containsKey('t') && (trie.root.next.get('c').next.get('a').next.get('t').end == true) &&
        trie.root.next.get('c').next.get('a').next.containsKey('r') &&
        (trie.root.next.get('c').next.get('a').next.get('r').end == true);
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Trie IsWord Method");


    assertTest(testCount, "has isWord method", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        try {
          trie.getClass().getMethod("isWord", new Class[] { String.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "should return false for an empty string as input", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        return trie.isWord("") == false;
      }
    });

    assertTest(testCount, "should return true for a word that exists", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        return trie.isWord("cat") == true;
      }
    });

    assertTest(testCount, "should return false for a word that does not exist", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        return trie.isWord("car") == false;
      }
    });

    assertTest(testCount, "should return true for a word that exists within a larger word", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cats");
        return trie.isWord("cat") == true;
      }
    });

    assertTest(testCount, "should return true for a word that is a larger word", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cats");
        return trie.isWord("cats") == true;
      }
    });

    assertTest(testCount, "should return false if a smaller word was not added, but exists in a larger word", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cats");
        return trie.isWord("cat") == false;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Trie StartsWith Method");

    assertTest(testCount, "has startsWith method", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        try {
          trie.getClass().getMethod("startsWith", new Class[] { String.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "returns null if no words start with input", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cats");
        trie.insert("corner");
        trie.insert("cesium");
        ArrayList<String> results = trie.startsWith("a");
        return results == null;
      }
    });

    assertTest(testCount, "returns correct prefixes including input that is a word", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cats");
        trie.insert("catnip");
        trie.insert("car");
        trie.insert("cars");
        ArrayList<String> results = trie.startsWith("car");
        return results instanceof ArrayList && results.get(0).equals("car") && results.get(1).equals("cars");
      }
    });

    assertTest(testCount, "returns the correct prefixes", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cats");
        trie.insert("catnip");
        trie.insert("car");
        trie.insert("cars");
        ArrayList<String> results = trie.startsWith("ca");

        return results instanceof ArrayList && results.indexOf("cat") != -1 && results.indexOf("cats") != -1 && results.indexOf("catnip") != -1 && results.indexOf("car") != -1 && results.indexOf("cars") != -1;
      }
    });

    assertTest(testCount, "returns all words if input is empty string", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cats");
        trie.insert("catnip");
        trie.insert("foo");
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("he");

        ArrayList<String> results = trie.startsWith("");

        return results instanceof ArrayList && results.indexOf("cat") != -1 && results.indexOf("cats") != -1 && results.indexOf("catnip") != -1 && results.indexOf("foo") != -1 && results.indexOf("hello") != -1 && results.indexOf("hell") != -1 && results.indexOf("he") != -1;
      }
    });

    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");



    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Trie Remove Method");

    assertTest(testCount, "has remove method", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        try {
          trie.getClass().getMethod("remove", new Class[] { String.class });
          return true;
        } catch (Exception e) {
          e.printStackTrace();
          return false;
        }
      }
    });

    assertTest(testCount, "removes a word that exists", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.remove("cat");
        return trie.isWord("cat") == false && (trie.root.next.get('c') == null);
      }
    });

    assertTest(testCount, "does not remove a word that does not exist", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.remove("c");
        return trie.isWord("cat") == true;
      }
    });

    assertTest(testCount, "does not remove letters at that belong to a longer word", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("he");
        trie.remove("hell");
        return trie.isWord("he") == true &&
               trie.isWord("hello") == true &&
               trie.isWord("hell") == false;
      }
    });

    assertTest(testCount, "removes letters from longer word and keeps shorter letters", new Test() {
      public boolean execute() {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("cats");
        trie.insert("catnip");
        trie.remove("catnip");
        return trie.isWord("cat") == true &&
               trie.isWord("cats") == true &&
               trie.isWord("catnip") == false && (trie.root.next.get('c').next.get('a').next.get('t').next.get('n') == null );
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
