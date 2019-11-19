package testfinproj.service;

import testfinproj.entities.People;

import java.util.List;

public interface PeopleService {

    People addPeople(People people);

    People getOnePeople(Long id);

    void delete(People people);

    People editPeople(People people);

    List<People> getAll();
}
