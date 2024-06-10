import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int winCount = 0;

        for (int i = 0; i < n; i++) {
            String sequence = br.readLine();
            if (!sequence.contains("CD")) {
                winCount++;
            }
        }

        System.out.println(winCount);
    }
}