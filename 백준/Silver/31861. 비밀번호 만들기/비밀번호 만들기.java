import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[][] dp = new long[m][26];

		Arrays.fill(dp[0], 1);

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < 26; j++) {
				dp[i][j] = 0;
				for (int k = 0; k < 26; k++) {
					if (Math.abs(j - k) >= n) {
						dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
					}
				}
			}
		}

		long result = 0;
		for (int i = 0; i < 26; i++) {
			result = (result + dp[m - 1][i]) % MOD;
		}

		System.out.println(result);
	}
}