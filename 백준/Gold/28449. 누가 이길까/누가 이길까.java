import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] hi = new int[n];
        int[] arc = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hi[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arc[i] = Integer.parseInt(st.nextToken());
            if (map.containsKey(arc[i])) {
                map.put(arc[i], map.get(arc[i]) + 1);
            } else {
                map.put(arc[i], 1);
            }
        }

        Arrays.sort(arc);

        long hiWin = 0;
        long arcWin = 0;
        long draw = 0;

        for (int i = 0; i < n; i++) {
            int index = LowerBound(arc, hi[i]);

            if (index >= m) {
                hiWin += m;
                continue;
            }

            if (arc[index] == hi[i]) {
                int targetInMap = map.get(hi[i]);
                if (targetInMap == 1) {
                    arcWin += (m - index - 1);
                    draw++;
                    hiWin += index;
                } else {
                    arcWin += (m - (index + targetInMap));
                    draw += targetInMap;
                    hiWin += index;
                }
            } else {
                hiWin += index;
                arcWin += m - index;
            }
        }
        System.out.println(hiWin + " " + arcWin + " " + draw);
    }

    public static int LowerBound(int[] arr, int target) {
        int l = 0;
        int r = arr.length;
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}