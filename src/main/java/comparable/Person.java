package comparable;

import java.util.*;


public class Person implements Comparable<Person>{
    private final String fName;
    private final String lName;
    private final GregorianCalendar birthDay;
    private final double heigth;

    public Person(String fName, String lName, int bYear, int bMonth, int bDate, double heigth) {
        this.fName = fName;
        this.lName = lName;
        this.birthDay = new GregorianCalendar(bYear, bMonth, bDate);
        this.heigth = heigth;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s, Last Name: %s, Birthday: %s, Height: %.2f\n", fName, lName, birthDay.getTime(), heigth);
    }

    @Override
    public int compareTo(Person o) {
        int lastNameComparison = this.lName.compareTo(o.lName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        int firstNameComparison = this.fName.compareTo(o.fName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        return this.birthDay.compareTo(o.birthDay);
    }

    private double getHeigth() {
        return this.heigth;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("A", "BB", 1980, 3, 17, 1.87));
        list.add(new Person("B", "BB", 1980, 3, 8, 1.86));
        list.add(new Person("A", "AA", 1980, 3, 9, 1.67));
        list.add(new Person("A", "BB", 1980, 3, 10, 1.67));
        list.add(new Person("A", "BB", 1980, 3, 1, 1.66));
        list.add(new Person("A", "CC", 1980, 3, 1, 1.65));
        
        System.out.println(list);
        
        Collections.sort(list);
        System.out.println("\nsorted:\n" +list);


        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Double.compare(o1.getHeigth(), o2.getHeigth());
            }
        });

        System.out.println("\nsorted:\n" +list);
        
    }
}
