import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = br.readLine().split(" ");
		int a = Integer.parseInt(inputs[0]);
		int b = Integer.parseInt(inputs[1]);
		int c = Integer.parseInt(inputs[2]);

		int missingNumber = 0;

		if (c == 0) {
			missingNumber = (int) Math.sqrt(a + b);
		} else if (a == 0) {
			missingNumber = c * c - b;
		} else if (b == 0) {
			missingNumber = c * c - a;
		}

		System.out.println(missingNumber);
	}
}