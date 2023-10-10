import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] money = new int[n];

        int left = 1, mid = 0, right = 0;

        StringTokenizer st= new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
            if(right < money[i]) right = money[i];
        }

        int max = Integer.parseInt(br.readLine());

        while(left <= right){
            mid = (left + right) / 2;
            sum = 0;

            for (int i : money) {
                if(i > mid){
                    sum += mid;
                }else{
                    sum += i;
                }
            }

            if(sum <= max){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}