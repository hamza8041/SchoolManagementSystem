package schoolmanagement.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolmanagement.dao.ClassroomRepository;
import schoolmanagement.dtos.Classroomdto;
import schoolmanagement.models.Classroom;
@Service
public class ClassroomService implements GenericService<Classroomdto> {

	@Autowired
	ClassroomRepository CR;
	
	@Autowired
	ModelMapper modelmapper;
	
	
	public Classroom dtotoclass(Classroomdto cdto)
	{
		Classroom C=this.modelmapper.map(cdto, Classroom.class);
		return C;
	}
	
	public Classroomdto classtodto(Classroom C)
	{
		Classroomdto cdto=this.modelmapper.map(C, Classroomdto.class);
		return cdto;
	}
	
	
	
	@Override
	public Classroomdto create(Classroomdto C) {
	
		
		Classroom C1=this.dtotoclass(C);
		Classroom C2=this.CR.save(C1);
		
		
		return this.classtodto(C2);
		
	}

	@Override
	public Classroomdto update(Classroomdto C, int id) {
		
		Classroom C1=this.dtotoclass(C);
		
		C1.setClassName(C.getClassName());
		
		C1.setStudentCount(C.getStudentCount());
		
	Classroom classroom=this.CR.save(C1);
		
	
		
		
		return this.classtodto(classroom);
		
	}

	@Override
	public void delete(int id) {
		
		Classroom C1=this.CR.findById(id).get();
		this.CR.delete(C1);
		
		
		
	}

	@Override
	public Classroomdto getbyId(int id) {
		
		Classroom C1=this.CR.findById(id).get();
		
		
		
		return this.classtodto(C1);
		
		
	}
	

}
