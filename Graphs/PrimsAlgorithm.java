import java.util.ArrayList;
import java.util.List;


class Edge implements Comparable<Edge> {

    private int source;
    private int destination;
    private int weight;

    public Edge(int source , int destination , int weight){
        this.source = source;
        this.destination = destination;
        this.weight = weight;

    }

    public int getSource() {
        return source;
    }
    public int getDest() {
        return destination;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

}

public class PrimsAlgorithm {
    private int numVertices;
    private List<List<Edge>> adjacencyList;

    public PrimsAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdges(int source , int destination , int weight){
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);
        adjacencyList.get(destination).add(edge);
    }

}


