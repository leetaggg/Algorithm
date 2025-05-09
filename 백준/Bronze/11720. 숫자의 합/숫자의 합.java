import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        char[] line = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            sum += line[i] - '0';
        }
        System.out.println(sum);
    }
}