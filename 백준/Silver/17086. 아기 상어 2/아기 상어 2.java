import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark{
	
	int row;
	int column;
	int cnt;
	
	public Shark(int row, int column, int cnt) {
		this.row = row;
		this.column = column;
		this.cnt = cnt;
	}
	
}
public class Main {

	private static int n;
	private static int m;
	private static int[][] arr;
	static int[][] dist = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, 
								{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};//상하좌우, 대각선
	private static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			 for (int j = 0; j < m; j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 완료
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] == 1) {
					//1 일 경우 이미 안전거리는 0 
					continue;
				}
				//아닐 경우 isVistied 생성해줌, 탐색 하게 함
				isVisited = new boolean[n][m];
				int answer = bfs(i, j, 0);
				max = Math.max(max, answer);
				
			}
			
		}
		System.out.println(max);
		

	}

	private static int bfs(int x, int y, int cnt) {
		Queue<Shark> queue = new ArrayDeque<Shark>();
		queue.offer(new Shark(x, y, cnt)); // 큐에 첫번째 값 저장
		isVisited[x][y] = true;
		int res = 0;
		
		while(! queue.isEmpty()) {//큐가 빌 때 까지
			Shark current = queue.poll();
			res = current.cnt;
			
			for (int i = 0; i < dist.length; i++) {//8가지 방향
				int nr = current.row + dist[i][0];
				int nc = current.column + dist[i][1];
				
				//범위 검사, 이미 방문했던 곳이면 continue
				if(nr < 0 || nr >= n || nc < 0 || nc >= m || isVisited[nr][nc]) {
					continue;
				}
				
				//만약 가서 만날 경우 리턴
				if(arr[nr][nc] == 1) {
					return res + 1;
				}
				
				if(arr[nr][nc] == 0) {// 갈 수 있는 곳일 경우 방문해줌, offer(cnt+1)
					queue.offer(new Shark(nr, nc, res + 1));
					isVisited[nr][nc] = true;
					
				}
				
			}
			
		}
		return res;
		
	}

}
/**
 * 
 * 
4 4
0 0 0 0
0 0 0 0
0 0 0 0
1 0 0 0
 */
