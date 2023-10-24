import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Graph {
    private int numVertices;
    private List<List<Integer>> adjacencyList;


    Graph(int numVertices){
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdges(int source , int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void removeEdges(int source , int destination) {
        adjacencyList.get(source).remove(Integer.valueOf(destination));
        adjacencyList.get(destination).remove(Integer.valueOf(source));
    }

    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencyList.get(vertex);
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            List<Integer> neighbors = adjacencyList.get(i);
            System.out.print(i + " -> ");
            for (int j = 0; j < neighbors.size(); j++) {
                System.out.print(neighbors.get(j) + " ");
            }
            System.out.println();
        }
    }

    // Depth first search using stack
    public void DFS(int startVertex){
        boolean[] visited = new boolean[numVertices];
        DFSutil(startVertex , visited);
    }

    private void DFSutil(int startVertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currVertex = stack.pop();

            if (!visited[currVertex]) {
                visited[currVertex] = true;
                System.out.print(currVertex + " ");

                List<Integer> neighbours = adjacencyList.get(currVertex);
                for (Integer neighbour : neighbours) {
                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                    }  
                }
            }
        }
    }

    // DFS using recursion

    public void recur_DFS(int startVertex){
        boolean[] visited = new boolean[numVertices];
        recur_DFS_util(startVertex , visited); 
    }

    private void recur_DFS_util(int startVertex, boolean[] visited) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        List<Integer> neighbourVertex = adjacencyList.get(startVertex);
        for (Integer neighbour : neighbourVertex) {
            if (!visited[neighbour]) {
                recur_DFS_util(neighbour, visited);
            }
        }
    }
}