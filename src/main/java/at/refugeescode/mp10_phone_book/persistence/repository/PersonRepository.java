package at.refugeescode.mp10_phone_book.persistence.repository;

import at.refugeescode.mp10_phone_book.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {

    Optional<Person> findByName(String name);
    boolean existsByName(String name);


}
