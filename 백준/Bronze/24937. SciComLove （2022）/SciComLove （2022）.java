import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String s = "SciComLove";
        int len = s.length();

        n = n % len;

        String result = s.substring(n) + s.substring(0, n);

        System.out.println(result);
    }
}