import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> bth = new ArrayList<>(n);

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            bth.add(new Person(name, new Date(year, month, day)));
        }

        bth.sort(Comparator.comparing(Person::getDate));

        System.out.println(bth.get(bth.size() - 1).getName());
        System.out.println(bth.get(0).getName());
    }

    static class Person{
        String name;
        Date date;

        public Person(String name, Date date){
            this.name = name;
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return date;
        }
    }
}