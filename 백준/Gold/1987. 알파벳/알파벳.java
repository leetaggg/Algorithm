import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[] visited;
    static int r, c, result;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < c; j++){
                map[i][j] = line[j];
            }
        }
        result = 0;
        visited = new boolean[26];
        visited[map[0][0] - 65] = true;
        dfs(0, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int count) {
        for (int[] dr: dir) {
            int dx = x + dr[0];
            int dy = y + dr[1];
            if (0 <= dx && dx < r && 0 <= dy && dy < c) {
                if(visited[map[dx][dy] - 65] ){
                    result = Math.max(result, count);
                }else{
                    visited[map[dx][dy] - 65] = true;
                    dfs(dx, dy, count + 1);
                    visited[map[dx][dy] - 65] = false;
                }
            }
        }
    }
}
