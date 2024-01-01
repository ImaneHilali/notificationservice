package com.example.notificationservice.serviceImpl;

import com.example.notificationservice.exception.AdminNotFoundException;
import com.example.notificationservice.exception.AdminNotFoundWithEmailException;
import com.example.notificationservice.model.Admin;
import com.example.notificationservice.repository.AdminRepository;
import com.example.notificationservice.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
     }

    @Override
    public Admin getAdmin(Long id) {
        return adminRepository.findById(id).orElseThrow(
                (AdminNotFoundException::new)
        );
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepository.findByEmail(email).orElseThrow(
                (AdminNotFoundWithEmailException::new)
        );
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

}