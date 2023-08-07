import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	private static Integer[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(st.nextToken());
		arr = new Integer[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 내림차순인 순간 찾기
		int nx = -1;
		for (int i = n - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				nx = i-1;
				break;
			}
		} // end for
		if (nx == -1) {
			sb.append(-1).append(" ");
			System.out.println(sb.toString());

			return;
		}
		int ny = 0;
		int max = Integer.MIN_VALUE;
		for (int i = n - 1; i > nx; i--) {
			// arr[nx] 보다 작으면서 가장 큰값
			if (arr[i] < arr[nx] && max < Math.max(arr[i], max)) {
				max = Math.max(arr[i], max);
				ny = i;
			}

		}
		swap(nx, ny);

		Comparator<Integer> cp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		};
		
		Arrays.sort(arr, nx+1, n, cp);
		
		for (Integer num : arr) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb.toString());
	}

	private static void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;

	}

}
