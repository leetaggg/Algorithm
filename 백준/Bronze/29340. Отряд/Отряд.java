import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        StringBuilder result = new StringBuilder();

        int n = a.length();

        for (int i = 0; i < n; i++) {
            char digitA = a.charAt(i);
            char digitB = b.charAt(i);

            if (digitA >= digitB) {
                result.append(digitA);
            } else {
                result.append(digitB);
            }
        }

        System.out.println(result.toString());
    }
}