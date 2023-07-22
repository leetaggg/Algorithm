import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	static int n, m, k, x;
	static int[] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		dist = new int[n+1];
		for(int i = 0; i <= n; i++) {
			map.add(new ArrayList<Integer>());
			dist[i] = -1;
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			map.get(to).add(from);
		}
		d(x);
	}
	public static void d(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		dist[start] = 0;
		while(!q.isEmpty()) {
			int to = q.poll();
			for(int i = 0; i < map.get(to).size(); i++) {
				int from = map.get(to).get(i);
				
				if(dist[from] == -1) {
					dist[from] = dist[to] + 1;
					q.add(from);
				}
			}
		}
		boolean flag = false;
		for(int i = 0; i <= n; i++) {
			if(dist[i] == k) {
				System.out.println(i);
				flag = true;
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
	}
}
