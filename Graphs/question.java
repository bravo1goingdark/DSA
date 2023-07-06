import java.util.ArrayList;
import java.util.HashMap;
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
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer , Integer> map = new HashMap<>();

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
}
