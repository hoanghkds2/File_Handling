package dataAccess;

import common.Sorting;
import common.Validate;
import content.Notice;
import java.util.Collections;
import java.util.List;
import model.Person;

public class FileDao {

    private static FileDao instance = null;
    Validate validate = new Validate();

    public static FileDao Instance() {
        if (instance == null) {
            synchronized (FileDao.class) {
                if (instance == null) {
                    instance = new FileDao();
                }

            }
        }
        return instance;
    }

    public void getPerson(String filename, List<Person> lp) {
        lp = new Person().readFile(filename);
        if (lp.isEmpty()) {
            System.out.println(Notice.fileNotFound);
        }
        Collections.sort(lp, new Sorting());
        double salary = validate.checkDouble("Enter Money");
        String maxSalary = "-----";
        String minSalary = "-----";
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        int count = 0;
        System.out.printf("%-15s%-15s%s\n", "Name", "Address", "Money");
        for (Person p : lp) {
            if (p.getSalary() >= salary) {
                count++;
                System.out.println(view(p));
                if (max < p.getSalary()) {
                    max = p.getSalary();
                    maxSalary = p.getName();
                }
                if (min > p.getSalary()) {
                    min = p.getSalary();
                    minSalary = p.getName();
                }
            }
        }
        if (count == 0) {
            System.out.println("Not found.");
            return;
        }
        System.out.println("Max: " + maxSalary);
        System.out.println("Min: " + minSalary);
    }

    public void copyWordOneTime() {
        List<Person> lp;
        Person p = new Person();
        String source = validate.checkString("Enter source path");
        lp = p.readFile(source);
        if (lp.isEmpty()) {
            System.out.println(Notice.fileNotFound);
        }
        String destination = validate.checkString("Enter destination path");
        if (!p.writeFile(destination, lp)) {
            System.out.println(Notice.pathNotFound);
            return;
        }
        System.out.println("Copy done...");
    }

    public String view(Person p) {
        return String.format("%-15s%-15s%.1f", p.getName(), p.getAddress(), p.getSalary());
    }
}