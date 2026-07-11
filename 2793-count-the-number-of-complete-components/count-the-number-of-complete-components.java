import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private boolean[] visited;
    private int nodes;
    private int edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nodes = 0;
                edgeCount = 0;

                dfs(i);

                if (edgeCount == nodes * (nodes - 1)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    private void dfs(int node) {
        visited[node] = true;
        nodes++;

        edgeCount += graph[node].size();

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}