package schoolmanagement.dtos;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClassEquipmentdto {
	
	
private int equipId;
	
	@Size(min = 30,message = "There should be minimum 30 benches")
	private int benchCount;
	
	@Size(min = 5)
	private int fanCount;
	
	@Size(min=8)
	private int lightCount;
	
Classroomdto classequip;

public ClassEquipmentdto() {
	super();
	// TODO Auto-generated constructor stub
}

public ClassEquipmentdto(int equipId, @Size(min = 30, message = "There should be minimum 30 benches") int benchCount,
		@Size(min = 5) int fanCount, @Size(min = 8) int lightCount, Classroomdto classequip) {
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

public Classroomdto getClassequip() {
	return classequip;
}

public void setClassequip(Classroomdto classequip) {
	this.classequip = classequip;
}



	
}
