package nuc.lb.location.service;

import nuc.lb.location.entity.User;

public interface IUserService {
	public String register(User u);
	public boolean login(User u);
}
