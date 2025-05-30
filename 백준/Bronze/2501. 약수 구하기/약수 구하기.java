import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) - 1;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                list.add(i);
            }
        }
        if(m >= list.size()){
            System.out.println(0);
        }else{
            System.out.println(list.get(m));
        }
    }
}