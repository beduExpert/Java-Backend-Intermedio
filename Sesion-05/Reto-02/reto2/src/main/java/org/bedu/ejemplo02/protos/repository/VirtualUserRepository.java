package org.bedu.ejemplo02.protos.repository;

import java.util.Map;

import org.bedu.ejemplo02.protos.models.LoginProto.User;

public class VirtualUserRepository {
	private Map<Integer, User> users;

	public VirtualUserRepository(Map<Integer, User> users) {
		this.users = users;
	}

	public User getUser(int id) {
		return users.get(id);
	}
}
