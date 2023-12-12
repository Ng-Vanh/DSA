package Week13;

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


public class test {
    public static FastReader fr = new FastReader();


    private static void dijkstra(int n, int m, long[][] weight, int start) {
        for (long[] row : weight)
            Arrays.fill(row, 1000000L);

        for (int i = 0; i < m; i++) {
            int x = fr.nextInt() - 1;
            int y = fr.nextInt() - 1;
            long cmp = fr.nextLong();
            if (weight[x][y] > cmp) {
                weight[x][y] = cmp;
                weight[y][x] = cmp;
            }
        }

        Stack<Integer> t = new Stack<>();
        for (int i = 1; i <= n; i++) {
            if (i != start) {
                t.push(i);
            }
        }

        Stack<Integer> p = new Stack<>();
        p.push(start);
        weight[start][start] = 0;

        while (!t.isEmpty()) {
            int min = 989997979;
            int loc = -1;

            for (int i = 0; i < t.size(); i++) {
                weight[start][t.elementAt(i)] = Math.min(weight[start][t.elementAt(i)], weight[start][p.peek()] + weight[p.peek()][t.elementAt(i)]);
                if (weight[start][t.elementAt(i)] <= min) {
                    min = (int) weight[start][t.elementAt(i)];
                    loc = i;
                }
            }

            p.push(t.elementAt(loc));
            t.removeElementAt(loc);
        }

        for (int i = 1; i <= n; i++) {
            if (i != start && weight[start][i] != 1000000L) {
                System.out.print(weight[start][i] + " ");
            } else if (i != start) {
                System.out.print("-1" + " ");
            }
        }
        System.out.println();
    }


    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            if (st == null || !st.hasMoreElements ()) {
                do {
                    try {
                        st = new StringTokenizer (br.readLine ());
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                } while (st == null || !st.hasMoreElements ());
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        int query = fr.nextInt();
        for (int i = 0; i < query; i++) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            long[][] w = new long[n + 1][n + 1];
            dijkstra(n, m, w, fr.nextInt());
        }
    }
}
