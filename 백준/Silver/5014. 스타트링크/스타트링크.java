import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] dUD = new int[2];
	static boolean[] visited;
	static int F, S, G, U, D;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		if(S == G) {
			System.out.println(0);
			return;
		}
		arr = new int[F + 1];
		visited = new boolean[F + 1];
		dUD[0] = U;
		dUD[1] = -D;
		bfs();
		System.out.println(arr[G] == 0 ? "use the stairs" : arr[G]);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(S);
		visited[S] = true;
		while(!q.isEmpty()) {
			int dir = q.poll();
			for(int nextDir : dUD) {
				int nUD = dir + nextDir;
				if(1 <= nUD && nUD <=F && !visited[nUD]) {
					arr[nUD] = arr[dir] + 1;
					visited[nUD] = true;
					q.add(nUD);
				}
			}
		}
	}
}