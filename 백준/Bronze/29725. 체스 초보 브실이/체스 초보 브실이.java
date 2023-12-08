import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[6];

        for (int i = 0; i < 8; i++) {
            char[] word = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if(word[j] == 'K'){
                    arr[0]++;
                }else if(word[j] == 'k'){
                    arr[0]--;
                }else if(word[j] == 'P'){
                    arr[1]++;
                }else if(word[j] == 'p'){
                    arr[1]--;
                }else if(word[j] == 'N'){
                    arr[2]++;
                }else if(word[j] == 'n'){
                    arr[2]--;
                }else if(word[j] == 'B'){
                    arr[3]++;
                }else if(word[j] == 'b'){
                    arr[3]--;
                }else if(word[j] == 'R'){
                    arr[4]++;
                }else if(word[j] == 'r'){
                    arr[4]--;
                }else if(word[j] == 'Q'){
                    arr[5]++;
                }else if(word[j] == 'q'){
                    arr[5]--;
                }
            }
        }

        int result = 0;

        result += (arr[1] * 1);
        result += (arr[2] * 3);
        result += (arr[3] * 3);
        result += (arr[4] * 5);
        result += (arr[5] * 9);

        System.out.println(result);
    }
}
