import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 1;

        if(n == 0){
            result = 1;
        }else{
            result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
        }
        System.out.println(result);
    }
}