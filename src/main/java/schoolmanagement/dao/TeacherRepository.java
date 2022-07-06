package schoolmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import schoolmanagement.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
