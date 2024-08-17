import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 0;
		while (br.readLine() != null) {
			cnt++;
		}

		System.out.println(cnt);
	}
}
