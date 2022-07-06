package schoolmanagement.services;

import java.util.List;

public interface GenericService<T> {
	
	
	public T create(T t);
	public T update(T t,int id);
	public void delete(int id);
	public T getbyId(int id);
	
	
	
	

}
