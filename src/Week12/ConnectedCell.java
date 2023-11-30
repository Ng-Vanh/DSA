package Week12;

import java.util.Scanner;

public class ConnectedCell {
    static int[][] grid;
    static boolean[][] visited;
    static int N, M;

    public static int[] moveRow = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] moveCol = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
    public static boolean isCorrectPosition(int row, int col){
        return row >=0 && row < N && col >=0 && col < M;
    }
    static int count_connected(int row, int col) {
        int cnt = 1;
        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            int curRow = row + moveRow[i];
            int curCol = col + moveCol[i];

            if (isCorrectPosition(curRow, curCol) && !visited[curRow][curCol] && grid[curRow][curCol] == 1) {
                cnt += count_connected(curRow, curCol);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}
