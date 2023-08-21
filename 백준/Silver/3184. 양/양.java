import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static char[][] map;
	private static boolean[][] isVisited;
	private static int[][] dist = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	private static int r;
	private static int c;

	// 답이 될 변수
	static int a_sheep = 0;
	static int a_fox = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0, index = 0; j < c; j++, index += 1) {
				map[i][j] = s.charAt(index);
			}
		} // 입력 완료

		isVisited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'v' || map[i][j] == 'o') {
					if(!isVisited[i][j])
						bfs(i, j);
				}

			}

		} // for 끝
		System.out.println(a_sheep + " " + a_fox);
	}

	private static void bfs(int a, int b) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] { a, b });// 큐에 첫값 넣기
		isVisited[a][b] = true;// 방문체크

		int sheep = 0;
		int fox = 0;

		if (map[a][b] == 'v')
			fox++;
		else if (map[a][b] == 'o')
			sheep++;

		while (!queue.isEmpty()) {// 큐가 빌때까지 인접 노드 탐색
			int[] current = queue.poll(); // 현재값 빼기(양값, 늑대값, 좌표있음)
			int x = current[0];
			int y = current[1];

			for (int i = 0; i < dist.length; i++) { // 4방향 탐색
				int nx = x + dist[i][0];
				int ny = y + dist[i][1];

				// 범위 체크
				if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != '#' && !isVisited[nx][ny]) {
					if (map[nx][ny] == 'o') {
						sheep++;
					} else if (map[nx][ny] == 'v') {
						fox++;
					}
					isVisited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}

			}

		}
		if (sheep > fox) {
			a_sheep += sheep;
		} else {
			a_fox += fox;
		}
	}
}
