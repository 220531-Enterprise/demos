> ***After demoing the following content**, be sure to complete this [LeetCode Challenge](https://leetcode.com/problems/binary-search/) 👈*

# Searching Algorithms

- **Basic Linear Search** - O(n) Linear
- **Binary Search** - O(log n) Logarithmic
  > *Logarithmic running time (O(log n)) essentially means that the running time grows in proportion to the logarithm of the input size - as an example, if 10 items takes at most some amount of time x, and 100 items takes at most, say, 2x, and 10,000 items takes at most 4x, then it's looking like an O(log n) time complexity.*
<br>

- **Recursive Linear Search**
- **Recursive Binary Search**

## Binary Search
Imagine that you have a shelf of books and you are looking for a book authored by *Shakespear*.  With Linear search, you would start from the beginning and check each book.  The faster approach (O(log n)) would be by using **Binary Search**.

> The collection must be **sorted** to apply Binary Search

- Imagine that the books are **sorted by last name**.
- With Binary Search you would **first located the center of the book shelf**.
- Imagine the book in the center of the shelf is authored by someone with a last name starting with "U".

<br>

> [ P Q R S T **U** V W X Y Z]

<br>

- Since "S" is *less than* "U", we can eliminate the entire right half of the book shelf, only searching between "P" - "T".

<br>

> [ P Q R S T ~~**U** V W X Y Z~~]

<br>

- We repeat this process, continuously finding the midpoint and checking whether our target value is greater than or less than, until we find "S".

<br>

> [ P Q **R** S T] <br>
> [ ~~P Q **R**~~ S T] <br> 
> [ **S** ~~T~~]

<br>

Binary Search on a *sorted* array looks like this:

<br>

```java
public static int binarySearch(int[] arr, int x) {
    int min = 0;
    int max = arr.length - 1;

    while (min <= max) {
        
        int mid = (min + max) / 2;
        
        if (x < arr[mid]) { // if the target value is less than
            max = mid - 1; // the midpoint, we discard the RHS
        } else if (x > arr[mid]) {
            min = mid + 1; // otherwise we discard the LHS
        } else {
            return mid;
        }
    }
    return -1;
}
```

<br>

### Logarithmic Complexity O(log n)
Logarithm is the inverse of exponentiation.  The way this works is by division - the size of the input is repeatedly being divided by 2. Note the radicall difference in number of operations performed based on input between Linear O(n) vs Binary Search O(log n).

<img src="imgs/bin.png">

The formula to get the logarithm of a number is `log`<sub>`2`</sub>`n`.  For example, let's say we had an input size of **10,000**.  To find how many opearations this would take with Binary Search to find a target value, in a calculator you would run:

> `n` = 10,000 <br>
> `log`<sub>`2`</sub>`n` = **14** <br>

Finding the `log`<sub>`2`</sub> of a number, is equivelent to asking "how many times can I divide this by 2 until I reach 1?".  That's why the `log`<sub>`2`</sub> of 10,000 is 14. 



## Recursion
Recursion occurs when a method invokes itself, like so:

<br

```java
public static void foo() {
    foo();
}
```

<br>

The above method will continue to call itself and adding one frame ontop of another in the stack until we reach a `StackOverflowError`.  We must add a condition for the method to be invoked called a **Base Case**.

Take a look at the following example:

<br>

```java
	public static void reduceByOne(int n) {
		
		if (n >= 0) { // we must add a condition to avoid a StackOverFlow error
					  // this is also called a Base Case.
			reduceByOne(n-1);
		}
		System.out.println("Completed Call: " + n);
	}
```

<br>

Within the `main()` method, if we run `	reduceByOne(10);`, it will return the following

```sh
Completed Call: -1
Completed Call: 0
Completed Call: 1
Completed Call: 2
Completed Call: 3
Completed Call: 4
Completed Call: 5
Completed Call: 6
Completed Call: 7
Completed Call: 8
Completed Call: 9
Completed Call: 10
```

<br>

***Why does the console print 10 last and -1 first?*** <br>
- The last method on top of the stack is the condition that breaks the recursive loop: `n = -1` which is `< 0`. 
- When that method completes, it allows the previous method (in which `n = 0`) to be complete and be released from the stack.
- This process continues all the way until the first call is popped off the stack. (`n = 10`).

