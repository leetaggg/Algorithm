import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
        }
        System.out.println(sb.toString());
    }
}
