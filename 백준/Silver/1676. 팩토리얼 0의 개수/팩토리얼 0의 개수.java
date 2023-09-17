import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int five = 0;
        while(n >= 5){
            five += n / 5;
            n /= 5;
        }
        System.out.println(five);
    }
}