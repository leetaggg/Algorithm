import java.io.*;

public class Main {

    static int[] tree = new int[10001];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        sb = new StringBuilder();
        String line = "";

        while ((line = br.readLine()) != null) {
            tree[idx++] = Integer.parseInt(line);
        }

        postOrder(0, idx - 1);

        System.out.println(sb);
    }

    static void postOrder(int n, int end) {
        if (n > end)
            return;

        int mid = n + 1;
        while (mid <= end && tree[mid] < tree[n])
            mid++;

        postOrder(n + 1, mid - 1);
        postOrder(mid, end);

        sb.append(tree[n]).append("\n");
    }
}