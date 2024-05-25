import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] numbers = new int[3];
		for (int i = 0; i < 3; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		int a = numbers[0];
		int b = numbers[1];
		int c = numbers[2];

		int d1 = b - a;
		int d2 = c - b;

		if (d1 == d2) {
			System.out.println(c + d1);
		} else if (d1 > d2) {
			System.out.println(a + d2);
		} else {
			System.out.println(b + d1);
		}
	}
}