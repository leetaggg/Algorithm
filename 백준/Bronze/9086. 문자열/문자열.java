import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCase = 0; testCase < t; testCase++) {
            char[] line = br.readLine().toCharArray();
            sb.append(line[0]).append(line[line.length - 1]).append("\n");
        }
        System.out.println(sb);
    }
}