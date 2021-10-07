package com.example.project.repository;

import com.example.project.model.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<Catagory, Integer> {
}
