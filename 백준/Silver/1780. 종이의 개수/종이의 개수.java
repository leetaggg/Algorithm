import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int[][] arr;
	private static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력 끝
		
		answer = new int[3]; //1: 0, 2: 1, 3: -1
		dfs(0, 0, N); //행, 열, 길이
		
		for (int s : answer) {
			System.out.println(s);
		}
	}

	
	private static void dfs(int r, int c, int n) {
		int target = arr[r][c];
		int cnt = 0;
		//기저조건
		if(n == 1) { //한 칸이면
			checked(target);
			return;
		}
		
			
		for (int i = r; i < n+r; i++) {
			for (int j = c; j < n+c; j++) {
				if(target != arr[i][j]) {
					//같지 않을 경우에 dfs 수행
					dfs(r, c, n/3);
					dfs(r, c+n/3, n/3);
					dfs(r, c+2*(n/3), n/3);
					dfs(r+n/3, c, n/3);
					dfs(r+n/3, c+n/3, n/3);
					dfs(r+n/3,c+2*(n/3), n/3);
					dfs(r+2*n/3, c, n/3);
					dfs(r+2*n/3, c+n/3, n/3);
					dfs(r+2*n/3,c+2*(n/3), n/3);
					            
				 	return;
				}
				cnt++;
			}
		}
		
		if(n*n == cnt) {
			checked(target);
			return;
		}
		
	}
	
	private static void checked(int target) {
		if(target == -1) {
			answer[0]++;
		}else if(target == 0) {
			answer[1]++;
		}else {
			answer[2]++;
		}
	}

}
