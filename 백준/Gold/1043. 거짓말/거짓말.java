import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int truePersonCnt = Integer.parseInt(st.nextToken());

		if (truePersonCnt == 0) {
			System.out.println(m);
			return;
		}


		Set<Integer> truePersons = new HashSet<>();
		for (int i = 0; i < truePersonCnt; i++) {
			truePersons.add(Integer.parseInt(st.nextToken()));
		}

		Set<Integer> trueGroups = new HashSet<>();

		List<List<Integer>> parties = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			parties.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int partyCnt = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			if (partyCnt == 1) {
				parties.get(i).add(x);
				continue;
			}

			for (int j = 1; j < partyCnt; j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
				parties.get(i).add(y);
			}
		}

		for (int person : truePersons) {
			trueGroups.add(find(person));
		}

		int result = 0;
		boolean flag;
		for (List<Integer> party : parties) {
			flag = false;
			for (int person : party) {
				if (trueGroups.contains(find(person))) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				result++;
			}
		}

		System.out.println(result);
	}

	public static void union(int x, int y) {
		parent[find(x)] = find(y);
	}

	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}
}