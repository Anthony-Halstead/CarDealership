package com.carDealerProject.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carDealerProject.entity.Auction;

@Repository
public interface AuctionRepo extends JpaRepository<Auction, Integer>{
    
}

