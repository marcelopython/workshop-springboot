package com.estudo.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.estudo.curso.entities.User;

import com.estudo.curso.repositories.UserRepository;
import com.estudo.curso.services.exceptions.DatabaseException;
import com.estudo.curso.services.exceptions.ResourceNotFoundException;

// Register injection
@Service
public class UserServices {

	// does dependency injection
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		
		try {
			repository.deleteById(id);
			
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	
	public User update(Long id, User user) {
		// prepara o objeto monitorado para depois dazer alguma operação no banco de dados 
		User entity = repository.getReferenceById(id);
		
		updateData(entity, user);
		
		return repository.save(entity);
		
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
	
	
	
}
