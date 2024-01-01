package com.example.notificationservice.service;

import com.example.notificationservice.model.Admin;

import java.util.List;

public interface AdminService {
    Admin getAdmin(Long id);

    Admin getAdminByEmail(String email);

    List<Admin> getAllAdmins();


}
