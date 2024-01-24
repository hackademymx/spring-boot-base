package com.swift.firstep.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swift.firstep.model.User;
import com.swift.firstep.repository.UserRepository;
import com.swift.firstep.request.UserRequest;
import com.swift.firstep.response.UserResponse;
import com.swift.firstep.service.CrudService;

@Service
public class CrudServiceImpl implements CrudService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<UserResponse> getAll() {
		// TODO Auto-generated method stub
		List<UserResponse> results = new ArrayList<UserResponse>();
		for(User v:repository.findAll()) {
			UserResponse r = new UserResponse();
			r.setNombre(v.getNombre());
			r.setNumeroEmpleado(v.getNumeroEmpleado());
			results.add(r);
		}
		return results;
	}

	@Override
	public UserResponse getById(Integer id) {
		// TODO Auto-generated method stub
		User v = repository.findById(id).get();
		UserResponse r = new UserResponse();
		r.setNombre(v.getNombre());
		r.setNumeroEmpleado(v.getNumeroEmpleado());
		return r;
	}

	@Override
	public UserResponse create(UserRequest uno) {
		// TODO Auto-generated method stub
		User v = new User();
		v.setNombre(uno.getNombre());
		v.setDomicilio(uno.getDomicilio());
		v.setNumeroEmpleado(null);
		User dos = repository.save(v);
		UserResponse r = new UserResponse();
		r.setNombre(dos.getNombre());
		r.setNumeroEmpleado(dos.getNumeroEmpleado());
		return r;
	}

	@Override
	public UserResponse update(Integer id, UserRequest dos) {
		// TODO Auto-generated method stub
		User v = new User();
		v.setNombre(dos.getNombre());
		v.setDomicilio(dos.getDomicilio());
		v.setNumeroEmpleado(null);
		v.setId(id);
		User uDos = repository.save(v);
		UserResponse r = new UserResponse();
		r.setNombre(uDos.getNombre());
		r.setNumeroEmpleado(uDos.getNumeroEmpleado());
		return r;
	}

	@Override
	public String delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return "Fue borrado el id: " +id;
	}

}
