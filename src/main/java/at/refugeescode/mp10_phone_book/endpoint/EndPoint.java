package at.refugeescode.mp10_phone_book.endpoint;

import at.refugeescode.mp10_phone_book.persistence.model.Person;
import at.refugeescode.mp10_phone_book.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EndPoint {


    private Person person ;
    private List<Person> contacts = new ArrayList<>();

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/contacts")
    List<Person> showContacts(){

        return contacts;
    }

    @PostMapping("/contacts")
    public void addContact(@RequestBody Person personFromARC){

        person = personFromARC;
        contacts.add(person);
        personRepository.saveAll(contacts);

    }

}
