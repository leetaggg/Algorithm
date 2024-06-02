import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = br.readLine().split(" ");
		int[] x = new int[10];

		for (int i = 0; i < 10; i++) {
			x[i] = Integer.parseInt(inputs[i]);
		}

		int result = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				result ^= (x[i] | x[j]);
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				for (int k = j + 1; k < 10; k++) {
					result ^= (x[i] | x[j] | x[k]);
				}
			}
		}

		System.out.println(result);
	}
}