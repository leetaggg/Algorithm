import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < t; testCase++) {
            long n = Long.parseLong(br.readLine());

            sb.append(n * n).append("\n");
        }
        System.out.println(sb);
    }
}
