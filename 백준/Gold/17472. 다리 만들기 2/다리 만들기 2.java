import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static class Location {
		int x;
		int y;
		int cnt;

		public Location(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no, weight; //정점번호, 트리정점과 연결했을 때의 간선 비용

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

	static int[][] dist = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[] direct = { 'U', 'D', 'L', 'R' }; // 방향
	static int[][] matrix;

	private static int n;
	private static int m;
	private static boolean[][] isVisited;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		isVisited = new boolean[n][m];
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력완

		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					bfs(i, j, cnt);
					cnt++;
				}
			}
		} // 섬 찾기
		matrix = new int[cnt][cnt];
		for (int i = 0; i < cnt; i++) {
			Arrays.fill(matrix[i], Integer.MAX_VALUE); // 가장 큰 값으로 초기화
		}

		// 연결됐는지 판단하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) { // 숫자를 만남
					go(i, j);

				}
			}
		}

		//MST-Prim 알고리즘
		
		boolean[] visited = new boolean[cnt];
		int[] minEdge = new int[cnt]; // 자신과 트리의 정점점들 간 최소 간선 비용
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0; //임의의 0정점을 트리 구성의 시작으로 하기 위해 세팅
		pQueue.offer(new Vertex(1, minEdge[1]));
		
		int min = 0, minVertex = 0;
		int result = 0;//최소 신장트리 비용 저장
		int index = 0;
		
		while(!pQueue.isEmpty()) {
			min = Integer.MAX_VALUE;
			minVertex = -1;
			//step1: 미방문(비트리) 정점 중 최소 간선 비용의 정점을 선택
			Vertex cur = pQueue.poll();
			minVertex = cur.no;
			min = cur.weight;
			if(visited[minVertex]) continue;
			
			//step2 : 방문(트리) 정점에 추가
			visited[minVertex] = true; //방문처리
			result += min; //신장트리 비용 누적
			if(++index == cnt)break;
			
			//step3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 고려(aka 영업타임)
			for (int i = 1; i < cnt; i++) {
				if(!visited[i] && matrix[minVertex][i] != 0 && minEdge[i] > matrix[minVertex][i]) {
					minEdge[i] = matrix[minVertex][i];
					pQueue.offer(new Vertex(i, minEdge[i]));
				}
			}//step3 끝 : 최소값으로 업뎃
			
		}
		
		boolean flag = false;
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) {
				flag = true;
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(result);
		
	} // end of main


	public static void go(int x, int y) {

		for (int i = 0; i < dist.length; i++) { // 0:U, 1:D, 2:L, 3:R
			int nx = x + dist[i][0];
			int ny = y + dist[i][1];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}

			if (map[nx][ny] == 0) { // 옆이 0 이면 경로 정해주기 (i)
				int[] value = find(nx, ny, i); // 다리 수, 땅 이름
				int target = map[x][y];
				if (target != 0 && value[0] - 1 >= 2) { // 2개 이상 일경우 node 연결해주기
					// map[nx][ny] 랑 value[1] 연결
//					System.out.println("nx: "+ nx + " ny: "+ ny+ " dir: "+ i + " cnt: " + value[0] +", land: " + value[1]);
					if (matrix[target][value[1]] > value[0] - 1) {
						matrix[target][value[1]] = value[0] - 1;
					} // 가치 주입하기
				}
			}
		}

	} // go 나아가기

	public static int[] find(int x, int y, int dir) {
		int cnt = 0;
		int land = 0;

		// dir - 0 : U
		if (dir == 0) {
			for (int i = x; i >= 0; i--) {
				cnt++;
				if (map[i][y] != 0) {
					land = map[i][y];
					break;
				}
			}

		}
		// dir - 1 : D
		else if (dir == 1) {
			for (int i = x; i < n; i++) {
				cnt++;
				if (map[i][y] != 0) {
					land = map[i][y];
					break;
				}
			}
		}
		// dir - 2 : L

		else if (dir == 2) {
			for (int i = y; i >= 0; i--) {
				cnt++;
				if (map[x][i] != 0) {
					land = map[x][i];
					break;
				}
			}
		}
		// dir - 3 : R
		else if (dir == 3) {
			for (int i = y; i < m; i++) {
				cnt++;
				if (map[x][i] != 0) {
					land = map[x][i];
					break;
				}
			}
		}

		return new int[] { cnt, land };

	}

	public static void bfs(int x, int y, int cnt) {
		Queue<Location> queue = new ArrayDeque<Location>();
		queue.offer(new Location(x, y, cnt));
		isVisited[x][y] = true;

		while (!queue.isEmpty()) {
			Location current = queue.poll();
			map[current.x][current.y] = cnt;

			for (int d = 0; d < dist.length; d++) {
				int nx = current.x + dist[d][0];
				int ny = current.y + dist[d][1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || isVisited[nx][ny]) {
					continue; // 범위 체크
				}

				if (map[nx][ny] == 1) {
					queue.offer(new Location(nx, ny, cnt));
					isVisited[nx][ny] = true;
				}

			}
		}
	}
} // end of class
