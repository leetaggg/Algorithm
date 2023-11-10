import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, b));
    }

    static int bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a, 1});
        boolean[] visited = new boolean[b + 1];
        visited[a] = true;
        while(!q.isEmpty()){
            int[] node = q.poll();
            int n = node[0];
            int cnt = node[1];

            if(n == b) return cnt;

            if((long) n * 2 <= b && !visited[n * 2]){
                visited[n * 2] = true;
                q.offer(new int[] {n * 2, cnt + 1});
            }
            if((long) n * 10 + 1 <= b && !visited[n * 10 + 1]){
                visited[n * 10 + 1] = true;
                q.offer(new int[] {n * 10 + 1, cnt + 1});
            }
        }
        return -1;
    }
}