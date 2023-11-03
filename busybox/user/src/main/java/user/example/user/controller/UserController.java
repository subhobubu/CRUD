package user.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import user.example.user.impl.UserImpl;
import user.example.user.model.UserModel;

@RestController
public class UserController {

	@Autowired UserImpl userImpl;
	
	@GetMapping("/hello")
	public String methodOne() {
		return "hello i am subhajit";
	}
	
	@GetMapping("/getAllUserInfo")
	public List<UserModel> methodTwo() {
		return userImpl.getAllUserModel();
	}
	
	@GetMapping("/getoneuser/{id}")
	public UserModel getOneUser(@PathVariable long id) {
		return userImpl.getOne(id);
	}

	@PostMapping("/adduser")
	public UserModel addUser(@RequestBody UserModel userinput) {
		return userImpl.addUser(userinput);
	}
	@PutMapping("edit/{id}")
	public UserModel editUser(@RequestBody UserModel input, @PathVariable long id) {
		return userImpl.editUser(input,id);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		userImpl.deleteuser(id);
		return "DELETED USER "+ id;
	}
}
