import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i < n + 1; i++){
            long sum = 0;
            for(int j = 4; j <= i; j++){
                sum = Math.max(dp[i - j] * (j - 1), sum);
            }
            dp[i] = Math.max(dp[i - 1] + 1, Math.max(dp[i-3] * 2, sum));
        }
        System.out.println(dp[n]);
    }
}