import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hset = new HashSet<String>();
		String s = br.readLine();
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j < s.length(); j++) {
				hset.add(s.substring(i, j+1));
			}
		}
		System.out.println(hset.size());
	}
}