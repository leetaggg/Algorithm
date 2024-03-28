import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

		int temp = Integer.parseInt(br.readLine());

		for (int i = 1; i < n ; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}

		int cnt = 0;

		while (!q.isEmpty()){
			int num = q.poll();
			if(temp <= num ){
				cnt++;
				temp++;
				q.add(--num);
			}
		}

		System.out.println(cnt);
	}
}