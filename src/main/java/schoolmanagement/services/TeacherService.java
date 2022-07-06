package schoolmanagement.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolmanagement.dao.TeacherRepository;
import schoolmanagement.dtos.Departmentdto;
import schoolmanagement.dtos.Teacherdto;
import schoolmanagement.models.Department;
import schoolmanagement.models.Teacher;

@Service
public class TeacherService implements GenericService<Teacherdto> {

	 @Autowired
	TeacherRepository TR;
	 
	 
	 @Autowired
	 ModelMapper modelmapper;
	 
	 
	    public Teacher dtototeacher(Teacherdto td)
		{
			
			Teacher T=this.modelmapper.map(td, Teacher.class);
			return T;
			
			
		}
		
		public Teacherdto teachertodto(Teacher T)
		{
			
			
			Teacherdto td=this.modelmapper.map(T, Teacherdto.class);
			return td;
		}
	
	@Override
	public Teacherdto create(Teacherdto td) {
		
		Teacher T=this.dtototeacher(td);
		
		Teacher T1=this.TR.save(T);
		
		return this.teachertodto(T1);
	}

	@Override
	public Teacherdto update(Teacherdto td, int id) {
		
		Teacher T=this.dtototeacher(td);
		
		Teacher T1=this.TR.findById(id).get();
		
		T1.setFirstName(td.getFirstName());
		T1.setLastName(td.getLastName());
		T1.setEmail(td.getEmail());
		
		Teacher updteacher=this.TR.save(T1);
		
		return this.teachertodto(updteacher);
		
	}

	@Override
	public void delete(int id) {
		
		
		Teacher T1=this.TR.findById(id).get();
		this.TR.delete(T1);
		
		
		
		
	}

	@Override
	public Teacherdto getbyId(int id) {
		
		Teacher T1=this.TR.findById(id).get();
		
		
		return this.teachertodto(T1);
		
	
	}
	

}
