package common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validate {

    public String checkString(String s) {
        String str = "";
        while (str.isBlank() || str.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print(s + ": ");
            str = sc.nextLine();
            return str;
        }
        System.err.println("Please input something.");
        return "";
    }

    public double checkDouble(String s) {
        double a = -1;
        while (a < 0) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(s + ": ");
                a = sc.nextDouble();
                return a;
            } catch (InputMismatchException e) {
                System.err.println("Enter a number");
            }
        }
        return -1;
    }
}