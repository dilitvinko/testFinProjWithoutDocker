package testfinproj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testfinproj.entities.People;
import testfinproj.repository.PeopleRepository;
import testfinproj.service.PeopleService;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public People addPeople(People people) {
        People savedPeople = peopleRepository.saveAndFlush(people);
        return savedPeople;
    }

    @Override
    public People getOnePeople(Long id) {
        return peopleRepository.getOne(id);
    }

    @Override
    public void delete(People people) {
        peopleRepository.delete(people);
    }

    @Override
    public People editPeople(People people) {
        return peopleRepository.saveAndFlush(people);
    }

    @Override
    public List<People> getAll() {
        return peopleRepository.findAll();
    }
}
