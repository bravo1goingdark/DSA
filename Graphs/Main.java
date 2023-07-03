import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdges(0, 1);
        graph.addEdges(1, 3);
        graph.addEdges(0, 4);
        graph.addEdges(4, 1);
        graph.display();
        System.out.println();
        graph.removeEdges(1, 4);
        graph.display();
        System.out.println();
        List<Integer> list = graph.getadjacentVertices(0);
        System.out.println(list);
    }
}
