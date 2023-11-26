package edu.hw7.Task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectronicGradeBook implements PersonDatabase {
    private Map<Integer, Person> personListMap = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
        if (person.name().isBlank() || person.phoneNumber().isBlank() || person.address().isBlank()) {
            throw new RuntimeException();
        }
        personListMap.put(person.id(), person);
    }

    @Override
    public synchronized void delete(int id) {
        personListMap.remove(id);
    }

    @Override
    public List<Person> findByName(String name) {
        return personListMap.values().stream().filter(person -> person.name().
            equals(name)).toList();
    }

    @Override
    public List<Person> findByAddress(String address) {
        return personListMap.values().stream().filter(person -> person.address().
            equals(address)).toList();
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return personListMap.values().stream().filter(person -> person.phoneNumber().
            equals(phone)).toList();
    }
}
