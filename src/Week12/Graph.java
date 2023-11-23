package Week12;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int V;
    private ArrayList<Integer>[] adj;
    private boolean[] visited;

    public Graph(int v) {
        V = v;
        visited = new boolean[V];
        adj = new ArrayList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new ArrayList<>();
            visited[i] = false;
        }
    }
    public void addEdge(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    public int degree(int v){
        int result = 0;
        for(int x: adj[v]){
            result ++;
        }
        return result;
    }
    public void DFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFS(neighbor);
            }
        }
    }
    public void BFS(int v) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adj[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public int countComponents(){
        int componentsCount = 0;

        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                DFS(i);
                componentsCount++;
            }
        }

        return componentsCount;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(1,4);
        graph.addEdge(4,2);
        graph.addEdge(4,5);
        graph.addEdge(2,3);
        graph.BFS(0);
        System.out.println();
        int x = graph.countComponents();
        System.out.println(x);
    }

}
