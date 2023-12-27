import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[n + 1];

        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        int first = -1;
        int sum = 0;

        for (int i = m; i <= n; i++) {
            if (!prime[i]) {
                sum += i;
                if (first == -1) {
                    first = i;
                }
            }
        }

        if (first == -1) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(first);
        }
    }
}