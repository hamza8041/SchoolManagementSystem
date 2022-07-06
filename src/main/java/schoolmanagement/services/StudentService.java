package schoolmanagement.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolmanagement.dao.StudentRepository;
import schoolmanagement.dtos.Departmentdto;
import schoolmanagement.dtos.Studentdto;
import schoolmanagement.models.Department;
import schoolmanagement.models.Student;

@Service
public class StudentService implements GenericService<Studentdto> {
	
	
	@Autowired
	StudentRepository SR;

	
	@Autowired
	ModelMapper modelmapper;
	
	
	public Student dtotostudent(Studentdto sdto)
	{
		
		Student S=this.modelmapper.map(sdto, Student.class);
		return S;
		
		
	}
	
	public Studentdto stutodto(Student S)
	{
		
		Studentdto sdto=this.modelmapper.map(S, Studentdto.class);
		return sdto;
	}
	
	
	
	@Override
	public Studentdto create(Studentdto sdto) {
		
	
	Student S=this.dtotostudent(sdto);
	Student S1=this.SR.save(S);
	
	
		
		return this.stutodto(S1);
		
	}

	@Override
	public Studentdto update(Studentdto sdto, int id) {
		
		
		Student S=this.dtotostudent(sdto);
		
		
		Student S1=this.SR.findById(id).get();
		
		S1.setFirstName(S.getFirstName());
		S1.setLastName(S.getLastName());
		S1.setEmail(S.getEmail());
		S1.setClassroom(S.getClassroom());
		S1.setAddress(S.getAddress());
		S1.setDepartment(S.getDepartment());
		
		
		Student updstudent=this.SR.save(S1);
		
		
		
		
		return this.stutodto(updstudent);
	}



	@Override
	public void delete(int id) {
		
		Student S1=this.SR.findById(id).get();
		this.SR.delete(S1);
		
		
		
		
		
	}

	@Override
	public Studentdto getbyId(int id) {
		Student S1=this.SR.findById(id).get();
		
		return this.stutodto(S1);
		
	}
	

}
