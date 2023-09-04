import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int[] dp = new int[money + 1];

        int k = Integer.parseInt(br.readLine());
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int kind = Integer.parseInt(st.nextToken());
            for (int j = money; j >= coin; j--) {
                for (int l = 1; l <= kind; l++) {
                    if(j - coin * l >= 0){
                        dp[j] += dp[j - coin * l];
                    }
                }
            }
        }
        System.out.println(dp[money]);
    }
}
