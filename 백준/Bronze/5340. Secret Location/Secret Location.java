import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] lines = new String[6];
		for (int i = 0; i < 6; i++) {
			lines[i] = br.readLine();
		}

		int[] lengths = new int[6];
		for (int i = 0; i < 6; i++) {
			lengths[i] = lines[i].trim().length();
		}

		System.out.printf("Latitude %d:%d:%d%n", lengths[0], lengths[1], lengths[2]);
		System.out.printf("Longitude %d:%d:%d%n", lengths[3], lengths[4], lengths[5]);
	}
}