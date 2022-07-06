package schoolmanagement.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import schoolmanagement.dao.ClassEquipmentRepository;
import schoolmanagement.dtos.ClassEquipmentdto;
import schoolmanagement.dtos.Departmentdto;
import schoolmanagement.models.ClassEquipments;
import schoolmanagement.models.Department;

@Service
public class ClassEquipmentService implements GenericService<ClassEquipmentdto> {

	@Autowired
	ClassEquipmentRepository CQR;
	
	
	@Autowired
	ModelMapper modelmapper;
	
	
	
	public ClassEquipments dtotoequip(ClassEquipmentdto cdto)
	{
		
		ClassEquipments cq=this.modelmapper.map(cdto, ClassEquipments.class);
		return cq;
		
	}
	
	public ClassEquipmentdto equiptodto(ClassEquipments cq)
	{
		
		ClassEquipmentdto cdto=this.modelmapper.map(cq, ClassEquipmentdto.class);
		
		return cdto;
	}
	
	
	
	
	@Override
	public ClassEquipmentdto create(ClassEquipmentdto cdto) {
		
		
		
		
		ClassEquipments CQ=this.dtotoequip(cdto);
		ClassEquipments C=this.CQR.save(CQ);
		
		
		return this.equiptodto(C);
		
	}
	
	

	@Override
	public ClassEquipmentdto update(ClassEquipmentdto C, int id) {
		
		
		
		ClassEquipments Cq=this.dtotoequip(C);
		ClassEquipments CE=this.CQR.findById(id).get();
		CE.setBenchCount(Cq.getBenchCount());
		
		CE.setFanCount(Cq.getFanCount());
		CE.setLightCount(Cq.getLightCount());
		
	ClassEquipments upd=this.CQR.save(CE);
		
		return this.equiptodto(upd);
		
	}

	@Override
	public void delete(int id) {
	
		ClassEquipments cq=this.CQR.findById(id).get();
		this.CQR.delete(cq);
		
		
	}

	@Override
	public ClassEquipmentdto getbyId(int id) {
		
		ClassEquipments cq=this.CQR.findById(id).get();
		
		return this.equiptodto(cq);
	}
	
	
	

}
