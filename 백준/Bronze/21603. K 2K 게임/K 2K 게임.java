import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (k % 10 != i % 10 && k * 2 % 10 != i % 10) {
                arr.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr.size()).append("\n");
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.print(sb);
    }
}