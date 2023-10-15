package repository;

import java.util.List;
import model.Person;


public interface IFile {

    void copyWordOneTime();

    void getPerson(List<Person> lp);

}