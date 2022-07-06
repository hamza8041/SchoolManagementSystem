package schoolmanagement.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class Studentdto {

	
private int studentId;
	
	@Size(max = 20)
	private String firstName;
	@Size(max = 20)
	private String lastName;
	
	@Email
	@NotBlank
	private String email;
	
	@Size(max = 50)
	private String address;
	
	
	Classroomdto classroom;
	
	Departmentdto dept;

	public Studentdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Studentdto(int studentId, @Size(max = 20) String firstName, @Size(max = 20) String lastName,
			@Email @NotBlank String email, @Size(max = 50) String address, Classroomdto classroom, Departmentdto dept) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.classroom = classroom;
		this.dept = dept;
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

	public Classroomdto getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroomdto classroom) {
		this.classroom = classroom;
	}

	public Departmentdto getDept() {
		return dept;
	}

	public void setDept(Departmentdto dept) {
		this.dept = dept;
	}
	
	
	
	
}
