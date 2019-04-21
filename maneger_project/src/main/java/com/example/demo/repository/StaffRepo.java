package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Integer> {
   List<Staff> findByFirstname(String firstname);
  
}
