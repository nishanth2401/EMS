//package com.excelr.mainpackage.service;
//
//import com.excelr.mainpackage.model.Admin;
//import com.excelr.mainpackage.repository.AdminRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AdminService {
//    @Autowired
//    private AdminRepository adminRepository;
//
//    public Optional<Admin> findAdminByUsername(String username) {
//        return adminRepository.findByUsername(username);
//    }
//}