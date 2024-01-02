import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int vote = 0;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == 'O') vote++;
            }
            if(vote > m / 2) result++;
        }

        System.out.println(result);
    }
}