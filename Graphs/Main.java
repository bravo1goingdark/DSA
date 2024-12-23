import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdges(0,1);
        graph.addEdges(0,2);
        graph.addEdges(0,3);
        graph.addEdges(1,2);
        graph.printGraph();
        System.out.println();
        graph.DFS(0);
        // System.out.println();
        // graph.recur_DFS(0);
        System.out.println();
        graph.BFS(0);
        System.out.println();

        TopologicalSort graphnew = new TopologicalSort(6);
        graphnew.addEdges(5, 2);
        graphnew.addEdges(5, 0);
        graphnew.addEdges(4, 0);
        graphnew.addEdges(4, 1);
        graphnew.addEdges(2, 3);
        graphnew.addEdges(3, 1);

        System.out.println(graphnew.topSort());
    }
}
