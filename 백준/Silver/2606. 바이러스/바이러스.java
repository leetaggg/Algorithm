import java.io.*;
import java.util.*;

public class Main {

	static boolean[] visited; //방문 여부 배열 전역 변수 선언
	static int N; //컴퓨터의 갯수 전역 변수 선언
	static int[][] arr; // 인접 행렬 전역 변수 선언
	static int cnt; //카운트 변수 전역 선언
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1]; //N + 1 X N + 1 인접 행렬 생성 정점 번호를 그대로 사용하기 위해 +1
		visited = new boolean[N + 1]; // 방문 여부 배열 초기화
		for(int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1; //그래프 간선 인접 행렬 초기화
			arr[y][x] = 1;
		}
		System.out.println(dfs(1));
	}
	
	public static int dfs(int start) {
		visited[start] = true; // 시작 정점 방문 했으니 true
		for(int i = 1; i < N+1; i++) {
			if(arr[start][i] == 1 && visited[i] == false) { //1에서 시작, 1에서 갈 수 있는(1인 지역) 지역인 경우와 해당 지역이 방문하지 않은 경우 실행
				cnt++; // 카운트 증가
				dfs(i);//다음 방문할 곳으로 재귀 함수 실행
			}
		}
		return cnt; //다 방문 했으면 
	}

}
