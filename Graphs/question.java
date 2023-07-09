import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class question {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        int center = -1;
        for (int i = 1; i <= n; i++) {
            if (adjacencyList.get(i).size() == n - 1) {
                center = i;
                break;
            }
        }
        return center;
    }
    public int findJudge(int n, int[][] trust) {
        Map<Integer , Integer> map = new HashMap<>();

        for (int[] pair : trust) {
            int person1 = pair[0];
            int person2 = pair[1];
            map.put(person1, map.getOrDefault(person1, 0));
            map.put(person2, map.getOrDefault(person2, 0) + 1);
        }

        for (int i = 0; i <= n; i++) {
            if (map.getOrDefault(i, 0) == n - 1) {
                boolean istownjudge = true;
                for (int[] pair : trust) {
                    if (pair[0] == i) {
                        istownjudge = false;
                        break;
                    }
                }
                if (istownjudge) {
                    return i;
                }
            }
        }
        return -1;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(adjacencyList , visited , source , destination);

    }
    private boolean dfs(List<List<Integer>> adjacencyList, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }

        visited[source] = true;

        for (int neighbour : adjacencyList.get(source)) {
            if (!visited[neighbour]) {
                if (dfs(adjacencyList, visited, neighbour, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        Arrays.fill(minDist , Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        int minCost = 0 ;
        for (int i = 0; i < n; i++) {
            int curr = -1;
            // Find the closest unvisited point
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (curr == -1 || minDist[j] < minDist[curr])) {
                    curr = j;
                }
            }
            minCost += minDist[curr];
            visited[curr] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(points[curr][0] - points[j][0]) + Math.abs(points[curr][1] - points[j][1]);
                    minDist[j] = Math.min(minDist[j], dist);
                }
            }
        }
        
        return minCost;

    }
}

