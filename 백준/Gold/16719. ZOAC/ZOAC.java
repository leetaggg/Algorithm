import java.io.*;
import java.util.*;

public class Main {

	private static String input;
	static StringBuilder sb = new StringBuilder();
	static int size;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();
		size = input.length();
		isVisited = new boolean[size];
		recu(0, size);
		
		System.out.println(sb.toString());
	}//main 끝
	
	public static void recu(int left, int right) {
		
		//기저조건
		if(left == right) {
			return;
		}
		
		//찾고 - 오/왼 (recu(): 범위 지정해줘야해) 으로 가야함 
		int min = 100;
		int index = 0;
		for (int i = left; i < right; i++) {
			if(min > input.charAt(i)) {
				min = input.charAt(i);
				index = i;
			}
		}
		isVisited[index] = true;
		//답출력
		for (int i = 0; i < isVisited.length; i++) {
			if(isVisited[i]) {
				sb.append(input.charAt(i));
			}
		}
		sb.append("\n");
		recu(index+1, right);
		recu(left, index);
		
	}	

}//class끝
