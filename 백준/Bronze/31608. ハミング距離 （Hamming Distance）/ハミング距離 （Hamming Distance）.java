import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());

		String s = br.readLine().trim();
		String t = br.readLine().trim();

		int hammingDistance = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				hammingDistance++;
			}
		}

		System.out.println(hammingDistance);
	}
}