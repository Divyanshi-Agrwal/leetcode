class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101];

        for (int num : nums) {
            if (num <= 100 && num % k == 0) {
                present[num] = true;
            }
        }

        for (int multiple = k; multiple <= 200; multiple += k) {
            if (multiple > 100 || !present[multiple]) {
                return multiple;
            }
        }

        return -1;
    }
}