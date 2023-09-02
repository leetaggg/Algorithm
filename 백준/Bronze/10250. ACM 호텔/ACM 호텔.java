import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (n % h == 0){
                sb.append((h * 100) + (n / h)).append("\n");
            }else{
                sb.append((((n % h) * 100)) + ((n / h) + 1)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}