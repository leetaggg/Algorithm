import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] == 1){
                        bfs(i, j);
                        result++;
                    }
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        map[x][y] = 0;
        while (!q.isEmpty()){
            int[] node = q.poll();
            int cr = node[0];
            int cc = node[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(0 <= nr && nr < n && 0 <= nc && nc < m && map[nr][nc] == 1){
                    map[nr][nc] = 0;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
