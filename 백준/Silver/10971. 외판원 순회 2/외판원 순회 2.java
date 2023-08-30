import java.io.*;
import java.util.*;

public class Main {
    static int n, min;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }
        System.out.println(min);

    }
    
    private static void dfs(int start, int now ,int result, int depth){
        if(depth == n - 1){
            if(map[now][start] != 0){
                result += map[now][start];
                min = Math.min(min, result);
            }
            return;
        }

        for (int i = 1; i <= n; i++){
            if(!visited[i] && map[now][i] != 0){
                visited[i] = true;
                dfs(start, i, result + map[now][i], depth+1);
                visited[i] = false;
            }
        }
    }
}
