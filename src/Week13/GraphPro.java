package Week13;

import java.util.ArrayList;
import java.util.List;

public class GraphPro {
    class Edge {
        int vertexTo;
        int weight;

        public Edge(int vertexTo, int weight) {
            this.vertexTo = vertexTo;
            this.weight = weight;
        }
    }

    private int V;
    private List<List<Edge>> adj;

    public GraphPro(int vertices) {
        V = vertices;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int fromVertex, int toVertex, int weight) {
        adj.get(fromVertex).add(new Edge(toVertex, weight));
        adj.get(toVertex).add(new Edge(fromVertex, weight));
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            List<Edge> neighbors = adj.get(i);
            for (Edge edge : neighbors) {
                System.out.print("(" + edge.vertexTo + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }
    public static int F(int n){
        if(n == 0) return 1;
        if(n%2 == 0){
            return F(n/2) * F (n/2);
        }else if(n%2 == 1){
            return 2* F((n-1)/2) * F((n-1)/2);
        }
        return 1;
    }

    public static void main(String[] args) {
//        GraphPro graph = new GraphPro(5);
//
//        graph.addEdge(0, 1, 2);
//        graph.addEdge(0, 2, 4);
//        graph.addEdge(1, 2, 1);
//        graph.addEdge(1, 3, 7);
//        graph.addEdge(2, 4, 3);
//
//        graph.printGraph();
        System.out.println(F(10));
    }
}
