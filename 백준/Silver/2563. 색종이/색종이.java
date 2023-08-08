import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		boolean[][] arr = new boolean[101][101];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()); 
			int n2 = Integer.parseInt(st.nextToken());
			for(int x = n1; x < n1 + 10; x++) {
				for(int y = n2; y < n2 + 10; y++) {
					arr[x][y] = true; 
				}
			}
		}
		int result = 0;
		for(int i = 0; i < 101; i++) {
			for(int j = 0; j < 101; j++) {
				if(arr[i][j]) result++;
			}
		}
		System.out.println(result);
	}
}
