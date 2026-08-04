class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int reach = target-nums[i];
            if(map.containsKey(reach)){
                return new int[]{map.get(reach),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
       

        }
       
        }
     
        
    
