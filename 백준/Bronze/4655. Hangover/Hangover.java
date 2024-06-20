import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = br.readLine()) != null) {
			double c = Double.parseDouble(line.trim());

			if (c == 0.00) {
				break;
			}

			int cards = 0;
			double overhang = 0.0;

			while (overhang < c) {
				cards++;
				overhang += 1.0 / (cards + 1);
			}

			System.out.printf("%d card(s)%n", cards);
		}
	}
}