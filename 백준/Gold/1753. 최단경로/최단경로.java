import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static class Node implements Comparable<Node>{
		int num, weight;
		
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		
		//그래프 연결
		List<Node>[] graph = new ArrayList[V+1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w)); //그래프 연결
		}
		
		boolean[] isVisited = new boolean[V+1];
		//큐생성
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(k, 0)); //시작점 넣기
		
		int min = Integer.MAX_VALUE;
		int[] answer = new int[V+1];
		
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(answer, INF); //정답 배열 초기화
		answer[k] = 0;
		
		while(!queue.isEmpty()) { //시작점 꺼내면서 인접 리스트 보기
			
			Node current = queue.poll();//현재 꺼낸점
			if(isVisited[current.num]) continue;
			
			isVisited[current.num] = true; //꺼냈으면 방문 체크 - 끝남 
			
			if(answer[current.num] > current.weight) {
				answer[current.num] = current.weight; //answer에 가중치 저장
			}
			
			//인접한 정점 검색
			for (int i = 0; i < graph[current.num].size(); i++) { // 현재 정점에 인접한 리스트 보기
				Node now = graph[current.num].get(i); //인접 리스트
				queue.offer(new Node(now.num, answer[current.num]+ now.weight));//정점이랑 가중치 넣기
			}
		}
		
		for (int i = 1; i < answer.length; i++) {
			if(answer[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(answer[i]);
		}
		
	}

}
