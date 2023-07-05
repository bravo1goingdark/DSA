import java.util.ArrayList;
import java.util.List;

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
}
