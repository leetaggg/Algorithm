import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int left = 0;
        int mid = 0;
        int right = 0;

        Loop:
        for (int i = 0; i < n - 2; i++) {
            int tmpLeft = i + 1;
            int tmpRight = n - 1;
            while (tmpLeft < tmpRight) {
                long sum = (long) arr[tmpLeft] + arr[i] + arr[tmpRight];

                if(Math.abs(sum) < min) {
                    left = tmpLeft;
                    mid = i;
                    right = tmpRight;
                    min = Math.abs(sum);
                }
                
                if(sum > 0) {
                    tmpRight--;
                } else if (sum == 0) {
                    left = tmpLeft;
                    mid = i;
                    right = tmpRight;
                    break Loop;
                } else {
                    tmpLeft++;
                }
            }
        }

        System.out.println(arr[mid] + " " + arr[left] + " " + arr[right]);
    }
}