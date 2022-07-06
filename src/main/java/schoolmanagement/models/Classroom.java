package schoolmanagement.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CLASSROOM")


public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classId;
	
	
	
	private String className;
	
	
	

private int studentCount;


@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "classroom",orphanRemoval = true)
private List<Student> students=new ArrayList<>();


@ManyToOne
@JoinColumn(name = "deptId")
private Department department;


@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "classequip",orphanRemoval = true)
private List<ClassEquipments>classEquipment=new ArrayList<>();



@ManyToMany(targetEntity = Teacher.class,cascade = {CascadeType.ALL})
@JoinTable(name = "classteachers", joinColumns = {@JoinColumn(referencedColumnName ="classId")}, 
inverseJoinColumns = {@JoinColumn(referencedColumnName ="teacherId")})
private List<Teacher>teachers=new ArrayList<>();



public Classroom() {
	super();
	// TODO Auto-generated constructor stub
}



public Classroom(int classId, String className, int studentCount, List<Student> students, Department department,
		List<ClassEquipments> classEquipment, List<Teacher> teachers) {
	super();
	this.classId = classId;
	this.className = className;
	this.studentCount = studentCount;
	this.students = students;
	this.department = department;
	this.classEquipment = classEquipment;
	this.teachers = teachers;
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



public List<Student> getStudents() {
	return students;
}



public void setStudents(List<Student> students) {
	this.students = students;
}



public Department getDepartment() {
	return department;
}



public void setDepartment(Department department) {
	this.department = department;
}



public List<ClassEquipments> getClassEquipment() {
	return classEquipment;
}



public void setClassEquipment(List<ClassEquipments> classEquipment) {
	this.classEquipment = classEquipment;
}



public List<Teacher> getTeachers() {
	return teachers;
}



public void setTeachers(List<Teacher> teachers) {
	this.teachers = teachers;
}
















	


	
	

}
