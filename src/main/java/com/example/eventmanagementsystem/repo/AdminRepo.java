package com.example.eventmanagementsystem.repo;

import com.example.eventmanagementsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

   public Admin findAdminByUsernameAndPassword(String username,String password);

}
