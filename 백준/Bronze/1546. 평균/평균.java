import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st =new StringTokenizer(br.readLine());
        double sum = 0.0;
        long max = -1;
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(st.nextToken());
            if(max < num) {
                max = num;
            }
            sum += num;
        }
        System.out.println(((sum / max)  * 100.0) / n);


    }
}