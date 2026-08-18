import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        int n = nums.length;

        // Check every subarray of size k
        for (int i = 0; i <= n - k; i++) {

            HashSet<Integer> set = new HashSet<>();

            // Add elements of current subarray
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            // Each unique number appears in this subarray
            for (int x : set) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
        }

        int ans = -1;

        // Find largest number appearing in exactly one subarray
        for (int x : count.keySet()) {
            if (count.get(x) == 1) {
                ans = Math.max(ans, x);
            }
        }

        return ans;
    }
}