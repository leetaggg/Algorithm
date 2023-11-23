import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        double length = Math.pow(Double.parseDouble(st.nextToken()), 2) + Math.pow(Double.parseDouble(st.nextToken()), 2);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if(Math.pow(Double.parseDouble(br.readLine()), 2) > length){
                sb.append("NE").append("\n");
            }else{
                sb.append("DA").append("\n");
            }
        }
        System.out.println(sb);
    }
}