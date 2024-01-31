import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int x = 0, y = 0;

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == 'a'){
                x++;
                y++;
            }else if(word.charAt(i) == 'e'){
                x++;
                y++;
            }else if(word.charAt(i) == 'i'){
                x++;
                y++;
            }else if(word.charAt(i) == 'o'){
                x++;
                y++;
            }else if(word.charAt(i) == 'u'){
                x++;
                y++;
            }else if(word.charAt(i) == 'y'){
                y++;
            }
        }
        System.out.printf("%d %d", x, y);
    }
}