import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < t; testCase++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = 1;
            for (int i = 1; i <= b; i++) {
                result = result * a % 10;
            }

            result = result == 0 ? 10 : result;

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}