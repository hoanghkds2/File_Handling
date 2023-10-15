package repository;

import common.Validate;
import dataAccess.FileDao;
import java.util.List;
import model.Person;

/**
 *
 * @author ASUS
 */
public class FileRepository implements IFile {
    Validate validate = new Validate();
    
    @Override
    public void getPerson(List<Person> lp){
        String source = validate.checkString("Enter source");
        FileDao.Instance().getPerson(source, lp);
    }
    
    @Override
    public void copyWordOneTime(){
        FileDao.Instance().copyWordOneTime();
    }
}