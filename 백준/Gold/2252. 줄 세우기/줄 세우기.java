import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); //키를 비교한 회수
		
		List<Integer>[] list = new ArrayList[n+1]; 
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int[] isEdge = new int[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b); //그래프 저장
			isEdge[b] += 1; //간선 수 저장
			
		}
		//위상정렬 시작
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		for(int i = 1; i <= n; i++) {
			if(isEdge[i] == 0) { //0일경우 큐에 넣기
				queue.offer(i);//0인값 큐에 넣기
			}
		}
		
		while(!queue.isEmpty()) {
			int current = queue.poll(); //0인 정점과 연결된 것 찾기
			sb.append(current).append(" ");
			
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i); // 인접 정점
				isEdge[next] -= 1;
				
				if(isEdge[next] == 0) { //뺀 값 0 이 되면 offer
					queue.offer(next);
				}
				
			}
			
		}
		
		System.out.println(sb.toString());
		
	}

}
