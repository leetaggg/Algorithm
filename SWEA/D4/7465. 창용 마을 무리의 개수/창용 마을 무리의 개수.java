import java.io.*;
import java.util.*;

public class Solution {

	private static boolean[] visited;
	private static int n;
	private static int m;
	static List<Integer>[] town;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= t; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());//창용마을에 사는 사람의 수
			m = Integer.parseInt(st.nextToken());//서로를 알고 있는 사람의 관계 수
			visited = new boolean[n+1]; // 방문 배열
			int answer = 0;
			town = new ArrayList[n+1];
			
			for (int i = 0; i < n+1; i++) {
				town[i] = new ArrayList<Integer>();
			}// 초기화
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				town[a].add(b);
				town[b].add(a);
			} // 입력 끝
			
			//시작점은 1 부터
			for (int i = 1; i <= n; i++) { //1번 부터 n번까지
				if(!visited[i]) {
					bfs(i);
					answer++;
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}// end testCase
		System.out.println(sb.toString());
	}//end main

	private static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for (int i = 0; i < town[current].size(); i++) {
				int target = town[current].get(i);
				if(!visited[target]) {
					queue.offer(target);
					visited[target] = true;
				}
			}
		}
		
	}

}//end class
