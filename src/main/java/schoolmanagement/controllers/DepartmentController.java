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

import schoolmanagement.dtos.Departmentdto;
import schoolmanagement.models.Department;
import schoolmanagement.models.Student;
import schoolmanagement.services.DepartmentService;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService DS;
	
	
	@PostMapping("/")
	public ResponseEntity<Departmentdto>create(@Valid @RequestBody Departmentdto D)
	{
Departmentdto D1=this.DS.create(D);
		return new ResponseEntity<>(D1,HttpStatus.CREATED);
		
	
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Departmentdto>update(@PathVariable Integer id,@Valid @RequestBody Departmentdto D)
	{
	Departmentdto upddept=this.DS.update(D, id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Departmentdto>getdept(@PathVariable("id")Integer id)
	{
		
		Departmentdto getdept=this.DS.getbyId(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Departmentdto>deletedept(@PathVariable("id")Integer id)
	{
	 
	  this.DS.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
