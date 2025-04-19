import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cards = new int[n];
        boolean[] exists = new boolean[1_000_001];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            exists[cards[i]] = true;
            max = Math.max(max, cards[i]);
        }

        int[] score = new int[1_000_001];

        for (int i = 1; i <= max; i++) {
            if (!exists[i]) continue;

            for (int j = i * 2; j <= max; j += i) {
                if (exists[j]) {
                    score[i]++;
                    score[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int card : cards) {
            sb.append(score[card]).append(" ");
        }
        System.out.println(sb);
    }
}
