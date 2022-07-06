package schoolmanagement.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Teacherdto {
	
private int teacherId;
	
	@Size(max = 20)
	private String firstName;
	
	@Size(max = 20)
	
	private String lastName;
	
	@Email
	@NotBlank
	private String email;
	
	Departmentdto dept;

	public Teacherdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacherdto(int teacherId, @Size(max = 20) String firstName, @Size(max = 20) String lastName,
			@Email @NotBlank String email, Departmentdto dept) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dept = dept;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	public Departmentdto getDept() {
		return dept;
	}

	public void setDept(Departmentdto dept) {
		this.dept = dept;
	}
	
	
	

}
