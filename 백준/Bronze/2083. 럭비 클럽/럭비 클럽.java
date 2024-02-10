import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();

            if(name.equals("#")) break;

            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if(age > 17 || weight >= 80){
                sb.append(name).append(" ").append("Senior").append("\n");
            }else {
                sb.append(name).append(" ").append("Junior").append("\n");
            }
        }
        System.out.println(sb);
    }
}
