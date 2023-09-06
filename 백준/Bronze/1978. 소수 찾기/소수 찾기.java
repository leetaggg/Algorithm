import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        boolean[] prime = new boolean[1001];
        prime[0] = prime[1] = true;
        for (int i = 2; i*i <= 1000; i++) {
            if(!prime[i]){
                for (int j = i*i; j <= 1000; j+=i) prime[j]= true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if(!prime[Integer.parseInt(st.nextToken())]) result++;
        }
        System.out.println(result);
    }
}
