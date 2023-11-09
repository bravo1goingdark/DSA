

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
    }
}
