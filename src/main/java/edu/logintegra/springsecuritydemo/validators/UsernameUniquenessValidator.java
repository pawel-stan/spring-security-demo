package edu.logintegra.springsecuritydemo.validators;

import edu.logintegra.springsecuritydemo.auth.PersonRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameUniquenessValidator
        implements ConstraintValidator<UniqueUsername, String> {

    private final PersonRepository personRepository;

    public UsernameUniquenessValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        // TODO: Obsługa edycji użytkownika
        return username != null && personRepository.findByUsername(username) == null;
    }
}
