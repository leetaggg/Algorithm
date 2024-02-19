import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            cnt -= out;
            cnt += in;
            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }
}