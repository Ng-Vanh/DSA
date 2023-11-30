package Week12;

import java.util.*;

public class ShortestReach {
    static class Graph {
        private int V;
        private List<Integer>[] adj;

        public Graph(int v) {
            V = v;
            adj = new ArrayList[V];
            for (int i = 0; i < V; ++i) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        public int[] shortestReach(int start) {
            int[] distances = new int[V];
            Arrays.fill(distances, -1);

            distances[start] = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();

                for (int neighbor : adj[currentVertex]) {
                    if (distances[neighbor] == -1) {
                        distances[neighbor] = distances[currentVertex] + 6;
                        queue.add(neighbor);
                    }
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();

            Graph graph = new Graph(nodes);

            for (int i = 0; i < edges; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                graph.addEdge(u, v);
            }

            int start = scanner.nextInt() - 1;

            int[] result = graph.shortestReach(start);

            for (int i = 0; i < result.length; i++) {
                if (i != start) {
                    System.out.print(result[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
