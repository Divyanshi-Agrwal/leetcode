import java.util.*;

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

      
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 4; k++) {

                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >= 0 && newY >= 0 &&
                    newX < n && newY < n &&
                    dist[newX][newY] == -1) {

                    dist[newX][newY] = dist[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

 
        int low = 0;
        int high = 2 * n;
        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canReach(dist, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
    private boolean canReach(int[][] dist, int safeValue) {

        int n = dist.length;

        if (dist[0][0] < safeValue) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int x = current[0];
            int y = current[1];

            if (x == n - 1 && y == n - 1) {
                return true;
            }

            for (int k = 0; k < 4; k++) {

                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >= 0 &&
                    newY >= 0 &&
                    newX < n &&
                    newY < n &&
                    !visited[newX][newY] &&
                    dist[newX][newY] >= safeValue) {

                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return false;
    }
}