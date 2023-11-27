import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(n >= 5){
            n -= 5;
            sb.append("V");
        }
        switch (n){
            case 4:
                sb.append("IIII");
                break;
            case 3:
                sb.append("III");
                break;
            case 2:
                sb.append("II");
                break;
            case 1:
                sb.append("I");
                break;
        }
        System.out.println(sb);
    }
}
