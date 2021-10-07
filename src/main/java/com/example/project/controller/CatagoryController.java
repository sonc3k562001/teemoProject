package com.example.project.controller;

import com.example.project.model.Catagory;
import com.example.project.serviced.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catagoties")
public class CatagoryController {
    @Autowired
    private CatagoryService catagoryService;

    @GetMapping
    public List<Catagory> listCatagory() {
        return catagoryService.getAllCatagory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catagory> getCatagoryById(@PathVariable int id) {
        try {
            Catagory catagory = catagoryService.getCatagoryById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public void addCatagory(@RequestBody Catagory catagory) {
        catagoryService.saveCatagory(catagory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catagory> updateCatagory(@RequestBody Catagory catagory, @PathVariable int id) {
        try {
            Catagory existcatagory = catagoryService.getCatagoryById(id);
            catagoryService.saveCatagory(catagory);

            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        catagoryService.deleteCatagory(id);
    }
}
