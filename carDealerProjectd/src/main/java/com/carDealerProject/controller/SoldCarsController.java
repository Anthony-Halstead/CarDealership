package com.carDealerProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carDealerProject.entity.SoldCars;
import com.carDealerProject.entity.Car;
import com.carDealerProject.service.SoldCarsService;

// Denotes that this will be a RESTFul
@RestController
@RequestMapping(value="/soldCars")

public class SoldCarsController {
    // You can autowire any service you need to get the data from
    @Autowired
    SoldCarsService soldCarsService;


    @RequestMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST
    )
    // We return a ResponseEntity<Object> because the object returned may vary, could be soldCars, could be an error
    // The RequestBody is the information sent to us to process, post and put has request body, get and delete do not
    // Request body is encrypted, always send password through a post request
    public ResponseEntity<Object> create(@RequestBody SoldCars soldCars) {

        try {
            SoldCars savedSoldCars = soldCarsService.save(soldCars);
            return new ResponseEntity<Object>(savedSoldCars, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/findSoldCarsById/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findSoldCarsById(@PathVariable Integer id) {

        try {
            SoldCars foundSoldCars = soldCarsService.findById(id);
            return new ResponseEntity<Object>(foundSoldCars, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/findAll",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findAll() {

        try {
            List<SoldCars> allSoldCars = soldCarsService.findAll();
            return new ResponseEntity<Object>(allSoldCars, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/updateSoldCars",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> updateSoldCars(@RequestBody SoldCars soldCars) {

        try {
            SoldCars updateSoldCars = soldCarsService.update(soldCars);
            return new ResponseEntity<Object>(updateSoldCars, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/deleteSoldCars/{id}",
        method = RequestMethod.DELETE
    )
    public ResponseEntity<Object> deleteSoldCars(@PathVariable Integer id) {

        try {
            // 
            soldCarsService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/addCarToSoldCars/{SoldCarsId}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> addCarToSoldCars(@PathVariable Integer SoldCarsId, @RequestBody Car car) {

        try {
            SoldCars soldCars = soldCarsService.addCarToSoldCars(SoldCarsId, car);

            return new ResponseEntity<Object>(soldCars, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
