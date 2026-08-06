class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // pivot element

        int pivot = -1;
        for(int i = n-2; i>=0; i--){ // becz we are moving from right to left
        if(nums[i] < nums[i+1]){
            pivot  =i;
            break;
        }

        }
        // if no pivot reverse thr whole array
        if(pivot == -1){
            reverse(nums , 0, n-1);
            return;
        }
        // next greter ele
        for(int i = n-1; i> pivot; i--){
            if(nums[i] > nums[pivot]){
                swap(nums , i, pivot);
                break;
            }
        }
      //  reverse right part
      reverse(nums,pivot+1 , n-1);

        
    }
    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums , int left , int right){
        while(left < right){
            swap(nums , left , right);
                left++;
                right--;
            }
        
    }
}