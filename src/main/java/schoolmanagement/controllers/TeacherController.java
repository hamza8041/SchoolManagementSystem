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

import schoolmanagement.dtos.Teacherdto;
import schoolmanagement.models.Department;
import schoolmanagement.models.Teacher;
import schoolmanagement.services.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService TS;

	
	@PostMapping("/")
	public ResponseEntity<Teacherdto>create(@Valid @RequestBody Teacherdto T)
	{
		
		Teacherdto T1=this.TS.create(T);
		return new ResponseEntity<>(T1,HttpStatus.CREATED);
		
	
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Teacherdto>update(@PathVariable Integer id,@Valid @RequestBody Teacherdto T)
	{
	
	Teacherdto updteacher=this.TS.update(T, id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacherdto>getteacher(@PathVariable("id")Integer id)
	{
		
		Teacherdto getteacher=this.TS.getbyId(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Department>deleteteacher(@PathVariable("id")Integer id)
	{
	 
	  
	  this.TS.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
