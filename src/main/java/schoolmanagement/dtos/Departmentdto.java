package schoolmanagement.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class Departmentdto {
	
	private int deptId;
	
	@Size(min = 3,message = "Dept name should be more than 3 letters")
	private String deptName;
	
	@Size(min = 3,message = "HOD should be more than 3 letters")
	private String headOfDepartment;

	public Departmentdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departmentdto(int deptId,
			@Size(min = 3, message = "Dept name should be more than 3 letters") String deptName,
			@Size(min = 3, message = "HOD should be more than 3 letters") String headOfDepartment) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.headOfDepartment = headOfDepartment;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(String headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}


	
	
	
	

}
