import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for (int i = n; i >= 0; i--) {
			// 별찍기
			for (int j = 0; j < i ; j++) {
				sb.append("*");
			}
			//빈칸 찍기
			for (int j = 0; j < n-i; j++) {
				sb.append("");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
