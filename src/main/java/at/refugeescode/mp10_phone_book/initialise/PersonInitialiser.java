package at.refugeescode.mp10_phone_book.initialise;

import at.refugeescode.mp10_phone_book.persistence.model.Address;
import at.refugeescode.mp10_phone_book.persistence.model.Person;
import at.refugeescode.mp10_phone_book.persistence.repository.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

//@Configuration
public class PersonInitialiser {
    @Bean
    ApplicationRunner initilaiser(PersonRepository personRepository){

        return args-> {
            personRepository.deleteAll();
            List<Person> people = createPeople();
            personRepository.saveAll(people);

            personRepository.findAll()
                    .forEach(System.out::println);
        };
    }

    private List<Person> createPeople() {
        Person person1 = new Person();
        Person person2 = new Person();
        Address address1 = new Address();
        Address address2 = new Address();
        address1.setStreet("Wiener Neustadt");
        address2.setStreet("Wien");

        person1.setName("Diaa");
        person2.setName("Ammar");
        person1.setAddress(address1);
        person2.setAddress(address2);


        return Arrays.asList(person1,person2);
    }
}
