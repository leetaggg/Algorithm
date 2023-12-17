import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] alphabet;

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        Loop1:
        for (int i = 0; i < n; i++) {
            alphabet = new boolean[26];
            String word = br.readLine();
            int prev = -1;
            for (int j = 0; j < word.length(); j++) {
                int now = word.charAt(j);
                if(prev != now){
                    if(!alphabet[now - 97]){
                        alphabet[now - 97] = true;
                        prev = now;
                    }else{
                        continue Loop1;
                    }
                }
            }
            result++;
        }

        System.out.println(result);
    }
}