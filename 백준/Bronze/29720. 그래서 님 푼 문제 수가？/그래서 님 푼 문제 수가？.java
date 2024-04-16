import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int minProblemsSolved = Math.max(0, n - m * k);
        int maxProblemsSolved = Math.max(0, n - 1 - m * (k - 1));

        System.out.println(minProblemsSolved + " " + maxProblemsSolved);
    }
}