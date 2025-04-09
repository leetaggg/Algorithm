import java.io.*;
import java.util.*;

public class Main {

	static int n, idx;
	static int[] inOrder, postOrder, preOrder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		inOrder = new int[n];
		preOrder = new int[n];
		postOrder = new int[n];


		for (int i = 0; i < n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}

		getPreOrder(0, n -1, 0, n - 1);

		StringBuilder sb = new StringBuilder();

		for (int i : preOrder) {
			sb.append(i).append(" ");
		}

		System.out.println(sb);
	}

	public static void getPreOrder(int is, int ie, int ps, int pe) {
		if (ie < is || pe < ps) return;

		preOrder[idx++] = postOrder[pe];

		int pivot = is;

		for (int i = is ; i <= ie; i++) {
			if (inOrder[i] == postOrder[pe]) {
				pivot = i;
				break;
			}
		}

		getPreOrder(is, pivot - 1, ps, ps + pivot - is - 1);
		getPreOrder(pivot + 1, ie, ps + pivot - is, pe - 1);
	}
}