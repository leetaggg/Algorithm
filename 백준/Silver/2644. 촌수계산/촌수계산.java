import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[] visited;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		visited = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		bfs(start, end);
		if(visited[end] == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(visited[end]);
		}
	}
	
	public static void bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int v = queue.poll();
			if(v == end) {
				return;
			}
			for(int i = 1; i <= n; i++) {
				if(arr[v][i] == 1 && visited[i] == 0) {
					queue.add(i);
					visited[i] = visited[v] + 1;
				}
			}
		}
	}

}
