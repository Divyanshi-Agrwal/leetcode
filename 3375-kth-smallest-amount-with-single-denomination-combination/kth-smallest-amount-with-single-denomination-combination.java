class Solution {

    public long findKthSmallest(int[] coins, int k) {

        java.util.Arrays.sort(coins);

        // Remove redundant coins
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();

        for (int coin : coins) {

            boolean redundant = false;

            for (int x : list) {
                if (coin % x == 0) {
                    redundant = true;
                    break;
                }
            }

            if (!redundant) {
                list.add(coin);
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        long low = 1;
        long high = (long) arr[0] * k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, arr) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long total = 0;

        // Inclusion-Exclusion
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean overflow = false;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    long g = gcd(lcm, coins[i]);

                    // lcm = lcm / gcd * coin
                    long value = lcm / g;

                    // Avoid overflow and ignore LCM > x
                    if (value > x / coins[i]) {
                        overflow = true;
                        break;
                    }

                    lcm = value * coins[i];

                    if (lcm > x) {
                        overflow = true;
                        break;
                    }
                }
            }

            if (overflow) {
                continue;
            }

            long current = x / lcm;

            if ((bits & 1) == 1) {
                total += current;
            } else {
                total -= current;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}