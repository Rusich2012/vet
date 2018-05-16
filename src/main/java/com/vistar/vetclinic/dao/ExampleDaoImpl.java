package com.vistar.vetclinic.dao;

import com.vistar.vetclinic.model.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ExampleDaoImpl implements ExampleDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "example";
    public List<Example> listExample() {
        return mongoTemplate.findAll(Example.class, COLLECTION_NAME);
    }

    public void add(Example example) {
        if (!mongoTemplate.collectionExists(Example.class)) {
            mongoTemplate.createCollection(Example.class);
        }
        example.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(example, COLLECTION_NAME);
    }

    public void update(Example example) {
        mongoTemplate.save(example);
    }

    public void delete(Example example) {
        mongoTemplate.remove(example, COLLECTION_NAME);
    }

    public Example findeExampleById(String id) {
        return mongoTemplate.findById(id, Example.class);
    }
}
