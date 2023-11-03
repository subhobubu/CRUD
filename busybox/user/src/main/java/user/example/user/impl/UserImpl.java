package user.example.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.example.user.dao.UserDao;
import user.example.user.model.UserModel;

@Service
public class UserImpl {

	@Autowired UserDao userDatabase;
	
	public List<UserModel> getAllUserModel(){
		return userDatabase.findAll();
	}
	
	public UserModel getOne(long id) {
		return userDatabase.findById(id).orElse(null);
	}
	
	public UserModel addUser(UserModel input) {
		return userDatabase.save(input);
	}

	public UserModel editUser(UserModel input, long id) {
	    return userDatabase.findById(id)
	        .map(user -> {
	            user.setName(input.getName()); // Replace with the appropriate field that you want to edit
	            user.setEmail(input.getEmail()); // Replace with the appropriate field that you want to edit
	            // Set other fields accordingly
	            return userDatabase.save(user);
	        })
	        .orElse(null);
	}


	public void deleteuser(long id) {
		// TODO Auto-generated method stub
		 userDatabase.deleteById(id);
	}
	
	
}
