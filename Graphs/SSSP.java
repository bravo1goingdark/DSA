// Single Source Shortest Path (SSSP) algorithm using Topological Sort

import java.util.ArrayList;
import java.util.List;

public class SSSP {
    public static List<Integer> dagShortestPath(List<List<Integer>> adjacencyList , int startNode , int numVertices){
        List<Integer> topSort = new TopologicalSort(numVertices).topSort();
        List<Integer> distance = new ArrayList<>(numVertices);
        distance.add(0, 0);
        for (int i = 0; i < numVertices; i++) {
            Integer nodeIndex = topSort.get(i);
            if (distance.get(nodeIndex) != null) {
                List<Integer> adjacentEdges = adjacencyList.get(nodeIndex);
                if (adjacentEdges != null) {
                    for (Integer edge : adjacentEdges) {
                        Integer newDistance = distance.get(nodeIndex) + edge;
                        if (distance.get(edge)) {
                            
                        }
                    }
                }
            }
        }

    }
}
