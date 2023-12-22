import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n, m;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j] - 48;
            }
        }

        for (int i = 0; i < m; i++) {
            if(map[0][i] == 0){
                bfs(new int[] {0, i});
            }
        }

        boolean flag = false;

        for (int i = 0; i < m; i++) {
            if(map[n - 1][i] == -1){
                flag = true;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
    static void bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        map[start[0]][start[1]] = -1;
        while(!q.isEmpty()){
            int[] node = q.poll();
            for (int[] dir : dirs) {
                int dx = node[0] + dir[0];
                int dy = node[1] + dir[1];
                if(0 <= dx && dx < n && 0 <= dy && dy < m && map[dx][dy] == 0){
                    map[dx][dy] = -1;
                    q.add(new int[] {dx, dy});
                }
            }
        }
    }
}