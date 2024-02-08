import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double n1 = Double.parseDouble(st.nextToken());
        double n2 = Double.parseDouble(st.nextToken());
        double n3 = Double.parseDouble(st.nextToken());
        
        System.out.println((int)Math.max(n1 * n2 / n3, n1 / n2 * n3));
    }
}