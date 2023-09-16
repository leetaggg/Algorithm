import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[m + 1];

        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= m; i++) {
            if (!prime[i]){
                for (int j = i * i; j <= m; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = n; i <= m; i++) {
            if(!prime[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}