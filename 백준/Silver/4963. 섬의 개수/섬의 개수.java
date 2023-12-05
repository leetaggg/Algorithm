import java.io.*;
import java.util.*;

public class Main {
    static int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            boolean[][] map = new boolean[n][m];
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    String y = st.nextToken();
                    if (y.equals("1")){
                        map[i][j] = true;
                    }
                }
            }

            sb.append(search(map, n, m)).append("\n");
        }
        System.out.println(sb);
    }

    static int search(boolean[][] map, int n, int m){
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]){
                    bfs(map, n, m, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    static void bfs(boolean[][] map, int n, int m, int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        while(!q.isEmpty()){
            int[] node = q.poll();
            for (int[] dir : dirs) {
                int dr = dir[0] + node[0];
                int dc = dir[1] + node[1];
                if(0 <= dr && dr < n && 0 <= dc && dc < m && map[dr][dc]){
                    map[dr][dc] = false;
                    q.add(new int[] {dr, dc});
                }
            }
        }
    }
}
