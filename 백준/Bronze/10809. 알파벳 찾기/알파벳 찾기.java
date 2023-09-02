import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char alphabet = 'a';
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            sb.append(word.indexOf(Character.toString(alphabet))).append(" ");
            alphabet++;
        }
        System.out.println(sb.toString());
    }
}