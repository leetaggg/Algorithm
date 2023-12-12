import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b + c || b == a + c || c == a + b) {
            System.out.println(1);
        }
        else if (a == b * c || b == a * c || c == a * b) {
            System.out.println(2);
        }
        else {
            System.out.println(3);
        }
    }
}