import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) { // o1(자신) - o2 : 오름 차순 [음수, 0 : 그대로, 양수 : 교환]
				if (Math.abs(o1) == Math.abs(o2)) return Integer.compare(o1, o2);
				return Math.abs(o1) - Math.abs(o2);
			}
		});
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.offer(x);
			}
		}
	}
}