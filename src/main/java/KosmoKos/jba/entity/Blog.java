package KosmoKos.jba.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Blog {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String irl;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIrl() {
		return irl;
	}
	public void setIrl(String irl) {
		this.irl = irl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
