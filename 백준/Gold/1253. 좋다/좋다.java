import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int number = arr[i];

            int left = 0;
            int right = n - 1;

            while(left < right){
                int sum = arr[left] + arr[right];

                if(left == i){
                    left++;
                    continue;
                }else if (right == i) {
                    right--;
                    continue;
                }

                if(sum < number){
                    left++;
                }else if(sum == number) {
                    cnt++;
                    break;
                }else{
                    right--;
                }
            }
        }

        System.out.println(cnt);
    }
}