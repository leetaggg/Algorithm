import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(power(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    static long power(int a, int b, int c){
        if(b == 1){
            return a % c;
        }
        long tmp = power(a, b/2, c);
        if(b % 2 == 0){
            return tmp * tmp % c;
        }else{
            return ((tmp * tmp) % c * a) % c;
        }
    }
}