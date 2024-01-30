import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = 0;
            for (int j = 0; j < 4; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) n++;
            }
            if(n == 1){
                System.out.println("C");
            }else if(n == 2){
                System.out.println("B");

            }else if(n == 3){
                System.out.println("A");
            }else if(n == 4){
                System.out.println("E");
            } else{
                System.out.println("D");
            }
        }
    }
}