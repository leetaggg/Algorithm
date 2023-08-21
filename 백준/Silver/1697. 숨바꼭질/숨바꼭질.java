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
		int k = Integer.parseInt(st.nextToken());
		
		int[] dist = {-1, 1, 2}; //좌우, 점프
		boolean[] isVisited = new boolean[100_001];
		
		Queue<int[]> queue = new ArrayDeque<>(); 
		queue.offer(new int[] {n, 0}); // 시작점 넣기, 시간
		int min = Integer.MAX_VALUE;
		int[] current;
		
		while(!queue.isEmpty()) {
			current = queue.poll();
			isVisited[current[0]] = true;
			
			int next;
			if(current[0] == k) {
				min = Math.min(min, current[1]);
				break;
			}
			
			for (int i = 0; i < dist.length; i++) {
				if(i == 2) {
					next = current[0]*dist[i];
				}else {
					next = current[0] + dist[i];
				} //다음값
				
				//범위체크
				if(next < 0 || next > 100_000 || isVisited[next]) {
					continue;
				}
				
				isVisited[next] = true;
				queue.offer(new int[] {next, current[1]+1});
				
			}
		}
		System.out.println(min);
		
	}

}
