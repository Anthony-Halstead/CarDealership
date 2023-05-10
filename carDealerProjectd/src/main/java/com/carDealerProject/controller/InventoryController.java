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

import com.carDealerProject.entity.Inventory;
import com.carDealerProject.entity.Car;
import com.carDealerProject.service.InventoryService;

// Denotes that this will be a RESTFul
@RestController
@RequestMapping(value="/inventory")
@CrossOrigin("*")

public class InventoryController {
     // You can autowire any service you need to get the data from
     @Autowired
     InventoryService InventoryService;
 
 
     @RequestMapping(
             value = "/create",
             consumes = MediaType.APPLICATION_JSON_VALUE,
             produces = MediaType.APPLICATION_JSON_VALUE,
             method = RequestMethod.POST
     )
     // We return a ResponseEntity<Object> because the object returned may vary, could be Inventory, could be an error
     // The RequestBody is the information sent to us to process, post and put has request body, get and delete do not
     // Request body is encrypted, always send password through a post request
     public ResponseEntity<Object> create(@RequestBody Inventory Inventory) {
 
         try {
             Inventory savedInventory = InventoryService.save(Inventory);
             return new ResponseEntity<Object>(savedInventory, HttpStatus.CREATED);
         } catch (Exception e) {
             System.out.println(e);
             return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
         } catch (Error e) {
             System.out.println(e);
             return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
         }
 
     }
 
     @RequestMapping(
         value="/findInventoryById/{id}",
         produces = MediaType.APPLICATION_JSON_VALUE,
         method = RequestMethod.GET
     )
     public ResponseEntity<Object> findInventoryById(@PathVariable Integer id) {
 
         try {
             Inventory foundInventory = InventoryService.findById(id);
             return new ResponseEntity<Object>(foundInventory, HttpStatus.OK);
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
             List<Inventory> allInventory = InventoryService.findAll();
             return new ResponseEntity<Object>(allInventory, HttpStatus.OK);
         } catch (Exception e) {
             System.out.println(e);
             return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
         } catch (Error e) {
             System.out.println(e);
             return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
         }
 
     }
 
     @RequestMapping(
         value="/updateInventory",
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE,
         method = RequestMethod.POST
     )
     public ResponseEntity<Object> updateInventory(@RequestBody Inventory Inventory) {
 
         try {
             Inventory updatdInventory = InventoryService.update(Inventory);
             return new ResponseEntity<Object>(updatdInventory, HttpStatus.OK);
         } catch (Exception e) {
             System.out.println(e);
             return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
         } catch (Error e) {
             System.out.println(e);
             return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
         }
 
     }
 
     @RequestMapping(
         value="/deleteInventory/{id}",
         method = RequestMethod.DELETE
     )
     public ResponseEntity<Object> deleteInventory(@PathVariable Integer id) {
 
         try {
             // 
             InventoryService.deleteById(id);
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
         value="/addCarToInventory/{InventoryId}",
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE,
         method = RequestMethod.POST
     )
     public ResponseEntity<Object> addCarToInventory(@PathVariable Integer InventoryId, @RequestBody Car car) {
 
         try {
             Inventory Inventory = InventoryService.addCarToInventory(InventoryId, car);
 
             return new ResponseEntity<Object>(Inventory, HttpStatus.OK);
         } catch (Exception e) {
             System.out.println(e);
             return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
         } catch (Error e) {
             System.out.println(e);
             return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
         }
 
     }
}
