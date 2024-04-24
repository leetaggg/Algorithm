import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());

        int count = 0;
        while (x < n) {
            int r = x % 3;
            switch (r) {
                case 0:
                    x = x + 1;
                    break;
                case 1:
                    x = x * 2;
                    break;
                case 2:
                    x = x * 3;
                    break;
            }
            count++;
        }

        System.out.println(count);
    }
}