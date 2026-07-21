class Solution {
      public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        String t = "1" + s + "1";
        int m = t.length();

        int[] start = new int[m];
        int[] len = new int[m];

        int i = 0;
        while (i < m) {
            int j = i;
            while (j < m && t.charAt(j) == t.charAt(i)) {
                j++;
            }
            start[i] = i;
            len[i] = j - i;

            for (int k = i + 1; k < j; k++) {
                start[k] = i;
                len[k] = j - i;
            }

            i = j;
        }

        int ans = totalOnes;

        i = 1;
        while (i < m - 1) {
            if (t.charAt(i) == '1') {
                int st = start[i];
                int l = len[i];
                int ed = st + l - 1;

                if (st > 0 && ed < m - 1 &&
                        t.charAt(st - 1) == '0' &&
                        t.charAt(ed + 1) == '0') {

                    int leftZero = len[st - 1];
                    int rightZero = len[ed + 1];

                    ans = Math.max(ans, totalOnes + leftZero + rightZero);
                }

                i = ed + 1;
            } else {
                i = start[i] + len[i];
            }
        }

        return ans;
    }
}