package graphs.AmazonInterviewRoundQuestions.FirstInterviewQuestions.CandyCrush;

/*
    You are playing a Candy crush game. Series of candies are provided to you in a single row (array).
    You have a hammer using which you can, and have to, recursively crush two adjacent
    candies in one go. Candies can only be crushed if they are of same type. Once crushed,
    neighbours of crushed candies become adjacent (see input 2).
    Having said that, return list of remaining candies post all possible crushing.

    Input1: AABCCCD
    Output1: BCD
*/

// Method 1: Time Complexity : O(n^2)
public class CandyCrush {

    public static String crushCandies(String candies) {
        StringBuilder sb = new StringBuilder(candies);

        while (true) {
            boolean found = false;
            int i = 0;

            while (i < sb.length() - 1) {
                int j = i;

                // Find the range of adjacent matching candies
                while (j < sb.length() - 1 && sb.charAt(j) == sb.charAt(j + 1)) {
                    j++;
                }

                // If at least two adjacent candies match, remove them
                if (j > i) {
                    sb.delete(i, j + 1);
                    found = true;
                } else {
                    i++;
                }
            }

            // If no more matches found, break out of loop
            if (!found) break;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input1 = "ABCCCD";
        String output1 = crushCandies(input1);
        System.out.println(output1); // Output: "BCD"


        System.out.println(crushCandies("ABCCCD"));  // Output: "BCD"
        System.out.println(crushCandies("AAABCCDDD"));  // Output: "B"
        System.out.println(crushCandies("AABBCC"));  // Output: ""
        System.out.println(crushCandies("AABBAAC"));  // Output: "C"
        System.out.println(crushCandies("ABBACCDDEE"));  // Output: ""
    }
}

/*
    Method 2: Time Complexity : O(n).

    import java.util.Deque;
    import java.util.LinkedList;

    public class CandyCrushDSA {

        // A simple Pair class to hold a candy and its current count (uncrushed odd count)
        static class Pair {
            char candy;
            int count;
            Pair(char candy, int count) {
                this.candy = candy;
                this.count = count;
            }
        }

        public static String crushCandies(String candies) {
            // Use a deque as a stack
            Deque<Pair> stack = new LinkedList<>();

            for (char c : candies.toCharArray()) {
                if (!stack.isEmpty() && stack.peek().candy == c) {
                    // Increment count if same candy appears consecutively
                    Pair top = stack.peek();
                    top.count++;
                    // If count becomes even, crush (remove) that pair
                    if (top.count % 2 == 0) {
                        stack.pop();
                    }
                } else {
                    // Otherwise, push a new pair with count 1
                    stack.push(new Pair(c, 1));
                }
            }

            // Reconstruct the result; since stack elements are in reverse order, use another container.
            StringBuilder result = new StringBuilder();
            // We need to build in the correct order from bottom to top.
            for (Pair p : stack) {
                // Append p.count copies of p.candy.
                for (int i = 0; i < p.count; i++) {
                    result.append(p.candy);
                }
            }
            // The iteration over a LinkedList-based stack gives reverse order of insertion,
            // so we reverse the result.
            return result.reverse().toString();
        }

        public static void main(String[] args) {
            String input = "AABCCCD"; // Example: crush "AA" -> "BCCCD", then crush "CC" from "CCC" -> "BCD"
            String output = crushCandies(input);
            System.out.println("Remaining candies: " + output); // Expected: "BCD"
        }
    }
 */