class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
       // ArrayList<Integer> arr = new ArrayList<>();
        int[] nums = new int[2];
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                nums[0] = left+1;
                nums[1] = right + 1;
                return nums;
            }
            else if(sum < target){
                left++;
            }
            else{
                right--;
            }
        }
        return nums;

        
    }
}