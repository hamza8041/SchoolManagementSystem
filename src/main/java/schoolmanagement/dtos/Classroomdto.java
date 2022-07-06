package schoolmanagement.dtos;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Classroomdto {
	
private int classId;


@Size(min = 4,message = "class name should be proper")
private String className;
	
//@Size(min = 15,max = 40,message = "should not be below or should not exceed")
private int studentCount;	
	
Departmentdto dept;

public Classroomdto() {
	super();
	// TODO Auto-generated constructor stub
}

public Classroomdto(int classId, @Size(min = 4, message = "class name should be proper") String className,
		@Size(min = 15, max = 40, message = "should not be below or should not exceed") int studentCount,
		Departmentdto dept) {
	super();
	this.classId = classId;
	this.className = className;
	this.studentCount = studentCount;
	this.dept = dept;
}

public int getClassId() {
	return classId;
}

public void setClassId(int classId) {
	this.classId = classId;
}

public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

public int getStudentCount() {
	return studentCount;
}

public void setStudentCount(int studentCount) {
	this.studentCount = studentCount;
}

public Departmentdto getDept() {
	return dept;
}

public void setDept(Departmentdto dept) {
	this.dept = dept;
}





}
