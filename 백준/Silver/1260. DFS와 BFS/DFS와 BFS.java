import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {//그래프 그리기.
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		//번호가 작은것 부터 먼저 방문
		for(int i=1; i<=n; i++) {
			Collections.sort(A[i]);
		}
		
		visited = new boolean[n+1];
		DFS(start);
		System.out.println();
		visited = new boolean[n+1];
		BFS(start);
		System.out.println();
	}


	private static void DFS(int Node) {
		System.out.print(Node + " ");
		visited[Node] = true;//true로 바꾸고
		for(int i: A[Node]) {
			if(!visited[i])//방문하지 않았으면 실행
				DFS(i);
		}
	}
	
	private static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node] = true;
		
		while(!queue.isEmpty()) {
			int now_Node = queue.poll();//젤 먼저들어간것 빼기
			System.out.print(now_Node + " ");
			for(int i: A[now_Node]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
	}

}
