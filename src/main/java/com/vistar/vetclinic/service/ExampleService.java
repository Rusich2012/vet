package com.vistar.vetclinic.service;

import com.vistar.vetclinic.model.Example;

import java.util.List;

public interface ExampleService {
    public List<Example> listExample();

    public void add(Example example);

    public void update(Example example);

    public void delete(Example example);

    public Example findeExampleById(String id);
}
