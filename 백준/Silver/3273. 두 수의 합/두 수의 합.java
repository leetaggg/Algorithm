import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int cnt = 0;
        int left = 0;
        int right = n - 1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == m){
                cnt++;
                left++;
            }else if(sum < m){
                left++;
            }else{
                right--;
            }
        }
        System.out.println(cnt);
    }
}
