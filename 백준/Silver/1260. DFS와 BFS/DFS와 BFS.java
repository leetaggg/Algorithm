import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;
	static int n, m;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		graph = new int[n + 1][n + 1];		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			graph[to][from] = graph[from][to] = 1;
		}
		visited = new boolean[n + 1];
		sb.append(v).append(" ");
		visited[v] = true;
		dfs(v);
		sb.append("\n");
		visited = new boolean[n + 1];
		bfs(v);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int start) {
		for(int i = 1; i <= n; i++) {
			if(graph[start][i] == 1 && !visited[i]) {
				sb.append(i).append(" ");
				visited[i] = true;
				dfs(i);
			}
		}
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		sb.append(start).append(" ");
		while(!q.isEmpty()){
			int current = q.poll();
			for(int i = 1; i <= n; i++) {
				if(graph[current][i] == 1 && !visited[i]) {
					visited[i] = true;
					sb.append(i).append(" ");
					q.add(i);
				}
			}
		}
	}
}
