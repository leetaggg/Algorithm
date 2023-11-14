import java.io.*;
import java.util.*;

public class Main {

    static int n, m, result = 0;
    static int[][] walls = new int[3][2];
    static List<int[]> virus = new ArrayList<>(), blank = new ArrayList<>();
    static boolean[][] map;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0){
                    blank.add(new int[] {i, j});
                }else if(num == 1){
                    map[i][j] = true;
                }else{
                    virus.add(new int[] {i, j});
                    map[i][j] = true;
                }
            }
        }
        combination(0, 0);
        System.out.println(result);
    }

    static int bfs(int[][] walls){
        boolean[][] visited = new boolean[n][m];

        for (int[] wall : walls) {
            visited[wall[0]][wall[1]] = true;
        }

        Queue<int[]> q = new LinkedList<>();
        for (int[] virus : virus) {
            q.offer(virus);
        }
        while(!q.isEmpty()){
            int[] node = q.poll();
            for (int[] dir : dirs) {
                int dr = node[0] + dir[0];
                int dc = node[1] + dir[1];

                if(0 <= dr && dr < n && 0 <= dc && dc < m && !map[dr][dc] && !visited[dr][dc]){
                    visited[dr][dc] = true;
                    q.offer(new int[] {dr, dc});
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!map[i][j] && !visited[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void combination(int cnt, int start){
        if(cnt == 3){
            int tmp = bfs(walls);
            if(result < tmp){
                result = tmp;
            }
            return;
        }
        for (int i = start; i < blank.size(); i++) {
            walls[cnt] = blank.get(i);
            combination(cnt + 1, i + 1);
        }
    }
}