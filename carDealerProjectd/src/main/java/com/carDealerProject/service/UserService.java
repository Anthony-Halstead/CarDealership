package com.carDealerProject.service;

import com.carDealerProject.repo.UserRepo;
import com.carDealerProject.entity.Car;
import com.carDealerProject.entity.User;

import java.util.List;


import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
    // YOU ONLY AUTOWIRE YOUR REPO OF YOUR OBJECT IN YOUR SERVIES!!!
	// NOTHING ELSE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Autowired
    private UserRepo userRepo;


    public User save(User user) {
		// Another predefined function, used to save your objects
		// Id will be autogenerated and will come back in the return after its saved

	    return userRepo.save(user);
	}
	
	public User update(User user) throws Exception {
		// Another predefined function, used to save your objects
		// Id will be autogenerated and will come back in the return after its saved

        if(user.getId() != null) {
	        return userRepo.save(user);
        }

        throw new AccountNotFoundException("Account does not exist! id not present");
	}
    
    public User findById(Integer userId) throws Error {
        
    	// Find by is another predefined repo function, you can always find by the primary key
    	// when you use findById, its good practice to use the isPresent in an if check first
    	// It will tell you if a object was actually found, with true or false values, true if found, false is not
    	// It will always return an Optional Object, the user will be there if found, null if not
    	// If found, give the object back with a .get() to grab it off the Optional object
    	
        if(userRepo.findById(userId).isPresent()) {
            return userRepo.findById(userId).get();
        }
        
        // if user is not present, throw error so front end can handle it
        throw new Error("No user id present, User not found, send an id billy, dumbass");
        
    }

	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

    public User signIn(User user) throws Exception {
		
		User loggedInUser = userRepo.signIn(user.getUserName(), user.getPassword());
		if(loggedInUser == null) {
			throw new Exception("User was not found");
		}

		return loggedInUser;

	}

    public void deleteById(Integer id) {
	 
        userRepo.deleteById(id);
	}

    public User buyCar(Integer userId, Car car){
        User user = userRepo.findById(userId).get();
        user.getUserCars().add(car);
        return userRepo.save(user);
    }
}