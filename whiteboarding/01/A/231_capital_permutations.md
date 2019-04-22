# What have you been doing recently?

Should take one minute; minute and a half at most

##### Prompt

Say: "What have you been doing recently?"

##### Do you hear these things?

- *Identify*: Does the interviewee discuss their competencies based on what you have asked them? Competencies include:
   - Technical Skills (libraries, languages, etc.)
   - Interpersonal Skills  


- *Prove*: Does the interviewee provide a _specific_ example (past experience or hypothetical scenario)  to showcase competencies and/or fit? Is it presented in the form of a story (punchline, beginning, middle, positive end)?


- *Close*: Does the interviewee showcase why the company should hire them and how their skills/experience/values will add value to and align with the team/company? Does the interviewee showcase what they have learned in "Prove" and how they will apply it to the new role?

# 231 - Capital Permutations

Given a string `str` of lowercase alphabetical characters, return the set of all permutations of those characters in upper AND lowercase.

### Advanced

Solve the same problem, except now you may have number characters in your string (which don't have a lowercase or uppercase, but should still be included in your result) and capital letters, that need to be lowercased.  


```
Input: str (String)
Output: [Str] (Array of Strings)
```

# Example

```
Input: "abc"
Output: ["ABC", "ABc", "AbC", "aBC", "Abc", "aBc", "abC", "abc"]


Advanced:

Input: "A1d3"
Output: ["A1D3", "a1D3", "A1d3", "a1d3"]
```

# Constraints

```
Time Complexity: O(2^N)
Space Complexity: O(2^N)
```

The order of the strings in the final result does not matter.

In the basic solution, all the input characters will be lowercase letters.

In the advanced solution, the input characters can be uppercase letters and numbers too.

# Resources

[Capital Permutations on Leetcode](https://leetcode.com/problems/letter-case-permutation/description/);

# Solution

Use helper method recursion to solve this problem, keeping track of the depth and the permutation you are building up.

### Basic

* 1) Instantiate a `result` array, and return it at the end.
* 2) Declare a recursive helper function called `permute` that takes two arguments `substr` and `depth`, and invoke this function with an empty string and `0`.
* 3) The base case when `depth` is equal to the lenght of the input `str`, push whatever `substr` you've built up so far into `result` and return.
* 4) The recursive cases to handle are

### Advanced

Here you need to manage three scenarios in your recursion.

* 1) If you the character you are looking at is a number, perform a single recursive call with that number concatenated to `substr` and `depth + 1`;

* 2) If the character you are looking at is a capital, perform two recursive calls:
  * a) One with `substr` and that character, with `depth + 1`.
  * b) The other with `substr` and the lowercase version of that character, with `depth + 1`.

* 3) If the character you are looking at is lowercase, just do what you did in the basic solution.
  * a) Recurse with `substr` and that character, with `depth + 1`.
  * b) Recurse with `substr` and that character uppercased, with `depth + 1`



# Code

```javascript
function captialPermutationsBasic(str) {  //Given a string of letters in lowercase
  let result = [];

  function permute(substr, depth) {
    if(depth === str.length) {
      result.push(substr);
      return;
    }
    permute(substr + str[depth], depth + 1);
    permute(substr + str[depth].toUpperCase(), depth + 1);
  }

  permute("", 0);

  return result;
}

console.log(capitalPermutationsBasic("abc"));

function capitalPermutationsAdvanced(S) { //Given a string of letters containing uppercase, lowercase and numbers
    let result = [];

    function recurse(substr, depth) {
        if(depth === S.length) {
            result.push(substr);
            return;
        }
        if(!isNaN(S[depth])) {
            recurse(substr + S[depth], depth + 1)
        } else if(S[depth] == S[depth].toUpperCase()) {
            recurse(substr + S[depth].toLowerCase(), depth + 1);
            recurse(substr + S[depth], depth + 1);
        } else {
            recurse(substr + S[depth].toUpperCase(), depth + 1);
            recurse(substr + S[depth], depth + 1);
        }
    }
    recurse("", 0)
    return result;
};

console.log(capitalPermutationsAdvanced("A1bC2"));

```
