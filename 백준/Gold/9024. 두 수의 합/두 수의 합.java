import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr,0 , n);

            int left = 0;
            int right = n - 1;

            int min = Integer.MAX_VALUE;
            int cnt = 0;

            while(left < right){
                int sum = arr[left] + arr[right];
                if (sum < k){
                    left++;
                }else {
                    right--;
                }
                if(min > Math.abs(k - sum)){
                    min = Math.abs(k - sum);
                    cnt = 1;
                }else if(min == Math.abs(k - sum)){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
