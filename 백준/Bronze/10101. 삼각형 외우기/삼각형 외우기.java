import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());

        if(n1 + n2 + n3 != 180){
            System.out.println("Error");
        }else{
            if(n1 == 60 && n2 == 60 && n3 == 60){
                System.out.println("Equilateral");
            }else if(n1 == n2 || n2 == n3 || n1 == n3){
                System.out.println("Isosceles");
            }else{
                System.out.println("Scalene");
            }
        }
    }
}
