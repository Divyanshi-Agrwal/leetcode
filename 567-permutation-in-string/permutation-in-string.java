class Solution {
    public boolean checkInclusion(String s1, String s2) {
    
    int[] count1 = new int[26];
     int[] count2 = new int[26];

     for(char ch : s1.toCharArray()){
        count1[ch - 'a']++;
     }
     int left = 0;
     for(int right = 0; right < s2.length(); right++){
        count2[s2.charAt(right) - 'a']++;

        if(right - left +1 > s1.length()){
            count2[s2.charAt(left) - 'a']--;
            left++;
        }
        if(Arrays.equals(count1 , count2)){
            return true;
        }

     }
     return false;
    }
}