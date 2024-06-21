import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line;
		String s;
		while((line = br.readLine()) != null) {
			if(line.equals("***")) {
				break;
			}

			s = new StringBuilder(line).reverse().toString();
			System.out.println(s);
		}
	}
}