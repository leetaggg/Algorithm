import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int j = Integer.parseInt(br.readLine());

        int result = combinations(j);
        System.out.println(result);
    }

    static int combinations(int J) {
        int cnt = 0;
        for (int player1 = 1; player1 < J; player1++) {
            for (int player2 = player1 + 1; player2 < J; player2++) {
                for (int player3 = player2 + 1; player3 < J; player3++) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
