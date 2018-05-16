package com.vistar.vetclinic.dao;

import com.vistar.vetclinic.model.Pet;

import java.util.List;

public interface PetDao {
    public List<Pet> listPet();

    public void add(Pet pet);

    public void update(Pet pet);

    public void delete(Pet pet);

    public Pet findePetById(String id);
}
