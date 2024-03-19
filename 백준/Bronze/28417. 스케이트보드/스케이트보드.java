import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int winPeople = 0;

        int[] trick = new int[5];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());


            int run1 = Integer.parseInt(st.nextToken());
            int run2 = Integer.parseInt(st.nextToken());


            for (int j = 0; j < 5; j++) {
                trick[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(trick);
            winPeople = Math.max(winPeople, Math.max(run1, run2) + trick[3] + trick[4]);
        }

        System.out.println(winPeople);
    }
}