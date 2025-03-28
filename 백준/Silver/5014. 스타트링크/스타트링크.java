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
		StringBuilder sb = new StringBuilder();
		
		int F = Integer.parseInt(st.nextToken());//총 수
		int S = Integer.parseInt(st.nextToken());//시작점
		int G = Integer.parseInt(st.nextToken());//도착점
		int U = Integer.parseInt(st.nextToken());//위
		int D = Integer.parseInt(st.nextToken());//아래
		
		int answer = -1;
		int index = 0;
		int[] floor = {U, -D}; //업,다운
		Queue<int[]> queue = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[F+1];
		//시작점 넣기
		queue.offer(new int[] {S, index}); //지점, 몇번 갔는지 카운트
		
		while(! queue.isEmpty()) {
			int[] current = queue.poll();
			index = current[1];
			
			
			if(current[0] == G) {
				answer = current[1];
				break;
			}
			
			int next_up = current[0]+floor[0];
			int next_dw = current[0]+floor[1];
			
			if(next_up <= F && next_up > 0 && !visited[next_up]) { //다음층이 도착점보다 작거나 같을경우
				//큐에 넣기
				queue.offer(new int[] {next_up, index+1});
				visited[next_up] = true;
			
			}
			if(next_dw <= F && next_dw > 0 && !visited[next_dw]) { //다음층이 도착점보다 작거나 같을경우
				//큐에 넣기
				queue.offer(new int[] {next_dw, index+1});
				visited[next_dw] = true;
			
			}
		}//end while
		
		if(answer == -1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(index);
		}
		
	}

}
