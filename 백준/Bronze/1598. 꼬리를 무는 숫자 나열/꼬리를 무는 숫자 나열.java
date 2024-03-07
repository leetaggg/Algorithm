import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()) - 1;
        int m = Integer.parseInt(st.nextToken()) - 1;

        System.out.println((Math.abs(n / 4 - m / 4)) + (Math.abs(n % 4 - m % 4)));
    }
}