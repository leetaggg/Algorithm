import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[10][20];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = '.';
            }
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String com = br.readLine();
            map[com.charAt(0) - 65][Integer.parseInt(com.substring(1)) - 1] = 'o';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
