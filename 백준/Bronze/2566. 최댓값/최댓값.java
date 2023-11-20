import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int r = 0, c = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(max < num){
                    max = num;
                    r = i + 1;
                    c = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(r + " " + c);

    }
}