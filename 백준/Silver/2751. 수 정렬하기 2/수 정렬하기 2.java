import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Integer> num = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(num);

        for (int i = 0; i < n; i++) {
            sb.append(num.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}