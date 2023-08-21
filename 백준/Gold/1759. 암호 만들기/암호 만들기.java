import java.io.*;
import java.util.*;
public class Main {
    static int[] vowel = {'a', 'e', 'i', 'o', 'u'};
    static int n, r;
    static char[] input, code;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        input = new char[n];
        code = new char[r];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);
        combination(0, 0);
        System.out.println(sb.toString());
    }
    public static void combination(int cnt, int start){
        if(cnt == r){
            if(isPw(code)){
                for (int i = 0; i < r; i++) {
                    sb.append(code[i]);
                }
                sb.append("\n");
            }
            return;
        }
        for (int i = start; i < n; i++) {
            code[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }
    public static boolean isPw(char[] code){
        int vowelCnt = 0;
        for(int i = 0; i < code.length; i++){
            for (int j = 0; j < vowel.length; j++) {
                if(code[i] == vowel[j]){
                    vowelCnt++;
                }
            }
        }
        if(code.length - vowelCnt >= 2 && vowelCnt >= 1) {
            return true;
        }else{
            return false;
        }
    }
}
