import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store reserved seats (only seats 2-9 matter)
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                int mask = map.getOrDefault(row, 0);
                mask |= (1 << (col - 2));
                map.put(row, mask);
            }
        }

        // Rows without reservations can fit 2 families
        int ans = (n - map.size()) * 2;

        int leftMask = 0b00001111;   // seats 2,3,4,5
        int middleMask = 0b00111100; // seats 4,5,6,7
        int rightMask = 0b11110000;  // seats 6,7,8,9

        for (int mask : map.values()) {

            boolean left = (mask & leftMask) == 0;
            boolean middle = (mask & middleMask) == 0;
            boolean right = (mask & rightMask) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans += 1;
            }
        }

        return ans;
    }
}