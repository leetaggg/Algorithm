import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 돌다리
 *
 */
public class Main {
	static class Location{
		int num;
		int cnt;
		
		public Location(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken()); //콩콩이 힘 A, B
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken()); //동규의 현 위치
		int M = Integer.parseInt(st.nextToken()); //주미의 현위치
		
		int[] dist = {1, -1, A, -A, B, -B, A, B}; //갈 수 있는 방향 인덱스[6] 부터 곱하기
		
		//첫점은 동규, 방문처리를 해야함
		boolean[] isVisited = new boolean[100_001]; //돌번호는  0 부터 100,000까지임
		
		//큐 이용
		Queue<Location> queue = new ArrayDeque<Location>();
		queue.offer(new Location(N, 0)); //시작점 동규 입력
		isVisited[N] = true; //시작점 방문처리
		
		int min = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			Location current = queue.poll();
			
			//주미에게 도착했을 때
			if(current.num == M) {
				if(min > Math.min(min, current.cnt)) {
					min = current.cnt;
				}
			}
			for (int i = 0; i < dist.length; i++) {
				int nx = 0; //다음 값

				if(i >= 6) {
					nx = current.num * dist[i];
				}else {
					nx = current.num + dist[i];
				}
				
				// nx 값 범위 체크 , 방문체크
				if(nx < 0 || nx >= 100_001 || isVisited[nx]) {
					continue;
				}
				queue.offer(new Location(nx, current.cnt+1));
				isVisited[nx] = true;
			}
		}
		
		System.out.println(min);
		
	}

}
