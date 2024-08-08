import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= t; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int quarters = n / 25;
			n %= 25;

			int dimes = n / 10;
			n %= 10;

			int nickels = n / 5;
			n %= 5;

			int pennies = n;

			sb.append(quarters).append(" ")
				.append(dimes).append(" ")
				.append(nickels).append(" ")
				.append(pennies).append("\n");
		}

		System.out.println(sb);
	}
}
