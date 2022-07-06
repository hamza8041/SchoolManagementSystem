package schoolmanagement.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DEPARTMENT")


public class Department {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptId;
	
	private String deptName;
	
	private String headOfDepartment;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "department")
	private List<Classroom>classrooms=new ArrayList<>();
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "department")
	private List<Teacher>teachers=new ArrayList<>();
	
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "department")
	private List<Student>students=new ArrayList<>();



	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Department(int deptId, String deptName, String headOfDepartment, List<Classroom> classrooms,
			List<Teacher> teachers, List<Student> students) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.headOfDepartment = headOfDepartment;
		this.classrooms = classrooms;
		this.teachers = teachers;
		this.students = students;
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



	public List<Classroom> getClassrooms() {
		return classrooms;
	}



	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}



	public List<Teacher> getTeachers() {
		return teachers;
	}



	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}



	public List<Student> getStudents() {
		return students;
	}



	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
	
}


