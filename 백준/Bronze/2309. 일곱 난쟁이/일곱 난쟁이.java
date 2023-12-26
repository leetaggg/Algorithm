import java.io.*;
import java.util.*;

public class Main {
    static int[] select = new int[7];
    static boolean[] visited = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        Loop1:
        for (int i = 0; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100){
                    arr[i] = arr[j] = 0;
                    break Loop1;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if(arr[i] != 0){
                System.out.println(arr[i]);
            }
        }
    }
}