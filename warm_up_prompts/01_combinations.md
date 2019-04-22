# Helper Method Recursion - Combinations

#### Prompt

Given two integers `n` and `k`, return **all possible combinations** of `k` numbers from `1` to `n`.

#### Examples:

```
n = 4
k = 2

result =
[
	[1,2],
	[1,3],
	[1,4],
	[2,3],
	[2,4],
	[3,4],
]

n = 3
k = 1

result =
[
	[1],
	[2],
	[3],
]

```


#### Input:
`n` = `Integer`

`k` = `Integer`

#### Output
`result` = `Array of Arrays of Integers`


#### Constraints:

**Time**: `O(n choose k)`

**Space**: `O(n choose k)`

The order of the output array **DOES NOT MATTER**.

`n` and `k` are both positive.

#### Resources:

[N Choose K](https://en.wikipedia.org/wiki/Binomial_coefficient)

[Combinations] (https://betterexplained.com/articles/easy-permutations-and-combinations/)

#### Hints:

You can think of `1` to `n` as the **set of numbers** you can choose from.

You can think of `k` as the **number of elements** in the result arrays that come from that set.

You'll want to ignore relative order of the numbers, ie use `[1,2]` and ignore `[2,1]`.

Think about how you might use multiple recursion here.

This problem will have two recursive cases and two base cases.

#### Solution:

YOUR WORK HERE
