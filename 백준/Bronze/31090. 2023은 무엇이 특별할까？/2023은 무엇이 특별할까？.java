import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < t; testCase++) {
            int n1 = Integer.parseInt(br.readLine());
            int n2 = n1 + 1;

            int s1 = Integer.parseInt(Integer.toString(n1).substring(2));

            if(n2 % s1 == 0){
                sb.append("Good\n");
            }else{
                sb.append("Bye\n");
            }
        }
        System.out.println(sb);
    }
}