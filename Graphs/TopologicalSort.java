import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    TopologicalSort(int numVertices){
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);
        
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdges(int source , int destination){
        adjacencyList.get(source).add(destination); // since its directed graph  
    }


    public List<Integer> topSort(){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];
        // Arrays.fill(visited, false);  no need to do another O(V) traversal since array is by default initialized with value "false"

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topSortUtil(i , visited , stack);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void topSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        List<Integer> neighbours = adjacencyList.get(vertex);
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour]) {
                topSortUtil(neighbour, visited, stack);
            }
        }
        stack.push(vertex);
    }
}
