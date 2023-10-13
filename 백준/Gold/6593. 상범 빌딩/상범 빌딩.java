import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Location {
		int l;
		int r;
		int c;
		int cnt;
		
		public Location(int l, int r, int c, int cnt) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Location [l=" + l + ", r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
	}
	static int[][] dist = {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, -1}, {0, 0, 1}}; //동서남북상하 -> <- 
	static int answer;
	private static char[][][] map;
	private static int l;
	private static int r;
	private static int c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			//입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			l = Integer.parseInt(st.nextToken()); //빌딩의 층수
			r = Integer.parseInt(st.nextToken()); //한층 행
			c = Integer.parseInt(st.nextToken());//한층 열
			
			if(l == 0 && r == 0 && c == 0)
				break;
			
			answer = Integer.MAX_VALUE; //초기화
			map = new char[l][r][c];
			int sk = 0;
			int si = 0;
			int sj = 0;
			for (int k = 0; k < l; k++) { //층
				for (int i = 0; i < r; i++) { //행
					String input = br.readLine();
					for (int j = 0; j < c; j++) { //열
						map[k][i][j] = input.charAt(j);
						if(map[k][i][j] == 'S') { //시작점 만나면 bfs
							sk = k;
							si = i;
							sj = j;
						}
					}
				}
				br.readLine();
			}
			
			bfs(sk, si, sj); 

			//탈출 불가능이라면
			if(answer == Integer.MAX_VALUE) {
				sb.append("Trapped!").append("\n");
			}else {
				//탈출 가능하다면
				sb.append("Escaped in ").append(answer).append(" minute(s).").append("\n");
			}
			
			
		}//입력 끝
		System.out.println(sb.toString());
	}//main 끝
	
	public static void bfs(int k, int i, int j) { //층, 행, 열
		Queue<Location> queue = new ArrayDeque<Location>();
		queue.offer(new Location(k, i, j, 0));
		map[k][i][j] = 'V'; //방문처리
		
		while(!queue.isEmpty()) {
			Location current = queue.poll();
//			map[current.l][current.r][current.c] = 'V'; //방문처리
					
			for (int d = 0; d < dist.length; d++) {
				int nx = current.r + dist[d][0];
				int ny = current.c + dist[d][1];
				int nl = current.l + dist[d][2];
				
				//범위, 방문 체크
				if(nl < 0 || nl >= l || nx < 0 || nx >= r || ny < 0 || ny >= c || map[nl][nx][ny] == 'V') {
					continue;
				}
				
				//출구 e
				if(map[nl][nx][ny] == 'E') {
					answer = current.cnt + 1;
					return;
				}
				
				//지나갈 수 없는 칸 #
				if(map[nl][nx][ny] == '#') {
					map[nl][nx][ny] = 'V';
					continue;
				}
				//비어있는 칸 . : 동서남북상하 가능
				//층끼리 . 이면 층 이동 가능
				if(map[nl][nx][ny] == '.') {
					queue.offer(new Location(nl, nx, ny, current.cnt+1));
					map[nl][nx][ny] = 'V';
				}
			}
			
		} //큐 끝
		
	}//end bfs
	
}//class 끝

