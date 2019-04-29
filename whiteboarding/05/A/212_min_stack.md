# Tell me about a time you had to overcome a roadblock?

Should take one minute; minute and a half at most

##### Prompt

Say: "Tell me about a time you had to overcome a roadblock? What did you do?

##### Do you hear these things?

- *Identify*: Does the interviewee discuss their competencies based on what you have asked them? Competencies include:
   - Technical Skills (libraries, languages, etc.)
   - Interpersonal Skills  


- *Prove*: Does the interviewee provide a _specific_ example (past experience or hypothetical scenario)  to showcase competencies and/or fit? Is it presented in the form of a story (punchline, beginning, middle, positive end)?


- *Close*: Does the interviewee showcase why the company should hire them and how their skills/experience/values will add value to and align with the team/company? Does the interviewee showcase what they have learned in "Prove" and how they will apply it to the new role?

# 212 - Min Stack

Design a `min stack` class with the following properties:

`push(value)` - Push an integer onto the stack

`pop()` - 	Removes and returns the element on top of the stack

`peek()` - Return the top value in the stack (do not remove it)

`min()` - 	Return the minimum value in the stack

You have access to a `Stack` class with `push(value)`, `pop()`, `peek()`, `size()` that all run in `O(1)` time/space.

```
Input:  N/A
Output: Instance of a min stack
```
# Example
```
Input: 	

minStack.push(-3)
minStack.push(1)
minStack.push(5)
minStack.min()

Output:	-3


Input:

minStack.push(5)
minStack.push(2)
minStack.push(3)
minStack.push(4)
minStack.push(1)

Output:

minStack.min()  => 1

minStack.pop()

minStack.min() => 2 (does this in O(1) time and space)

```
# Constraints

`Push`, `Pop`, `Peek`, and `Min` must be performed in:

```
Time Complexity: O(1)

Auxiliary Space Complexity: O(1)
```

You have access to a `Stack` class with `push(value)`, `pop()`, `peek()`, `size()` that all run in `O(1)` time/space.

All the `METHODS` are in constant time, constant space.

However, your `MinStack` instance may contain more than one instance of a `Stack` class.

IMPORTANT: only let the person being interviewed know that you can use multiple stacks if they get stuck.

The main method you will be implementing is the `min()`.


# Solution

Create two `stacks` using  `arrays` (or `dynamic arrays` if `java`) called `storage` and `minStorage`

`push(input)`:

* 1) `push` the `input` into the `storage` `array`
* 2) find lower of the last item in the `minStorage` `array` and the `input` value
* 3) `push` the lower of the two into the `minStorage` `array`

`pop()`: `pop` from the `min` `array`, then `pop` and return the element from the  `storage` `array`

`peek()`: return the last item in the `storage` array

`min()`: return the last item in the `minStorage` array

# Code

```javascript
class MinStack {
  constructor() {
    this.storage = [];
    this.minStorage = [];
  }

  push(item) {
    this.storage.push(item);

    if (this.minStorage.length === 0) {
      this.minStorage.push(item);
    } else if (item < this.min()) {
      this.minStorage.push(item);
    } else {
      let minItem = this.min();
      this.minStorage.push(minItem);
    }
  }

  pop() {
    this.minStorage.pop();
    return this.storage.pop();
  }

  peek() {
    return this.storage[this.storage.length - 1];  
  }

  min() {
    return this.minStorage[this.minStorage.length - 1];
  }
}

```

# Resources

[Min Stack on Leetcode](https://leetcode.com/problems/min-stack/)
