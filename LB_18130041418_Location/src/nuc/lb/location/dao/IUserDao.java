package nuc.lb.location.dao;

import java.util.Map;

import nuc.lb.location.entity.User;

public interface IUserDao {
	public void addUser(User u);
	public Map<String,User> getUsers();
	public User query(int id);
	public boolean delete(int id);
}
