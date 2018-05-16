package com.vistar.vetclinic.dao;
import com.vistar.vetclinic.model.Example;

import java.util.List;

public interface ExampleDao {
    public List<Example> listExample();

    public void add(Example example);

    public void update(Example example);

    public void delete(Example example);

    public Example findeExampleById(String id);
}
