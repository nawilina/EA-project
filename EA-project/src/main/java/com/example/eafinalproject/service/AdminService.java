package com.example.eafinalproject.service;

import com.example.eafinalproject.model.Admin;
import com.example.eafinalproject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(String id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.orElse(null);
    }

    public Admin updateAdmins(Admin admin, String id) {
        Optional<Admin> existingAdmin = adminRepository.findById(id);
        if (existingAdmin.isPresent()) {
            admin.setId(existingAdmin.get().getId());
            return adminRepository.save(admin);
        }
        return null;
    }

    public void deleteAdminById(String id) {
        adminRepository.deleteById(id);
    }
}

