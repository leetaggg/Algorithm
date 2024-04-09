import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = br.readLine();
			if (s.equals("#")) {
				break;
			}

			char eng = s.substring(0, 1).charAt(0);
			String check = s.substring(2).toLowerCase();
			int cnt = 0;
			for (int i = 0; i < check.length(); i++) {
				if (check.charAt(i) == eng) {
					cnt += 1;
				}
			}
			System.out.println(eng + " " + cnt);
		}
	}
}