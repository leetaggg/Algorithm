import java.io.*;
import java.util.*;

public class Main {

    static boolean flag;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] choice1 = new int[n];
            int[] choice2 = new int[n];

            visited = new boolean[n][8];

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                choice1[j] = st.nextToken().charAt(0) == '+' ? Integer.parseInt(st.nextToken()) : -(Integer.parseInt(st.nextToken()));
                choice2[j] = st.nextToken().charAt(0) == '+' ? Integer.parseInt(st.nextToken()) : -(Integer.parseInt(st.nextToken()));

                flag = false;
            }
            backTracking(1, choice1, choice2, 0, n);
            sb.append(flag ? "LUCKY\n" : "UNLUCKY\n");
        }
        System.out.println(sb);
    }

    static public void backTracking(int k, int[] choice1, int[] choice2, int depth, int limit) {
        if (flag || depth == limit) {
            if(!flag){
                flag = k % 7 == 0;
            }
            return;
        }

        if(visited[depth][k]){
            return;
        }

        visited[depth][k] = true;

        int choice1Result = (choice1[depth] > 0 ? k + choice1[depth] : k * Math.abs(choice1[depth])) % 7;
        int choice2Result = (choice2[depth] > 0 ? k + choice2[depth] : k * Math.abs(choice2[depth])) % 7;


        backTracking(choice1Result, choice1, choice2, depth + 1, limit);
        backTracking(choice2Result, choice1, choice2, depth + 1, limit);
    }
}