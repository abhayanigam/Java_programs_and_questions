package graphs.AmazonInterviewRoundQuestions.SecondInterviewQuestions.RotatedArrayNTimes;

/*
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
    For example, the array nums = [0,1,2,4,5,6,7] might become:

    * [4,5,6,7,0,1,2] if it was rotated 4 times.
    * [0,1,2,4,5,6,7] if it was rotated 7 times.

    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the
    array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
    Given the sorted rotated array nums of unique elements, return the minimum element of this array.

    Example 1:

    Input: nums = [3,4,5,1,2]
    Output: 1
    Explanation: The original array was [1,2,3,4,5] rotated 3 times.

    Example 2:

    Input: nums = [4,5,6,7,0,1,2]
    Output:
    Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

    Example 3:

    Input: nums = [11,13,15,17]
    Output: 11
    Explanation: The original array was [11,13,15,17] and it was rotated 4 times.


    Constraints:

    * n == nums.length
    * 1 <= n <= 5000
    * -5000 <= nums[i] <= 5000
    * All the integers of nums are unique.
    * nums is sorted and rotated between 1 and n times.



        Approach:
        1. Binary Search:
            if(nums[mid] > num[right]) --> minimum in the right side

            if(num[mid] <= num[right]) --> minimum in left side

            loop until left == right --> leftInd point the mini index ele

    Time & Space Complexity:
        Time Complexity: O(log n) → Binary search reduces the search space by half each time.
        Space Complexity: O(1) → No extra space used.

    Why Use Binary Search?
        Binary Search is the best approach for this problem because:

        1. Array is Sorted but Rotated
           - The given array is a sorted array that has been rotated. This means we can use binary search to efficiently locate the minimum element instead of checking each element one by one.

        2. Better Than Linear Search
           - A simple linear search (O(n) time complexity) would require scanning the entire array.
           - Binary search cuts down the search space by half in each iteration, leading to an O(log n) time complexity, which is much faster.

        3. Pattern in Rotated Array
           - In a rotated sorted array, the minimum element is the only element that is smaller than its previous element.
           - If nums[mid] > nums[right], the minimum element must be in the right half.
           - If nums[mid] ≤ nums[right], the minimum is in the left half.


        Binary Search Steps in This Problem
        Let's consider nums = [4, 5, 6, 7, 0, 1, 2]:

        1. Initial state → left = 0, right = 6
           - mid = (0 + 6) / 2 = 3, nums[mid] = 7
           - Since nums[mid] > nums[right] (7 > 2), move left = mid + 1 = 4.

        2. New state → left = 4, right = 6
           - mid = (4 + 6) / 2 = 5, nums[mid] = 1
           - Since nums[mid] < nums[right] (1 < 2), move right = mid = 5.

        3. New state → left = 4, right = 5
           - mid = (4 + 5) / 2 = 4, nums[mid] = 0
           - Since nums[mid] < nums[right] (0 < 1), move right = mid = 4.

        4. Stopping Condition → left == right, return nums[left] = 0.


        Time & Space Complexity
        - Time Complexity: O(log n) → Since we are halving the search space at every step.
        - Space Complexity: O(1) → We only use a few extra variables.

        This makes binary search the best choice for finding the minimum element in a rotated sorted array.
*/

class RotatedArrayNTimes {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        RotatedArrayNTimes solution = new RotatedArrayNTimes();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element: " + solution.findMin(nums));
    }
}

