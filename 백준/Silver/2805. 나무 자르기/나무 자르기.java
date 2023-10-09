import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] tree = new int[n];

        st = new StringTokenizer(br.readLine());

        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(end < tree[i]){
                end = tree[i];
            }
        }

        while(start <= end){
            int mid = (start + end) / 2;
            long sum = 0;

            for (int i : tree){
                sum += i > mid ? i - mid : 0;
            }

            if(sum >= m){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}