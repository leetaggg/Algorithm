import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<String> adjectives = new ArrayList<>();
		List<String> nouns = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjectives.add(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			nouns.add(br.readLine());
		}

		for (String adjective : adjectives) {
			for (String noun : nouns) {
				System.out.println(adjective + " as " + noun);
			}
		}
	}
}