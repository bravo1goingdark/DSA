import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph{
    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }
    // bi-directional graph
    public void addEdges(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void removeEdges(int source, int destination) {
        List<Integer> sourceList = adjacencyList.get(source);
        List<Integer> destList = adjacencyList.get(destination);

        if (sourceList != null) {
            sourceList.remove(Integer.valueOf(destination));
        }
        if (destList != null) {
            destList.remove(Integer.valueOf(source));
        }
    }
    public List<Integer> getadjacentVertices(int vertex) {
        return adjacencyList.get(vertex);
    }
    public void bfs(int startVertex){
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> que = new LinkedList<>();
        visited[startVertex] = true;
        que.offer(startVertex);

        while (!que.isEmpty()) {
            int currVertex = que.poll();
            System.out.print(currVertex + " ");

            List<Integer> list = adjacencyList.get(currVertex);
            for (int adjacent : list) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    que.offer(adjacent);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int startVertex){
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();
        visited[startVertex] = true;
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currVertex = stack.pop();
            System.out.print(currVertex + " ");

            List<Integer> neighbour = adjacencyList.get(currVertex);
            for (int adj : neighbour) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    stack.push(adj);
                }
            }

        }
    }

    public void display() {
        for (int i = 0; i < numVertices; i++) {
            List<Integer> neighbors = adjacencyList.get(i);
            System.out.print(i + " -> ");
            for (int j = 0; j < neighbors.size(); j++) {
                System.out.print(neighbors.get(j) + " ");
            }
            System.out.println();
        }
    }
}