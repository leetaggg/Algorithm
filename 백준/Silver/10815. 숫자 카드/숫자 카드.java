import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] cards = new boolean[20000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[10000000 + Integer.parseInt(st.nextToken())] = true;
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(cards[10000000 + Integer.parseInt(st.nextToken())] ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}