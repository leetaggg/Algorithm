import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> numberMap = new HashMap<>();
        int current = n;
        int index = 0;
        numberMap.put(current, index);

        while (true) {
            current = (current * n) % p;
            index++;

            if (numberMap.containsKey(current)) {
                System.out.println(index - numberMap.get(current));
                break;
            }
            numberMap.put(current, index);
        }
    }
}