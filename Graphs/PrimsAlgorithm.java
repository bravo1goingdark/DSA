import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


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

    public void primsMST(int source) {
        boolean[] visited = new boolean[numVertices];
        int[] parent = new int[numVertices];
        int[] key = new int[numVertices];
        Arrays.fill(key , Integer.MAX_VALUE);

        PriorityQueue<Edge> minheap = new PriorityQueue<>();
        int startvertex = 0;
        key[startvertex] = 0;
        minheap.add(new Edge(startvertex, startvertex, 0));

        while (!minheap.isEmpty()) {
            Edge currEdge = minheap.poll();
            int currvertex = currEdge.getDest();

            if (visited[currvertex]) {
                continue;
            }

            visited[currvertex] = true;

            for (Edge edge : adjacencyList.get(currvertex)) {
                int neigbour = edge.getDest();
                int weight = edge.getWeight();

                if (!visited[neigbour] && weight < key[neigbour] ) {
                    parent[neigbour] = currvertex;
                    key[neigbour] = weight;
                    minheap.add(new Edge(currvertex, neigbour, weight));
                }
            }
        }
        System.out.println("Minimum Spanning Tree");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(parent[i] + " -> " + i);
        }
    }

}


