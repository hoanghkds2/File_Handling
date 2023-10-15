package controller;

import model.Person;
import repository.FileRepository;
import view.Menu;


public class FileController extends Menu<Person>{
     static String[] mc = {"Find person info", "Copy Text to new file", "Exit"};
    FileRepository fr;
    Person p;

    public FileController() {
        super("========== File Processing =========", mc);
        fr = new FileRepository();
        p = new Person();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: {
                System.out.println("--------- Person info ---------");
                fr.getPerson(p.getLp());
                break;
            }
            case 2: {
                System.out.println("------------- Copy text --------------");
                fr.copyWordOneTime();
                break;
            }
            case 3: {
                System.out.println("Close..");
                System.exit(0);
            }
            default: {
                System.out.println("Choose again.");
            }
        }
    }
}