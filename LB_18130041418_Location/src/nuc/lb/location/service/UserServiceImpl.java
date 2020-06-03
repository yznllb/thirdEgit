package nuc.lb.location.service;

import nuc.lb.location.dao.IUserDao;
import nuc.lb.location.dao.UserDaoImpl;
import nuc.lb.location.entity.User;

public class UserServiceImpl implements IUserService{

	@Override
	public String register(User u) {
		
		return null;
	}
	@Override
	public boolean login(User u) {
		int id =u.getStuid();
		IUserDao dao = new UserDaoImpl();
		User u2 = null;
		u2 = dao.query(id);
		if(u2!=null){
			return true;
		}else {
		return false;
		}
	}
}
