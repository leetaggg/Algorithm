import java.io.*;
import java.util.*;

public class Main {

    static int n, m, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;

        recursive(cards, 0, 0);

        System.out.println(result);

    }

    static void recursive(int[] cards, int depth, int sum){
        if (depth == 3){
            if(sum <= m){
                if(Math.abs(m - sum) < Math.abs(m - result)){
                    result = sum;
                }
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                recursive(cards, depth + 1, sum + cards[i]);
                visited[i] =false;
            }
        }

    }
}