import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i=1; i<n; i++) {
            sb.append(" ");
        }
        sb.append("*").append("\n");

        for (int i=2; i<n; i++) {
            for (int j=n-i; j>0; j--) {
                sb.append(" ");
            }
            sb.append("*");

            for (int j=1; j<=2*(i-1)-1; j++) {
                sb.append(" ");
            }
            sb.append("*").append("\n");
        }
        if (n != 1) {
            for (int i=1; i<=2*n-1; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}