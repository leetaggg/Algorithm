import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < t; i++) {
			String s = br.readLine().trim();
			int countA = 0;
			int countB = 0;

			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'a') {
					countA++;
				} else if (s.charAt(j) == 'b') {
					countB++;
				}
			}

			System.out.println(Math.min(countA, countB));
		}
	}
}