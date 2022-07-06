package schoolmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;

import schoolmanagement.models.Department;

public class Customdeptimpl implements Customdept {


	@Override
	public Department findbyName(String name) {
		Department D=new Department();
		D.setDeptName(name);
		
		return D;
		
	}

}
