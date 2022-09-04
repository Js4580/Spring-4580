package kg.nazi_4580.util;

import kg.nazi_4580.models.Person;
import kg.nazi_4580.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Autowired

    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (peopleService.trueOrFalsePersonIsPresent(person.getFullName()).isPresent())
            errors.rejectValue("fullName","","Такое имя уже существует - прошу вас ввести другое имя");
    }
}

