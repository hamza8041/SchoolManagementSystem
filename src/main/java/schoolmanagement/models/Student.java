package schoolmanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "STUDENT")


public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	
	private String firstName;
	private String lastName;
	
	private String email;
	
	private String address;
	
	
	
	@ManyToOne
	@JoinColumn(name = "classId")
	private Classroom classroom;
	
	
	@ManyToOne
	@JoinColumn(name = "deptId")
	private Department department;


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int studentId, String firstName, String lastName, String email, String address, Classroom classroom,
			Department department) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.classroom = classroom;
		this.department = department;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Classroom getClassroom() {
		return classroom;
	}


	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}

	
	
	
	
	
	
	

}
