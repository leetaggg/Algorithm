import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int a = Integer.parseInt(br.readLine());
            if((a & (-a)) == a){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
