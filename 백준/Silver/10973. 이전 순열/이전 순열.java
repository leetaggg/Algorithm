import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        if (!nextPermutation(nums, N)) {
            System.out.println(-1);
        } else {
            for (int number : nums) {
                sb.append(number).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean nextPermutation(int[] arr, int n) {
        int top = arr.length - 1;
        while (top > 0 && arr[top - 1] <= arr[top])
            --top;

        if (top == 0) {
            reverse(arr, 0, arr.length - 1); // 배열 전체를 뒤집어서 초기 순열로 돌아감
            return false;
        }
        int swapIdx = arr.length - 1;

        while (arr[top - 1] <= arr[swapIdx]) {
            --swapIdx;
        }
        swap(arr, top - 1, swapIdx);

        swapIdx = arr.length - 1;
        while (top < swapIdx) {
            swap(arr, top, swapIdx);
            top++;
            swapIdx--;
        }
        return true;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
