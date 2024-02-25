import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] magicHat = new int[4];
        for (int i = 0; i < 4; i++) {
            magicHat[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(magicHat);

        int result = 0;
        for (int i = 1; i < magicHat.length; i++) {
            result += magicHat[i];
        }

        System.out.println(++result);
    }
}