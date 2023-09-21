import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[n + 1][m + 1][k + 1];

        int[][] order = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            int x = order[i][0];
            int y = order[i][1];
            for (int j = 0; j <= m; j++) {
                for (int l = 0; l <= k; l++) {
                    dp[i][j][l] = dp[i - 1][j][l];
                }
            }
            for (int j = x; j <= m; j++) {
                for (int l = y; l <= k; l++) {
                    dp[i][j][l] = Math.max(dp[i - 1][j - x][l - y] + 1, dp[i - 1][j][l]);
                }
            }
        }
        System.out.println(dp[n][m][k]);
    }
}
