import java.io.*;

public class Main {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            cnt = 0;
            sb.append(isPalindrome(s)).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r){
            return 1;
        }else if(s.charAt(l) != s.charAt(r)){
            return 0;
        }else{
            return recursion(s, l + 1, r - 1);
        }
    }

    static int isPalindrome(String s){
        return recursion(s, 0, s.length() - 1);
    }

}