package com.vistar.vetclinic.dao;

import com.vistar.vetclinic.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PetDaoImpl implements PetDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "pet";

    public List<Pet> listPet() {
        return mongoTemplate.findAll(Pet.class, COLLECTION_NAME);
    }

    public void add(Pet pet) {
        if (!mongoTemplate.collectionExists(Pet.class)) {
            mongoTemplate.createCollection(Pet.class);
        }
        pet.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(pet, COLLECTION_NAME);
    }

    public void update(Pet pet) {
        mongoTemplate.save(pet);
    }

    public void delete(Pet pet) {
        mongoTemplate.remove(pet, COLLECTION_NAME);
    }

    public Pet findePetById(String id) {
        return mongoTemplate.findById(id, Pet.class);
    }
}
