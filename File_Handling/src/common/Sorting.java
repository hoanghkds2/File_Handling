package common;

import java.util.Comparator;
import model.Person;

public class Sorting implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getSalary() > p2.getSalary()) return 1;
        if (p1.getSalary() < p2.getSalary()) return -1;
        return 0;
    }
}