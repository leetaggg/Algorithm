import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] section = new int[n];
        int[] countArr = new int[1000001];
        int requiredCnt = (int) Math.ceil((m * 9.0) / 10.0);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            section[i] = Integer.parseInt(st.nextToken());
            countArr[section[i]]++;
            if(countArr[section[i]] == requiredCnt){
                System.out.println("YES");
                System.exit(0);
            }
        }

        for (int i = m; i < n; i++) {
            section[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;

        for (int i = 0; i < n - m; i++) {
            countArr[section[m + i]]++;
            countArr[section[i]]--;
            if(countArr[section[m + i]] == requiredCnt){
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}