import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[m];

        permutation(1, 0);

        System.out.println(sb);
    }

    public static void permutation(int num, int cnt){
        if(cnt == m){
            for (int i : numbers) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = num; i <= n; i++) {
            numbers[cnt] = i;
            permutation(i, cnt + 1);
        }
    }
}
