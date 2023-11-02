import java.io.*;
import java.util.*;

public class Main {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        int n = read();
        int m = read();

        int[][] map = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(arr -> arr[2])));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read();
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    pq.offer(new int[]{i, j, map[i][j]});
                    map[i][j] = -1;
                }
            }
        }

        int k = read();

        bfs(pq, map, n, m, k);
    }

    static void bfs(PriorityQueue<int[]> pq, int[][] map, int n, int m, int k) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            cnt++;
            sb.append(node[0] + 1).append(" ").append(node[1] + 1).append("\n");
            if (cnt == k) break;
            for (int i = 0; i < 4; i++) {
                int nr = node[0] + dr[i];
                int nc = node[1] + dc[i];
                if (0 <= nr && nr < n && 0 <= nc && nc < m && map[nr][nc] != -1) {
                    pq.offer(new int[]{nr, nc, map[nr][nc]});
                    map[nr][nc] = -1;
                }
            }
        }
        System.out.println(sb);
    }
    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}