package com.example.eventmanagementsystem.repo;

import com.example.eventmanagementsystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event,Integer> {
      public Event findByNotice(String notice);
      public int findAllByAdminId(int id);
      public void deleteAllByNotice(String Notice);
}
