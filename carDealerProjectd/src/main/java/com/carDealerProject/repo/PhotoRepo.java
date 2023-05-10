package com.carDealerProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carDealerProject.entity.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Integer> {
    
}
