package schoolmanagement.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import schoolmanagement.dtos.Classroomdto;
import schoolmanagement.models.Classroom;
import schoolmanagement.models.Department;
import schoolmanagement.models.Teacher;
import schoolmanagement.services.ClassroomService;

@RestController
@RequestMapping("/api/class")
public class ClassroomController {

	@Autowired
	ClassroomService CS;
	
	
	@PostMapping("/")
	public ResponseEntity<Classroomdto>create(@Valid @RequestBody Classroomdto C)
	{
		
		Classroomdto C1=this.CS.create(C);
		return new ResponseEntity<>(C1,HttpStatus.CREATED);
		
	
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Classroomdto>update(@PathVariable Integer id,@Valid @RequestBody Classroomdto C)
	{
	
	Classroomdto updclass=this.CS.update(C, id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Classroomdto>getclass(@PathVariable("id")Integer id)
	{
		
		Classroomdto getclass=this.CS.getbyId(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Classroomdto>deleteclass(@PathVariable("id")Integer id)
	{
	 
	  
	  
	  this.CS.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
