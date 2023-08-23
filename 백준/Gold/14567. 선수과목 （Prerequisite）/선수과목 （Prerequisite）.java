import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] adjMatrix = new int[n+1][n+1];
        int[] in_ver = new int[n+1];
        int[] result = new int[n+1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjMatrix[a][b] = adjMatrix[b][a] = 1; //a,b 친구
            in_ver[b]++; //진입 차수 올리기
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            if(in_ver[i] == 0) {//진입 차수가 0이면 큐에 넣기
                queue.offer(i); //시작
                result[i] = 1;
            }
        }
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
//            System.out.println("c: "+current);
            for (int i = 1; i <= n; i++) {
                if(adjMatrix[current][i] > 0) {
                	in_ver[i]--;
                	
                	if(in_ver[i] == 0) {
                		queue.offer(i);
                		result[i] = result[current] + 1;
                	}//진입차수가 0이면 큐에 넣기
                }
            }
            
        }//while 끝
        
        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] +" ");
        }
    }

}
