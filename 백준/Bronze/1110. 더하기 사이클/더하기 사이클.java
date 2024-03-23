import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int copy = n;

        do {
            n = ((n % 10) * 10) + (((n / 10) + (n % 10)) % 10);
            cnt++;
        } while (copy != n);

        System.out.println(cnt);
    }
}