package com.swift.firstep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swift.firstep.request.UserRequest;
import com.swift.firstep.response.UserResponse;
import com.swift.firstep.service.CrudService;

@RestController
@RequestMapping("/crud")
public class Crud {

	@Autowired
	private CrudService service;
	
	@GetMapping("/{id}/hello")
	public String helloworld(@PathVariable String id) {
		return "Hello "+id;
	}
	
	@GetMapping("/")
	public List<UserResponse> all() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public UserResponse getId(@PathVariable Integer id) {
		return service.getById(id);
	}
	@PostMapping("/")
	public UserResponse test1(@RequestBody UserRequest uno) {
		return service.create(uno);
	}
	
	@PatchMapping("/{id}")
	public UserResponse testP1(@PathVariable Integer id, @RequestBody UserRequest dos) {
		return service.update(id, dos);
	}
	
	@PutMapping("/{id}")
	public UserResponse testP2(@PathVariable Integer id, @RequestBody UserRequest uno) {
		return service.update(id, uno);
	}
	
	@DeleteMapping("/{id}")
	public String testD(@PathVariable Integer id) {
		return service.delete(id);
	}
}
