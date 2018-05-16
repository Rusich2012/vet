package com.vistar.vetclinic.service;

import com.vistar.vetclinic.dao.ExampleDao;
import com.vistar.vetclinic.model.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExampleDao exampleDao;

    public List<Example> listExample() {
        return exampleDao.listExample();
    }

    public void add(Example example) {
        exampleDao.add(example);
    }

    public void update(Example example) {
        exampleDao.update(example);
    }

    public void delete(Example example) {
        exampleDao.delete(example);
    }

    public Example findeExampleById(String id) {
        return exampleDao.findeExampleById(id);
    }
}
