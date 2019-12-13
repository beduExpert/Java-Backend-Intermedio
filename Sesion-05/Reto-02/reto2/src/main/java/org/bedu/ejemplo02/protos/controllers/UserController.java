package org.bedu.ejemplo02.protos.controllers;

import org.bedu.ejemplo02.protos.models.LoginProto;
import org.bedu.ejemplo02.protos.repository.VirtualUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private VirtualUserRepository userRepository;

	@RequestMapping("/user/{id}")
	LoginProto.User user(@PathVariable Integer id) {
		return this.userRepository.getUser(id);
	}
}
