import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	private static ArrayList<Integer>[] Sang;
	private static boolean[] isVisited;

	static int cnt;
	
	public static void main(String[] args) throws IOException {
		
		//그래프 시작 정점은 1
		//next.next의 data까지
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		Sang = new ArrayList[n+1] ;
		for (int i = 1; i <= n; i++) {
			Sang[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			Sang[s].add(e);
			Sang[e].add(s);
		}
		
		isVisited = new boolean[n+1];
		isVisited[1] = true;
		dfs(1, 0);

		for (boolean is : isVisited) {
			if(is) {cnt++;}
		}
		System.out.println(cnt-1);
	}

	public static void dfs(int v, int depth) {
		if(depth == 2) {
			return;
		}
		//인접노드 검색

		for (int i : Sang[v]) {
			isVisited[i] = true;
			dfs(i, depth+1);
					
		}
	}
}
