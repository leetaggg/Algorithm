import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        if(20 <= start && start <= 23){
            System.out.println(24 - start + end);
        } else {
            System.out.println(end - start);
        }
    }
}