import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(cards , Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int[] cards, int target){
        int left = 0;
        int right = cards.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(target < cards[mid]){
                right = mid - 1;
            }else if(target > cards[mid]){
                left = mid + 1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}