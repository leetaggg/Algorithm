import java.io.*;
import java.util.*;

public class Main {

	static class Min_Max{
		int min;
		int max;
		
		public Min_Max(int min, int max) {
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "[min=" + min + ", max=" + max + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][3];
		Min_Max[][] dp = new Min_Max[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i == 0) {
					dp[i][j] = new Min_Max(arr[i][j], arr[i][j]); 
				}
			}
		} //입력 끝
//		System.out.println(Arrays.deepToString(dp));
		for (int i = 1; i < n; i++) {
			
			for (int j = 0; j < 3; j++) {
				if(j == 0) {
					int min  = arr[i][j] + Math.min(dp[i-1][j].min, dp[i-1][j+1].min);
					int max  = arr[i][j] + Math.max(dp[i-1][j].max, dp[i-1][j+1].max);
					dp[i][j] = new Min_Max(min, max);
				}else if(j == 1) {
					int min  = arr[i][j] + Math.min(dp[i-1][j-1].min, Math.min(dp[i-1][j].min, dp[i-1][j+1].min));
					int max  = arr[i][j] + Math.max(dp[i-1][j-1].max, Math.max(dp[i-1][j].max, dp[i-1][j+1].max));
					dp[i][j] = new Min_Max(min, max);
				}else if(j == 2) {
					int min  = arr[i][j] + Math.min(dp[i-1][j].min, dp[i-1][j-1].min);
					int max  = arr[i][j] + Math.max(dp[i-1][j].max, dp[i-1][j-1].max);
					dp[i][j] = new Min_Max(min, max);
				}
				
			}
			
		} //저장 끝
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			if(min > Math.min(min, dp[n-1][i].min)) {
				min = dp[n-1][i].min;
			}
			if(max < Math.max(max, dp[n-1][i].max)) {
				max = dp[n-1][i].max;
			}
		}
		System.out.printf("%d %d", max, min);
		
	}

}
