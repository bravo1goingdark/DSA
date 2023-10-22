public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdges(0,1);
        graph.addEdges(0,2);
        graph.addEdges(2,1);
        graph.addEdges(1,3);
        graph.printGraph();
        System.out.println();
        graph.removeEdges(0, 1);
        graph.printGraph();
    }
}
