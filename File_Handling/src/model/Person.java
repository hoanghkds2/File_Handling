package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Person {

    private String name;
    private String address;
    private double salary;
    List<Person> lp = new ArrayList<>();

    public Person() {
    }

    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Person> getLp() {
        return lp;
    }

    public void setLp(List<Person> lp) {
        this.lp = lp;
    }

    @Override
    public String toString() {
        return this.getName() + ";" + this.getAddress() + ";" + this.getSalary() + "\n";
    }

    public List<Person> readFile(String filename) {
        List<Person> data = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String s[] = line.split(";");
                String pname = s[0];
                String paddress = s[1];
                double psalary;
                try {
                    psalary = Double.parseDouble(s[2]);
                    if (psalary < 0) {
                        psalary = 0;
                    }
                } catch (NumberFormatException e) {
                    psalary = 0;
                }
                data.add(new Person(pname, paddress, psalary));
            }
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        return data;
    }

    public boolean writeFile(String filename, List<Person> lp) {
        try {
            FileWriter fw = new FileWriter(new File(filename));
            try (PrintWriter pw = new PrintWriter(fw)) {
                for (Person p : lp) {
                    pw.append(p.toString());
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}