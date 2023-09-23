import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] num = new boolean[31];

        for (int i = 0; i < 28; i++) {
            num[Integer.parseInt(br.readLine())] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if(!num[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}