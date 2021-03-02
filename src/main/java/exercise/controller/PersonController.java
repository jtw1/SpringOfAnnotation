package exercise.controller;

import exercise.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @date 2021/1/17-16:01
 */
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;
}
