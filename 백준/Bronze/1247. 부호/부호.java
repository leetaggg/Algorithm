import java.io.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 3; i++) {
			int N = Integer.parseInt(br.readLine());
			BigInteger sum = BigInteger.ZERO;

			for (int j = 0; j < N; j++) {
				BigInteger num = new BigInteger(br.readLine());
				sum = sum.add(num);
			}

			if (sum.compareTo(BigInteger.ZERO) > 0) {
				System.out.println("+");
			} else if (sum.compareTo(BigInteger.ZERO) < 0) {
				System.out.println("-");
			} else {
				System.out.println("0");
			}
		}
	}
}
