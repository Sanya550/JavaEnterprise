package com.example.hw5.service;


import com.example.hw5.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonService {

@GetMapping("/person/read")
@ResponseBody
public List<Person> read() {
        List<Person> personList = new ArrayList<>();
    Person person = new Person();
        person.setId(5);
        person.setName("Sasha");
        person.setSurname("Pyvovar");
        personList.add(person);
        return personList;
        }

    @PostMapping("/person/create")
    @ResponseBody
    public boolean create(Person person) {
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        if (personList.contains(person)) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/person/update")
    @ResponseBody
    public boolean update(Person neew) {
        List<Person> personList = new ArrayList<>();
        Person old = new Person();
        old.setId(7);
        old.setName("Sasha");
        old.setSurname("Pyvovar");
        personList.add(old);
        personList.remove(old);
        personList.add(neew);
        if (personList.contains(neew) || (!personList.contains(old))) {
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/person/delete")
    @ResponseBody
    public boolean delete(Person person) {
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.remove(person);
        if (!personList.contains(person)) {
            return true;
        } else {
            return false;
        }
    }
}
