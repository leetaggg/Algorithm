import java.io.*;
import java.util.*;

public class Main {

    static int n, s, cnt;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        num = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;

        getSubsequence(0, 0, 0);
        System.out.println(cnt);
    }

    static void getSubsequence(int sum, int depth, int count){
        if(depth == n){
            if(count > 0 && sum == s){
                cnt++;
            }
            return;
        }

        getSubsequence(sum + num[depth], depth + 1, count + 1);
        getSubsequence(sum, depth + 1, count);
    }
}