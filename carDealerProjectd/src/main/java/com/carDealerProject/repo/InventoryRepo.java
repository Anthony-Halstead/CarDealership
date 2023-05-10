package com.carDealerProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carDealerProject.entity.Inventory;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer>{
    
}
