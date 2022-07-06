package schoolmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import schoolmanagement.models.ClassEquipments;

public interface ClassEquipmentRepository extends JpaRepository<ClassEquipments, Integer> {

}
