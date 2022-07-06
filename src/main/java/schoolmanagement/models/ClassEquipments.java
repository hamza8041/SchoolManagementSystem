package schoolmanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CLASSEQUIPMENTS")


public class ClassEquipments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int equipId;
	
	
	private int benchCount;
	

	private int fanCount;
	
	
	private int lightCount;
	
	
	@ManyToOne
	@JoinColumn(name = "classId")
	Classroom classequip;


	public ClassEquipments() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClassEquipments(int equipId, int benchCount, int fanCount, int lightCount, Classroom classequip) {
		super();
		this.equipId = equipId;
		this.benchCount = benchCount;
		this.fanCount = fanCount;
		this.lightCount = lightCount;
		this.classequip = classequip;
	}


	public int getEquipId() {
		return equipId;
	}


	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}


	public int getBenchCount() {
		return benchCount;
	}


	public void setBenchCount(int benchCount) {
		this.benchCount = benchCount;
	}


	public int getFanCount() {
		return fanCount;
	}


	public void setFanCount(int fanCount) {
		this.fanCount = fanCount;
	}


	public int getLightCount() {
		return lightCount;
	}


	public void setLightCount(int lightCount) {
		this.lightCount = lightCount;
	}


	public Classroom getClassequip() {
		return classequip;
	}


	public void setClassequip(Classroom classequip) {
		this.classequip = classequip;
	}

	
	
	

	
	
	
	
	
}
