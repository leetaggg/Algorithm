import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Location implements Comparable<Location>{
		int r;
		int c;
		int value;
		public Location(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}
		public int compareTo(Location o) {
			return o.value - this.value;
		}
		@Override
		public String toString() {
			return "Location [r=" + r + ", c=" + c + ", value=" + value + "]";
		}
		
	}
	
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
	private static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][m+1];
		int si = 0;
		int sj = 0; //처음 시작할 점
		
		Queue<Location> queue = new PriorityQueue<Location>();
		isVisited = new boolean[n+1][m+1];
		
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < m+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == 1 || j == 1 || i == n || j == m) {
					queue.offer(new Location(i, j, map[i][j]));
					isVisited[i][j] = true;
				} //우선순위 큐에 넣기
			}
		} //옥수수 가중치 입력 끝
		
		int k = Integer.parseInt(br.readLine()); //반복할 횟수
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			if(cnt == k) {
				break;
			} //종료 조건
			Location current = queue.poll();
			sb.append(current.r).append(" ").append(current.c).append("\n");
			cnt++;
			
			for (int i = 0; i < dist.length; i++) {
				int nr = current.r + dist[i][0];
				int nc = current.c + dist[i][1];
				
				//범위체크
				if(nr < 1 || nr >= n || nc < 1 || nc >= m || isVisited[nr][nc]) {
					continue;
				}
				int nvalue = map[nr][nc];
				queue.offer(new Location(nr, nc, nvalue));
				isVisited[nr][nc] = true;
			}
			
		}
		
		System.out.println(sb.toString());
	}//end main

}//end class
