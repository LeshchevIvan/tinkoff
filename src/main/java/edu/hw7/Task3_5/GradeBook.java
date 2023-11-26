package edu.hw7.Task3_5;

import edu.hw7.Task3.PersonDatabase;
import edu.hw7.Task3.Person;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GradeBook implements PersonDatabase {
    private Map<Integer, Person> personListMap = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override
    public synchronized void add(Person person) {
        if (person.name().isBlank() || person.phoneNumber().isBlank() || person.address().isBlank()) {
            throw new RuntimeException();
        }
        lock.writeLock().lock();
        try {
            personListMap.put(person.id(), person);
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public synchronized void delete(int id) {
        lock.writeLock().lock();
        try {
            personListMap.remove(id);
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return personListMap.values().stream().filter(person -> person.name().
                equals(name)).toList();
        } finally {
            lock.readLock().unlock();
        }

    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return personListMap.values().stream().filter(person -> person.address().
                equals(address)).toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return personListMap.values().stream().filter(person -> person.phoneNumber().
                equals(phone)).toList();
        } finally {
            lock.readLock().unlock();
        }

    }
}
