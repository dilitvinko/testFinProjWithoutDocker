package testfinproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testfinproj.entities.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    People findFirstById(Long id);
}
