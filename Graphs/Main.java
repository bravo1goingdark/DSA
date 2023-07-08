import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdges(1, 4);
        graph.addEdges(1, 2);
        graph.addEdges(4, 3);
        graph.addEdges(2, 3);
        graph.addEdges(2, 5);
        graph.addEdges(2, 8);
        graph.addEdges(5, 8);
        graph.addEdges(5, 7);
        graph.addEdges(7, 8);
        graph.addEdges(5, 6);
        graph.addEdges(2, 7);
        graph.display();
        System.out.println();

        graph.bfs(1);
        System.out.println();
        graph.dfs(1);
        System.out.println();
        System.out.println();
        
        graph.removeEdges(1, 4);
        graph.display();
        System.out.println();
        List<Integer> list = graph.getadjacentVertices(1);
        System.out.println(list);
    }
}
