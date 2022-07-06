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

import schoolmanagement.dtos.ClassEquipmentdto;
import schoolmanagement.models.ClassEquipments;
import schoolmanagement.models.Classroom;
import schoolmanagement.services.ClassEquipmentService;

@RestController
@RequestMapping("/api/classequip")
public class ClassEquipmentController {
	
	
	@Autowired
	ClassEquipmentService ces;
	
	@PostMapping("/")
	public ResponseEntity<ClassEquipmentdto>create(@Valid @RequestBody ClassEquipmentdto cq)
	{
		
		ClassEquipmentdto C1=this.ces.create(cq);
		return new ResponseEntity<>(C1,HttpStatus.CREATED);
		
	
	
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClassEquipmentdto>update(@PathVariable Integer id,@Valid @RequestBody ClassEquipmentdto cq)
	{
	
	
	ClassEquipmentdto C=this.ces.update(cq, id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClassEquipmentdto>getclassequipments(@PathVariable("id")Integer id)
	{
		
		
		ClassEquipmentdto cq=this.ces.getbyId(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClassEquipmentdto>deleteclassequipments(@PathVariable("id")Integer id)
	{
	 
	  
	  
	  
	  this.ces.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
