import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int g = Integer.parseInt(st.nextToken());

            int d = g * 100 / n;

            if (0 <= d && d <= 4) {
                System.out.print("1 ");
            } else if (4 < d && d <= 11) {
                System.out.print("2 ");
            } else if(11 < d && d <= 23){
                System.out.print("3 ");
            } else if(23 < d && d <= 40){
                System.out.print("4 ");
            } else if(40 < d && d <= 60){
                System.out.print("5 ");
            } else if(60 < d && d <= 77){
                System.out.print("6 ");
            } else if(77 < d && d <= 89){
                System.out.print("7 ");
            } else if(89 < d && d <= 96){
                System.out.print("8 ");
            } else if (96 < d && d <= 100){
                System.out.print("9 ");
            }
        }
    }
}