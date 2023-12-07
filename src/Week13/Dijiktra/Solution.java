package Week13.Dijiktra;
import java.util.*;

public class Solution {
    static class DGraph {
        private static int V = 0;
        private static List<List<Node>> adj = new ArrayList<List<Node>>();

        public DGraph(int V) {
            this.V = V;

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adj.get(u).add(new Node(v, weight));
            adj.get(v ).add(new Node(u, weight));
        }

        public static int[] dijkstra(int start) {
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                int u = pq.poll().vertex;

                for (Node neighbor : adj.get(u)) {
                    int v = neighbor.vertex;
                    int weight = neighbor.distance;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }

            return dist;
        }

        static class Node {
            private final int vertex;
            private final int distance;

            public Node(int vertex, int distance) {
                this.vertex = vertex;
                this.distance = distance;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int query = scanner.nextInt();
        while(query -->0){
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            DGraph dGraph = new DGraph(nodes);

            for (int i = 0; i < edges; i++) {
                int u = scanner.nextInt() -1;
                int v = scanner.nextInt() -1;
                int w = scanner.nextInt();
                dGraph.addEdge(u, v, w);
            }
            int startNode = scanner.nextInt() - 1;
            int[] distances = DGraph.dijkstra(startNode);
            for (int i = 0; i < nodes; i++) {
                if(i != startNode) {
                    if(distances[i] == Integer.MAX_VALUE){
                        System.out.print(-1 + " ");
                    }else{
                        System.out.print(distances[i] + " ");
                    }
                }
            }
        }
    }
}
