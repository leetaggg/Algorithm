import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Double> temperatures = new ArrayList<>();

        while (true) {
            String line = br.readLine();
            double temp = Double.parseDouble(line);
            if (temp == 999) {
                break;
            }
            temperatures.add(temp);
        }

        for (int i = 1; i < temperatures.size(); i++) {
            double change = temperatures.get(i) - temperatures.get(i - 1);
            System.out.printf("%.2f\n", change);
        }
    }
}