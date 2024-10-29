import java.io.*;
import java.util.*;

public class Main {

    static int n, min;
    static int[][] stats;
    static boolean[] visited;

    
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        stats = new int[n][n];
        visited = new boolean[n];
        min = Integer.MAX_VALUE;
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(0, 0);
        System.out.println(min);
    }

    public static void combi(int start, int depth) {
        if(depth == n / 2) {
            min = Math.min(min, count());
            return;
        }

        for (int i = start; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int count() {

        int start = 0;
        int link = 0;

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i] && visited[j]) {
                    start += stats[i][j];
                } else if(!visited[i] && !visited[j]) {
                    link += stats[i][j];
                }
            }
        }

        return Math.abs(start - link);
    }
}