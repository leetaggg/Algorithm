import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int testCase = 0; testCase < t; testCase++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int i = 0; i < c; i++) {
                for (int j = 0; j < r; j++) {
                    sb.append("X");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}