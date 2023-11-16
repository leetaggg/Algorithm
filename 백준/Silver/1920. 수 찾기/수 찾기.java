import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            boolean flag = false;
            int left = 0;
            int right = n - 1;
            int num = arr2[i];
            while(left <= right){
                int mid = (left + right) / 2;

                if(arr1[mid] < num){
                    left = mid + 1;
                }else if(arr1[mid] == num){
                    sb.append("1").append("\n");
                    flag = true;
                    break;
                }else{
                    right = mid - 1;
                }
            }
            if(!flag){
                sb.append("0").append("\n");
            }
        }
        System.out.println(sb);
    }
}