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

import schoolmanagement.dtos.Studentdto;
import schoolmanagement.models.Student;
import schoolmanagement.services.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {


	@Autowired
	StudentService ss;
	
	@PostMapping("/")
	public ResponseEntity<Studentdto>create(@Valid @RequestBody Studentdto S)
	{
		Studentdto S1=this.ss.create(S);
		return new ResponseEntity<>(S1,HttpStatus.CREATED);
		
	
	
	}
	
	@PutMapping("/{sid}")
	public ResponseEntity<Studentdto>update(@PathVariable Integer sid,@Valid @RequestBody Studentdto S)
	{
		Studentdto updstudent=this.ss.update(S, sid);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/{sid}")
	public ResponseEntity<Studentdto>getstudent(@PathVariable("sid")Integer sid)
	{
		Studentdto getstudent=this.ss.getbyId(sid);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{sid}")
	public ResponseEntity<Studentdto>deletestudent(@PathVariable("sid")Integer sid)
	{
	  this.ss.delete(sid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
