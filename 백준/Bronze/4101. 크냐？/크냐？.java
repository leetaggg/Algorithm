import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true){
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(a == 0 && b == 0){
				break;
			}

			if(a > b){
				sb.append("Yes").append("\n");
			}else{
				sb.append("No").append("\n");
			}
		}
		System.out.println(sb);
	}
}