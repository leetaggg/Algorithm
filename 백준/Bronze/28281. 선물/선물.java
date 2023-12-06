import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];

        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int temp = arr[i] * x + arr[i + 1] * x;
            result = Math.min(result, temp);
        }

        System.out.println(result);
        
    }
}
