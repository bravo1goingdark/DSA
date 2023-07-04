import java.util.ArrayList;
import java.util.List;

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