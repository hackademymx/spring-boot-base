package com.swift.firstep.service;

import java.util.List;

import com.swift.firstep.request.UserRequest;
import com.swift.firstep.response.UserResponse;

public interface CrudService {

	List<UserResponse> getAll();

	UserResponse getById(Integer id);

	UserResponse create(UserRequest uno);

	UserResponse update(Integer id, UserRequest dos);

	String delete(Integer id);

}
