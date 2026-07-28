class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n/2];
        int cost = 0;
        for(int num: nums){
            cost += Math.abs(num - median);
        }
        return cost;
        
    }
}