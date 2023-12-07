package Week13.RoadLibrary;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */
    static int numberOfEdges = 0;
    static class MGraph{
        private int V;
        private ArrayList<Integer>[] adj;
        private boolean[] visited;

        public MGraph(int v) {
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
        public void DFS(int v) {
            visited[v] = true;

            for (int neighbor : adj[v]) {
                if (!visited[neighbor]) {
                    numberOfEdges++;
                    DFS(neighbor);
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
    }

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // Write your code here
        MGraph myGraph = new MGraph(n);

        for(List<Integer> city: cities) {
            myGraph.addEdge(city.get(0) -1, city.get(1)-1);
        }
        int componentsCount = 0;
        long res = 0;

        for (int i = 0; i < n; ++i) {
            if (!myGraph.visited[i]) {
                myGraph.DFS(i);

                res += Math.min((numberOfEdges + 1) * c_lib , numberOfEdges * c_road + c_lib);
                numberOfEdges = 0;
                componentsCount++;
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
