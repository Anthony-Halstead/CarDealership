package com.carDealerProject.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Auction")

public class Auction {
     // ID lets you know its an id
     @Id
     // Column maps to the same name as the column name in the database, it is case sensitive
     @Column(name = "id")
     // This will configure your id to be auto generated, now you don't need a setter for your id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
 
    @OneToMany
    @JoinColumn(name="car_id")
     private List<Car> carsInAuction;

    public Auction() {
     }
 
     public Integer getId() {
         return id;
     }
 
     public void setId(Integer id) {
         this.id = id;
     }

     public List<Car> getCarsInAuction() {
        return carsInAuction;
    }

    public void setCarsInAuction(List<Car> carsInAuction) {
        this.carsInAuction = carsInAuction;
    }

}