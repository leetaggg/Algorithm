import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        boolean flag = true;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != s.charAt(list.size() - i - 1)){
                flag = false;
            }
        }

        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}