import java.io.*;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int r = Integer.parseInt(br.readLine());

		double euclideanArea = Math.PI * r * r;

		double taxiArea = 2 * r * r;

		DecimalFormat df = new DecimalFormat("0.000000");

		System.out.println(df.format(euclideanArea));
		System.out.println(df.format(taxiArea));
	}
}