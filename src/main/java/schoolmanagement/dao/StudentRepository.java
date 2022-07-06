package schoolmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import schoolmanagement.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}
