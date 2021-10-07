package com.example.project.serviced;

import com.example.project.model.Catagory;
import com.example.project.repository.CatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CatagoryService {
    @Autowired
    private CatagoryRepository catagoryRepository;

    public List<Catagory> getAllCatagory(){
        return catagoryRepository.findAll();
    }
    public void saveCatagory(Catagory catagory) {
        catagoryRepository.save(catagory);
    }
    public Catagory getCatagoryById(int id) {
        return catagoryRepository.findById(id).get();
    }
    public void deleteCatagory(int id){
        catagoryRepository.deleteById(id);
    }
}
