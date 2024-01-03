import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();

        Character[] C = new Character[c.length];

        for (int i = 0; i < c.length; i++) {
            C[i] = c[i];
        }

        Arrays.sort(C, Collections.reverseOrder());

        for (int i = 0; i < C.length; i++) {
            System.out.print(C[i]);
        }
    }
}