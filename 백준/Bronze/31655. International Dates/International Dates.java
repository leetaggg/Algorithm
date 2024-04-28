import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String dateInput = br.readLine();
		System.out.println(determineDateFormat(dateInput));
	}

	public static String determineDateFormat(String date) {
		String[] parts = date.split("/");
		int AA = Integer.parseInt(parts[0]);
		int BB = Integer.parseInt(parts[1]);

		boolean AAIsMonth = 1 <= AA && AA <= 12;
		boolean BBIsMonth = 1 <= BB && BB <= 12;

		if (AAIsMonth && !BBIsMonth) {
			return "US";
		} else if (BBIsMonth && !AAIsMonth) {
			return "EU";
		} else {
			return "either";
		}
	}
}