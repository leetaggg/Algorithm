import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] groups = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            groups[i] = Integer.parseInt(st.nextToken());
        }

        int currentLoad = 0;
        int time = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (currentLoad + groups[i] > M) {
                time++;
                currentLoad = 0;
            }
            sb.append(time).append("\n");
            currentLoad += groups[i];
        }

        System.out.print(sb.toString());
    }
}