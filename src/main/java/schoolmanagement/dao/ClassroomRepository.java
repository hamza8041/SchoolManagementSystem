package schoolmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import schoolmanagement.models.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

}
