import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numberOfTestCases = Integer.parseInt(br.readLine());

		for (int i = 0; i < numberOfTestCases; i++) {
			String line = br.readLine();
			String reversedLine = new StringBuilder(line).reverse().toString();
			System.out.println(reversedLine);
		}
	}
}