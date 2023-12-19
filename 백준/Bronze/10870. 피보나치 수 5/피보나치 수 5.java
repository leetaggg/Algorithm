import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> fibo = Map.ofEntries(
            Map.entry(0, 0),
            Map.entry(1, 1),
            Map.entry(2, 1),
            Map.entry(3, 2),
            Map.entry(4, 3),
            Map.entry(5, 5),
            Map.entry(6, 8),
            Map.entry(7, 13),
            Map.entry(8, 21),
            Map.entry(9, 34),
            Map.entry(10, 55),
            Map.entry(11, 89),
            Map.entry(12, 144),
            Map.entry(13, 233),
            Map.entry(14, 377),
            Map.entry(15, 610),
            Map.entry(16, 987),
            Map.entry(17, 1597),
            Map.entry(18, 2584),
            Map.entry(19, 4181),
            Map.entry(20, 6765));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo.get(n));
    }
}