import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxTime = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[maxTime + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int priority = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            for (int j = maxTime; j >= time ; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + priority);
            }
        }
        System.out.println(dp[maxTime]);
    }
}
