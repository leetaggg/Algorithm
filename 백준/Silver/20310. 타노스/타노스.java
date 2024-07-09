import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();

		int cnt0 = s.length() / 2 - s.replace("0", "").length() / 2;
		int cnt1 = s.length() / 2 - s.replace("1", "").length() / 2;

		boolean[] chk = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			chk[i] = true;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (cnt1 > 0 && s.charAt(i) == '1') {
				cnt1--;
				chk[i] = false;
			}
		}

		for (int i = s.length() - 1; i >= 0; i--) {
			if (cnt0 > 0 && s.charAt(i) == '0') {
				cnt0--;
				chk[i] = false;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (chk[i]) {
				sb.append(s.charAt(i));
			}
		}

		System.out.println(sb);
	}
}
