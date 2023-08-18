import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int node, line, start;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		map = new int[node+1][node+1];
		visit = new boolean[node+1];
		
		for(int i = 0; i < line; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
			
		}
		dfs(start);
		bw.write("\n");
		bw.flush();
		visit = new boolean[node+1];
		bfs(start);
		bw.flush();
		
	}
	public static void dfs(int st) throws IOException {
		visit[st] = true;
		bw.write(Integer.toString(st) + " ");
		for(int i = 1; i<node+1; i++) {
			if(map[st][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
	public static void bfs(int st) throws IOException{
		visit[st] = true;
		q.offer(st);
		while(!q.isEmpty()) {
			st = q.poll();
			bw.write(Integer.toString(st) + " ");
			
			for (int i = 1; i < node+1; i++) {
				if(map[st][i] == 1 && !visit[i]) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}