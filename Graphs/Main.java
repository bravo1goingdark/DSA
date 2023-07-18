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
        System.out.println();


        PrimsAlgorithm graph2 = new PrimsAlgorithm(11);
        graph2.addEdges(10, 1, 5);
        graph2.addEdges(10, 2, 1);
        graph2.addEdges(1, 2, 2);
        graph2.addEdges(1, 3, 3);
        graph2.addEdges(2, 3, 4);
        graph2.addEdges(2, 4, 6);
        graph2.addEdges(3, 4, 7);

        graph2.primsMST(10);
    }
}
