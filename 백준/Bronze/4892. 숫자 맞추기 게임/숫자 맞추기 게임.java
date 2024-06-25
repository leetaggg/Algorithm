import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		int caseNumber = 1;

		while ((line = br.readLine()) != null) {
			int n0 = Integer.parseInt(line.trim());
			if (n0 == 0) {
				break;
			}

			int n1 = 3 * n0;
			boolean isOdd = (n1 % 2 != 0);
			int n2 = isOdd ? (n1 + 1) / 2 : n1 / 2;
			int n3 = 3 * n2;
			int n4 = n3 / 9;

			if (isOdd) {
				System.out.printf("%d. odd %d%n", caseNumber, n4);
			} else {
				System.out.printf("%d. even %d%n", caseNumber, n4);
			}
			caseNumber++;
		}
	}
}