import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        if(line[0].isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(line.length);
        }
    }
}