package com.carDealerProject.entity;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;

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
@Table(name="soldCars")

public class SoldCars {
    

    // ID lets you know its an id
    @Id
    // Column maps to the same name as the column name in the database, it is case sensitive
    @Column(name = "id")
    // This will configure your id to be auto generated, now you don't need a setter for your id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @OneToMany
   @JoinColumn(name="car_id")
    private List<Car> pastSoldCars;  //stores car and the date it was sold

    public SoldCars() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Car> getPastSoldCars() {
        return pastSoldCars;
    }

    public void setPastSoldCars(List<Car> pastSoldCars) {
        this.pastSoldCars = pastSoldCars;
    }
    
}
