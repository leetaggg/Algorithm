import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		TreeSet<Integer> numbers = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			numbers.add(number);
		}

		for (int number : numbers) {
			System.out.println(number);
		}

	}
}