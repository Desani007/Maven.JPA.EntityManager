package services;

import com.sun.xml.bind.v2.model.core.ID;
import entities.People;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

public interface PeopleRepository  {
    People findById(Long peopleId);

    void findAll();

    void update(Long id, String name);

    void create(String name, String age, String car);

    void delete(Long id);


}
