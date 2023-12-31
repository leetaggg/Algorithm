import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[15][15];

        for (int i = 1; i < 15; i++) {
            dp[0][i] = i;
            dp[i][1] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            sb.append(dp[Integer.parseInt(br.readLine())][Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }
}