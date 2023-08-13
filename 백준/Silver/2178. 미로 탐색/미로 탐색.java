import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] map;
	static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			char[] line = br.readLine().toCharArray(); 
			for(int j = 0; j < m; j++) {
				map[i][j] =  line[j] == '1' ? true : false;
			}
		}
		System.out.println(bfs());
	}
	public static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0, 0, 1});
		map[0][0] = false;
		while(!q.isEmpty()) {
			int[] cXY = q.poll();
			int cX = cXY[0];
			int cY = cXY[1];
			int cCnt = cXY[2];
			for(int dr[] : dirs) {
				int dx = cX + dr[0];
				int dy = cY + dr[1];
				if(0 <= dx && dx < n && 0 <= dy && dy < m && map[dx][dy]) {
					if(dx == n - 1 && dy == m - 1) {
						return cCnt + 1;
					}
					q.add(new int[] {dx, dy, cCnt + 1});
					map[dx][dy] = false;
				}
			}
		}
		return -1;
	}
}
