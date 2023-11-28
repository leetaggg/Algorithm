import java.io.*;
import java.util.*;

public class Main {
    static final Map<Character, Integer> m =  Map.ofEntries(
            Map.entry('A', 2),
            Map.entry('B', 2),
            Map.entry('C', 2),
            Map.entry('D', 3),
            Map.entry('E', 3),
            Map.entry('F', 3),
            Map.entry('G', 4),
            Map.entry('H', 4),
            Map.entry('I', 4),
            Map.entry('J', 5),
            Map.entry('K', 5),
            Map.entry('L', 5),
            Map.entry('M', 6),
            Map.entry('N', 6),
            Map.entry('O', 6),
            Map.entry('P', 7),
            Map.entry('Q', 7),
            Map.entry('R', 7),
            Map.entry('S', 7),
            Map.entry('T', 8),
            Map.entry('U', 8),
            Map.entry('V', 8),
            Map.entry('W', 9),
            Map.entry('X', 9),
            Map.entry('Y', 9),
            Map.entry('Z', 9)
    );
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] word = br.readLine().toCharArray();

        int result = 0;

        for (int i = 0; i < word.length; i++) {
            result += m.get(word[i]);
        }

        System.out.println(result + word.length);

    }
}