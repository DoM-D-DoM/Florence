package it.domenico.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.domenico.models.User;
import it.domenico.responses.UserSearchResponse;
import it.domenico.services.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(originPatterns = "*")
@Validated
public class UserController {

	@Autowired
	private UserService us; 

	@GetMapping("")
	public ResponseEntity<List<User>> list(){
		List<User> l = us.list();

		return ResponseEntity.ok().body(l);
	}

	@PostMapping("")
	public ResponseEntity<Long> addUser(@RequestBody @Valid User user){
		Long l = us.addUser(user);

		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable @NotNull Long id){
		us.deleteUser(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("")
	public ResponseEntity<Void> updateUser(@RequestBody @Valid User user){
		us.updateUser(user);
		return ResponseEntity.ok().build();
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUser(@PathVariable @NotNull Long id){
		User user = us.getUser(id); 

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("search/{searchFilter}")
	public ResponseEntity<UserSearchResponse> searchByFilter (@PathVariable @NotEmpty String searchFilter){
		UserSearchResponse usr = us.searchByFilter(searchFilter); 
		return new ResponseEntity<>(usr, HttpStatus.OK);
	}

}
