package com.example.project.controller;

import com.example.project.exception.ResourceNotFoundException;
import com.example.project.repository.AdminRootRepository;
import com.example.project.model.AdminRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/project/adminroot")
public class AdminRootController {

    private final AdminRootRepository adminRootRepository;

    @Autowired
    public AdminRootController( AdminRootRepository adminRootRepository) {
                this.adminRootRepository = adminRootRepository;
    }

    @PostMapping("/adminroot")
        public AdminRoot createAdmin(@Valid @RequestBody AdminRoot adminRoot) {

        return adminRootRepository.save(adminRoot);
    }

    @PutMapping("/adminroot")
        public AdminRoot updateAdmin(@PathVariable (value = "username") String username, @Valid @RequestBody AdminRoot adminRootDetails) {
        AdminRoot adminRoot = adminRootRepository.findById(username).orElseThrow(()-> new ResourceNotFoundException("Admin", "username", username)) ;
        adminRoot.setUsername(adminRootDetails.getUsername());
        adminRoot.setPassword(adminRootDetails.getPassword());

        AdminRoot updateAdmin = adminRootRepository.save(adminRoot);
        return updateAdmin;
    }

    @DeleteMapping("/adminroot/{username}")
    public ResponseEntity<?> delete(@PathVariable(value = "username") String username) {
        AdminRoot adminRoot = adminRootRepository.findById(username).orElseThrow(() -> new ResourceNotFoundException("Admin", "username", username));

        adminRootRepository.delete(adminRoot);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/adminroot")
    public List<AdminRoot> getAllAdmin() {
        return adminRootRepository.findAll();
    }
}
