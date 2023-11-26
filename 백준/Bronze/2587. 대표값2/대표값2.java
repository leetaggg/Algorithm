import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(((int) Arrays.stream(arr).average().orElse(0.0)));
        System.out.println(Arrays.stream(arr).sorted().toArray()[2]);
    }
}
