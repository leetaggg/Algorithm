import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());

        int language = (a % c == 0) ? a / c : a / c + 1;
        int math = (b % d == 0) ? b / d : b / d + 1;

        int holiday = (language > math) ? l - language : l - math;

        System.out.println(holiday);

    }
}