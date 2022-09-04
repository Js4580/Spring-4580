package kg.nazi_4580.repositories;

import kg.nazi_4580.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Person findByFullName(String fullName);
}
