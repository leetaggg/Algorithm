import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] lan = new int[k];
        long end = 0;
        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if(end < lan[i]){
                end = lan[i];
            }
        }

        long start = 1;
        long mid;
        while (start <= end){
            mid = (start + end) / 2;
            long cnt = 0;
            for (int i : lan) {
                cnt += (i / mid);
            }

            if(cnt >= n){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}