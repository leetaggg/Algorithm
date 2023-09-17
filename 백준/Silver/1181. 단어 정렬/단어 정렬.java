import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        list.stream().
                distinct().
                sorted((o1, o2) -> {
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }else{
                        return o1.length() - o2.length();
                    }})
                .forEach(System.out::println);
    }
}