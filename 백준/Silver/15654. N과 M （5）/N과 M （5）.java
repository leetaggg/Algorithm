import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] numbers, inputs;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inputs = new int[n];
        numbers = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);

        permutation(0);

        System.out.println(sb);
    }

    public static void permutation(int cnt){
        if(cnt == m){
            for (int i : numbers) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                numbers[cnt] = inputs[i];
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
