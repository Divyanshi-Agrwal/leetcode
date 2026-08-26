class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }

            // We have exactly k ones
            while (ones == k) {
                int len = right - left + 1;
                String sub = s.substring(left, right + 1);

                if (len < minLen) {
                    minLen = len;
                    ans = sub;
                } else if (len == minLen && sub.compareTo(ans) < 0) {
                    ans = sub;
                }

        
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
        }

        return ans;
    }
}