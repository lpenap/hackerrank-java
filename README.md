# Collection of HackerRank problem solutions.

Personal collection of solutions to HackerRank problems using Java.

You will find project files for Eclipse and an easy method to switch from
local file inputs to hackerrank.com System.in inputs.

Also, you'll find: URL to problem statement, order of the function (O notation)
and solution approach on each source file.

### Switching from local input to hackerrank 

Use the following method to switch between inputs:

```java
	public BufferedReader inputFromHackerrank(boolean fromHackerrank) {
		String DIR_SEP = "/";
		BufferedReader br = null;

		if (fromHackerrank) {
			return new BufferedReader(new InputStreamReader(System.in));
		} else {
			return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(DIR_SEP
					+ getClass().getPackage().getName().replaceAll("\\.", DIR_SEP) + DIR_SEP + "input.txt")));
		}
	}
```

Passing **true** to the above method will use input from hackerrank. Passing **false** will make use of the input.txt file on each problem package (Adjust your folder separator string accordingly). For example:

```java
	public static void main(String[] args) {
		BufferedReader br = inputFromHackerrank(false);
		Scanner in = new Scanner(br);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}
	public static BufferedReader inputFromHackerrank(boolean fromHackerrank) {
		String DIR_SEP = "/";
		BufferedReader br = null;
		if (fromHackerrank) {
			return new BufferedReader(new InputStreamReader(System.in));
		} else {
			return new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(DIR_SEP
					+ getClass().getPackage().getName().replaceAll("\\.", DIR_SEP) + DIR_SEP + "input.txt")));
		}
	}
```

### Problems solved so far (6):

* https://www.hackerrank.com/challenges/ctci_array_left_rotation
* https://www.hackerrank.com/challenges/ctci_contacts
* https://www.hackerrank.com/challenges/ctci_is_binary_search_tree
* https://www.hackerrank.com/challenges/ctci_linked_list_cycle
* https://www.hackerrank.com/challenges/ctci_making_anagrams
* https://www.hackerrank.com/challenges/ctci_ransom_code