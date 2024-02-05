package it.domenico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.domenico.models.User;
import it.domenico.repositories.UserRepository;
import it.domenico.responses.UserSearchResponse;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur; 

	public List<User> list() {
		return ur.findAll(); 
	}

	public Long addUser (User user){
		User response = ur.save(user);	

		return response.id;
	}

	public void deleteUser(Long id){
		ur.deleteById(id);
	}

	public void updateUser(User user){
		if(!ur.existsById(user.id)){
			throw new IllegalStateException("not found");
		}
		ur.save(user); 
	}

	/**
	 * Search user by id
	 * @param id
	 * @return the User requested or a new Empty one, if cannot find any user with the given id
	 */
	public User getUser(Long id){
		return ur.findById(id).orElse(new User());
	}

	public UserSearchResponse searchByFilter(String searchFilter) {
		UserSearchResponse usr=new UserSearchResponse();

		List<User> allName=ur.findByNameSimilarities(searchFilter);
		usr.setByName(allName);

		List<User> allLast=ur.findByLastNameSimilarities(searchFilter);
		usr.setByLastName(allLast);

		return usr;
	}
}
