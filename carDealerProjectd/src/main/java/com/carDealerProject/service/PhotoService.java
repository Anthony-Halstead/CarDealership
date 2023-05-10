package com.carDealerProject.service;

import com.carDealerProject.repo.PhotoRepo;
import com.carDealerProject.entity.Car;
import com.carDealerProject.entity.Photo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class PhotoService {
    @Autowired
    private PhotoRepo photoRepo;

    public Photo save(Photo photo) {
		// Another predefined function, used to save your objects
		// Id will be autogenerated and will come back in the return after its saved

	    return photoRepo.save(photo);
	}
	
	public Photo update(Photo photo) throws Exception {
		// Another predefined function, used to save your objects
		// Id will be autogenerated and will come back in the return after its saved

        if(photo.getId() != null) {
	        return photoRepo.save(photo);
        }

        throw new Exception("Object does not exist! id not present");
	}
    
    public Photo findById(Integer photoId) throws Error {
        
    	// Find by is another predefined repo function, you can always find by the primary key
    	// when you use findById, its good practice to use the isPresent in an if check first
    	// It will tell you if a object was actually found, with true or false values, true if found, false is not
    	// It will always return an Optional Object, the Photo will be there if found, null if not
    	// If found, give the object back with a .get() to grab it off the Optional object
    	
        if(photoRepo.findById(photoId).isPresent()) {
            return photoRepo.findById(photoId).get();
        }
        
        // if Photo is not present, throw error so front end can handle it
        throw new Error("No Photo id present, Photo not found, send an id billy, dumbass");
        
    }

	public List<Photo> findAll() {
		return photoRepo.findAll();
	}

    public void deleteById(Integer id) {
	    photoRepo.deleteById(id);
	}

    public List<Photo> findByCar(Integer carID){
        return photoRepo.findByCarID(carID);
    }
}
