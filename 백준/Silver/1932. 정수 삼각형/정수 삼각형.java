import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            triangle[i] = new int[i + 1];
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp(n, triangle);
    }

    static void dp(int n, int[][] triangle){
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(j == 0){
                    triangle[i][j] += triangle[i - 1][j];
                }
                else if(j == i){
                    triangle[i][j] += triangle[i - 1][j - 1];
                }
                else{
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        Arrays.sort(triangle[n - 1]);
        System.out.println(triangle[n - 1][n - 1]);
    }
}