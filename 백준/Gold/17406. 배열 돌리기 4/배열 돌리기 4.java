import java.io.*;
import java.util.*;

public class Main {
	static int n, m, k, result;
	static int[][] arr, rotation;
	static boolean[] visited;
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[k + 1]; // 순열 방문 배열
		nums = new int[k];
		rotation = new int[k][3]; // 회전 연산 정보
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			rotation[i][0] = Integer.parseInt(st.nextToken()); // r
			rotation[i][1] = Integer.parseInt(st.nextToken()); // c
			rotation[i][2] = Integer.parseInt(st.nextToken()); // s
		}
		result = Integer.MAX_VALUE;
		permutation(0);
		System.out.println(result);
	}

	public static void turn(int[][] arr, int r, int c, int s) {
		r = r - 1;
		c = c - 1;
		for (int i = 1; i <= s; i++) {
			int temp = arr[r - i][c - i];

			for (int j = r - i; j < r + i; j++) {
				arr[j][c - i] = arr[j + 1][c - i];
			}

			for (int j = c - i; j < c + i; j++) {
				arr[r + i][j] = arr[r + i][j + 1];
			}

			for (int j = r + i; j > r - i; j--) {
				arr[j][c + i] = arr[j - 1][c + i];
			}

			for (int j = c + i; j > c - i + 1; j--) {
				arr[r - i][j] = arr[r - i][j - 1];
			}

			arr[r - i][c - i + 1] = temp;
		}
		
	}

	public static void permutation(int cnt) {
		if(cnt == k){
			int[][] copyArr = new int[n][m];
			for(int i = 0; i < n; i++) {
				copyArr[i] = arr[i].clone();
			}
			for(int per : nums) {
				turn(copyArr, rotation[per][0], rotation[per][1], rotation[per][2]);
			}
			int arrSum = 0;
			for(int i = 0; i < n; i++) {
				arrSum = 0;
				for(int j = 0; j < m; j++) {
					arrSum +=copyArr[i][j];
				}
				result = Math.min(result, arrSum);
			}
		}
		
		for(int i = 0; i < k; i++) {
			if(!visited[i]) {
				nums[cnt] = i;
				visited[i] = true;
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}
	
}
