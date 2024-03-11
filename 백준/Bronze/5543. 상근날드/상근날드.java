import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sang = Integer.parseInt(br.readLine());
        int joong = Integer.parseInt(br.readLine());
        int ha = Integer.parseInt(br.readLine());
        int coke = Integer.parseInt(br.readLine());
        int cider = Integer.parseInt(br.readLine());

        System.out.println(Math.min(sang, Math.min(joong, ha)) + Math.min(coke, cider) - 50);

    }
}