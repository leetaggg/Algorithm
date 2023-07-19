import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[][] arr = new long[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				arr[i][j] = 1;
			}
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 2; j <=m; j++) {
				arr[i][j] = (arr[i-1][j] + arr[i][j-1] + arr[i-1][j-1]) % 1000000007;
			}
		}
		System.out.println(arr[n][m]);
		
	}
}
