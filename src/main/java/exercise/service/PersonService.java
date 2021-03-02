package exercise.service;

import exercise.Dao.PersonDao;
import exercise.controller.PersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @date 2021/1/17-16:00
 */
@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;

    public void print(){
        System.out.println(personDao);
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + personDao +
                '}';
    }
}
