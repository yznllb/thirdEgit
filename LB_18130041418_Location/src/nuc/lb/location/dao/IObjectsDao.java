package nuc.lb.location.dao;

import java.util.Map;

import nuc.lb.location.entity.User;
import nuc.lb.location.entity.object;
//team add 222
public interface IObjectsDao {
	public boolean addObject(object o);
	public Map<String,object> getObjects();
	public Map<String,object> getObjectsByIo();
	public object query(int id);
	public boolean delete(int id);
	//public boolean addObjectInFile(object o);
}
