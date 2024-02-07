import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        
        int[] str1 = new int[26];
        int[] str2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            str1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            str2[s2.charAt(i) - 'a']++;
        }

        int cnt = 0;

        for (int i = 0; i < 26; i++) {
            int n = str1[i] - str2[i];
            if(n != 0){
                cnt += Math.abs(n);
            }
        }

        System.out.println(cnt);
    }
}