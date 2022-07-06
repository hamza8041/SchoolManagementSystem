package schoolmanagement.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolmanagement.dao.Customdept;
import schoolmanagement.dao.DepartmentRepository;
import schoolmanagement.dtos.Departmentdto;
import schoolmanagement.models.Department;
@Service
public class DepartmentService implements GenericService<Departmentdto> {
	
	@Autowired
	DepartmentRepository DR;
	
	@Autowired
	ModelMapper modelmapper;
	
	
	
	
	
	
	
	public Department dtotodept(Departmentdto deptdto)
	{
		Department dept=this.modelmapper.map(deptdto, Department.class);
		return dept;
		
		
	}
	
	public Departmentdto depttodto(Department dept)
	{
		Departmentdto deptdto=this.modelmapper.map(dept, Departmentdto.class);
		return deptdto;
	}
	
	
	

	@Override
	public Departmentdto create(Departmentdto D) {
		
	
		Department dept=this.dtotodept(D);
		Department D1=this.DR.save(dept);
		
		return this.depttodto(D1);
	}

	@Override
	public Departmentdto update(Departmentdto D, int id) {
		
		
		Department dept=this.dtotodept(D);
		
		Department D1=this.DR.findById(id).get();
		
		
		
		D1.setDeptName(dept.getDeptName());
		
		D1.setHeadOfDepartment(dept.getHeadOfDepartment());
		
		
		
		
		Department upddept=this.DR.save(D1);
		
		
		
		
		return this.depttodto(upddept);
		
	
	}

	@Override
	public void delete(int id) {
		
		
		Department D1=this.DR.findById(id).get();
		this.DR.delete(D1);
		
	}

	@Override
	public Departmentdto getbyId(int id) {
		Department D1=this.DR.findById(id).get();
		
		return this.depttodto(D1);
		
	}

	
}
