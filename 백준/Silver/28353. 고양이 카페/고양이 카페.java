import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] weights = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);

        int left = 0;
        int right = n - 1;
        int cnt = 0;
        while(left < right){
            int weight = weights[left] + weights[right];
            if(weight > k){
                right--;
            }else{
                cnt++;
                right--;
                left++;
            }
        }

        System.out.println(cnt);
    }
}