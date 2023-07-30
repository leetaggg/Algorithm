import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		recursion(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}

	public static void recursion(int x, int y, int size) {
		if (isCheck(x, y, size)) {
			if (arr[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		int nextSize = size / 2;
		recursion(x, y, nextSize);
		recursion(x, y + nextSize, nextSize);
		recursion(x + nextSize, y, nextSize);
		recursion(x + nextSize, y + nextSize, nextSize);

	}

	public static boolean isCheck(int x, int y, int size) {
		int check = arr[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != check) {
					return false;
				}
			}
		}
		return true;
	}
}
