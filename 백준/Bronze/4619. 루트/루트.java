import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] inputs = br.readLine().split(" ");
			int B = Integer.parseInt(inputs[0]);
			int N = Integer.parseInt(inputs[1]);

			if (B == 0 && N == 0) {
				break;
			}

			int A = 1;
			while (true) {
				int currentPower = (int) Math.pow(A, N);
				int nextPower = (int) Math.pow(A + 1, N);

				if (currentPower == B || (currentPower < B && nextPower > B)) {
					if (Math.abs(B - currentPower) <= Math.abs(B - nextPower)) {
						System.out.println(A);
					} else {
						System.out.println(A + 1);
					}
					break;
				}

				A++;
			}
		}
	}
}
