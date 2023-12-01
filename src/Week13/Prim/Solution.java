package Week13.Prim;

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

class Cost implements Comparable<Cost> {
    public int weight, vertex;

    public Cost(int cost, int vertex) {
        this.weight = cost;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Cost c) {
        if (weight != c.weight) {
            return Integer.compare(weight, c.weight);
        }
        return Integer.compare(vertex, c.vertex);
    }

}

class Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Write your code here
        int res = 0;
        List<List<Cost>> adj = new ArrayList<List<Cost>>(n+1);
        boolean visited[] = new boolean[n+1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Cost>());
        }
        for(int i = 0; i< edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);
            adj.get(u).add(new Cost(w, v));
            adj.get(v).add(new Cost(w, u));
        }
        PriorityQueue<Cost> minQ = new PriorityQueue<Cost>();
        minQ.add(new Cost(0,start));
        while (!minQ.isEmpty()) {
            Cost tmp = minQ.poll();
            if(visited[tmp.vertex]){
                continue;
            }else{
                visited[tmp.vertex] = true;
                res += tmp.weight;
                for(Cost c: adj.get(tmp.vertex)){
                    if(!visited[c.vertex]){
                        minQ.add(c);
                    }
                }
            }

        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
