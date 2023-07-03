import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T , List<T>> adjacencylist;

    public Graph() {
        this.adjacencylist = new HashMap<>();
    }

    // bi-directional graph
    public void addEdges(T source , T destination){
        List<T> sourcelist = adjacencylist.get(source);
        if (sourcelist == null) {
            sourcelist = new ArrayList<>();
            adjacencylist.put(source, sourcelist);
        }
        sourcelist.add(destination);

        List<T> destinationList = adjacencylist.get(destination);
        if (destinationList == null) {
            destinationList = new ArrayList<>();
            adjacencylist.put(destination, destinationList);
        }
        destinationList.add(source);
    }

    public void removeEdges(T source , T destination) {
        List<T> sourceList = adjacencylist.get(source);
        if (sourceList != null) {
            sourceList.remove(destination);
        }

        List<T> destinationList = adjacencylist.get(destination);
        if (destinationList != null) {
            destinationList.remove(source);
        }
    }
    public List<T> getadjacentVertices(T vertex){
        List<T> neighbours = adjacencylist.get(vertex);
        if (neighbours == null) {
            neighbours = new ArrayList<>();
        }
        return neighbours;
    }
    public void display() {
        for (Map.Entry<T , List<T>> entry : adjacencylist.entrySet()) {
            T vertex = entry.getKey();
            List<T> neighbours = entry.getValue();
            System.out.print(vertex + " -> ");
            for (T neighbour : neighbours) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
}