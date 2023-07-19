import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int[] choose;
	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		visited = new boolean[n];
		choose = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0, 0);
		System.out.println(sb.toString());
		
	}
	
	public static void perm(int start, int depth) {
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				sb.append(choose[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choose[depth] = arr[i];
				perm(i, depth + 1);
				visited[i] = false;
			}
		}
	}
}
