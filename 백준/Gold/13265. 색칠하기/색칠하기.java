import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 색칠하기
 *
 */
public class Main {
	
	static class Location{
		int num;
		char color;
		
		public Location(int num, char color) {
			this.num = num;
			this.color = color;
		}
		
	}

	static List<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	private static int n;
	private static int m;
	private static char[] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 동그라미 개수
			m = Integer.parseInt(st.nextToken()); // 직선들의 개수
			graph = new ArrayList[n+1]; //동그라미는 1부터 시작함
            
			for (int j = 0; j < graph.length; j++) {
				graph[j] = new ArrayList<Integer>();
			}
			
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 동그라미 x
				int y = Integer.parseInt(st.nextToken()); // 동그라미 y
				
				graph[x].add(y); //동그라미들이 서로 연결되어 있다.
				graph[y].add(x);
			} //입력 끝
			
			isVisited = new char[n+1]; 
			Arrays.fill(isVisited, 'X');
			boolean flag = true;
			out: for (int j = 1; j < n+1; j++) {
				if(isVisited[j] == 'X') {
					flag = bfs(j);
					if(!flag) {
						sb.append("impossible").append("\n");
						break out;
					} 
						
				}
			}
			if(flag) {
				sb.append("possible").append("\n");
			}
		}//end tc
		
		System.out.println(sb.toString());
	}//end main

	private static boolean bfs(int start) {
		
		Queue<Location> queue = new ArrayDeque<Location>();
		queue.offer(new Location(start, 'R')); //시작점
		isVisited[start] = 'R';
		
		while(!queue.isEmpty()) {
			Location current = queue.poll(); //선택된 정점
			
			for (int j = 0; j < graph[current.num].size(); j++) {
				int next_num = graph[current.num].get(j);
				char next_color = isVisited[next_num];
	
				//구현 해야 할 곳 - next_color 에서 current.color 랑 같으면 impossible
				//아무것도 안써있으면 current.color 랑 다른거 넣어놓고 다음 큐 넣기
				if(current.color == next_color) {
					return false;
				}else if(next_color == 'X') {
					if(current.color == 'R') {
						isVisited[next_num] = 'B';
						queue.offer(new Location(next_num, 'B'));
					}else {
						isVisited[next_num] = 'R';
						queue.offer(new Location(next_num, 'R'));
					}
					
				}
				
			}
			
		}
		return true;
	}

}//end class
