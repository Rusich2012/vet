package com.vistar.vetclinic.service;

import com.vistar.vetclinic.dao.PetDao;
import com.vistar.vetclinic.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetDao petDao;

    public List<Pet> listPet() {
        return petDao.listPet();
    }

    public void add(Pet pet) {
        petDao.add(pet);
    }

    public void update(Pet pet) {
        petDao.update(pet);
    }

    public void delete(Pet pet) {
        petDao.delete(pet);
    }

    public Pet findePetById(String id) {
        return petDao.findePetById(id);
    }
}
