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
    static boolean[] checked;
    static List<List<Long>> cities;

    public static long roadsAndLibraries(long n, long c_lib, long c_road, List<List<Long>> c) {
        cities = new ArrayList<>();
        // Write your code here
        checked = new boolean[9999999];
        for (int i = 0; i < n; i++) {
            cities.add(new ArrayList<>( i));
        }
        for (List<Long> e : c) {
            cities.get(Math.toIntExact(e.get(0))).add(e.get(1) );
            cities.get(Math.toIntExact(e.get(1))).add(e.get(0) );

        }
        for (long i = 0; i < n; i++) {
            checked[(int) i] = false;
        }

        List<Integer> lib = new ArrayList<>();
        long count=0;
        for (long i = 0; i < n; i++){
            if(!checked[(int) i]){
                int ans=Dfs((int) i);
                lib.add(ans);
                count+=ans-1;
            }
        }
        return Math.min(count*c_road+c_lib*lib.size(),c_lib*n);
    }
    public static int Dfs(int u){
        checked[u] = true;
        int result =1;
        for (int i=0;i<cities.get(u).size();i++){
            if(!checked[Math.toIntExact(cities.get(u).get(i))]){
                result+=Dfs(Math.toIntExact(cities.get(u).get(i)));
            }
        }
        return result;
    }


}

public class test {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        for(int i = 0; i < q; i++){
            List<List<Long>> adj = new ArrayList<>();
            long n = input.nextLong();
            long m = input.nextLong();
            long c_lib = input.nextLong();
            long c_road = input.nextLong();

            for(int j = 0; j < m; j++){
                long v = input.nextInt();
                long w = input.nextInt();
                List<Long> tmp=new ArrayList<>();
                tmp.add(v-1);
                tmp.add(w-1);
                adj.add(tmp);
            }

            long result = Result.roadsAndLibraries(n, c_lib, c_road, adj);
            System.out.println(result);

        }
    }
}