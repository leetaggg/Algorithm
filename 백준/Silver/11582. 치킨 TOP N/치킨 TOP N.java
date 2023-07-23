import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		int k = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> sort = new ArrayList<Integer>();
		int idx = n/k;
		int temp_idx = idx;
		for(int i = 0; i < n; i+=idx) {
			ArrayList<Integer> temp = new ArrayList<Integer>(arr.subList(i, temp_idx));
			Collections.sort(temp);
			sort.addAll(temp);
			temp_idx += idx;
		}
		for(int i = 0; i < sort.size(); i++) {
			System.out.printf(String.valueOf(sort.get(i)) + " ");
		}
		
	}
}
