import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int r = 0, c = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 2){
                    r = i;
                    c = j;
                }else if(num == 1){
                    map[i][j] = -1;
                }else{
                    map[i][j] = num;
                }
            }
        }

        bfs(r, c);
    }

    static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r ,c});
        while(!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : dirs) {
                int dr = node[0] + dir[0];
                int dc = node[1] + dir[1];
                if (0 <= dr && dr < n && 0 <= dc && dc < m && map[dr][dc] == -1) {
                    map[dr][dc] = map[node[0]][node[1]] + 1;
                    q.offer(new int[]{dr, dc});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
