import java.io.*;
import java.util.*;

public class Main {
    static int n, d, k, c, maxCnt;
    static int[] sushi;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 회전 초밥 접시 수
        d = Integer.parseInt(st.nextToken()); // 초밥 가짓 수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹을 수 있는 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        sushi = new int[n + k];
        arr = new int[d + 1];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < k; i++) {
            sushi[n + i] = sushi[i];
        }
        Set<Integer> set = new HashSet<>();
        arr[c]++;
        set.add(c);
        for (int i = 0; i < k; i++) {
            arr[sushi[i]]++;
            set.add(sushi[i]);
        }
        int cnt = set.size();
        for(int i = 1; i <= n; i++) {
            if(--arr[sushi[i - 1]] == 0) cnt--;
            if(++arr[sushi[i + k - 1]] == 1) cnt++;
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);
    }
}
