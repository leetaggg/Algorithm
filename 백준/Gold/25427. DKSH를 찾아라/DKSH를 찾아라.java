import java.io.*;
import java.util.*;

public class Main {

    static final char[] dksh = {'D', 'K', 'S', 'H'};
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] chars = br.readLine().toCharArray();
        boolean[] visited = new boolean[n];
        cnt = 0;

        char[] selectedChars = new char[4];

        backTracking(chars, selectedChars, visited, 0, n, 0);
        System.out.println(cnt);
    }

    static void backTracking(char[] chars, char[] selectedChars, boolean[] visited, int depth, int limit, int start) {
        if (depth == 4) {
            if (Arrays.equals(selectedChars, dksh)) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < limit; i++) {
            if (!visited[i] && (chars[i] == 'D' || chars[i] == 'K' || chars[i] == 'S' || chars[i] == 'H')) {
                visited[i] = true;
                selectedChars[depth] = chars[i];
                backTracking(chars, selectedChars, visited, depth + 1, limit, i + 1);
                visited[i] = false;
            }
        }
    }
}