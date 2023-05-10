package com.carDealerProject.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.carDealerProject.entity.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
    

    @Query(value="select * from car where make = ?1", nativeQuery = true)
    public List<Car> findByMake(String make);
    
    @Query(value="select * from car where model = ?1", nativeQuery = true)
    public List<Car> findByModel(String model);
     
    @Query(value="select * from car where price BETWEEN ?1 AND ?2;", nativeQuery = true)
    public List<Car> findByPrice(double fromPrice, double toPrice);
    
    @Query(value="select * from car where DATE(dateAdded) < DATE_SUB(CURDATE(), INTERVAL 119 DAY", nativeQuery = true)
    public List<Car> findAuctionCars();
    
    @Query(value="select * from car where isSold = 0", nativeQuery = true)
    public List<Car> findCarsInInvetory();
    
    @Query(value="select * from car where isSold = 1 and dateSold BETWEEN ?1 AND ?2",nativeQuery = true)
    public List<Car> findCarsSold(LocalDate dateFrom,LocalDate dateTo);
	
	
}
