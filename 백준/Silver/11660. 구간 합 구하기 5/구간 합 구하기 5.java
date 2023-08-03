import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // dp[n][n] = dp[n-1][n] + d[n][n-1] - dp[n-1][n-1]
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n+1][n+1];
        
        //입력
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        
        
        int[][] dp = new int[n+1][n+1];
        //dp 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = arr[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        
//        System.out.println();
//        for (int[] is : dp) {
//            System.out.println(Arrays.toString(is));
//        }
        
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            //구현시작
            System.out.println(dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1]);
//            System.out.println();
            
        }
        /**
         * 
         * 
         *  1 2 3 4
            2 3 4 5
            3 4 5 6
            4 5 6 7
         * 
         *     1, 3, 6, 10
             3, 8, 15, 24
            6, 15, 27, 42
            10, 24, 42, 64
            
            (2, 2) -> 8
            (3, 4) -> 42
         */
        
        
        
        
    }

}