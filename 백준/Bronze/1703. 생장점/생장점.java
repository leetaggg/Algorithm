import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int tree = 1;

            if(n == 0) {
                break;
            }

            for(int i = 0; i < 2 * n; i++) {
                int m = Integer.parseInt(st.nextToken());
                if(i % 2 == 0) {
                    tree *= m;
                }else {
                    tree -= m;
                }
            }
            System.out.println(tree);
        }
    }

}